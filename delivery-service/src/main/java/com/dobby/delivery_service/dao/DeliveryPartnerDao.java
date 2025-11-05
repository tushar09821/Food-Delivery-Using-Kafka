package com.dobby.delivery_service.dao;

import com.dobby.delivery_service.entity.DeliveryPartner;
import com.dobby.delivery_service.util.PartnerAvailabliltyStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DeliveryPartnerDao extends JpaRepository<DeliveryPartner,Integer> {
    @Query("SELECT dp FROM DeliveryPartner dp WHERE dp.availabilityStatus = :status")
    List<DeliveryPartner> findAvailablePartners(@Param("status") PartnerAvailabliltyStatus status);
}
