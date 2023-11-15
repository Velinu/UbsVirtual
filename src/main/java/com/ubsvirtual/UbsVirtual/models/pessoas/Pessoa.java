package com.ubsvirtual.UbsVirtual.models.pessoas;

import com.ubsvirtual.UbsVirtual.exceptions.CpfException;
import com.ubsvirtual.UbsVirtual.interfaces.ValidadorCpf;
import org.springframework.data.annotation.Id;
import java.time.LocalDate;

abstract class Pessoa implements ValidadorCpf{

    @Id
    private Integer id;

    private String cpf;
    private String nome;
    private LocalDate nascimento;
    private String sexo;
    private TiposSanguineo tipo_sanguineo;
    private boolean ativo;
    private String senha;


    public Pessoa(Integer id,
                  String cpf,
                  String nome,
                  LocalDate nascimento,
                  String sexo,
                  TiposSanguineo tipo_sanguineo,
                  String senha) throws CpfException {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.tipo_sanguineo = tipo_sanguineo;
        this.ativo = true;
        this.senha = senha;
        if(!validaCpf()){
            throw new CpfException();
        }
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public TiposSanguineo getTipo_sanguineo() {
        return tipo_sanguineo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public boolean validaCpf(){

        String cpfFormatado = this.cpf.replaceAll("[^0-9]", "");
        if(cpfFormatado.length() != 11){
            return false;
        }

        int soma = 0;
        for (int i = 0; i < 9; i++) {
            int digito = Character.getNumericValue(cpfFormatado.charAt(i));
            soma += digito * (10 - i);
        }
        int primeiroDigito = 11 - (soma % 11);

        if (primeiroDigito == 10 || primeiroDigito == 11) {
            primeiroDigito = 0;
        }
        if (primeiroDigito != Character.getNumericValue(cpfFormatado.charAt(9))) {
            return false;
        }

        soma = 0;
        for (int i = 0; i < 10; i++) {
            int digito = Character.getNumericValue(cpfFormatado.charAt(i));
            soma += digito * (11 - i);
        }
        int segundoDigito = 11 - (soma % 11);

        if (segundoDigito == 10 || segundoDigito == 11) {
            segundoDigito = 0;
        }
        if (segundoDigito != Character.getNumericValue(cpfFormatado.charAt(10))) {
            return false;
        }

        return true;
    }

    public void delete(){
        ativo = false;
    }

    public void active() {
        ativo = true;
    }


}
