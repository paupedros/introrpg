/* Programa que indica el nom del dia de la setmana segons el seu numero,
	utilitzant switch */

public class DiaSetmanaSwitch {
	public static void main(String[] args) {
		int num = Integer.parseInt(args[0]);
		String dia = "";
		switch (num) {
			case 1:	dia = "Dilluns";
						break;
			case 2:	dia = "Dimarts";
						break;
			case 3:	dia = "Dimecres";
						break;
			case 4:	dia = "Dijous";
						break;
			case 5:	dia = "Divendres";
						break;
			case 6:	dia = "Dissabte";
						break;
			case 7:	dia = "Diumenge";
						break;
			default:	dia = "Error";
						break;
		}
		System.out.println(dia);
	}
}
