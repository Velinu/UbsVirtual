package com.ubsvirtual.UbsVirtual.controllers;

import com.ubsvirtual.UbsVirtual.models.ubs.Ubs;
import com.ubsvirtual.UbsVirtual.services.UbsService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ubs")
public class UbsController {
    @Autowired
    UbsService ubsService;

    @GetMapping("/")
    public ResponseEntity<List<Ubs>> getAll(){
        try {
            return new ResponseEntity<>(ubsService.getAll(), HttpStatus.OK);
        }catch (ResponseStatusException e){
            return ResponseEntity.noContent().build();
        }

    }

    @GetMapping("/{offset}/{pageSize}")
    public Page<Ubs> getAllPagination(@PathVariable Integer offset, @PathVariable Integer pageSize){
        return ubsService.getAllPagination(offset, pageSize);
    }

    @GetMapping("/{i}")
    public ResponseEntity<Ubs> getById(@PathVariable Integer i){
        try {
            return new ResponseEntity<>(ubsService.getById(i), HttpStatus.OK);
        }catch (ResponseStatusException e){
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/delete/{i}")
    public ResponseEntity<Ubs> delete(@PathVariable Integer i){

        try{
            return new ResponseEntity<>(ubsService.delete(i), HttpStatus.OK);
        }catch(ResponseStatusException e){
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/truedelete/{i}")
    public ResponseEntity<Ubs> trueDelete(@PathVariable Integer i){
        try {
            return new ResponseEntity<>(ubsService.trueDelete(i), HttpStatus.OK);
        }catch (ResponseStatusException e){
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/active/{i}")
    public ResponseEntity<Ubs> activate(@PathVariable Integer i){
        try {
            return new ResponseEntity<>(ubsService.activate(i), HttpStatus.OK);
        }catch (ResponseStatusException e){
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/setnome/{i}")
    public ResponseEntity<Ubs> setNome(@PathVariable Integer i, @RequestBody String n){
        try{
            return new ResponseEntity<>(ubsService.setName(i, n), HttpStatus.OK);
        }catch (ResponseStatusException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/settelefone/{i}")
    public ResponseEntity<Ubs> setTelefone(@PathVariable Integer i, @RequestBody String n) {
        try {
            return new ResponseEntity<>(ubsService.setTelefone(i, n), HttpStatus.OK);
        }catch (ResponseStatusException e){
            return ResponseEntity.badRequest().build();
        }

    }

    @PostMapping("/postone/")
    public ResponseEntity<Ubs> insertOne(@RequestBody Ubs ubs){
        try {
            return new ResponseEntity<>(ubsService.insetOne(ubs), HttpStatus.OK);
        }catch (ResponseStatusException e){
            return ResponseEntity.badRequest().build();
        }
    }
}
