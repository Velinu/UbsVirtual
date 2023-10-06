package com.ubsvirtual.UbsVirtual.models.pessoas;

import com.ubsvirtual.UbsVirtual.exceptions.CpfException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;



@Document(collection = "Medicos")
public class Medico extends Pessoa{
    private String crm;
    private Especializacao especializacao;


    public Medico(Integer id, String crm, Especializacao especializacao, String cpf, String nome, LocalDate nascimento, String sexo, TiposSanguineo tipo_sanguineo) throws CpfException, CpfException {
        super(id, cpf, nome, nascimento, sexo, tipo_sanguineo);
        this.crm = crm;
        this.especializacao = especializacao;
    }

    public String getCrm() {
        return crm;

    }

    public Especializacao getEspecializacao() {
        return especializacao;
    }

}
