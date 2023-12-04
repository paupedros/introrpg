
/* En aquest programa separarem les lletres en comes i mostrarem nomes les lletres, cada tasca
	la farem amb un modul reutilitzat des de l'arxiu UtilString */

public class NomesLletres{
	public static void main(String[] args){
		System.out.println("Text?");
		System.out.println(
			UtilString.lletresSeparades(
				UtilString.nomesLletres(
					Entrada.readLine()
				)
			)
		);
	}
}



