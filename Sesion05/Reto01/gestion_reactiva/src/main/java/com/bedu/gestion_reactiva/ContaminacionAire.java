package com.bedu.gestion_reactiva;

public class ContaminacionAire {
    private final String ubicacion;
    private final Double nivelContaminacion;

    public ContaminacionAire(String ubicacion, Double nivelContaminacion) {
        this.ubicacion = ubicacion;
        this.nivelContaminacion = nivelContaminacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public Double getNivelContaminacion(){
        return nivelContaminacion;
    }
}