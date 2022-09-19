package org.afrivera.hilos.ejemplosync;

import org.afrivera.hilos.ejemplosync.runnable.Consumidor;
import org.afrivera.hilos.ejemplosync.runnable.Panadero;

public class EjemploProductorConsumidor {
    public static void main(String[] args) {
        Panaderia p = new Panaderia();
        new Thread(new Panadero(p)).start();
        new Thread(new Consumidor(p)).start();

    }
}
