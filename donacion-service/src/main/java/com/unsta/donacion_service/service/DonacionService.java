package com.unsta.donacion_service.service;

import com.unsta.donacion_service.dto.*;
import com.unsta.donacion_service.model.*;
import com.unsta.donacion_service.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DonacionService {

    private final DonanteRepository donanteRepository;
    private final DonacionRepository donacionRepository;

    public DonacionService(DonanteRepository donanteRepository, DonacionRepository donacionRepository) {
        this.donanteRepository = donanteRepository;
        this.donacionRepository = donacionRepository;
    }

    public DonanteDTO crearDonante(DonanteDTO dto) {
        Donante donante = new Donante();
        donante.setNombre(dto.getNombre());
        donante.setDocumento(dto.getDocumento());
        donante.setEmail(dto.getEmail());
        donante.setTelefono(dto.getTelefono());
        donante.setTipoDonante(dto.getTipoDonante());

        Donante guardado = donanteRepository.save(donante);
        dto.setId(guardado.getId());
        return dto;
    }

    public List<DonanteDTO> listarDonantes() {
        return donanteRepository.findAll().stream().map(d -> {
            DonanteDTO dto = new DonanteDTO();
            dto.setId(d.getId());
            dto.setNombre(d.getNombre());
            dto.setDocumento(d.getDocumento());
            dto.setEmail(d.getEmail());
            dto.setTelefono(d.getTelefono());
            dto.setTipoDonante(d.getTipoDonante());
            return dto;
        }).collect(Collectors.toList());
    }

    @Transactional
    public DonacionResponseDTO registrarDonacion(DonacionRequestDTO request) {
        Donante donante = donanteRepository.findById(request.getDonanteId())
                .orElseThrow(() -> new RuntimeException("Donante no encontrado con ID: " + request.getDonanteId()));

        Donacion donacion = new Donacion();
        donacion.setDonante(donante);
        donacion.setEstado(EstadoDonacion.REGISTRADA);
        donacion.setObservaciones(request.getObservaciones());

        if (request.getItems() != null) {
            for (ItemDonacionDTO itemDto : request.getItems()) {
                ItemDonacion item = new ItemDonacion();
                item.setDescripcion(itemDto.getDescripcion());
                item.setCategoria(itemDto.getCategoria());
                item.setCantidad(itemDto.getCantidad());
                item.setUnidadMedida(itemDto.getUnidadMedida());
                item.setFechaVencimiento(itemDto.getFechaVencimiento());
                item.setDonacion(donacion);
                donacion.getItems().add(item);
            }
        }

        Donacion guardada = donacionRepository.save(donacion);
        return mapearADonacionResponse(guardada);
    }

    public List<DonacionResponseDTO> listarDonaciones() {
        return donacionRepository.findAll().stream()
                .map(this::mapearADonacionResponse)
                .collect(Collectors.toList());
    }

    public DonacionResponseDTO obtenerDonacionPorId(Long id) {
        Donacion donacion = donacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Donacion no encontrada con ID: " + id));
        return mapearADonacionResponse(donacion);
    }

    private DonacionResponseDTO mapearADonacionResponse(Donacion donacion) {
        DonacionResponseDTO resp = new DonacionResponseDTO();
        resp.setId(donacion.getId());
        resp.setFechaRegistro(donacion.getFechaRegistro());
        resp.setEstado(donacion.getEstado());
        resp.setObservaciones(donacion.getObservaciones());
        resp.setDonanteId(donacion.getDonante().getId());
        resp.setDonanteNombre(donacion.getDonante().getNombre());

        List<ItemDonacionDTO> itemsDto = new ArrayList<>();
        if (donacion.getItems() != null) {
            for (ItemDonacion item : donacion.getItems()) {
                ItemDonacionDTO iDto = new ItemDonacionDTO();
                iDto.setId(item.getId());
                iDto.setDescripcion(item.getDescripcion());
                iDto.setCategoria(item.getCategoria());
                iDto.setCantidad(item.getCantidad());
                iDto.setUnidadMedida(item.getUnidadMedida());
                iDto.setFechaVencimiento(item.getFechaVencimiento());
                itemsDto.add(iDto);
            }
        }
        resp.setItems(itemsDto);
        return resp;
    }
}