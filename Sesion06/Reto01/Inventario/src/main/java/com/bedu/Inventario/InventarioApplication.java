package com.bedu.Inventario;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bedu.Inventario.Models.Producto;
import com.bedu.Inventario.Repository.ProductoRepository;

@SpringBootApplication
public class InventarioApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventarioApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(ProductoRepository repository) {
        return (args) -> {
            // Guardar algunos productos
            repository.save(new Producto("Laptop Lenovo", "Portátil de 16 pulgadas", 12500.00));
            repository.save(new Producto("Teclado mecánico", "Switch azul", 950.00));
            repository.save(new Producto("Mouse Logitech", "Alta precisión", 350.00));
            repository.save(new Producto("Monitor", "Alta resolución", 3200.00));

            // Mostrar todos los productos
            System.out.println("📂 Productos disponibles:");
            repository.findAll().forEach(System.out::println);
            System.out.println();

            System.out.println("📦 Productos con precio mayor a 500:");
            repository.findByPrecioGreaterThan(500).forEach(System.out::println);
            System.out.println();

            // Buscar por nombre parcial
            System.out.println("\n🔍 Productos que contienen 'Lap':");
            repository.findByNombreContaining("Lap").forEach(System.out::println);
            System.out.println();

            System.out.println("🎯 Productos con precio entre 400 y 1000:");
            repository.findByPrecioBetween(400,1000).forEach(System.out::println);
            System.out.println();

            System.out.println("📘 Productos cuyo nombre empieza con 'm':");
            repository.findByNombreStartingWithIgnoreCase("m").forEach(System.out::println);
            System.out.println();
        };
    }
}
