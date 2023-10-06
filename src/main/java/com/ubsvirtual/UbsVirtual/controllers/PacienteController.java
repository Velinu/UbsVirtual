package com.ubsvirtual.UbsVirtual.controllers;

import com.ubsvirtual.UbsVirtual.models.pessoas.Paciente;
import com.ubsvirtual.UbsVirtual.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @GetMapping("/")
    public List<Paciente> getAll(){
        return pacienteService.getAll();
    }


    @GetMapping("/{offset}/{pageSize}")
    public Page<Paciente> getAllPagination(@PathVariable Integer offset, @PathVariable Integer pageSize){
        return pacienteService.getAllPagination(offset,pageSize);
    }

    @GetMapping("/{i}")
    public ResponseEntity<Paciente> getById(@PathVariable Integer i){
         try{
             return ResponseEntity.ok(pacienteService.getById(i));
         }catch (ResponseStatusException e){
             return ResponseEntity.noContent().build();
         }
    }

    @GetMapping("/delete/{i}")
    public String delete(@PathVariable Integer i){
        return pacienteService.delete(i);
    }

    @GetMapping("/active/{i}")
    public String activate(@PathVariable Integer i){
        return pacienteService.activate(i);
    }

    @GetMapping("/truedelete/{i}")
    public String trueDelete(@PathVariable Integer i){
        return pacienteService.trueDelete(i);
    }

    @GetMapping("/setnome/{i}/{n}")
    public String setName(@PathVariable Integer i, @PathVariable String n){
        return pacienteService.setName(i,n);
    }

    @GetMapping("/setsexo/{i}/{s}")
    public String setSexo(@PathVariable Integer i, @PathVariable String s){
        return pacienteService.setSexo(i,s);
    }
}
