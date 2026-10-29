package com.unsta.donacion_service.controller;

import com.unsta.donacion_service.dto.DonanteDTO;
import com.unsta.donacion_service.service.DonacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/donantes")
public class DonanteController {

    private final DonacionService donacionService;

    public DonanteController(DonacionService donacionService) {
        this.donacionService = donacionService;
    }

    @PostMapping
    public ResponseEntity<DonanteDTO> crearDonante(@RequestBody DonanteDTO dto) {
        return new ResponseEntity<>(donacionService.crearDonante(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DonanteDTO>> listarDonantes() {
        return ResponseEntity.ok(donacionService.listarDonantes());
    }
}