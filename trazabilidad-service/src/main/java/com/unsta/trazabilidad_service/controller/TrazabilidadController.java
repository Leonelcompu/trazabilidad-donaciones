package com.unsta.trazabilidad_service.controller;

import com.unsta.trazabilidad_service.model.Trazabilidad;
import com.unsta.trazabilidad_service.service.TrazabilidadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trazabilidad")
public class TrazabilidadController {

    private final TrazabilidadService service;

    public TrazabilidadController(TrazabilidadService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Trazabilidad>> listarTodos() {
        return ResponseEntity.ok(service.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trazabilidad> obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<Trazabilidad> obtenerPorCodigo(@PathVariable String codigo) {
        return service.obtenerPorCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/donacion/{donacionId}")
    public ResponseEntity<List<Trazabilidad>> listarPorDonacion(@PathVariable Long donacionId) {
        return ResponseEntity.ok(service.obtenerPorDonacion(donacionId));
    }

    @PostMapping
    public ResponseEntity<Trazabilidad> registrarEvento(@RequestBody Trazabilidad evento) {
        Trazabilidad creado = service.registrarEvento(evento);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }
}