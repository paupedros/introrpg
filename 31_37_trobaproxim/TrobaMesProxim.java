
/* En aquest programa introduim un valor inicial i valors despres, el valor que mes s'apropi al
	inicial es el que direm al introduir un valor negatiu */

public class TrobaMesProxim {
	public static void main(String[] args){
		System.out.println("Introdueix l'àncora");
		int ancora = Integer.parseInt(Entrada.readLine());
		if (ancora>=0){
			System.out.println("Introdueix un valor");
			int valor = Integer.parseInt(Entrada.readLine());
			int valorProxim = valor;
			if (valor>=0){
				int calculProxim = (ancora - valor);
				if (calculProxim<0){
						calculProxim= calculProxim*(-1); 
				}
				
				while (valor>=0){
					System.out.println("Introdueix un valor");
					valor = Integer.parseInt(Entrada.readLine());
					if(valor>=0){
						int calcul2 = (ancora - valor) ;
						if (calcul2<0){
							calcul2= calcul2*(-1); 
						}
						if (calcul2 == calculProxim && valorProxim >= valor){
							valorProxim = valor;
						}
						if (calcul2 < calculProxim){
							valorProxim = valor;
							calculProxim = calcul2;
						}
					}
					
				}
				
				System.out.println("El valor introduït més pròxim a "+ancora +" és "+valorProxim);
			}
			else {
				System.out.println("No s'ha introduït cap valor positiu");
			}
		
		}
		else {
			System.out.println("Àncora no vàlida");
		}
		
	}
}
