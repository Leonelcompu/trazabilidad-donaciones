package com.unsta.donacion_service.dto;

import java.util.List;

public class DonacionRequestDTO {
    private Long donanteId;
    private String observaciones;
    private List<ItemDonacionDTO> items;

    public DonacionRequestDTO() {}

    public Long getDonanteId() { return donanteId; }
    public void setDonanteId(Long donanteId) { this.donanteId = donanteId; }
    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
    public List<ItemDonacionDTO> getItems() { return items; }
    public void setItems(List<ItemDonacionDTO> items) { this.items = items; }
}