package org.afrivera.hilos.ejemploexecutor;

import java.util.concurrent.*;

public class EjemploExecutorFuture2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(1); // con el newfixed se puede agregar la cantidad de thread solicitados
        System.out.println("Tamaño del pool " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola " + executor.getQueue().size());
        Callable<String> tarea = ()->{
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

        Callable<Integer> tarea2 = ()->{
            System.out.println("Iniciando Tarea 3");
            TimeUnit.SECONDS.sleep(3);
            return 10;
        };

        Future<String> resultadoFuturo = executor.submit(tarea);
        Future<String> resultadoFuturo2 = executor.submit(tarea);
        Future<Integer> resultadoFuturo3 = executor.submit(tarea2);

        executor.shutdown(); // el shutdown now cierra de forma abrupta
        System.out.println("Continuando con la ejecución del main ");

        while (!(resultadoFuturo.isDone() && resultadoFuturo2.isDone() && resultadoFuturo3.isDone())){
            System.out.println(String.format("Resultado1: %s - resultado2 %s  - resultado3: %s",
                    resultadoFuturo.isDone()? "Finalizó": "en proceso",
                    resultadoFuturo2.isDone()? "Finalizó": "en proceso",
                    resultadoFuturo3.isDone()? "Finalizó": "en proceso"));
            TimeUnit.MILLISECONDS.sleep(1000);
        }

        System.out.println("Obtenemos el resultado1 de la tarea: " +resultadoFuturo.get()); // hace una pausa y bloquea el thread
        System.out.println(resultadoFuturo.isDone());

        System.out.println("Obtenemos el resultado2 de la tarea: " +resultadoFuturo2.get()); // hace una pausa y bloquea el thread
        System.out.println(resultadoFuturo2.isDone());

        System.out.println("Obtenemos el resultado3 de la tarea: " +resultadoFuturo3.get()); // hace una pausa y bloquea el thread
        System.out.println(resultadoFuturo3.isDone());

    }
}
