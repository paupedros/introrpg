# AFIRMACIONS SOBRE JDBC

1. És un sistema que ens permet accedir des d'una base de 
dades relacional, a un programa fet en Java.

    Ben bé és al revés, és un sistema que ens permet accedir a base de
    dades a través d'un programa en Java.

2. Per a poder accedir a un SGBD concret, ens caldrà una 
implementació adequada del JDBC, doncs JDBC per si sol només 
defineix interfaces i poc més.

    Exacte, per poder "parlar" amb un SGBD necessitem un controlador
    que sigui capaç de traduïrnos.

3. Si els nostres programes fan servir les interfícies definides 
per JDBC en comptes de les classes concretes dels drivers, hauria de 
ser raonablement fàcil canviar de SGBD sense haver de 
modificar els nostres programes.

    

4. Donada una implementació concreta de JDBC, coneguda com a driver, 
podríem accedir a diverses fonts de dades, no només bases de dades.

    Tot depen del driver que estiguem utilitzant, si aquest driver
    permet accedir a diferents fonts de dades doncs si que podrem.

5. Amb el driver adequat, el nostre programa hauria de poder accedir 
a un full de càlcul fent servir JDBC.

    Sí, nosaltres podem utilitzat un driver per a poder accedir a un csv.