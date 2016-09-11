package practicas.tres;

import java.util.Scanner;

import static java.lang.Math.pow;

public class InnerStatic {
	
	static double PI = 3.1416;
    static class Circulo {
       
    	static double radio = 2;

        static{

            /* bloque statico de inicializacion */

            System.out.println("ingrese el valor de Radio: ");
            Scanner sc = new Scanner(System.in);  //crear un objeto Scanner
            radio = sc.nextDouble();

        }

        static double getArea(){
            // c) para pow se importa static java.lang.Math
            double a = PI * pow(radio,2);
            System.out.println("El area es: " + a);
            return a;
        }

        static double getLongitudCircunsferencia(){
            double l = 2 * PI * radio;
            System.out.println("la longitud es: " + l);
            return l;
        }
    }
}
