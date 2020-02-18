package ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaAleatoria {

    private static final int TAMMANO_INICIAL = 100;

    private List<Integer> listaEnteros = new ArrayList();
    private double valorMedio;

    public ListaAleatoria() {

        for (int i = 0; i < TAMMANO_INICIAL; i++) {
            listaEnteros.add((int) (Math.random() * 101));
        }
        Collections.sort(listaEnteros);
    }

    public List<Integer> devolverPares(){
        List<Integer> listaPares = new ArrayList();
        for (int valor: listaEnteros){
            if (valor % 2 == 0)
                listaPares.add(valor);
        }
        return listaPares;
    }

    public int obtenerValorMinimo(){return listaEnteros.get(0);}
    public int obtenerValorMaximo(){return listaEnteros.get(listaEnteros.size() - 1);}
}
