package com.ubsvirtual.UbsVirtual.controllers;

import com.ubsvirtual.UbsVirtual.models.consultas.Consulta;
import com.ubsvirtual.UbsVirtual.services.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
@RequestMapping("/consulta")
public class ConsultaController {
    @Autowired
    ConsultaService consultaService;

    @GetMapping("/")
    public ResponseEntity<List<Consulta>> getAll(){
        try {
            return consultaService.getAll();
        }catch (ResponseStatusException e){
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    public Page<Consulta> getAllPagination(@PathVariable Integer offset, @PathVariable Integer pageSize){
        return consultaService.getAllPagination(offset,pageSize);
    }

    @GetMapping("/{i}")
    public ResponseEntity<Consulta> getById(@PathVariable Integer i){
        try {
            return ResponseEntity.ok(consultaService.getById(i));
        }catch (ResponseStatusException e){
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("/postone/")
    public ResponseEntity<Consulta> postOne(@RequestBody Consulta c){
        try {
            return new ResponseEntity<>(consultaService.postOne(c), HttpStatus.OK);
        }catch (ResponseStatusException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/conclude/{i}")
    public ResponseEntity<Consulta> conclude(@PathVariable Integer i){
        try {
            return new ResponseEntity<>(consultaService.conclude(i),HttpStatus.OK);
        }catch (ResponseStatusException e){
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/delete/{i}")
    public ResponseEntity<Consulta> delete(@PathVariable Integer i){
        try {
            return new ResponseEntity<>(consultaService.cancel(i), HttpStatus.OK);
        }catch (ResponseStatusException e){
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/truedelete/{i}")
    public ResponseEntity<Consulta> trueDelete(@PathVariable Integer i){
        try{
            return new ResponseEntity<>(consultaService.trueDelete(i),HttpStatus.OK);
        }catch (ResponseStatusException e){
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/setannotation/{i}")
    public ResponseEntity<Consulta> setAnnotation(@PathVariable Integer i, @RequestBody String s){
        try{
            return new ResponseEntity<>(consultaService.setAnnotation(i, s), HttpStatus.OK);
        }catch (ResponseStatusException e){
            return ResponseEntity.noContent().build();
        }
    }



}
