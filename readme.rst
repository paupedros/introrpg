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

	numeroPensat = Integer.parseInt(args[0]);
	
