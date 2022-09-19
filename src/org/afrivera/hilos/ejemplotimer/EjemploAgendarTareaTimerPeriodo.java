package org.afrivera.hilos.ejemplotimer;

import java.awt.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploAgendarTareaTimerPeriodo {
    public static void main(String[] args) {

        // int contador = 3;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        AtomicInteger contadorAtom = new AtomicInteger(3); // con atomic se puede acceder desde una clase anonima

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            private int contador = 3; // se puede implementar como atributo interno, pero no desde afuera

            @Override
            public void run() {
                int  i = contadorAtom.getAndDecrement();
                if( i > 0) {
                    toolkit.beep(); // para realizar sonido
                    System.out.println("Tarea periodica " + i + " en: " + new Date() + " nombre del thread: " +
                            Thread.currentThread().getName());
                    // contador--;
                } else {
                    System.out.println("Finaliza el tiempo");
                    timer.cancel(); // sino se comenta se sale
                }
            }
        }, 0, 5000);

        System.out.println("Agendadamos una tarea para inmediata que repite cada 5 segundos más ...");
    }
}
