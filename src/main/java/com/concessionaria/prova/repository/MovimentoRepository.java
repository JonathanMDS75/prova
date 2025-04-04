package com.concessionaria.prova.repository;

import com.concessionaria.prova.models.Movimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentoRepository extends JpaRepository<Movimento, Long> {
}