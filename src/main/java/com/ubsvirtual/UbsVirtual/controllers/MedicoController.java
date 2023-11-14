package com.ubsvirtual.UbsVirtual.controllers;

import com.ubsvirtual.UbsVirtual.models.pessoas.Medico;
import com.ubsvirtual.UbsVirtual.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
@RequestMapping("/medico")
public class MedicoController {
    @Autowired
    MedicoService medicoService;


    @GetMapping("/")
    public ResponseEntity<List<Medico>> getAll(){
        try {
            return new ResponseEntity<>(medicoService.getAll(), HttpStatus.OK);
        }catch (ResponseStatusException e){
            return ResponseEntity.noContent().build();
        }
    }


    @GetMapping("/pagination/{offset}/{pageSize}")
    public Page<Medico> getAllPagination(@PathVariable Integer offset, @PathVariable Integer pageSize){
        return medicoService.getAllPagination(offset,pageSize);
    }

    @GetMapping("/{i}")
    public ResponseEntity<Medico> getById(@PathVariable Integer i) throws Exception {
        try {
            return new ResponseEntity<>(medicoService.getById(i), HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("/postone/")
    public ResponseEntity<Medico> postMedico(@RequestBody Medico medico) {
        try {
            return medicoService.postOne(medico);
        }catch (ResponseStatusException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/setnome/{i}")
    public ResponseEntity<Medico> setNome(@PathVariable Integer i, @RequestBody String novoNome) {
        try {
            return new ResponseEntity<>(medicoService.setName(i, novoNome), HttpStatus.OK);
        }catch (ResponseStatusException e){
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/setsexo/{i}")
    public ResponseEntity<Medico> setSexo(@PathVariable Integer i, @RequestBody String novoSexo){
        try {
            return new ResponseEntity<>(medicoService.setSexo(i, novoSexo), HttpStatus.OK);
        }catch (ResponseStatusException e){
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/setsenha/{i}")
    public ResponseEntity<Medico> setSenha(@PathVariable Integer i, @RequestBody String senha){
        try {
            return new ResponseEntity<>(medicoService.setSenha(i, senha), HttpStatus.OK);
        }catch (ResponseStatusException e){
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/active/{i}")
    public ResponseEntity<Medico> activate(@PathVariable Integer i){
        try {
            return new ResponseEntity<>(medicoService.activate(i), HttpStatus.OK);
        }catch (ResponseStatusException e){
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/delete/{i}")
    public ResponseEntity<Medico> delete(@PathVariable Integer i){
        try {
            return new ResponseEntity<>(medicoService.delete(i), HttpStatus.OK);
        }catch(ResponseStatusException e){
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/truedelete/{i}")
    public ResponseEntity<Medico> trueDelete(@PathVariable Integer i){
        try {
            return new ResponseEntity<>(medicoService.trueDelete(i), HttpStatus.OK);
        }catch (ResponseStatusException e){
            return ResponseEntity.noContent().build();
        }
    }

}
