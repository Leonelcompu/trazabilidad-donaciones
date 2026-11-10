package com.unsta.trazabilidad_service.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "trazabilidades")
public class Trazabilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String codigoSeguimiento;

    @Column(nullable = false)
    private Long donacionId;

    private Long loteId;

    private Long distribucionId;

    @Column(nullable = false)
    private String etapa; // REGISTRADO, EN_STOCK, EN_TRANSITO, ENTREGADO

    private String ubicacion;

    private String observaciones;

    private LocalDateTime fechaRegistro;

    public Trazabilidad() {
    }

    public Trazabilidad(String codigoSeguimiento, Long donacionId, Long loteId, Long distribucionId, String etapa, String ubicacion, String observaciones) {
        this.codigoSeguimiento = codigoSeguimiento;
        this.donacionId = donacionId;
        this.loteId = loteId;
        this.distribucionId = distribucionId;
        this.etapa = etapa;
        this.ubicacion = ubicacion;
        this.observaciones = observaciones;
        this.fechaRegistro = LocalDateTime.now();
    }

    @PrePersist
    public void prePersist() {
        if (this.fechaRegistro == null) {
            this.fechaRegistro = LocalDateTime.now();
        }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCodigoSeguimiento() { return codigoSeguimiento; }
    public void setCodigoSeguimiento(String codigoSeguimiento) { this.codigoSeguimiento = codigoSeguimiento; }

    public Long getDonacionId() { return donacionId; }
    public void setDonacionId(Long donacionId) { this.donacionId = donacionId; }

    public Long getLoteId() { return loteId; }
    public void setLoteId(Long loteId) { this.loteId = loteId; }

    public Long getDistribucionId() { return distribucionId; }
    public void setDistribucionId(Long distribucionId) { this.distribucionId = distribucionId; }

    public String getEtapa() { return etapa; }
    public void setEtapa(String etapa) { this.etapa = etapa; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }
}