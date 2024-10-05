package com.prw3.oficina.controller;

import com.prw3.oficina.conserto.Conserto;
import com.prw3.oficina.conserto.ConsertoDados;
import com.prw3.oficina.conserto.ConsertoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conserto")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody ConsertoDados dados){

        System.out.println(dados);
        repository.save(new Conserto(dados));
    }
}
