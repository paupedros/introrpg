#############################
Anotacions sobre accés extern
#############################

* Autor/a: XXX

* Data: XXX

Introducció
===========

En aquest exercici incloc les meves anotacions sobre el tema de *accés
extern* dins de la *programació orientada a objectes*.

Disposem ara de dos fitxers amb codi:

* ``GatRenat.java``

  ::

    01   public class GatRenat {
    02       public int vides = 7;         // vides disponibles del gat Renat
    03       public static void main(String[] args) {
    04           GatRenat renat;           // declarem la referència al gat
    05           renat = new GatRenat();   // creem la instància del gat Renat.
    06           System.out.println("Al gat Renat li queden " + renat.vides + " vides");
    07       }
    08   }



* ``UsaGatRenat.java``

  ::

    01      public class UsaGatRenat {
    02          public static void main(String[] args) {
    03              GatRenat renat = new GatRenat();
    04              System.out.println("Al gat Renat li queden " + renat.vides + " vides");
    05          }
    06      }

Pregunta 1. On està el ``main()``
=================================

El punt d'entrada ``main()`` d'aquest programa es troba al fitxer UsaGatRenat.java
suposant que estem executant el programa UsaGatRenat, pero si executem GatRenat
es trobara al fitxer GatRenat.java.

Pregunta 2. Distingint dos ``main()``
=====================================

Ara tenim dos fitxers amb ``main()``. Java pot saber quin dels dos volem
executar gracies a que li indiquem quan l'executem:
  Exemple: java UsaGatRenat

Pregunta 3. Definició de la classe
==================================

La classe del gat Renat està definida al fitxer GatRenat.

Pregunta 4. Quants programes
============================

El nombre de programes que es podrien construir fent ús de la definició del gat Renat és infinit.

Penso això perquè puc crear infinites instancies de la classe GatRenat.

Pregunta 5. Eliminant ``main()``
================================

Quan elimino el ``main()`` de ``GatRenat`` (per exemple, comentant-lo) em trobo que en intentar
tornar a compilar/executar ``UsaGatRenat``, no passa res.

El que sí ha deixat de funcionar és l'execucio de GatRenat, ja que no te ningun main.

Pregunta 6. Diferents directoris
================================

Després de moure el fitxer ``UsaGatRenat.java`` a una carpeta diferent d'on es
troba ``GatRenat.java``, m'he trobat que no troba la classe GatRenat

