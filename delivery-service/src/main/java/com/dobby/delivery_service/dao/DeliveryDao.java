package com.dobby.delivery_service.dao;

import ch.qos.logback.core.model.INamedModel;
import com.dobby.delivery_service.entity.Delivery;
import com.dobby.delivery_service.util.DeliveryStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryDao extends JpaRepository<Delivery, Integer> {

    @Query("Select d from Delivery d where d.status =:status")
    List<Delivery> getAllPendingDeliveries(@Param("status") DeliveryStatus status);
}
