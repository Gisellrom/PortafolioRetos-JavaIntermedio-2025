package com.bedu.gestion_reactiva;

public class SensoresTrafico {
    private final String ubicacion;
    private final int congestion;

    public SensoresTrafico(String ubicacion, int congestion) {
        this.ubicacion = ubicacion;
        this.congestion = congestion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public int getCongestion() {
        return congestion;
    }
    
}