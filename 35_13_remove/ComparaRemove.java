/*
    Comparació de l'operació remove() en ArrayList i LinkedList
    eliminant per l'inici, pel final i pel mig.

    Els resultats obtinguts han estat:
    Primera execució:
    =================

Comparant l'eficiència de les llistes
Comparació quan eliminem sempre de l'inici
test remove(0) LinkedList:     259
test remove(0) ArrayList:      224

Comparació quan eliminem sempre del final
test remove(últim) LinkedList: 303
test remove(últim) ArrayList:  227
Comparació quan eliminem sempre del mig
test remove(mig) LinkedList: 15925
test remove(mig) ArrayList:    828

        Segona execució:
        ================
Comparant l'eficiència de les llistes

Comparació quan eliminem sempre de l'inici
test remove(0) LinkedList:     269
test remove(0) ArrayList:      170
Comparació quan eliminem sempre del final
test remove(últim) LinkedList: 247
test remove(últim) ArrayList:  189

Comparació quan eliminem sempre del mig
test remove(mig) LinkedList:  5894
test remove(mig) ArrayList:    433
        Tercera execució:
        =================

Comparant l'eficiència de les llistes
Comparació quan eliminem sempre de l'inici
test remove(0) LinkedList:     265
test remove(0) ArrayList:      200

Comparació quan eliminem sempre del final
test remove(últim) LinkedList: 328
test remove(últim) ArrayList:  252259
Comparació quan eliminem sempre del mig
test remove(mig) LinkedList:  6459
test remove(mig) ArrayList:    297

        Resultats
        =========
========== ================== ================== ======================================================
**prova**  **linkedList**      **ArrayList**      **resultat**
---------- ------------------ ------------------ ------------------------------------------------------
inici       264                 198                1
final       292                 84225              288
mig         9426                519                18
========== ================== ================== ======================================================

    Per calcular cada columna:
    * la cel·la (1, 1) correspon al temps mig de la implementació LinkedList eliminant des de l'inici
      Es calcula sumant els valors obtinguts a les tres execucions i dividint-los per 3

    * el resultat per la fila inici indica quantes vegades és més ràpid un que l'altre. Per fer-ho, dividim
      el valor més petit pel més gran i arrodonim a l'enter.
    Conclusions
    ===========

    En vistes als resultats, en cas que hagi de fer servir una List per eliminar molts valors, escolliré XXX
     */
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
public class ComparaRemove {
    private static final int LONGITUD = 100000;
    private static List<Integer> emplena(List<Integer> llista) {
        // codi que emplena la llista amb enters del 0 a LONGITUD - 1
        for (int i = 0; i < LONGITUD - 1; i++) {
            llista.add(0);
        }
        return llista;
    }
    private static long testRemove0(List<Integer> llista) {
        long tempsInicial = System.nanoTime();
        // codi que elimina un a un tots els elements de la llista per la posició 0
        for (int i = 0; i < llista.size() - 1; i++) {
            llista.remove(0);
        }
        return System.nanoTime() - tempsInicial;
    }
    private static long testRemove(List<Integer> llista) {
        long tempsInicial = System.nanoTime();
        // codi que elimina un a un tots els elements de la llista per la darrera posició
        for (int i = llista.size() - 1; i >= 0; i--) {
            llista.remove(llista.size() - 1);
        }
        return System.nanoTime() - tempsInicial;
    }
    private static long testRemoveMig(List<Integer> llista) {
        long tempsInicial = System.nanoTime();
        // codi que elimina un a un tots els elements de la llista per la posició mig
        while(!llista.isEmpty()){
            llista.remove(llista.size()/2);
        }
        return System.nanoTime() - tempsInicial;
    }
    public static void main(String[] args) {
        System.out.println("Comparant l'eficiència de les llistes");
        System.out.println();

        System.out.println("Comparació quan eliminem sempre de l'inici");
        System.out.printf("test remove(0) LinkedList:     %10d%n", testRemove0(emplena(new LinkedList<Integer>())));
        System.out.printf("test remove(0) ArrayList:      %10d%n", testRemove0(emplena(new ArrayList<Integer>())));
        System.out.println();
        System.out.println("Comparació quan eliminem sempre del final");
        System.out.printf("test remove(últim) LinkedList: %10d%n", testRemove(emplena(new LinkedList<Integer>())));
        System.out.printf("test remove(últim) ArrayList:  %10d%n", testRemove(emplena(new ArrayList<Integer>())));
        System.out.println();

        System.out.println("Comparació quan eliminem sempre del mig");
        System.out.printf("test remove(mig) LinkedList:   %10d%n", testRemoveMig(emplena(new LinkedList<Integer>())));
        System.out.printf("test remove(mig) ArrayList:    %10d%n", testRemoveMig(emplena(new ArrayList<Integer>())));
        System.out.println();
    }
}