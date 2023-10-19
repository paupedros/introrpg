
/* En aquest programa introduirem notes entre el 0 i el 100, quan s'introdueixi 
	una fora del rang ens dirà la mitja de notes */
	
	
public class NotaMitja {
	public static void main(String[] args){
		int nota = 0;
		int notes = 0;
		int sumaNotes = 0;
		System.out.println("Introdueix un valor");
		nota = Integer.parseInt(Entrada.readLine());
		notes = 1;
		if (nota>=0 && nota<=100){
			sumaNotes = nota;
			while (nota>=0 && nota<=100){
				System.out.println("Introdueix una nota");
				nota = Integer.parseInt(Entrada.readLine());
				if (nota>=0 && nota<=100){
					notes = notes+1;
					sumaNotes = sumaNotes + nota;
				}
				
			}
			System.out.println("La mitja de les notes vàlides és " + sumaNotes/notes);
		}
		else {
			System.out.println("Cap nota vàlida introduïda");
		}
	}
}
