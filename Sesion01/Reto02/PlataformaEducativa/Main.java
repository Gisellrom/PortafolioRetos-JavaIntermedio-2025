package PlataformaEducativa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){

        //Instanciamos un objeto de la clase Generica:
        Materiales mtr = new Materiales();

        //Materiales con video
        Video v1 = new Video("Introducción a Java", "Mario",15);
        Video v2 = new Video("POO en Java","Carlos",20);

        //Materiales con Articulos
        Articulo art1 = new Articulo("Historia de Java","Ana",1200);
        Articulo art2 = new Articulo("Tipos de datos","Luis",800);

        //Materiales con Ejercicio
        Ejercicio ejer1 = new Ejercicio("Variables y tipos","Luis",false);
        Ejercicio ejer2 = new Ejercicio("Condicionales","Mario",false);

        //Agregamos los objetos creados a las listas correspondientes:

        //Para videos
        List<Video> listaVideos = new ArrayList<>();
        listaVideos.add(v1);
        listaVideos.add(v2);

        //Para articulos:
        List<Articulo> listaArticulos = new ArrayList<>();
        listaArticulos.add(art1);
        listaArticulos.add(art2);

        List<Ejercicio> listaEjercicios = new ArrayList<>();
        listaEjercicios.add(ejer1);
        listaEjercicios.add(ejer2);

        //Mostramos los materiales:
        System.out.println();
        System.out.println("\uD83D\uDCDA Materiales del curso: \n");

        mtr.mostrarMateriales(listaVideos);

        mtr.mostrarMateriales(listaArticulos);

        mtr.mostrarMateriales(listaEjercicios);

        System.out.println();
        //Mostramos la duracion total de los videos
        mtr.contarDuracionVideos(listaVideos);
        System.out.println();

        //Mostramos que se revisaron los videos
        mtr.marcarEjerciciosRevisados(listaEjercicios);

        //Todos los materiales en una lista
        List<MaterialCurso> material = new ArrayList<>();
        material.addAll(listaVideos);
        material.addAll(listaArticulos);
        material.addAll(listaEjercicios);

        //  Filtrar por autor
        System.out.println();
        List<MaterialCurso> filtrados = mtr.filtrarPorAutor(
                material,
                m -> m.getAutor().equalsIgnoreCase("Mario")
        );

        System.out.println("🔍 Filtrando materiales por autor:");
        mtr.mostrarMateriales(filtrados);

    }
}
