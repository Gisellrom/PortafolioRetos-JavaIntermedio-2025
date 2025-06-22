package PlataformaEducativa;

public class Video extends MaterialCurso{
    private int duracionMinutos;

    public Video(String titulo, String autor, int duracionMinutos) {
        super(titulo, autor);
        this.duracionMinutos = duracionMinutos;
    }

    public int getDuracionMinutos(){
        return duracionMinutos;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("\uD83C\uDFA5 Video: " +titulo+ " - Autor: "+autor+" - Duración: "+ duracionMinutos +" min");
    }
}
