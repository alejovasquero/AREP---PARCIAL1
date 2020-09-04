package edu.escuelaing.arep.utilities;

import java.util.ArrayList;
import java.util.List;

public class Sorts {

    public static <E extends Comparable> void bubbleSort(List<E> lista) {
        int n = lista.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (lista.get(j).compareTo(lista.get(j+1)) > 0) {
                    E temp = lista.get(j);
                    lista.set(j, lista.get(j+1));
                    lista.set(j+1, temp);

                }
            }
        }
    }
}
