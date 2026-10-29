package com.unsta.donacion_service.dto;

import com.unsta.donacion_service.model.TipoDonante;

public class DonanteDTO {
    private Long id;
    private String nombre;
    private String documento;
    private String email;
    private String telefono;
    private TipoDonante tipoDonante;

    public DonanteDTO() {}

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
}