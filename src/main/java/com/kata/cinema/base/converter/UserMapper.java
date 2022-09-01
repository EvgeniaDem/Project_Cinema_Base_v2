
package com.kata.cinema.base.converter;


import com.kata.cinema.base.models.dto.request.UserRegistrationRequestDto;
import com.kata.cinema.base.models.entitys.User;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface UserMapper extends Converter<UserRegistrationRequestDto, User> {

    User toUser(UserRegistrationRequestDto userRegistrationRequestDto);
}
