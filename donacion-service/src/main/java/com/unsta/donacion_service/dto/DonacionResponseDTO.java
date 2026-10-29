package com.unsta.donacion_service.dto;

import com.unsta.donacion_service.model.EstadoDonacion;
import java.time.LocalDateTime;
import java.util.List;

public class DonacionResponseDTO {
    private Long id;
    private LocalDateTime fechaRegistro;
    private EstadoDonacion estado;
    private String observaciones;
    private Long donanteId;
    private String donanteNombre;
    private List<ItemDonacionDTO> items;

    public DonacionResponseDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }
    public EstadoDonacion getEstado() { return estado; }
    public void setEstado(EstadoDonacion estado) { this.estado = estado; }
    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
    public Long getDonanteId() { return donanteId; }
    public void setDonanteId(Long donanteId) { this.donanteId = donanteId; }
    public String getDonanteNombre() { return donanteNombre; }
    public void setDonanteNombre(String donanteNombre) { this.donanteNombre = donanteNombre; }
    public List<ItemDonacionDTO> getItems() { return items; }
    public void setItems(List<ItemDonacionDTO> items) { this.items = items; }
}