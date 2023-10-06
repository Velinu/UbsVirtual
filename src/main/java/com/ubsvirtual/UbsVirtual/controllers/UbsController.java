package com.ubsvirtual.UbsVirtual.controllers;

import com.ubsvirtual.UbsVirtual.models.ubs.Ubs;
import com.ubsvirtual.UbsVirtual.services.UbsService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ubs")
public class UbsController {
    @Autowired
    UbsService ubsService;

    @GetMapping("/")
    public List<Ubs> getAll(){
        return ubsService.getAll();
    }

    @GetMapping("/{offset}/{pageSize}")
    public Page<Ubs> getAllPagination(@PathVariable Integer offset, @PathVariable Integer pageSize){
        return ubsService.getAllPagination(offset, pageSize);
    }

    @GetMapping("/{i}")
    public ResponseEntity<Ubs> getById(@PathVariable Integer i){
        try {
            return ResponseEntity.ok(ubsService.getById(i));
        }catch (ResponseStatusException e){
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/delete/{i}")
    public String delete(@PathVariable Integer i){
        return ubsService.delete(i);
    }

    @GetMapping("/active/{i}")
    public String activate(@PathVariable Integer i){
        return ubsService.activate(i);
    }

    @GetMapping("/truedelete/{i}")
    public String trueDelete(@PathVariable Integer i){
        return ubsService.trueDelete(i);
    }

    @GetMapping("/setnome/{i}/{n}")
    public String getNome(@PathVariable Integer i, @PathVariable String n){
        return ubsService.setName(i, n);
    }

    @GetMapping("/settelefone/{i}/{t}")
    public String getTelefone(@PathVariable Integer i, @PathVariable String t){
        return ubsService.setTelefone(i, t);
    }

}
