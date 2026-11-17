package com.unsta.distribucion_service.service;

import com.unsta.distribucion_service.model.Distribucion;
import com.unsta.distribucion_service.repository.DistribucionRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DistribucionService {

    private final DistribucionRepository repository;

    public DistribucionService(DistribucionRepository repository) {
        this.repository = repository;
    }

    public List<Distribucion> listarTodas() {
        return repository.findAll();
    }

    public Distribucion guardar(Distribucion distribucion) {
        distribucion.setId(null);
        if (distribucion.getFechaDistribucion() == null) {
            distribucion.setFechaDistribucion(LocalDateTime.now());
        }
        if (distribucion.getEstado() == null || distribucion.getEstado().isBlank()) {
            distribucion.setEstado("EN_TRANSITO");
        }
        return repository.save(distribucion);
    }
}