package com.ubsvirtual.UbsVirtual.services;

import com.ubsvirtual.UbsVirtual.models.ubs.Ubs;
import com.ubsvirtual.UbsVirtual.repositorys.UbsRepository;
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
public class UbsService {


    @Autowired
    private UbsRepository ubsRepository;
    public Ubs insetOne(Ubs ubs) {
        if(ubsRepository.existsById(ubs.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID já existe");
        }else {
            this.ubsRepository.insert(ubs);
            return ubs;
        }
    }

    public List<Ubs> getAll(){
        if(ubsRepository.findAll().isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Ubs não encontrada");
        }else {
            return ubsRepository.findAll();
        }
    }

    public Page<Ubs> getAllPagination(Integer offset, Integer pageSize){
        return ubsRepository.findAll(PageRequest.of(offset, pageSize));
    }

    public Ubs getById(Integer id) {
        Optional<Ubs> ubs = ubsRepository.findById(id);
        if(ubs.isEmpty()){
            throw  new ResponseStatusException(HttpStatus.NO_CONTENT);
        }else{
            return ubs.get();
        }
    }

    public Ubs delete(Integer id){
        if(ubsRepository.findById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "UBS não encontrada");
        }else {
            Ubs ubs = ubsRepository.findById(id).get();
            ubs.desativar();
            ubsRepository.save(ubs);
            return ubs;
        }
    }

    public Ubs activate(Integer id){
        if(ubsRepository.findById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "UBS não encontrada");
        }
            Ubs ubs = ubsRepository.findById(id).get();
            ubs.ativar();
            ubsRepository.save(ubs);
            return ubs;
    }

    public Ubs trueDelete(Integer id){
        if (ubsRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "UBS não encontrada");
        }else {
            Ubs ubs = ubsRepository.findById(id).get();
            ubsRepository.delete(ubs);
            return ubs;
        }
    }

    public Ubs setName(Integer id, String name){
        if (ubsRepository.findById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "UBS não encontrada");
        }else {
            Ubs ubs = ubsRepository.findById(id).get();
            ubs.setNome(name);
            ubsRepository.save(ubs);
            return ubs;
        }
    }

    public Ubs setTelefone(Integer id, String telefone){
        if(ubsRepository.findById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "UBS não encontrada");
        }else {
            Ubs ubs = ubsRepository.findById(id).get();
            ubs.setTelefone(telefone);
            ubsRepository.save(ubs);
            return ubs;
        }
    }


}
