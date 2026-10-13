/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

/**
 *
 * @author marta
 */
public class PruebaCodigo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread hilo1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("-> Tarea 1 ejecutándose... paso " + i);
                try {
                    Thread.sleep(500); // Pausa de medio segundo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Creamos el Hilo 2
        Thread hilo2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("   => Tarea 2 en paralelo... paso " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // ¡Arrancamos ambos hilos!
        hilo1.start();
        hilo2.start();

        System.out.println("El método main (hilo principal) terminó de lanzar los hilos.");
    }
    
}
