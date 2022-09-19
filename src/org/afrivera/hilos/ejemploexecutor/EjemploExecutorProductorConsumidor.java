package org.afrivera.hilos.ejemploexecutor;

import org.afrivera.hilos.ejemplosync.Panaderia;
import org.afrivera.hilos.ejemplosync.runnable.Consumidor;
import org.afrivera.hilos.ejemplosync.runnable.Panadero;

import java.util.concurrent.*;

public class EjemploExecutorProductorConsumidor {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2); // con el newfixed se puede agregar la cantidad de thread solicitados
        System.out.println("Tamaño del pool " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola " + executor.getQueue().size());

        Panaderia p = new Panaderia();
        Runnable productor = new Panadero(p);
        Runnable consumidor = new Consumidor(p);
        Future<?> futuro1 = executor.submit(productor);
        Future<?> futuro2 = executor.submit(consumidor);

        executor.shutdown(); // el shutdown now cierra de forma abrupta
        System.out.println("Continuando con la ejecución del main ");

    }
}
