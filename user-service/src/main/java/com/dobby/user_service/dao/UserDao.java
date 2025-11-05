package com.dobby.user_service.dao;

import com.dobby.user_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
    List<User> findBytype(String type);
}
