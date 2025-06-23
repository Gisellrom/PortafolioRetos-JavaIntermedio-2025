package com.bedu.gestion_reactiva;


import java.time.Duration;
import java.util.Random;

import reactor.core.publisher.Flux;


public class MeridianPrimeSimulador {

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();

        //Simulacion de Sensores de Trafico
        Flux<String> sensoresTraficoFlux = Flux
            .interval(Duration.ofMillis(500))
            .map(i -> new SensoresTrafico("Avenida Juarez", random.nextInt(101)))
            .filter(evento -> evento.getCongestion() > 70)
            .map(evento -> "Alerta de congestion en " + evento.getUbicacion() + 
                            " con nivel de congestion vial: " + evento.getCongestion() + "%")
            .doOnNext(System.out::println)
            .onBackpressureBuffer(10);

        //Simulacion de Conaminacion del Aire
        Flux<String> contaminacionAireFlux = Flux
            .interval(Duration.ofMillis(600))
            .map(i -> new ContaminacionAire("Plaza central", random.nextDouble()*100))
            .filter(evento -> evento.getNivelContaminacion() > 50)
            .map(evento -> "Alerta de contaminacion en " + evento.getUbicacion() +
                            " con nivel de contamincion: " + evento.getNivelContaminacion())
                            .doOnNext(System.out::println);


        //Simulacion de Accidentes viales
        Flux<String> accidentesVialesFlux = Flux
            .interval(Duration.ofMillis(800))
            .map(i -> new AccidentesViales("Avenida Circunvalación", AccidentesViales.Prioridad.values()[random.nextInt(3)]))
            .filter(evento -> evento.getPrioridad() == AccidentesViales.Prioridad.ALTA)
            .map(evento -> "Alerta de accidente vial en " + evento.getUbicacion() +
                            " con prioridad: " + evento.getPrioridad())
            .doOnNext(System.out::println);


        //Simulacion de Trenes Maglev
        Flux<String> trenesMaglevFlux = Flux
            .interval(Duration.ofMillis(700))
            .map(i -> new TrenesMaglev("Línea 1", random.nextInt(11)))
            .filter(evento -> evento.getRetrasoMinutos() > 5)
            .map(evento -> "Alerta de retraso en " + evento.getLinea() +
                            " con retraso de: " + evento.getRetrasoMinutos() + " minutos")
            .doOnNext(System.out::println)
            .delayElements(Duration.ofMillis(200)); // Simula un retraso en la emisión de eventos, es decir, cada 200 ms se emite un nuevo evento, lo que simula un -backpressure- en el flujo de datos.


        //Simulacion de Semaforo Inteligente
        Flux<String> semaforoInteligenteFlux = Flux
    .interval(Duration.ofMillis(800))
    .map(i -> new Semaforos("Avenida Principal", Semaforos.EstadoSemaforo.values()[random.nextInt(3)]))
    .filter(evento -> evento.getEstado() == Semaforos.EstadoSemaforo.ROJO)
    .scan(
        new Object() { Semaforos.EstadoSemaforo prev = null; int count = 0; String interseccion = ""; },
        (est, evento) -> {
            if(evento.getEstado() == Semaforos.EstadoSemaforo.ROJO) {
                est.count = (est.prev == Semaforos.EstadoSemaforo.ROJO) ? est.count + 1 : 1;
            } else {
                est.count = 0;
            }
            est.prev = evento.getEstado();
            est.interseccion = evento.getInterseccion();
            return est;
        }
    )
    .filter(est -> est.count == 3)
    .map(est -> "Alerta: El semáforo en " + est.interseccion + " ha estado en ROJO 3 veces consecutivas.")
    .doOnNext(System.out::println);


    //ALERTA GLOBAL: si 3 o más eventos críticos ocurren en un intervalo corto
    Flux.merge(sensoresTraficoFlux, contaminacionAireFlux, accidentesVialesFlux, trenesMaglevFlux, semaforoInteligenteFlux)
        .window(Duration.ofMillis(300))
        .flatMap(window -> window.collectList())
        .filter(list -> list.size() >=3)
        .doOnNext(list -> System.out.println("ALERTA GLOBAL: Múltiples eventos críticos detectados en Meridian Prime"))
        .subscribe();

        //Mantener la aplicación corriendo para la demo (10 segundos)
        Thread.sleep(10000);


    }

}