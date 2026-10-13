
import java.util.Scanner;

/*
 Modifica el programa anterior para que la Clase Sumador2 lea los números, de 2 en 2, desde la entrada estándar y muestre por consola el resultado de cada una de las sumas.

La suma de 5 + 8 = 13
La suma de 9 + 34 = 43
...

Si en algún caso la cantidad de números que lee no es par, el que falte lo sustituirá por 0.

Hay que controlar los posibles errores que se produzcan en la lectura de los números y generar mensajes de error para avisar al usuario.
 */

public class U2A11_Sumador2 {
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        double num1 = 0;
        double num2 = 0;
        
        if(entrada.hasNextLine()){
            
            try{
            
                num1 = Double.parseDouble(entrada.nextLine()); 
                
            }catch(NumberFormatException e){
                System.out.println("No es un numero valido");
            }
            
        }
        
        if(entrada.hasNextLine()){
            String input2 = entrada.nextLine().trim();
            
            try{
                
                num2 = Double.parseDouble(input2); 
                
            }catch(NumberFormatException e){
                System.out.println("Introdujo " + input2 + " , que no es un numero valido, se asignara cero.");
            }
            
        } else{
            
            num2 = 0;
            
        }
        
        double resultado = num1 + num2;
        
        System.out.println("El resultado de sumar " + num1 + " + " + num2 + " es " + resultado);
        
        entrada.close();
    }
}
