package com.dobby.user_service.controller;

import com.dobby.user_service.dto.Create;
import com.dobby.user_service.dto.Update;
import com.dobby.user_service.dto.UserRequestDto;
import com.dobby.user_service.serivce.UserService;
import com.dobby.user_service.util.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse>getUserByID(@PathVariable int id){
     return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success("User found",userService.getUserById(id)));
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> registerUser(@Validated(Create.class) @RequestBody UserRequestDto userRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("User created ",userService.createUser(userRequestDto)));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse> updateUserDetails(@Validated(Update.class) @RequestBody UserRequestDto userRequestDto, @PathVariable int id){
         return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("User updated",userService.updateUser(userRequestDto,id)));
    }
}
