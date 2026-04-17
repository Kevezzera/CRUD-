package com.garciadev.crud_simples.repository;

import com.garciadev.crud_simples.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {


    public List<UserEntity> findByNameContaining(String name);
}
