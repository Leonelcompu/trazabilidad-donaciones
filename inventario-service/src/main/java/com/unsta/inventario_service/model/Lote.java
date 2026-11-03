package com.unsta.inventario_service.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "lotes")
public class Lote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private String categoria;

    @Column(nullable = false)
    private Double cantidad;

    @Column(name = "unidad_medida", nullable = false)
    private String unidadMedida; // KG, LITROS, UNIDADES

    @Column(name = "fecha_ingreso", nullable = false)
    private LocalDate fechaIngreso;

    @Column(name = "fecha_vencimiento", nullable = false)
    private LocalDate fechaVencimiento;

    @Column(name = "donacion_id")
    private Long donacionId;

    public Lote() {
    }

    public Lote(String descripcion, String categoria, Double cantidad, String unidadMedida, LocalDate fechaIngreso, LocalDate fechaVencimiento, Long donacionId) {
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.unidadMedida = unidadMedida;
        this.fechaIngreso = fechaIngreso;
        this.fechaVencimiento = fechaVencimiento;
        this.donacionId = donacionId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public Double getCantidad() { return cantidad; }
    public void setCantidad(Double cantidad) { this.cantidad = cantidad; }

    public String getUnidadMedida() { return unidadMedida; }
    public void setUnidadMedida(String unidadMedida) { this.unidadMedida = unidadMedida; }

    public LocalDate getFechaIngreso() { return fechaIngreso; }
    public void setFechaIngreso(LocalDate fechaIngreso) { this.fechaIngreso = fechaIngreso; }

    public LocalDate getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(LocalDate fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

    public Long getDonacionId() { return donacionId; }
    public void setDonacionId(Long donacionId) { this.donacionId = donacionId; }
}