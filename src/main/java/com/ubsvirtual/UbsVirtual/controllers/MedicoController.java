package com.ubsvirtual.UbsVirtual.controllers;

import com.ubsvirtual.UbsVirtual.models.pessoas.Especializacao;
import com.ubsvirtual.UbsVirtual.models.pessoas.Medico;
import com.ubsvirtual.UbsVirtual.responsestatusexception.MedicoNotFound;
import com.ubsvirtual.UbsVirtual.services.MedicoService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medico")
public class MedicoController {
    @Autowired
    MedicoService medicoService;

    @GetMapping("/")
    public List<Medico> getAll(){
        return medicoService.getAll();
    }

    @GetMapping("/teste")
    ResponseEntity<String> teste(){
        return new ResponseEntity<>("Hello worled", HttpStatus.BAD_GATEWAY);
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    public Page<Medico> getAllPagination(@PathVariable Integer offset, @PathVariable Integer pageSize){
        return medicoService.getAllPagination(offset,pageSize);
    }

    @GetMapping("/{i}")
    public ResponseEntity<Medico> getById(@PathVariable Integer i) throws Exception {
        try {
            return ResponseEntity.ok(medicoService.getById(i));
        }catch (ResponseStatusException e){
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/delete/{i}")
    public String delete(@PathVariable Integer i){
        return medicoService.delete(i);
    }

    @GetMapping("/active/{i}")
    public String activate(@PathVariable Integer i){
        return medicoService.activate(i);
    }

    @GetMapping("/truedelete/{i}")
    public String trueDelete(@PathVariable Integer i){
        return medicoService.trueDelete(i);
    }

    @GetMapping("/setnome/{i}/{n}")
    public String setName(@PathVariable Integer i, @PathVariable String n){
        return medicoService.setName(i,n);
    }

    @GetMapping("/setsexo/{i}/{s}")
    public String setSexo(@PathVariable Integer i, @PathVariable String s){
        return medicoService.setSexo(i,s);
    }

}
