package com.dobby.user_service.serivce;

import com.dobby.user_service.dao.UserDao;
import com.dobby.user_service.dto.UserRequestDto;
import com.dobby.user_service.dto.UserResponseDTO;
import com.dobby.user_service.entity.User;
import com.dobby.user_service.exception.ResourceNotFoundException;
import com.dobby.user_service.mapper.UserMapper;
import com.dobby.user_service.util.ApiResponse;
import com.dobby.user_service.util.CheckNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserMapper mapper;


    private User getById(int id){
      return userDao.findById(id).orElseThrow(()-> new ResourceNotFoundException("User with id " + id + " not found"));
    }

    public UserResponseDTO getUserById(int id){
       return mapper.toResponseDTO(getById(id));
    }
    public UserResponseDTO createUser(UserRequestDto userRequestDto){
        User user = new User();
        user = mapper.toEntity(userRequestDto);
        return mapper.toResponseDTO(userDao.save(user));
    }

    public UserResponseDTO updateUser(UserRequestDto userRequestDto, int id) {
        User existingUser = getById(id);
        mapper.updateEntityFromDTo(userRequestDto,existingUser);
        return mapper.toResponseDTO( userDao.save(existingUser));


    }
}
