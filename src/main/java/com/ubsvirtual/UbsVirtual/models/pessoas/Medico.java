package com.ubsvirtual.UbsVirtual.models.pessoas;

import com.ubsvirtual.UbsVirtual.exceptions.CpfException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Document(collection = "Medicos")
public class Medico extends Pessoa{
    private String crm;
    private Especializacao especializacao;
    private Roles role;

    public Medico(Integer id,
                  String crm,
                  Especializacao especializacao,
                  String cpf,
                  String nome,
                  LocalDate nascimento,
                  String sexo,
                  TiposSanguineo tipo_sanguineo,
                  String senha) throws CpfException {
        super(id, cpf, nome, nascimento, sexo, tipo_sanguineo, senha);

        this.role = Roles.MEDICO;
        this.crm = crm;
        this.especializacao = especializacao;
    }

    public String getCrm() {
        return crm;
    }

    public Especializacao getEspecializacao() {
        return especializacao;
    }


    @Override
    Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_MEDICO"),
                       new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
}
