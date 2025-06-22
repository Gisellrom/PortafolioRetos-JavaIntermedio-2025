package PlataformaEducativa;

public class Ejercicio extends MaterialCurso{

    private boolean revisado;

    public Ejercicio(String titulo, String autor, boolean revisado) {
        super(titulo, autor);
        this.revisado = revisado;
    }

    public void setRevisado(boolean revisado){
        this.revisado = revisado;
    }

    public boolean isRevisado() {
        return revisado;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("\uD83D\uDCDD Ejercicio: "+titulo+" - Autor: "+autor+" - Revisado: " +revisado);
    }
}
