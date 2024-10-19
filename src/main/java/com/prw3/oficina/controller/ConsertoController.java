package com.prw3.oficina.controller;

import com.prw3.oficina.conserto.Conserto;
import com.prw3.oficina.conserto.ConsertoDados;
import com.prw3.oficina.conserto.ConsertoRepository;
import com.prw3.oficina.conserto.ConsertoResumo;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conserto")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid ConsertoDados dados){
        System.out.println(dados);
        repository.save(new Conserto(dados));
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @GetMapping
    public Page<Conserto> listar(Pageable pageable){
        return repository.findAll(pageable);
    }

    @GetMapping("resumo")
    public List<ConsertoResumo> resumo(){
        return repository.findAll().stream().map(ConsertoResumo::new).toList();
    }
}
