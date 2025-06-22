package PlataformaEducativa;

public abstract class MaterialCurso {

    //Atributos
    protected String titulo;
    protected String autor;

    //Constructor
    public MaterialCurso(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }
    public String getAutor(){
        return autor;
    }

    //Método abstracto sin implementacion
    public abstract void mostrarDetalle();

}
