package com.dobby.restaurant_service.dao;

import com.dobby.restaurant_service.entity.MenuItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemsDao extends JpaRepository<com.dobby.restaurant_service.entity.MenuItems,Integer> {
    @Query("SELECT m FROM MenuItems m WHERE m.available = true AND m.restaurant.id = :restId")
    List<MenuItems> findAllAvailableFoods(@Param("restId") int restId);
}
