package Encuestas;

import java.util.Optional;

public class Encuesta {

    private final String paciente;
    private final String comentario; //puede ser null
    private final int calificacion;

    public Encuesta(String paciente, String comentario, int calificacion) {
        this.paciente = paciente;
        this.comentario = comentario;
        this.calificacion = calificacion;
    }

    public String getPaciente() {
        return paciente;
    }

    //Metodo seguro para obtener el teléfono como Optional
    public Optional<String> getComentario() {
        return Optional.ofNullable(comentario);
    }

    public int getCalificacion() {
        return calificacion;
    }
}
