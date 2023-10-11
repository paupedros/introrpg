public class DiaSetmana {
	public static void main(String[] args) {
		int num = Integer.parseInt(args[0]);
		String dia = "";
		if ( num == 1 ) {
			dia = "Dilluns";
		}
		else if ( num == 2 ) {
			dia = "Dimarts";
		}
		else if ( num == 3 ) {
			dia = "Dimecres";
		}
		else if ( num == 4 ) {
			dia = "Dijous";
		}
		else if ( num == 5 ) {
			dia = "Divendres";
		}
		else if ( num == 6 ) {
			dia = "Dissabte";
		}
		else if ( num == 7 ) {
			dia = "Diumenge";
		}
		else {
			dia = "Error";
		}
		System.out.println(dia);
	}
}
