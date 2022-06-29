package com.example.fortylineshr.repository;

import com.example.fortylineshr.model.AuthInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<AuthInfo,Long> {


  Optional<AuthInfo> findByEmail(String name);
}
