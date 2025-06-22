package PlataformaEducativa;

public class Articulo extends MaterialCurso{
    private int palabras;

    public Articulo(String titulo, String autor, int palabras) {
        super(titulo, autor);
        this.palabras = palabras;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("\uD83D\uDCC4 Artículo: "+titulo+" - Autor: "+autor+" - Palabras: "+ palabras);
    }
}
