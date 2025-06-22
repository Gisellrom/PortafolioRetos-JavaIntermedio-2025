package gestionordenes;

abstract class OrdenProduccion {
    protected String codigo;
    protected int cantidad;

    //    Constructor
    OrdenProduccion(String codigo, int cantidad){
        this.codigo = codigo;
        this.cantidad = cantidad;
    }


    // Método abtracto sin implementacion
    public abstract void mostrarResumen();


}