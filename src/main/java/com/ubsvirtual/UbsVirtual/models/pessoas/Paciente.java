package com.ubsvirtual.UbsVirtual.models.pessoas;

import com.ubsvirtual.UbsVirtual.exceptions.CpfException;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "Pacientes")
public class Paciente extends Pessoa{

    @Transient
    public static final String SEQUENCE_PACIENTE = "paciente_sequence";

    private LocalDate ultima_consulta;
    private Roles role;
    public Paciente(Integer id,
                    String cpf,
                    String nome,
                    LocalDate nascimento,
                    String sexo,
                    TiposSanguineo tipo_sanguineo,
                    String senha) throws CpfException {
        super(id, cpf, nome, nascimento, sexo, tipo_sanguineo, senha);
        this.role = Roles.PACIENTE;
    }

    public LocalDate getUltima_consulta() {
        return ultima_consulta;
    }

}
