package com.unsta.solicitud_service.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "solicitudes")
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String solicitante;

    @Column(nullable = false, length = 60)
    private String categoriaAlimento;

    @Column(nullable = false)
    private Double cantidadRequerida;

    @Column(nullable = false, length = 20)
    private String unidadMedida;

    @Column(nullable = false, length = 20)
    private String prioridad;

    @Column(nullable = false, length = 30)
    private String estado;

    @Column(nullable = false)
    private LocalDateTime fechaSolicitud;

    @Column(length = 255)
    private String observaciones;

    public Solicitud() {
        this.fechaSolicitud = LocalDateTime.now();
        this.estado = "PENDIENTE";
        this.prioridad = "MEDIA";
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getSolicitante() { return solicitante; }
    public void setSolicitante(String solicitante) { this.solicitante = solicitante; }
    public String getCategoriaAlimento() { return categoriaAlimento; }
    public void setCategoriaAlimento(String categoriaAlimento) { this.categoriaAlimento = categoriaAlimento; }
    public Double getCantidadRequerida() { return cantidadRequerida; }
    public void setCantidadRequerida(Double cantidadRequerida) { this.cantidadRequerida = cantidadRequerida; }
    public String getUnidadMedida() { return unidadMedida; }
    public void setUnidadMedida(String unidadMedida) { this.unidadMedida = unidadMedida; }
    public String getPrioridad() { return prioridad; }
    public void setPrioridad(String prioridad) { this.prioridad = prioridad; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public LocalDateTime getFechaSolicitud() { return fechaSolicitud; }
    public void setFechaSolicitud(LocalDateTime fechaSolicitud) { this.fechaSolicitud = fechaSolicitud; }
    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
}