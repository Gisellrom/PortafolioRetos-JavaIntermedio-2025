package com.bedu.gestion_reactiva;

public class Semaforos {
    public enum EstadoSemaforo {
        VERDE, AMARILLO, ROJO
    }

    private final String interseccion;
    private final EstadoSemaforo estado;

    public Semaforos(String interseccion, EstadoSemaforo estado) {
        this.interseccion = interseccion;
        this.estado = estado;
    }

    public String getInterseccion() {
        return interseccion;
    }

    public EstadoSemaforo getEstado() {
        return estado;
    }
}