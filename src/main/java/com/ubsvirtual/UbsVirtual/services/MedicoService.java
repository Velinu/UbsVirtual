package com.ubsvirtual.UbsVirtual.services;

import com.ubsvirtual.UbsVirtual.models.pessoas.Medico;
import com.ubsvirtual.UbsVirtual.repositorys.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public ResponseEntity<Medico> postOne(Medico medico) {
        if (medicoRepository.existsById(medico.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Médico já existente");
        } else {
            this.medicoRepository.insert(medico);
            return new ResponseEntity<>(medico, HttpStatus.OK);
        }
    }

    public ResponseEntity<List<Medico>> getAll() {
        if (medicoRepository.findAll().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Medico não encontrado");
        } else {
            return new ResponseEntity<>(medicoRepository.findAll(), HttpStatus.OK);
        }
    }

    public Page<Medico> getAllPagination(Integer offSet, Integer pageSize) {
        if (medicoRepository.findAll(PageRequest.of(offSet, pageSize)).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Médico não encontrado");
        } else {
            return medicoRepository.findAll(PageRequest.of(offSet, pageSize));
        }
    }

    public Medico getById(Integer id) {
        Optional<Medico> medico = medicoRepository.findById(id);
        if (medico.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Médico não encontrado");
        } else {
            return medico.get();
        }
    }

    public ResponseEntity<Medico> delete(Integer id) {
        Optional<Medico> medico = medicoRepository.findById(id);
        if (medico.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Medico não encontrado");
        } else {
            medico.get().delete();
            medicoRepository.save(medico.get());
            return new ResponseEntity<>(medico.get(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Medico> activate(Integer id) {
        Optional<Medico> medico = medicoRepository.findById(id);
        if (medico.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Medico não encontrado");
        } else {
            medico.get().active();
            medicoRepository.save(medico.get());
            return new ResponseEntity<>(medico.get(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Medico> trueDelete(Integer id) {
        if (medicoRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Médico não encontrado");
        } else {
            Medico medico = medicoRepository.findById(id).get();
            medicoRepository.delete(medico);
            return new ResponseEntity<>(medico, HttpStatus.OK);
        }
    }

    public ResponseEntity<Medico> setName(Integer id, String nome) {
        if (medicoRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.OK, "Médico não encontrado");
        } else {
            Medico medico = medicoRepository.findById(id).get();
            medico.setNome(nome.trim());
            medicoRepository.save(medico);
            return new ResponseEntity<>(medico, HttpStatus.OK);
        }
    }

    public ResponseEntity<Medico> setSexo(Integer id, String sexo) {
        if (medicoRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Medico não encontrado");
        } else {
            Medico medico = medicoRepository.findById(id).get();
            medico.setSexo(sexo);
            medicoRepository.save(medico);
            return new ResponseEntity<>(medico, HttpStatus.OK);
        }
    }

    public ResponseEntity<Medico> setSenha(Integer id, String senha) {
        if (medicoRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Medico não encontrado");
        } else {
            Medico medico = medicoRepository.findById(id).get();
            medico.setSenha(senha);
            medicoRepository.save(medico);
            return new ResponseEntity<>(medico, HttpStatus.OK);

        }
    }
}
