
package Recursividad;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase que contiene diferentes algoritmos usados para la ordenación
 * Algorithms are: Merge Sort and Quick Sort (using id numbers to sort elements and name)
 *
 * @author Giovanni Locatelli
 * @author Alex Lopez Delacalle
 */
public class Ordenacion {

	 /**
     * Merge Sort genérico usando número id
     *
     * @param list lista que va a ordenarse
     * @param <T>  tipo de los objetos que se van a ordenar
     * @return lista ordenada
     */
    public static <T extends IComparable<T>> ArrayList<T> mergeSortNum(ArrayList<T> list) {
        if (list.size() == 1) return list;
        else {
            ArrayList<T> listLeft = new ArrayList<T>(list.subList(0, list.size() / 2));
            ArrayList<T> listRight = new ArrayList<T>(list.subList(list.size() / 2, list.size()));

            listLeft = mergeSortNum(listLeft);
            listRight = mergeSortNum(listRight);

            return mergeNum(listLeft, listRight);
        }


    }

    /**
     * Función Merge genérica para fusionar y ordenar las listas divididas usando un identificador
     *
     * @param a   lista de la izquierda
     * @param b   lista de la derecha
     * @param <T> tipo de los objetos en la lista
     * @return lista fusionada y ordenada
     */
    public static <T extends IComparable<T>> ArrayList<T> mergeNum(ArrayList<T> a, ArrayList<T> b) {
        ArrayList<T> c = new ArrayList<>();
        while (!a.isEmpty() && !b.isEmpty()) {
            if (a.get(0).compareNum(b.get(0))) {
                c.add(b.get(0));
                b.remove(0);
            } else {
                c.add(a.get(0));
                a.remove(0);
            }
        }
        while (!a.isEmpty()) {
            c.add(a.get(0));
            a.remove(0);
        }
        while ((!b.isEmpty())) {
            c.add(b.get(0));
            b.remove(0);
        }
        return c;
    }

    /**
     * Función Merge Sort genérica usando nombre
     *
     * @param list lista que se va a ordenar
     * @param <T>  tipo de los objetos a ordenar
     * @return lista ordenada
     */
    public static <T extends IComparable<T>> ArrayList<T> mergeSortStr(ArrayList<T> list) {
        if (list.size() == 1) return list;
        else {
            ArrayList<T> listLeft = new ArrayList<T>(list.subList(0, list.size() / 2));
            ArrayList<T> listRight = new ArrayList<T>(list.subList(list.size() / 2, list.size()));

            listLeft = mergeSortStr(listLeft);
            listRight = mergeSortStr(listRight);

            return mergeStr(listLeft, listRight);
        }


    }

    /**
     * Función Merge genérica para fusionar y ordenar las listas divididas usando el nombre
     *
     * @param a   lista de la izquierda
     * @param b   lista de la derecha
     * @param <T> tipo de los objetos de la lista
     * @return lista fusionada y ordenada
     */
    public static <T extends IComparable<T>> ArrayList<T> mergeStr(ArrayList<T> a, ArrayList<T> b) {
        ArrayList<T> c = new ArrayList<>();
        while (!a.isEmpty() && !b.isEmpty()) {
            if (a.get(0).compareStr(b.get(0))) {
                c.add(b.get(0));
                b.remove(0);
            } else {
                c.add(a.get(0));
                a.remove(0);
            }
        }
        while (!a.isEmpty()) {
            c.add(a.get(0));
            a.remove(0);
        }
        while ((!b.isEmpty())) {
            c.add(b.get(0));
            b.remove(0);
        }
        return c;
    }

    /**
     * Método Quicksort genérico
     * @param a Array que va a ser ordenado
     * @param low Índice del primer elemento
     * @param high Índice del último elemento
     * @param <E> Tipo de los elementos en el array
     */
    public static <E extends IComparable<E>> void quicksortStr(ArrayList<E> a, int low, int high) {
        if (low < high) {
            int pivotLocation = partition(a, low, high);
            quicksortStr(a, low, pivotLocation);
            quicksortStr(a, pivotLocation + 1, high);
        }
    }
    /**
     * Método para calcular el elemento medio en el Array
     * @param a Array que va a ser ordenado
     * @param low Índice del primer número
     * @param high Índice del último número
     * @param <E> Tipo de los elementos en el array
     * @return Índice del elemento medio
     */
    private static <E extends IComparable<E>> int partition(ArrayList<E> a, int low, int high) {
        E pivot = a.get(low);
        int left = low;
        for (int i = low + 1; i < high; i++) {
            if (a.get(i).compareStr(pivot)) {
                Collections.swap(a, i, left);
                left += 1;
            }
        }
        Collections.swap(a, low, left);
        return left;
    }
}
