package com.ubsvirtual.UbsVirtual.models.pessoas;

import com.ubsvirtual.UbsVirtual.exceptions.CpfException;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "Pacientes")
public class Paciente extends Pessoa{
    private LocalDate ultima_consulta;

    public Paciente(Integer id, String cpf, String nome, LocalDate nascimento, String sexo, TiposSanguineo tipo_sanguineo) throws CpfException, CpfException {
        super(id, cpf, nome, nascimento, sexo, tipo_sanguineo);
    }

    public LocalDate getUltima_consulta() {
        return ultima_consulta;
    }
}
