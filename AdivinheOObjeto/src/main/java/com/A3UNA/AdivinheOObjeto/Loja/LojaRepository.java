package com.A3UNA.AdivinheOObjeto.Loja;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LojaRepository extends JpaRepository<Loja, Long> {
    @Override
    Optional<Loja> findById(Long aLong);
}
