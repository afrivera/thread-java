package org.afrivera.hilos.ejemploexecutor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploExecutorServiceSchedulePeriodo {
    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        // instancia de cuenta regresiva
        //CountDownLatch lock = new CountDownLatch(5);

        AtomicInteger contador = new AtomicInteger(5);

        System.out.println("Simulando alguna tarea en el main");
        Future<?> futuro =  executor.scheduleAtFixedRate(()->{
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                // lock.countDown();
                contador.getAndDecrement();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hola Mundo tarea....");
        }, 1000, 2000,TimeUnit.MILLISECONDS);

        // lock.await();
        // futuro.cancel(true); // cerrarlo de forma normal

        // TimeUnit.SECONDS.sleep(10);
        while(contador.get()>=0){
            if(contador.get() == 0){
                futuro.cancel(true);
                contador.getAndDecrement(); // o break
            }
        }
        System.out.println("Alguna otra tarea en el main...");
        executor.shutdown(); // si se quita queda infinito
    }
}
