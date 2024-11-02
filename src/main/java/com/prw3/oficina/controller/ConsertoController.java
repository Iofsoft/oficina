package com.prw3.oficina.controller;

import com.prw3.oficina.conserto.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/conserto")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<ConsertoDetalhes> cadastrar(@RequestBody @Valid ConsertoDados dados, UriComponentsBuilder uriBuilder) {
        Conserto conserto = new Conserto(dados);
        repository.save(conserto);
        var uri = uriBuilder.path("/conserto/{id}").buildAndExpand(conserto.getId()).toUri();
        return ResponseEntity.created(uri).body(new ConsertoDetalhes(conserto));

    }

    @GetMapping
    public ResponseEntity<Page<ConsertoDetalhes>> listar(Pageable pageable){
        var consertos = repository.findAll(pageable).map(ConsertoDetalhes::new);
        return ResponseEntity.ok(consertos);
    }

    @GetMapping("resumo")
    public ResponseEntity<List<ConsertoResumo>> resumo(){
        var resumos = repository.findAllByAtivoTrue().stream().map(ConsertoResumo::new).toList();
        return ResponseEntity.ok(resumos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conserto> getConsertoById(@PathVariable Long id){
        Optional<Conserto> conserto = repository.findById(id);
        return conserto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ConsertoDetalhes> atualizar(@RequestBody @Valid ConsertoDadosUpdate dados){
        Conserto conserto = repository.getReferenceById(dados.id());
        conserto.atualizarDados(dados);
        return ResponseEntity.ok(new ConsertoDetalhes(conserto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        Conserto conserto = repository.getReferenceById(id);
        conserto.excluir();
        return ResponseEntity.noContent().build();
    }
}
