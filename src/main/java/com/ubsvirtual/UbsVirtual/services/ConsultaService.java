package com.ubsvirtual.UbsVirtual.services;

import com.ubsvirtual.UbsVirtual.models.consultas.Consulta;
import com.ubsvirtual.UbsVirtual.repositorys.ConsultasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultasRepository consultasRepository;

    public void insert(List<Consulta> consultas) { this.consultasRepository.insert(consultas); }

    public List<Consulta> getAll() {
        return consultasRepository.findAll();
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

    public String cancel(Integer id){
        Consulta consulta = consultasRepository.findById(id).get();
            consulta.cancelar();
            consultasRepository.save(consulta);
            return "A Consulta de Id " + consulta.getId()+ " foi cancelada com sucesso";
    }

    public String conclude(Integer id){
        Consulta consulta = consultasRepository.findById(id).get();
        consulta.concluir();
        consultasRepository.save(consulta);
        return "A Consulta de Id " + consulta.getId()+ " foi concluída com sucesso";

    }

    public String trueDelete(Integer id){
        Consulta consulta = consultasRepository.findById(id).get();
        consultasRepository.delete(consulta);
        return "O registro da consulta de ID: "+id+" foi excluido com sucesso";
    }
}
