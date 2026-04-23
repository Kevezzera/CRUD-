package com.garciadev.crud_simples.repository;

import com.garciadev.crud_simples.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {


    Optional<UserDetails> findByUserByEmail(String userName);

    public List<UserEntity> findByNameContaining(String name);
}
