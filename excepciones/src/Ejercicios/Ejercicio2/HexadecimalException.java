package Ejercicios.Ejercicio2;

public class HexadecimalException extends Exception{
    @Override
    public String getMessage() {
        return "No es un número en hexadecimal";
    }
}
