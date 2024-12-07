package com.prw3.oficina.repository;

import com.prw3.oficina.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;


public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByLogin(String username);
}
