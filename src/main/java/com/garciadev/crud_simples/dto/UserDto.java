package com.garciadev.crud_simples.dto;

import com.garciadev.crud_simples.entity.UserEntity;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@NoArgsConstructor
@Setter
@Getter
public class UserDto {
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;

    public UserDto(UserEntity userEntity){
        BeanUtils.copyProperties(userEntity, this);
    }
}
