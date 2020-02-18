package Ejercicios.Ejercicio2;

import java.util.List;

public class Hexadecimal {
    private String valor;

    public Hexadecimal (String valor) throws HexadecimalException {
        if (esHexadecimal(valor))
            this.valor = valor;
        else
            throw new HexadecimalException();
    }

    private boolean esHexadecimal(String valor) {
        return valor.matches("[0-9abcdefABCDEF]+");
    }

    public int devolverValorDecimal(){
        return Integer.parseInt(valor, 16);
    }

    @Override
    public String toString() {
        //return "Valor hexadecimal"+ valor;
        return String.format("Hexadecimal: %s Decimal: %d\n",
                valor, devolverValorDecimal());
    }

    public static long obtenerSumaDecimalListaHexadecimales(List<Hexadecimal> lista){
        long suma = 0;
        for (Hexadecimal h: lista ) {
            suma += h.devolverValorDecimal();
        }
        return suma;
    }
}
