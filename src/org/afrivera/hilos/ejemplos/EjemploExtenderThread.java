package org.afrivera.hilos.ejemplos;

import org.afrivera.hilos.ejemplos.threads.NombreThread;

public class EjemploExtenderThread {
    public static void main(String[] args) throws InterruptedException {

        // hay dos formas para implementar extends de thread o implements de runnable
        Thread hilo = new NombreThread("John Doe");
        hilo.start();
        // Thread.sleep(3);
        Thread hilo2 = new NombreThread("Maria");
        hilo2.start();

        Thread hilo3 = new NombreThread("Pepe");
        hilo3.start();
        System.out.println(hilo.getState()); // NEW => es el estado cuando se crea la instancia no asigna recurso
        /* RUNNABLE => cuando está corriendo el hilo, ya se asignan recursos
            TERMINATED => termina el hilo.

        * */

    }
}
