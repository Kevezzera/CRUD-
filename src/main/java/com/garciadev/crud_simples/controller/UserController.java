package com.garciadev.crud_simples.controller;

import com.garciadev.crud_simples.dto.UserDto;
import com.garciadev.crud_simples.entity.UserEntity;
import com.garciadev.crud_simples.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "USERS", description = "Gerenciador de registros")
@RequestMapping("/user")
@RestController
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @Operation(summary = "Cadastrar novo cliente", description = "Cadastre um novo cliente.")
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody UserDto userDto){
        try {
            String msg = userService.save(userDto);
            return new  ResponseEntity<>(msg, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Deletar registro.", description = "Delete registros do Db com base no Id.")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        try {
            String msg = userService.delete(id);
            return new ResponseEntity<>(msg, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Listar registros", description = "Lista todos os registros do DB")
    @GetMapping("/findall")
    public ResponseEntity<List<UserDto>> findAll(){
        try {
            List<UserDto> list = userService.findAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Buscar registro", description = "Busca registros com base em seu nome")
    @GetMapping("/finbyname")
    public ResponseEntity<List<UserDto>> findByContain(String name){
        try {
            List<UserDto> list = userService.findByNameContain(name);
            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.BAD_REQUEST);
        }
    }
}
