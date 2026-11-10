package com.unsta.trazabilidad_service.service;

import com.unsta.trazabilidad_service.model.Trazabilidad;
import com.unsta.trazabilidad_service.repository.TrazabilidadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TrazabilidadService {

    private final TrazabilidadRepository repository;

    public TrazabilidadService(TrazabilidadRepository repository) {
        this.repository = repository;
    }

    public List<Trazabilidad> obtenerTodos() {
        return repository.findAll();
    }

    public Optional<Trazabilidad> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Optional<Trazabilidad> obtenerPorCodigo(String codigo) {
        return repository.findByCodigoSeguimiento(codigo);
    }

    public List<Trazabilidad> obtenerPorDonacion(Long donacionId) {
        return repository.findByDonacionId(donacionId);
    }

    public Trazabilidad registrarEvento(Trazabilidad evento) {
        if (evento.getCodigoSeguimiento() == null || evento.getCodigoSeguimiento().isBlank()) {
            evento.setCodigoSeguimiento("TRZ-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        }
        return repository.save(evento);
    }
}