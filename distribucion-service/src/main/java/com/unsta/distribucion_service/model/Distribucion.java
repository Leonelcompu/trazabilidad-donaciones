package com.unsta.distribucion_service.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "distribuciones")
public class Distribucion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long loteId;

    private Long solicitudId;

    @Column(nullable = false, length = 150)
    private String destino;

    @Column(length = 100)
    private String responsable;

    @Column(nullable = false)
    private Double cantidadEntregada;

    @Column(nullable = false, length = 30)
    private String estado;

    @Column(nullable = false)
    private LocalDateTime fechaDistribucion;

    @Column(length = 255)
    private String observaciones;

    public Distribucion() {
        this.fechaDistribucion = LocalDateTime.now();
        this.estado = "EN_TRANSITO";
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getLoteId() { return loteId; }
    public void setLoteId(Long loteId) { this.loteId = loteId; }
    public Long getSolicitudId() { return solicitudId; }
    public void setSolicitudId(Long solicitudId) { this.solicitudId = solicitudId; }
    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }
    public String getResponsable() { return responsable; }
    public void setResponsable(String responsable) { this.responsable = responsable; }
    public Double getCantidadEntregada() { return cantidadEntregada; }
    public void setCantidadEntregada(Double cantidadEntregada) { this.cantidadEntregada = cantidadEntregada; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public LocalDateTime getFechaDistribucion() { return fechaDistribucion; }
    public void setFechaDistribucion(LocalDateTime fechaDistribucion) { this.fechaDistribucion = fechaDistribucion; }
    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
}