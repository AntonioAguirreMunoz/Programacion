package matematicas;

public class Geometria {

    private double lado;
    private double altura;

    public Geometria(double lado, double altura) {
        this.lado = lado;
        this.altura = altura;
    }

    public double getLado() {
        return lado;
    }

    public double getAltura() {
        return altura;
    }

    public double getAreaTriangulo(double lado, double altura){

        return lado * altura / 2.0;
    }

    public double getAreaCuadrado(double lado){

        return lado * lado;
    }

    public double getAreaPentagono(double lado){

        return  1.72 * (lado * lado);
    }

    public double getAreaHexagono(double lado){

        return 2.6 * (lado * lado);
    }
}
