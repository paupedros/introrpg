# Explicacio de la herencia
*Utilitzant els exemples d'Electrodomestics*

A partir de la classe Base ``Electrodomestic`` tenim dues subclasses ``Rentadora`` i ``Rentaplats``.

Aquests dos hereden de ``Electrodomestic`` les propietats `marca`, ``model`` i si esta ``ences`` o no. Llavors les subclasses al ser instanciades es pot definir el model i la marca directament amb el constructor d'``Electrodomestic``, a demes d'encendre i apagar-lo.

Rentadora te la propietat ``rpm`` referint-se a les revolucions per minut del tambor. Junt amb metodes com centrifugar que canvia les revolucions a 3600.

Rentaplats te la propietat ``eficiencia`` que ens indica quina lletra de la escala d'eficiencia té.

<hr>

***Conclusió: Rentadora i Rentaplats són Electrodomestics, pero un Electrodomestic no pot ser ni Rentadora ni Rentaplats***