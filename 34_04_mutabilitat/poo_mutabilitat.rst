####################################
Anotacions sobre propietats mutables
####################################

* Autor/a: Pau Pedrós Ribas

* Data: 15/02/2024

Introducció
===========

En aquest exercici incloc les meves anotacions sobre el tema de *propietats mutables*
dins de la *programació orientada a objectes*.

Les anotacions responen a diferents preguntes sobre aquest codi:

::

    01    public class GatRenat {
    02        public int vides = 7;         // vides disponibles del gat Renat
    03        public static void main(String[] args) {
    04            GatRenat renat;           // declarem l'objecte (la referència) al gat
    05            renat = new GatRenat();   // creem la instància del gat Renat.
    06            System.out.println("Abans el gat Renat tenia " + renat.vides + " vides");
    07            renat.vides = renat.vides - 1;  // Renat ha tingut un accident
    08            System.out.println("Ara el gat Renat té " + renat.vides);
    09        }
    10    }

Pregunta 1. Obtenir
===================

Per consultar (llegir, obtenir) el valor d'una propietat de la instància,
cal:
    Indicar quina instancia vull consultar i quina propietat
    Exemple:
        renat.vides

Pregunta 2. Assignar
====================

Per canviar (escriure, assignar) el valor d'una propietat de la instància,
cal:
    Indicar l'instancia i propietat a canviar i el valor que es vol donar:
    renat.vides = renat.vides - 1

Pregunta 3. Valors absurds
==========================

A la pregunta següent:

    És possible indicar que el gat Renat té -12 vides? Com? És quelcom
    desitjable que pugui passar? En cas que es pugui, com ho podries
    evitar fent servir els coneixements de programació estructurada i
    modular que hem treballat fins ara?

La meva resposta és:
    Sí, es posible.

    A la linia 2 on es inicialitza la variable vides
    li donariem el valor -12.

    No seria desitjable ja que, a renat al arribar a 0 estaria mort.

    Es podria evitar fent una condicio de si les vides
    son menors a 0 no es restin vides.

