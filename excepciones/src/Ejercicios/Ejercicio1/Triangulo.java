package Ejercicios.Ejercicio1;

import Ejercicios.Ejercicio1.IlegalTrianguloException;

public class Triangulo {
    private double lado1;
    private double lado2;
    private double lado3;

    public Triangulo(double lado1, double lado2, double lado3) throws IlegalTrianguloException {

        if(esTrianguloValido(lado1, lado2, lado3)){
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
        } else {
            throw new IlegalTrianguloException();
        }
    }

    private boolean esTrianguloValido(double lado1, double lado2, double lado3){
        if (lado1 + lado2 >= lado3 && lado1 + lado3 >= lado2 && lado2 + lado3 >= lado1)
        return true;
        else return false;
    }

    @Override
    public String toString() {
        return "Triangulo válido: " +
                "lado 1 = " + lado1 +
                ", lado 2 = " + lado2 +
                ", lado 3 = " + lado3;
    }
}
