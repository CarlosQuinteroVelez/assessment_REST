package com.assessment.assessment.controller;

import com.assessment.assessment.model.Phones;
import com.assessment.assessment.model.User;
import com.assessment.assessment.model.UserResponse;
import com.assessment.assessment.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.TreeMap;

@RestController
public class UserController {

    private final UserService userService;

    private final ObjectMapper objectMapper;

    @Autowired
    public UserController(ObjectMapper objectMapper, UserService userService) {
        this.objectMapper = objectMapper;
        this.userService = userService;
    }

    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        try {
            System.out.println(user.toString());
            for (Phones phone : user.getPhones()) {
                phone.setUser(user);
            }
            user.setCreated(LocalDateTime.now());
            user.setModified(LocalDateTime.now());
            user.setLastLogin(LocalDateTime.now());
           // user.setToken(generateToken());
            user.setActive(true);
            LinkedHashMap<String, Object> responseObject = new  LinkedHashMap<>();
            responseObject.put("mensaje", "Usuario creado exitosamente");
            responseObject.put("id", user.getId());
            responseObject.put("created", user.getCreated().toString());
            responseObject.put("modified", user.getModified().toString());
            responseObject.put("last_login", user.getLastLogin().toString());
            responseObject.put("token", user.getToken());
            responseObject.put("isactive", user.isActive());

            JSONObject jsonResponse = new JSONObject(responseObject);

             userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(jsonResponse.toString());
        }catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"mensaje\": \"El correo ya está registrado\"}");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"mensaje\": \"El JSON enviado no es válido\"}");
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Object> getUser(@PathVariable long id) {
        User user = userService.getUserById(id);
        if (user != null) {

            UserResponse response = new UserResponse("Usuario obtenido exitosamente", user);
            return ResponseEntity.ok().body(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"mensaje\": \"El usuario con el ID proporcionado no existe\"}");
        }
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable long id) {
        if (userService.existsById(id)) {
            userService.deleteUserById(id);
            return ResponseEntity.ok().body("{\"mensaje\": \"Usuario eliminado exitosamente\"}");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"mensaje\": \"El usuario con el ID proporcionado no existe\"}");
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable long id, @RequestBody User user) {
        if (userService.existsById(id)) {
            user.setId(id);
            userService.updateUser(user);
            return ResponseEntity.ok().body("{\"mensaje\": \"Usuario actualizado exitosamente\"}");

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"mensaje\": \"El usuario con el ID proporcionado no existe\"}");
        }
    }
}