package com.bedu.gestion_reactiva;

import java.time.Duration;
import java.util.Random;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class UCIMonitor {

    static class EventoVital {
        final int pacienteId;
        final int fc;      // Frecuencia cardiaca
        final int paSys;   // Presión arterial sistólica
        final int paDia;   // Presión arterial diastólica
        final int spo2;    // Oxígeno en sangre

        EventoVital(int pacienteId, int fc, int paSys, int paDia, int spo2) {
            this.pacienteId = pacienteId;
            this.fc = fc;
            this.paSys = paSys;
            this.paDia = paDia;
            this.spo2 = spo2;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Flux<EventoVital> paciente1 = generarFlujoPaciente(1);
        Flux<EventoVital> paciente2 = generarFlujoPaciente(2);
        Flux<EventoVital> paciente3 = generarFlujoPaciente(3);

        // Fusiona los flujos de los 3 pacientes
        Flux<EventoVital> flujoFusionado = Flux.merge(paciente1, paciente2, paciente3);

        flujoFusionado
                .onBackpressureDrop() // se utliiza en caso de que se requiera mantener la frecuencia rápida pero se quiere evitar producir un error cuando los eventos llegan más rápido de lo que se consumen.
                .filter(UCIMonitor::esEventoCritico) // Filtra eventos críticos
                .delayElements(Duration.ofSeconds(1)) // Backpressure: procesa más lento
                .publishOn(Schedulers.boundedElastic())
                .subscribe(UCIMonitor::imprimirAlerta, error -> System.err.println("Error en el flujo: " + error.getMessage())); //ademas se agrrega un segundo parametro en .subscribe()

        // Mantén el programa corriendo un tiempo para observar la salida
        Thread.sleep(20000);
    }

    static Flux<EventoVital> generarFlujoPaciente(int pacienteId) {
        Random random = new Random();
        return Flux.interval(Duration.ofMillis(300))
                .map(i -> new EventoVital(
                        pacienteId,
                        40 + random.nextInt(100),    // FC: 40 a 140 bpm
                        80 + random.nextInt(80),     // PA sys: 80 a 160 mmHg
                        50 + random.nextInt(50),     // PA dia: 50 a 100 mmHg
                        80 + random.nextInt(20)      // SpO2: 80 a 99 %
                ));
    }

    static boolean esEventoCritico(EventoVital e) {
        return e.fc < 50 || e.fc > 120 ||
                e.paSys < 90 || e.paDia < 60 ||
                e.paSys > 140 || e.paDia > 90 ||
                e.spo2 < 90;
    }

    static void imprimirAlerta(EventoVital e) {
        if (e.fc < 50 || e.fc > 120) {
            System.out.printf("⚠️ Paciente %d - FC crítica: %d bpm%n", e.pacienteId, e.fc);
        }
        if (e.paSys < 90 || e.paDia < 60 || e.paSys > 140 || e.paDia > 90) {
            System.out.printf("⚠️ Paciente %d - PA crítica: %d/%d mmHg%n", e.pacienteId, e.paSys, e.paDia);
        }
        if (e.spo2 < 90) {
            System.out.printf("⚠️ Paciente %d - SpO2 baja: %d%%%n", e.pacienteId, e.spo2);
        }
    }
}