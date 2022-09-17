package org.afrivera.hilos.ejemplos.threads;

public class NombreThread extends Thread{

    // no es tan recomendable
    public NombreThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Se inicia el metodo run del hilo " + getName());

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName());
        }
        System.out.println("Finaliza el hilo");
    }
}
