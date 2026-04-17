package com.garciadev.crud_simples.service;

import com.garciadev.crud_simples.dto.UserDto;
import com.garciadev.crud_simples.entity.UserEntity;
import com.garciadev.crud_simples.repository.UserRepository;
import com.garciadev.crud_simples.utils.MetodosUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String save(UserDto userdto){
        MetodosUtils metodosUtils = new MetodosUtils();
        if (!metodosUtils.validEmail(userdto.getEmail())) return "ERRO! no campo EMAIL " + HttpStatus.BAD_REQUEST;

        UserEntity user = new UserEntity(userdto);
        userRepository.save(user);
        return "Registro realizado!";
    }

    public String delete(Long id){
        userRepository.deleteById(id);
        return "ID " + id + " deletado!";
    }

    public List<UserDto> findAll(){
        List<UserEntity> list = userRepository.findAll();
        return list.stream().map(UserDto::new).toList();
    }

    public List<UserDto> findByNameContain(String name){
        List<UserEntity> list = userRepository.findByNameContaining(name);
        return list.stream().map(UserDto::new).toList();
    }
}
