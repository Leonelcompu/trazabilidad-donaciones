package com.unsta.donacion_service.repository;

import com.unsta.donacion_service.model.Donante;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DonanteRepository extends JpaRepository<Donante, Long> {
    Optional<Donante> findByDocumento(String documento);
}