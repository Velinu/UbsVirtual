package com.ubsvirtual.UbsVirtual.services;

import com.ubsvirtual.UbsVirtual.exceptions.CpfException;
import com.ubsvirtual.UbsVirtual.models.consultas.Consulta;
import com.ubsvirtual.UbsVirtual.models.pessoas.Especializacao;
import com.ubsvirtual.UbsVirtual.models.pessoas.Medico;
import com.ubsvirtual.UbsVirtual.repositorys.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;
    public void insert(List<Medico> medico) throws CpfException {
        this.medicoRepository.insert(medico);
    }

    public List<Medico> getAll(){
        return medicoRepository.findAll();
    }

    public Page<Medico> getAllPagination(Integer offSet, Integer pageSize) {
        return medicoRepository.findAll(PageRequest.of(offSet, pageSize));
    }

    public Medico getById(Integer id) {
        Optional<Medico> medico = medicoRepository.findById(id);
        if (medico.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Médico não encontrado");
        } else {
            return medico.get();
        }
    }

    public String delete(Integer id){
        Medico medico = medicoRepository.findById(id).get();
        medico.delete();
        medicoRepository.save(medico);
        return "O médico de ID: " + id + " foi deletado com sucesso";
    }

    public String activate(Integer id){
        Medico medico = medicoRepository.findById(id).get();
        medico.active();
        medicoRepository.save(medico);
        return "O médico de ID: " + id + " foi reativado com sucesso";
    }

    public String trueDelete(Integer id){
        Medico medico = medicoRepository.findById(id).get();
        medicoRepository.delete(medico);
        return "O registro do medico de ID: "+id+" foi excluido com sucesso";
    }

    public String setName (Integer id, String nome){
        Medico medico = medicoRepository.findById(id).get();
        medico.setNome(nome);
        medicoRepository.save(medico);
        return medico.getNome();
    }

    public String setSexo (Integer id, String sexo){
        Medico medico = medicoRepository.findById(id).get();
        medico.setSexo(sexo);
        medicoRepository.save(medico);
        return medico.getSexo();
    }

}
