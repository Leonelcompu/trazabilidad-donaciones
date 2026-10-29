package com.unsta.donacion_service.repository;

import com.unsta.donacion_service.model.ItemDonacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDonacionRepository extends JpaRepository<ItemDonacion, Long> {
}