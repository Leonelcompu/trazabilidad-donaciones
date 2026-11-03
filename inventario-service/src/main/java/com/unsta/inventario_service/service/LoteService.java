package com.unsta.inventario_service.service;

import com.unsta.inventario_service.model.Lote;
import com.unsta.inventario_service.repository.LoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LoteService {

    @Autowired
    private LoteRepository loteRepository;

    public List<Lote> obtenerTodos() {
        return loteRepository.findAll();
    }

    public Optional<Lote> obtenerPorId(Long id) {
        return loteRepository.findById(id);
    }

    public List<Lote> obtenerPorDonacion(Long donacionId) {
        return loteRepository.findByDonacionId(donacionId);
    }

    public List<Lote> obtenerPorCategoria(String categoria) {
        return loteRepository.findByCategoria(categoria);
    }

    public Lote registrarLote(Lote lote) {
        if (lote.getFechaIngreso() == null) {
            lote.setFechaIngreso(LocalDate.now());
        }
        return loteRepository.save(lote);
    }

    public void eliminarLote(Long id) {
        loteRepository.deleteById(id);
    }
}