package com.apiuser.apiuser.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombres;
    private boolean activo;
    private String email;

    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;



    // Getters, setters, constructores, etc.
}
