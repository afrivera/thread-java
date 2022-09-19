package org.afrivera.hilos.ejemploexecutor;

import java.util.concurrent.*;

public class EjemploExecutorFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ExecutorService executor = Executors.newSingleThreadExecutor();

//        Runnable tarea = ()->{
        Callable<String> tarea = ()->{ // el callable retorna un valor, el runnable no
            System.out.println("Inicio de la tarea");
            try {
                System.out.println("Nombre del thread: " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }

            System.out.println("Finaliza la tarea.");
            return "algún resultado imprtante de la tare";
        };

        Future<String> resultadoFuturo = executor.submit(tarea);
        executor.shutdown(); // el shutdown now cierra de forma abrupta
        System.out.println("Continuando con la ejecución del main ");

        // System.out.println("resultadoFuturo.isDone() = " + resultadoFuturo.isDone());
        while (!resultadoFuturo.isDone()){
            System.out.println("Ejecutando tarea");
            TimeUnit.MILLISECONDS.sleep(1300);
        }

        // System.out.println(resultadoFuturo.get(2, TimeUnit.SECONDS)); // hace una pausa y bloquea el thread
        System.out.println("Obtenemos el resultado de la tarea: " +resultadoFuturo.get()); // hace una pausa y bloquea el thread
        // System.out.println("continuamos...");
        System.out.println(resultadoFuturo.isDone());
    }
}
