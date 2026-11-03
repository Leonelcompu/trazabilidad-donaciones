package com.unsta.inventario_service.repository;

import com.unsta.inventario_service.model.Lote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoteRepository extends JpaRepository<Lote, Long> {
    List<Lote> findByDonacionId(Long donacionId);
    List<Lote> findByCategoria(String categoria);
}