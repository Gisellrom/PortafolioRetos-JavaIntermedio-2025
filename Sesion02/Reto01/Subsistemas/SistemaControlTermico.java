package Subsistemas;

import java.util.concurrent.Callable;

public class SistemaControlTermico implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "\uD83D\uDD25 Control térmico: temperatura estable (22°C).";
    }
}
