package com.unsta.distribucion_service.controller;

import com.unsta.distribucion_service.model.Distribucion;
import com.unsta.distribucion_service.service.DistribucionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/distribuciones")
public class DistribucionController {

    private final DistribucionService service;

    public DistribucionController(DistribucionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Distribucion>> listar() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @PostMapping
    public ResponseEntity<Distribucion> crear(@RequestBody Distribucion distribucion) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(distribucion));
    }
}