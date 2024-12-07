package com.prw3.oficina.repository;

import com.prw3.oficina.model.Conserto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface IConsertoRepository extends JpaRepository<Conserto, Long> {
    Collection<Conserto> findAllByAtivoTrue();
}
