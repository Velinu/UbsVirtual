package com.ubsvirtual.UbsVirtual.services;

import com.ubsvirtual.UbsVirtual.exceptions.CpfException;
import com.ubsvirtual.UbsVirtual.models.pessoas.Paciente;
import com.ubsvirtual.UbsVirtual.repositorys.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;
    public void insert(List<Paciente> pacientes) throws CpfException {
        this.pacienteRepository.insert(pacientes);
    }

    public List<Paciente> getAll(){
        return pacienteRepository.findAll();
    }

    public Page<Paciente> getAllPagination(Integer offset, Integer pageSize){
        return pacienteRepository.findAll(PageRequest.of(offset,pageSize));
    }

    public Paciente getById(Integer id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        if(paciente.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }else {
            return paciente.get();
        }
    }

    public String delete(Integer id){
        Paciente paciente = pacienteRepository.findById(id).get();
        paciente.delete();
        pacienteRepository.save(paciente);
        return "O paciente de ID: " + id + " foi deletado com sucesso";
    }

    public String activate(Integer id){
        Paciente paciente = pacienteRepository.findById(id).get();
        paciente.active();
        pacienteRepository.save(paciente);
        return "O paciente de ID: " + id + " foi reativado com sucesso";
    }

    public String trueDelete(Integer id){
        Paciente paciente = pacienteRepository.findById(id).get();
        pacienteRepository.delete(paciente);
        return "O registro do paciente de ID: "+id+" foi excluido com sucesso";
    }

    public String setName (Integer id, String nome){
        Paciente paciente = pacienteRepository.findById(id).get();
        paciente.setNome(nome);
        pacienteRepository.save(paciente);
        return paciente.getNome();
    }

    public String setSexo (Integer id, String sexo){
        Paciente paciente = pacienteRepository.findById(id).get();
        paciente.setSexo(sexo);
        pacienteRepository.save(paciente);
        return paciente.getSexo();
    }

}
