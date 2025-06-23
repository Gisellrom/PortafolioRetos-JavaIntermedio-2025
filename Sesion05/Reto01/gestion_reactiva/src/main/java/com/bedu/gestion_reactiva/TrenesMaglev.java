package com.bedu.gestion_reactiva;

public class TrenesMaglev {
    private final String linea;
    private final int retrasoMinutos;

    public TrenesMaglev(String linea, int retrasoMinutos) {
        this.linea = linea;
        this.retrasoMinutos = retrasoMinutos;
    }

    public String getLinea() {
        return linea;
    }

    public int getRetrasoMinutos() {
        return retrasoMinutos;
    }
}