package Ejercicios.Ejercicio1;

import java.util.Scanner;

public class TestTriangulo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Lado 1:\n");
        double lado1 = sc.nextDouble();
        System.out.println("Lado 2:\n");
        double lado2 = sc.nextDouble();
        System.out.println("Lado 3:\n");
        double lado3 = sc.nextDouble();

        try {
            Triangulo triangulo = new Triangulo(lado1, lado2, lado3);
            System.out.println(triangulo);
        } catch (IlegalTrianguloException e){
            System.out.println(e.getMessage());
        }
    }
}
