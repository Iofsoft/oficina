package com.prw3.oficina.util.security;

import com.prw3.oficina.repository.IUsuarioRepository;
import com.prw3.oficina.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private IUsuarioRepository repository;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException,
                                                                    IOException {
        var authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null){
            authorizationHeader = authorizationHeader.replace("Bearer ","");
            var subject = tokenService.getSubject(authorizationHeader);
            var usuario = repository.findByLogin(subject);
            var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);

            //Mantive os prints só pra visualizar mesmo
            System.out.println("\nToken: " + authorizationHeader);
            System.out.println("Usuario: " + subject + "\n");
        }

        filterChain.doFilter(request, response);
    }
}
