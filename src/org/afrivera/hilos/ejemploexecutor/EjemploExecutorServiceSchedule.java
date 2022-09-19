package org.afrivera.hilos.ejemploexecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EjemploExecutorServiceSchedule {
    public static void main(String[] args) {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        System.out.println("Simulando alguna tarea en el main");
        executor.schedule(()->{
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hola Mundo tarea....");
        }, 2000, TimeUnit.MILLISECONDS);

        System.out.println("Alguna otra tarea en el main...");
        executor.shutdown();
    }
}
