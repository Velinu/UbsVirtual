package com.ubsvirtual.UbsVirtual.controllers;

import com.ubsvirtual.UbsVirtual.models.pessoas.Paciente;
import com.ubsvirtual.UbsVirtual.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @GetMapping("/")
    public ResponseEntity<List<Paciente>> getAll(){
        try {
            return pacienteService.getAll();
        }catch (ResponseStatusException e){
            return ResponseEntity.noContent().build();
        }
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

    @PutMapping("/active/{i}")
    public ResponseEntity<Paciente> activate(@PathVariable Integer i){
        try {
            return pacienteService.activate(i);
        }catch (ResponseStatusException e){
            return ResponseEntity.noContent().build();
        }

    }

    @PostMapping("/postone/")
    public ResponseEntity<Paciente> post(@RequestBody Paciente paciente){
        return pacienteService.postOne(paciente);
    }

    @PutMapping("/setnome/{i}")
    public ResponseEntity<Paciente> setNome(@RequestBody String novoNome, @PathVariable Integer i){
        try {
            return pacienteService.setName(i, novoNome);
        }catch (ResponseStatusException e){
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/setsexo/{i}")
    public ResponseEntity<Paciente> setSexo(@RequestBody String sexo, @PathVariable Integer i){
        try {
            return pacienteService.setSexo(i, sexo);
        }catch (ResponseStatusException e){
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/setsenha/{i}")
    public ResponseEntity<Paciente> setSenha(@RequestBody String senha, @PathVariable Integer i){
        try {
            return pacienteService.setSenha(i, senha);
        }catch (ResponseStatusException e){
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/delete/{i}")
    public ResponseEntity<Paciente> delete(@PathVariable Integer i){
        try {
            return pacienteService.delete(i);
        }catch (ResponseStatusException e){
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/truedelete/{i}")
    public ResponseEntity<Paciente> trueDelete(@PathVariable Integer i){
        try {
            return pacienteService.trueDelete(i);
        }catch (ResponseStatusException e){
            return ResponseEntity.noContent().build();
        }
    }

}
