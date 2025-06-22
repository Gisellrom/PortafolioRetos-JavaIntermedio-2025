package PlataformaEducativa;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Materiales {

    //Metodo generico para mostar detalle de todos los materiales
    public void mostrarMateriales(List<? extends MaterialCurso> lista){
        System.out.println();
        lista.forEach(MaterialCurso::mostrarDetalle);
    }

    //Metodo generico que Suma y muestra la duración total de los videos)
    public void contarDuracionVideos(List<? extends Video> lista){
        int totalMinutos = 0;
        for(Object obj : lista){
            if(obj instanceof Video){
                totalMinutos += ((Video) obj).getDuracionMinutos();
            }
        }
        System.out.println("\uD83C\uDFA5 Duración total de videos: " + totalMinutos +" minutos");
    }

    //Actualiza el estado de los ejercicios a revisado = true y muestra un mensaje por cada uno
    public void marcarEjerciciosRevisados(List<? super Ejercicio> lista){
        for(Object obj : lista){
            if(obj instanceof Ejercicio){
                if(((Ejercicio) obj).isRevisado() == false){
                    ((Ejercicio) obj).setRevisado(true);
                }
                System.out.println("✅ Ejercicio: "+((Ejercicio) obj).titulo +" marcado como revisado.");
            }
        }
    }

    //    Método generico que filtre materiales por autor
    public List<MaterialCurso> filtrarPorAutor(List<? extends MaterialCurso> lista, Predicate<MaterialCurso> filtro) {
        return lista.stream()
                .filter(filtro)
                .collect(Collectors.toList());
    }


}
