package Subsistemas;

import java.util.concurrent.Callable;

public class SistemaSoporteVital implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "\uD83E\uDDEA Soporte vital: presión y oxígeno dentro de parámetros normales.";
    }
}
