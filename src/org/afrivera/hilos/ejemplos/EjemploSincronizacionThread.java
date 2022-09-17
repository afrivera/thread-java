package org.afrivera.hilos.ejemplos;

import org.afrivera.hilos.ejemplos.runnable.ImprimirFrases;

public class EjemploSincronizacionThread {
    public static void main(String[] args) throws InterruptedException {

        new Thread(new ImprimirFrases("Hola, ", "que tal")).start();
        new Thread(new ImprimirFrases("quien eres ", "tú")).start();
        Thread.sleep(500);
        Thread h3 = new Thread(new ImprimirFrases("Muchas ", "gracias amigo"));
        h3.start();
        Thread.sleep(100);
        System.out.println(h3.getState());



    }

    public synchronized static void imprimirFrases(String f1, String f2){
        System.out.print(f1);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(f2);
    }
}
