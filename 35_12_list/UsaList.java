/*
 * Primer exercici que es realitza de Llistes, anirem probant les diferents
 * modularitats que te una llista etc.
 */

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class UsaList {
    public static void main(String[] args) {
        List<String> llista;
        // TODO: inicialitza la llista amb una instància de ArrayList
        // o un LinkedList. Com et vingui de gust
        llista = new ArrayList<String>();

        System.out.println("Obtenim les entrades");
        System.out.println("====================");
        String valor;

        valor = Entrada.readLine();
        // TODO: afegeix valor a la llista
        llista.add(valor);

        valor = Entrada.readLine();

        // TODO: afegeix el valor a l'inici de la llista
        llista.add(0, valor);

        valor = Entrada.readLine();
        // TODO: afegeix el valor al mig de la llista
        llista.add(llista.size() / 2, valor);

        System.out.println("Cerquem elements de la llista");
        System.out.println("=============================");
        String text = Entrada.readLine();
        boolean esTroba;
        // TODO: inicialitza esTroba a true si text està a la llista
        if (llista.contains(text))
            esTroba = true;
        else
            esTroba = false;

        System.out.printf("El text %s és troba a la llista: %s%n", text, esTroba);
        int indexPrimerOcurrencia;
        // TODO: inicialitza indexPrimerOcurrencia a l'índex on es troba text
        indexPrimerOcurrencia = llista.indexOf(text);

        System.out.printf("Posició de %s a la llista: %s%n", text, indexPrimerOcurrencia);

        System.out.println("Mostrem les entrades introduïdes");
        System.out.println("================================");
        boolean llistaBuida;
        // TODO inicialitza llistaBuida de manera que valgui cert si
        // la llista està buida.
        if (llista.isEmpty())
            llistaBuida = true;
        else
            llistaBuida = false;

        while (!llistaBuida) {
            String entrada;
            // TODO: inicialitza entrada de manera que contingui el
            // primer element de la llista
            entrada = llista.get(0);
            System.out.println(entrada);
            // TODO: elimina el primer element de la llista
            llista.remove(0);
            // TODO: actualitza el valor de llistaBuida
            if (llista.isEmpty())
                llistaBuida = true;
            else
                llistaBuida = false;

        }
    }
}