package com.unsta.inventario_service.controller;

import com.unsta.inventario_service.model.Lote;
import com.unsta.inventario_service.service.LoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lotes")
@CrossOrigin(origins = "*")
public class LoteController {

    @Autowired
    private LoteService loteService;

    @GetMapping
    public ResponseEntity<List<Lote>> listarLotes() {
        return ResponseEntity.ok(loteService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lote> obtenerPorId(@PathVariable Long id) {
        return loteService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/donacion/{donacionId}")
    public ResponseEntity<List<Lote>> listarPorDonacion(@PathVariable Long donacionId) {
        return ResponseEntity.ok(loteService.obtenerPorDonacion(donacionId));
    }

    @PostMapping
    public ResponseEntity<Lote> crearLote(@RequestBody Lote lote) {
        Lote nuevoLote = loteService.registrarLote(lote);
        return new ResponseEntity<>(nuevoLote, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLote(@PathVariable Long id) {
        loteService.eliminarLote(id);
        return ResponseEntity.noContent().build();
    }
}