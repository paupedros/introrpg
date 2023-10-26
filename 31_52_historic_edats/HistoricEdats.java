
/* En aquest programa indicarem el nom, l'edat i l'any actual, a partir d'aixo direm quants 
	anys hem tingut cada any de la nostra vida */
	
public class HistoricEdats{
	public static void main(String[] args){
		System.out.println("El vostre nom?");
		String nom = Entrada.readLine();
		System.out.println("La vostra edat?");
		int edat = Integer.parseInt(Entrada.readLine());
		System.out.println("L'any actual?");
		int any = Integer.parseInt(Entrada.readLine());
		
		if (edat==0){
			System.out.println("Adéu " + nom);
		}
		else {
			int anyNeixer = any - edat;
			for (int i=0; i<edat; i++){
				if (i==0){
					System.out.println("El " + anyNeixer + " vau néixer");
				}
				else if (i==1){
					System.out.println("El " + anyNeixer + " teníeu " + i + " any");
				}
				else {
					System.out.println("El " + anyNeixer + " teníeu " + i + " anys");
				}
				anyNeixer++;
			}
			System.out.println("Adéu " + nom);
		}
		
		
		
		
	}
}

