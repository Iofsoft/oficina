package com.prw3.oficina.controller;

import com.prw3.oficina.model.Usuario;
import com.prw3.oficina.record.AutenticacaoDados;
import com.prw3.oficina.record.JWTDados;
import com.prw3.oficina.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<JWTDados> Login(@RequestBody @Valid AutenticacaoDados dados){

        var token = new UsernamePasswordAuthenticationToken( dados.login(), dados.senha());
        var authentication = manager.authenticate(token);
        var tokenJWT = tokenService.getToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new JWTDados(tokenJWT));
    }

}