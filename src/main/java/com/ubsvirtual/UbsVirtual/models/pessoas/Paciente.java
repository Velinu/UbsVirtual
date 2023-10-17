package com.ubsvirtual.UbsVirtual.models.pessoas;

import com.ubsvirtual.UbsVirtual.exceptions.CpfException;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Document(collection = "Pacientes")
public class Paciente extends Pessoa{
    private LocalDate ultima_consulta;
    private Roles role;
    public Paciente(Integer id,
                    String cpf,
                    String nome,
                    LocalDate nascimento,
                    String sexo,
                    TiposSanguineo tipo_sanguineo,
                    String senha) throws CpfException, CpfException {
        super(id, cpf, nome, nascimento, sexo, tipo_sanguineo, senha);
        this.role = Roles.PACIENTE;
    }

    @Override
    Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_PACIENTE"));
    }

    public LocalDate getUltima_consulta() {
        return ultima_consulta;
    }

}
