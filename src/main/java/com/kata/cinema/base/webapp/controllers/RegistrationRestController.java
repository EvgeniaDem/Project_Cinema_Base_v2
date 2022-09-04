package com.kata.cinema.base.webapp.controllers;
import com.kata.cinema.base.converter.UserMapper;
import com.kata.cinema.base.dao.entity.RoleDao;
import com.kata.cinema.base.exceptions.PasswordNotFoundException;
import com.kata.cinema.base.models.dto.request.UserRegistrationRequestDto;
import com.kata.cinema.base.models.entitys.Role;
import com.kata.cinema.base.models.entitys.User;
import com.kata.cinema.base.models.enums.Roles;
import com.kata.cinema.base.service.entity.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@AllArgsConstructor
@Validated
@AllArgsConstructor
public class RegistrationRestController {

    private final UserService userService;
    //TODO создать сервис
    private final RoleDao roleDao;
    private final UserMapper userMapper;
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/api/registration")
    public ResponseEntity<Void> registration(@RequestBody UserRegistrationRequestDto userRegistrationRequestDto) {
    public ResponseEntity<Void> registration(@Valid @RequestBody UserRegistrationRequestDto userRegistrationRequestDto) {


        if (userRegistrationRequestDto.getPassword().equals(userRegistrationRequestDto.getConfirmPassword())) {
            Set<Role> role = new HashSet<>();
            role.add(roleDao.findByName(Roles.USER));
            User user = userMapper.toUser(userRegistrationRequestDto);
            user.setRoles(role);
            userService.create(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            throw new PasswordNotFoundException("Password: " + userRegistrationRequestDto.getPassword() + " and confirm password: " + userRegistrationRequestDto.getConfirmPassword() + " not match");
        }
    }
}
