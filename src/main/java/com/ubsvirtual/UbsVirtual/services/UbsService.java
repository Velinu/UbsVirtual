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
    public void insert(List<Ubs> ubs) {
        this.ubsRepository.insert(ubs);
    }

    public List<Ubs> getAll(){
        return  ubsRepository.findAll();
    }

    public Page<Ubs> getAllPagination(Integer offset, Integer pageSize){
        return ubsRepository.findAll(PageRequest.of(offset, pageSize));
    }

    public Ubs getById(Integer id) {
        Optional<Ubs> ubs = ubsRepository.findById(id);
        if(!ubs.isPresent()){
            throw  new ResponseStatusException(HttpStatus.NO_CONTENT);
        }else{
            return ubs.get();
        }
    }

    public String delete(Integer id){
        Ubs ubs = ubsRepository.findById(id).get();
            ubs.desativar();
            ubsRepository.save(ubs);
            return "A Ubs de Id " + ubs.getId()+ " foi excluída com sucesso";

    }

    public String activate(Integer id){
        Ubs ubs = ubsRepository.findById(id).get();
            ubs.ativar();
            ubsRepository.save(ubs);
            return "A UBS de Id: " + ubs.getId()+ " foi reativada com sucesso";
    }

    public String trueDelete(Integer id){
        Ubs ubs = ubsRepository.findById(id).get();
        ubsRepository.delete(ubs);
        return "O registro da ubs de ID: "+id+" foi excluido com sucesso";
    }

    public String setName(Integer id, String name){
        Ubs ubs = ubsRepository.findById(id).get();
        ubs.setNome(name);
        ubsRepository.save(ubs);
        return ubs.getNome();
    }

    public String setTelefone(Integer id, String telefone){
        Ubs ubs = ubsRepository.findById(id).get();
        ubs.setTelefone(telefone);
        ubsRepository.save(ubs);
        return ubs.getTelefone();
    }


}
