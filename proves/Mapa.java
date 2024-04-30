/*
 * Escriviu un programa en Java que llegeixi un text 
 * (pot ser una cadena estàtica dins del codi per simplificar) i utilitzi 
 * un Map per comptar quantes vegades apareix cada paraula. Finalment, el 
 * programa hauria d'imprimir les paraules i la seva freqüència d'aparició.
 * 
 * 
 * Pasos a seguir:

    - Definiu una cadena de text a analitzar. Per exemple, podeu utilitzar un text curt com: 
    "Aquest és un text de prova amb text repetit i text de prova".
    - Utilitzeu un HashMap<String, Integer> per emmagatzemar les paraules com a claus i les seves freqüències com a valors.
    - Dividiu el text en paraules. Podeu utilitzar el mètode split(" ") de la 
    classe String per dividir el text utilitzant els espais com a delimitadors.
    - Itereu sobre l'array de paraules resultant. Per a cada paraula:
        Comproveu si la paraula ja existeix com a clau al Map.
        Si no existeix, afegiu-la al Map amb un valor inicial de 1.
        Si ja existeix, actualitzeu el seu valor incrementant la freqüència en 1.
    - Un cop hàgiu processat totes les paraules, imprimeixi el contingut del Map per 
    mostrar les paraules i la seva freqüència d'aparició.

 */

import java.util.Map;
import java.util.HashMap;

public class Mapa {
    public static void main(String[] args) {
        String text = Entrada.readLine();
        // Map<Paraula, frequencia>
        Map<String, Integer> map = new HashMap<>();

        // Separem les paraules
        String[] paraules = text.split(" ");

        for (String paraula : paraules){
            // Obtenim el valor de la parella
            Integer num = map.get(paraula);
            // Si el map no te aquesta paraula la afegim amb valor 1
            if (num == null) {
                map.put(paraula, 1);
            }
            // Si tenim la paraula al map incrementem el seu valor
            else {
                map.put(paraula, num + 1);
            }
        }

        // Fem print de les paraules amb la seva frequencia
        for (Map.Entry<String, Integer> entrada : map.entrySet()) {
            System.out.println(entrada.getKey() + ": " + entrada.getValue());
        }
    }
}