
import java.util.List;

import java.util.ArrayList;

import java.util.LinkedList;

public class ComparaAdd {

    private static final int LONGITUD = 100000;

    private static long testAdd0(List<Integer> llista) {

        long tempsInicial = System.nanoTime();

        for (int i=0; i < LONGITUD; i++) {

            llista.add(0, i);

        }

        return System.nanoTime() - tempsInicial;

    }

    private static long testAdd(List<Integer> llista) {

        long tempsInicial = System.nanoTime();

        for (int i=0; i < LONGITUD; i++) {

            llista.add(i);

        }

        return System.nanoTime() - tempsInicial;

    }

    private static long testAddMig(List<Integer> llista) {

        long tempsInicial = System.nanoTime();

        for (int i=0; i < LONGITUD; i++) {

            int mig = llista.size() / 2;

            llista.add(mig, i);

        }

        return System.nanoTime() - tempsInicial;

    }

    public static void main(String[] args) {

        System.out.println("Comparant l'eficiència de les llistes");

        System.out.println();


        System.out.println("Comparació quan inserim sempre a l'inici");

        System.out.printf("test add(0, i) LinkedList:   %10d%n", testAdd0(new LinkedList<Integer>()));

        System.out.printf("test add(0, i) ArrayList:    %10d%n", testAdd0(new ArrayList<Integer>()));

        System.out.println();


        System.out.println("Comparació quan inserim sempre al final");

        System.out.printf("test add(i) LinkedList:      %10d%n", testAdd(new LinkedList<Integer>()));

        System.out.printf("test add(i) ArrayList:       %10d%n", testAdd(new ArrayList<Integer>()));

        System.out.println();


        System.out.println("Comparació quan inserim sempre al mig");

        System.out.printf("test add(mig, i) LinkedList: %10d%n", testAddMig(new LinkedList<Integer>()));

        System.out.printf("test add(mig, i) ArrayList:  %10d%n", testAddMig(new ArrayList<Integer>()));

        System.out.println();

    }

}