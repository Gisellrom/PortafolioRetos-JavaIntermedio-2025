package com.bedu.Inventario.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.bedu.Inventario.Models.Marca;

// Esta interfaz extiende JpaRepository para gestionar operaciones CRUD sobre la entidad Producto
public interface MarcaRepository extends JpaRepository<Marca, Long> {

    
}