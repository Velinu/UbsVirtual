package com.ubsvirtual.UbsVirtual.controllers;

import com.ubsvirtual.UbsVirtual.models.consultas.Consulta;
import com.ubsvirtual.UbsVirtual.services.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
    @Autowired
    ConsultaService consultaService;

    @GetMapping("/")
    public List<Consulta> getAll(){
        return consultaService.getAll();
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

    @GetMapping("/delete/{i}")
    public String delete(@PathVariable Integer i){
        return consultaService.cancel(i);
    }

    @GetMapping("/conclude/{i}")
    public String conclude(@PathVariable Integer i){
        return consultaService.conclude(i);
    }

    @GetMapping("/truedelete/{i}")
    public String trueDelete(@PathVariable Integer i){
        return consultaService.trueDelete(i);
    }
}
