
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author marta
 */
public class Lanzador {
  
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("¿Cuantas veces quiere lanzar el sumador?: ");
        int veces = Integer.parseInt(entrada.nextLine());
        
        for(int i = 1; i <= veces; i++){
            System.out.println("--- Ejecucion numero " + i + "---");
            
            System.out.println("Introduce el primer numero: ");
            String num1 = entrada.nextLine();
            
            System.out.println("Introduce el segundo numero: ");
            String num2 = entrada.nextLine();
            
            try{
            
                //ProcessBuilder pb = new ProcessBuilder("java", "appr.U2A10_Sumador");
                ProcessBuilder pb = new ProcessBuilder("java", "U2A11_Sumador2");
                pb.directory(new File("build/classes"));
                
                Process proceso = pb.start();
                
                try (PrintWriter escritor = new PrintWriter (new BufferedWriter(
                        new OutputStreamWriter(proceso.getOutputStream())))) {
                            escritor.println(num1);
                            escritor.println(num2);
                            escritor.flush();
                }
                
                try (BufferedReader lector = new BufferedReader(
                        new InputStreamReader(proceso.getInputStream()))) {
                    String linea;

                    while ((linea = lector.readLine()) != null) {
                        System.out.println("Linea + " + linea);
                    }
                }
                
                proceso.waitFor();
            
            }catch(Exception e){
                System.out.println("Error al ejecutar el proceso: " + e.getMessage());
            }
            
        }
        
        System.out.println("Todas las ejecuciones han terminado.");
    }
    
    
}
