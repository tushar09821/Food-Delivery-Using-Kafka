package com.dobby.user_service.mapper;

import com.dobby.user_service.dto.UserRequestDto;
import com.dobby.user_service.dto.UserResponseDTO;
import com.dobby.user_service.entity.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserRequestDto dto);

    UserResponseDTO toResponseDTO(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDTo(UserRequestDto dto, @MappingTarget User user);
}
