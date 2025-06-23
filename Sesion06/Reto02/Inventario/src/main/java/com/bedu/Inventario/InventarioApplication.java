package com.bedu.Inventario;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bedu.Inventario.Models.Categoria;
import com.bedu.Inventario.Models.Marca;
import com.bedu.Inventario.Models.Producto;
import com.bedu.Inventario.Repository.CategoriaRepository;
import com.bedu.Inventario.Repository.MarcaRepository;
import com.bedu.Inventario.Repository.ProductoRepository;

@SpringBootApplication
public class InventarioApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventarioApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(ProductoRepository productoRepo, CategoriaRepository categoriaRepo, MarcaRepository marcaRepo) {
        return (args) -> {
           
           Categoria tecnologia = new Categoria("Tecnología");
           categoriaRepo.save(tecnologia); 
            
            Marca apple = new Marca("Apple");
            marcaRepo.save(apple);

            Marca samsung = new Marca("Samsung");
            marcaRepo.save(samsung);

            productoRepo.save(new Producto("Iphone 15", "128 GB", 14500.00, tecnologia, apple));
            productoRepo.save(new Producto("iPad Pro", "Pantalla Ultra Retina XDR", 12000.00, tecnologia, apple));
            productoRepo.save(new Producto("Galaxy S23", "128 GB y 8 GB", 7800.00, tecnologia,samsung));
            productoRepo.save(new Producto("Smart TV", "Pantalla 10 pulgadas", 100800.00, tecnologia,samsung));

            System.out.println("📚 Productos por marca:");
            marcaRepo.findAll().forEach(marca -> {
            System.out.println("🏷️ " + marca.getNombre() + ":");
            productoRepo.findAll().stream()
                .filter(p -> p.getMarca().getId().equals(marca.getId()))
                .forEach(p -> System.out.println("   - " + p.getNombre()));
            });
        };
    }
}
