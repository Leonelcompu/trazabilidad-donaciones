package com.unsta.trazabilidad_service.repository;

import com.unsta.trazabilidad_service.model.Trazabilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrazabilidadRepository extends JpaRepository<Trazabilidad, Long> {
    Optional<Trazabilidad> findByCodigoSeguimiento(String codigoSeguimiento);
    List<Trazabilidad> findByDonacionId(Long donacionId);
    List<Trazabilidad> findByLoteId(Long loteId);
}