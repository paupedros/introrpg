############################
Introducció a la Programació
############################

Activitats del curs d'introducció a la programació

Comandes
========

Tipus de variables
------------------

.. code-block:: java

	int edat = 42;
	int temperatura = -12;

	double radi = 2.36;
	double mig = 0.5;

	boolean content = true;
	boolean trist = false;

	char lletraInicial = 'R';
	char euro = '€';

	String nom = "Pau";
	String buit = "";


Public class i public main
--------------------------

.. code-block:: java

	public class NomFitxer{
		public static void main(String[] args){
			/* ---- Codi ---- */
		}
	}


Imprimir per pantalla
---------------------

.. code-block:: java

	System.out.print("Impressió simple");
	System.out.println("Impressió amb salt de línia");

Entrada estàndard
-----------------

.. code-block:: java

	int primerOperand = Integer.parseInt(Entrada.readLine());


Inicialització en línia
-----------------------

Al executar farem: java EndeveinaNombre 42, llavors numeroPensat agafarà el valor 42

.. code-block:: java

	int numeroPensat = Integer.parseInt(args[0]);


Bucle while
-----------

.. code-block:: java

	int numero = 1;         // variable de recorregut assignada al primer valor

	while (numero <= 10) {  // condició de sortida en passar del darrer valor

   		 System.out.println(numero);

   		 numero = numero + 1;    // passem el número al següent

	}	

Bucle for
---------

Parts del bucle for:

.. code-block:: java

	for (int numero = 1;             // variable de recorregut

     		numero <= 10;               // condició

     		numero = numero + 1) {      // passa al número següent

     		System.out.println(numero); // processa el valor

 	}

Manera abreujada

.. code-block:: java

	for (int numero = 1; numero <= 10; numero = numero + 1) {

    		System.out.println(numero);

	}
