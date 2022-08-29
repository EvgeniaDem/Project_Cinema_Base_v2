package com.kata.cinema.base.webapp.controllers;
import com.kata.cinema.base.exceptions.PasswordNotFoundException;
import com.kata.cinema.base.models.dto.request.UserRegistrationRequestDto;
import com.kata.cinema.base.models.entitys.Role;
import com.kata.cinema.base.models.entitys.User;
import com.kata.cinema.base.service.abstracts.model.RoleService;
import com.kata.cinema.base.service.abstracts.model.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
public class RegistrationRestController {

    private UserService userService;
    private RoleService roleService;

    public RegistrationRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostMapping("/api/registration")
    public ResponseEntity registration(UserRegistrationRequestDto userRegistrationRequestDto) {

        if (userRegistrationRequestDto.getPassword().equals(userRegistrationRequestDto.getConfirmPassword())) {
            Set<Role> role = new HashSet<>();
            role.add(roleService.findByName("USER_ROLE"));
            User user = new User(userRegistrationRequestDto.getEmail(), userRegistrationRequestDto.getFirstName(),
                    userRegistrationRequestDto.getLastName(), userRegistrationRequestDto.getPassword(),
                    userRegistrationRequestDto.getBirthday(), null, role);
            userService.create(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            throw new PasswordNotFoundException("Password: " + userRegistrationRequestDto.getPassword() + " and confirm password: " + userRegistrationRequestDto.getConfirmPassword() + " not match");
        }

    }
}
