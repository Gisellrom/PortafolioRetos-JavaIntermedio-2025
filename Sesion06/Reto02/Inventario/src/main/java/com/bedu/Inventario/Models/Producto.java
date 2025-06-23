package com.bedu.Inventario.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;



@Entity
public class Producto {

    @Id // Campo que funcionará como clave primaria de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY) // El ID se generará automáticamente (autoincremental)
    private Long id;

    // Campos que serán columnas en la tabla 'producto'
    
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;
    @NotBlank(message = "La descripción no puede estar vacía")
    private String descripcion;
    @Min(value = 1, message = "El precio debe ser mayor o igual a 1")
    private double precio;

    // Justo después de los demás atributos
    @ManyToOne
    @JoinColumn(name = "categoria_id") // nombre de la columna FK en la tabla productos
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "marca_id") // nombre de la columna FK en la tabla productos
    private Marca marca;

    protected Producto() {} // Constructor por defecto requerido por JPA

    // Constructor público para crear objetos de tipo Producto con los campos necesarios
    public Producto(String nombre, String descripcion, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    // Dentro del constructor público (debajo de los otros parámetros)
    public Producto(String nombre, String descripcion, double precio, Categoria categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
    }

    public Producto(String nombre, String descripcion, double precio, Categoria categoria, Marca marca) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.marca = marca;
    }

    // Getters para acceder a los atributos (necesarios para el funcionamiento de JPA y buenas prácticas)
    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public double getPrecio() { return precio; }

    // Agregar un getter al final de los métodos de acceso
    public Categoria getCategoria() {
        return categoria;
    }

    public Marca getMarca(){
        return marca;
    }

    
    // Dentro del método toString(), agrega la categoría y la marca de forma opcional
    @Override
    public String toString() {
        return String.format(
            "Producto[id=%d, nombre='%s', precio=%.2f, categoria='%s']",
            id, nombre, precio, categoria != null ? categoria.getNombre() : "Sin categoría",
            marca != null ? marca.getNombre() : "Sin marca"
        );
    }
}
