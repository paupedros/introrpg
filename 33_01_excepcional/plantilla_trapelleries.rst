===========================
Trapelleries a Mostrat.java
===========================

Resum de trapelleries al codi de ``Mostrat.java``


Trapelleria 1. Fitxer inexistent
================================

Canvia el nom del fitxer de la línia 11 per ``inexistent.txt``. Compila
i intenta executar el programa.

L'error que genera és: ::

    $ java Mostrat
    Exception in thread "main" java.io.FileNotFoundException: inexistent.txt (No such file or directory)

Trapelleria 2. Fitxer protegit
==============================

Crea ara un fitxer anomenat ``existent.txt`` però protegeix-lo perquè
no pugui ser llegit.

Aquí tens unes instruccions que t'ajudaran: ::

    $ touch existent.txt
    $ chmod -r existent.txt

L'error que genera és: ::

    $ java Mostrat
    Exception in thread "main" java.io.FileNotFoundException: existent.txt (Permission denied)


Trapelleria 3. Un directori en comptes d'un fitxer
==================================================

Canvia el nom de ``existent.txt`` per ``/tmp``. Compila i torna a
intentar executar-ho i copia aquí el que et genera: ::

    $ java Mostrat
    Exception in thread "main" java.io.FileNotFoundException: /tmp (Is a directory)

