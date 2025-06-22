package RecursoMedico;

import java.util.concurrent.locks.ReentrantLock;

public class MemoriaCompartida {
    String nombre = "";

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public static void usar(String profesional){
        System.out.println("\uD83D\uDC68\u200D⚕\uFE0F "+profesional+" ha ingresado a Sala de cirugía");
        System.out.println("✅ "+profesional+" ha salido de Sala de cirugía");
    }

    public static ReentrantLock candado = new ReentrantLock();
}
