package com.A3UNA.AdivinheOObjeto.Inventario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {
    @Override
    Optional<Inventario> findById(Long aLong);
    List<Inventario> findByJogadorId(Long jogadorId);
}
