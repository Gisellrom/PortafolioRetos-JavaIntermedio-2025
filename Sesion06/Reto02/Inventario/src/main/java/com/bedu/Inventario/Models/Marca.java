package com.bedu.Inventario.Models;

import jakarta.persistence.*;

@Entity
public class Marca {

    @Id // Esta anotación indica que el campo 'id' será la clave primaria de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY) // El valor del ID se generará automáticamente (autoincremental) por la base de datos
    private Long id;

    private String nombre;

    protected Marca() {}

    public Marca(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
}