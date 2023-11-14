package com.ubsvirtual.UbsVirtual.services;

import com.ubsvirtual.UbsVirtual.models.pessoas.Paciente;
import com.ubsvirtual.UbsVirtual.repositorys.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public ResponseEntity<Paciente> postOne(Paciente Paciente){
        if(pacienteRepository.existsById(Paciente.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Esse ID já existe");
        }else {
            this.pacienteRepository.insert(Paciente);
            return new ResponseEntity<>(Paciente, HttpStatus.OK);
        }
    }

    public List<Paciente> getAll(){
        if (pacienteRepository.findAll().isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Paciente não encontrado");
        }else {
            return pacienteRepository.findAll();
        }
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

    public Paciente delete(Integer id){
        if ( pacienteRepository.findById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }else {
            Paciente paciente = pacienteRepository.findById(id).get();
            paciente.delete();
            pacienteRepository.save(paciente);
            return paciente;
        }
    }

    public Paciente activate(Integer id){
        if(pacienteRepository.findById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Paciente não encontrado");
        }else {
            Paciente paciente = pacienteRepository.findById(id).get();
            paciente.active();
            pacienteRepository.save(paciente);
            return paciente;
        }
    }

    public Paciente trueDelete(Integer id){
        if(pacienteRepository.findById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Paciente não encontrado");
        }
        Paciente paciente = pacienteRepository.findById(id).get();
        pacienteRepository.delete(paciente);
        return paciente;
    }

    public Paciente setName (Integer id, String nome){
        if(pacienteRepository.findById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Paciente não encontrado");
        }else {
            Paciente paciente = pacienteRepository.findById(id).get();
            paciente.setNome(nome);
            pacienteRepository.save(paciente);
            return paciente;
        }
    }

    public Paciente setSexo (Integer id, String sexo){
        if(pacienteRepository.findById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Paciente não encontrado");
        }else {
            Paciente paciente = pacienteRepository.findById(id).get();
            paciente.setSexo(sexo);
            pacienteRepository.save(paciente);
            return paciente;
        }
    }

    public Paciente setSenha (Integer id, String senha){
        if(pacienteRepository.findById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Paciente não encontrado");
        }else {
            Paciente paciente = pacienteRepository.findById(id).get();
            paciente.setSenha(senha);
            pacienteRepository.save(paciente);
            return paciente;
        }
    }
}
