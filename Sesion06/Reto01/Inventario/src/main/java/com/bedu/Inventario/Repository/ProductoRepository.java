package com.bedu.Inventario.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bedu.Inventario.Models.Producto;

import java.util.List;

// Esta interfaz extiende JpaRepository para gestionar operaciones CRUD sobre la entidad Producto
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // Método personalizado que busca productos cuyo nombre contenga un texto específico (no sensible a mayúsculas)
    List<Producto> findByNombreContaining(String nombre);

    List<Producto> findByPrecioGreaterThan(double precio);
    List<Producto> findByNombreContainingIgnoreCase(String nombre);
    List<Producto> findByPrecioBetween(double min, double max);
    List<Producto> findByNombreStartingWithIgnoreCase(String prefijo);
}
