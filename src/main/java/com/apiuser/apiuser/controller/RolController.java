package com.apiuser.apiuser.controller;

import com.apiuser.apiuser.model.Rol;
import com.apiuser.apiuser.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rol")
public class RolController {

    @Autowired
    private RolRepository rolRepository;

    @GetMapping
    public List<Rol> obtenerTodosLosRoles() {
        return rolRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> obtenerRolPorId(@PathVariable Long id) {
        Optional<Rol> rol = rolRepository.findById(id);
        return rol.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Rol crearRol(@RequestBody Rol rol) {
        return rolRepository.save(rol);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rol> actualizarRol(@PathVariable Long id, @RequestBody Rol rolActualizado) {
        Optional<Rol> rolExistente = rolRepository.findById(id);
        if (rolExistente.isPresent()) {
            rolActualizado.setRolId(id);
            return ResponseEntity.ok(rolRepository.save(rolActualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRol(@PathVariable Long id) {
        Optional<Rol> rolExistente = rolRepository.findById(id);
        if (rolExistente.isPresent()) {
            rolRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}