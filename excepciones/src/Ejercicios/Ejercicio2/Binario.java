package Ejercicios.Ejercicio2;

import java.util.List;

public class Binario{

    private String valor;

    public Binario(String valor) throws BinarioException{
        if(esBinario(valor))
            this.valor = valor;
        else
            throw new BinarioException();
    }

    private boolean esBinario(String valor) {
        return valor.matches("[01]+");
    }

    public int devolverValorDecimal(){
        double suma = 0.0;
        StringBuilder sB = new StringBuilder(valor);
        String valorReverse = sB.toString();
        for (int i = 0; i < valorReverse.length(); i++) {
            suma += Math.pow(2,i) * Integer.parseInt(valorReverse.charAt(i) + "");
        }
        return (int) suma;
    }

    @Override
    public String toString() {
        return String.format("Binario: %s Hexadecimal: %d\n",
                valor, devolverValorDecimal());
    }

    public static int obtenerSumaDecimalListaBinarios(List<Binario> lista){
        int suma = 0;
        for (Binario b: lista ) {
            suma += b.devolverValorDecimal();
        }
        return suma;
    }

    public static Binario convertirDecimalABinario(int valor){
        StringBuilder sBuilder = new StringBuilder();
        int cociente = valor / 2;
        int resto = valor % 2;
        sBuilder.append(resto);
        while (cociente > 1){
            resto = cociente % 2;
            sBuilder.append(resto);
            cociente = cociente / 2;
        }
        if (valor > 2){
            sBuilder.append(1);
        }
        sBuilder.reverse();
        Binario binario = null;
        try {
            binario = new Binario(sBuilder.toString());
        } catch (BinarioException e) {
            e.printStackTrace();
        }
        return binario;
    }
}
