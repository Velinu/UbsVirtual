package com.ubsvirtual.UbsVirtual.controllers;

import com.ubsvirtual.UbsVirtual.models.pessoas.Medico;
import com.ubsvirtual.UbsVirtual.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController {
    @Autowired
    MedicoService medicoService;

    @GetMapping("/")
    public ResponseEntity<List<Medico>> getAll(){
        try {
            return medicoService.getAll();
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
            return ResponseEntity.ok(medicoService.getById(i));
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
            return medicoService.setName(i, novoNome);
        }catch (ResponseStatusException e){
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/setsexo/{i}")
    public ResponseEntity<Medico> setSexo(@PathVariable Integer i, @RequestBody String novoSexo){
        try {
            return medicoService.setSexo(i, novoSexo);
        }catch (ResponseStatusException e){
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/setsenha/{i}")
    public ResponseEntity<Medico> setSenha(@PathVariable Integer i, @RequestBody String senha){
        try {
            return medicoService.setSenha(i, senha);
        }catch (ResponseStatusException e){
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/active/{i}")
    public ResponseEntity<Medico> activate(@PathVariable Integer i){
        try {
            return medicoService.activate(i);
        }catch (ResponseStatusException e){
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/delete/{i}")
    public ResponseEntity<Medico> delete(@PathVariable Integer i){
        try {
            return medicoService.delete(i);
        }catch(ResponseStatusException e){
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/truedelete/{i}")
    public ResponseEntity<Medico> trueDelete(@PathVariable Integer i){
        try {
            return medicoService.trueDelete(i);
        }catch (ResponseStatusException e){
            return ResponseEntity.noContent().build();
        }
    }

}
