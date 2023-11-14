package com.ubsvirtual.UbsVirtual.services;

import com.ubsvirtual.UbsVirtual.models.consultas.Consulta;
import com.ubsvirtual.UbsVirtual.repositorys.ConsultasRepository;
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
public class ConsultaService {

    @Autowired
    private ConsultasRepository consultasRepository;

    public void insert(List<Consulta> consultas) { this.consultasRepository.insert(consultas); }

    public ResponseEntity<List<Consulta>> getAll() {
        if(consultasRepository.findAll().isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Consulta não encontrada");
        }else {
            return new ResponseEntity<>(consultasRepository.findAll(), HttpStatus.OK);
        }
    }

    public Page<Consulta> getAllPagination(Integer offset, Integer pageSize){
        return consultasRepository.findAll(PageRequest.of(offset, pageSize));
    }

    public Consulta getById(Integer id){
        Optional<Consulta> consulta = consultasRepository.findById(id);
        if(consulta.isEmpty()){
          throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }else{
            return consulta.get();
        }
    }

    public Consulta cancel(Integer id){
        if(consultasRepository.findById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Consulta não encontrada");
        }else {
            Consulta consulta = consultasRepository.findById(id).get();
            consulta.cancelar();
            consultasRepository.save(consulta);
            return consulta;
        }
    }

    public Consulta conclude(Integer id){
        if(consultasRepository.findById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Consulta não encontrada");
        }else {
            Consulta consulta = consultasRepository.findById(id).get();
            consulta.concluir();
            consultasRepository.save(consulta);
            return consulta;
        }
    }

    public Consulta trueDelete(Integer id){
        if(consultasRepository.findById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Consulta não encontrado");
        }else {
            Consulta consulta = consultasRepository.findById(id).get();
            consultasRepository.delete(consulta);
            return consulta;
        }
    }

    public Consulta postOne(Consulta c){
        if (consultasRepository.existsById(c.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este id já está cadastrado");
        }
        consultasRepository.insert(c);
        return c;
    }

    public Consulta setAnnotation(Integer i, String s) {
        if(consultasRepository.findById(i).isEmpty()){
            throw  new ResponseStatusException(HttpStatus.NO_CONTENT, "Consulta não encconttrada");
        }else{
            Consulta consulta = consultasRepository.findById(i).get();
            consulta.setAnotattion(s);
            consultasRepository.save(consulta);
            return consulta;
        }
    }
}
