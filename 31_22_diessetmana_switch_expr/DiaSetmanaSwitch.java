public class DiaSetmanaSwitch {
	public static void main(String[] args) {
		int num = Integer.parseInt(args[0]);
		String dia = "";
		switch (num) {
			case 1 -> dia = "Dilluns";
			case 2 -> dia = "Dimarts";
			case 3 -> dia = "Dimecres";
			case 4 -> dia = "Dijous";
			case 5 -> dia = "Divendres";
			case 6 -> dia = "Dissabte";
			case 7 -> dia = "Diumenge";
			default -> dia = "Error";
		}
		
		
		
		/*switch (num) {
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
		}*/
		System.out.println(dia);
	}
}
