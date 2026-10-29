package com.unsta.donacion_service.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "donantes")
public class Donante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String nombre;

    @Column(nullable = false, unique = true, length = 20)
    private String documento;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(length = 30)
    private String telefono;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TipoDonante tipoDonante;

    @OneToMany(mappedBy = "donante", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Donacion> donaciones = new ArrayList<>();

    public Donante() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public TipoDonante getTipoDonante() { return tipoDonante; }
    public void setTipoDonante(TipoDonante tipoDonante) { this.tipoDonante = tipoDonante; }
    public List<Donacion> getDonaciones() { return donaciones; }
    public void setDonaciones(List<Donacion> donaciones) { this.donaciones = donaciones; }
}