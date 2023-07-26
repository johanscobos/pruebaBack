package com.apiuser.apiuser.repository;

import com.apiuser.apiuser.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

// UsuarioRepository.java
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}