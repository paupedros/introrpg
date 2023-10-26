
/* En aquest programa introduim un valor inicial i valors despres, el valor que mes s'apropi al
	inicial es el que direm al introduir un valor negatiu */

public class TrobaMesProxim {
	public static void main(String[] args){
		System.out.println("Introdueix l'àncora");
		int ancora = Integer.parseInt(Entrada.readLine()); 
		// Demanem l'ancora
		
		if (ancora>=0){	// Si ancora és positiva...
		
			System.out.println("Introdueix un valor");
			int valor = Integer.parseInt(Entrada.readLine());	// Demanem el primer valor
			int valorProxim = valor;	// Li assignem al valor més pròxim al valor actual
			
			if (valor>=0){	// Si el valor és positiu...
			
				int calculProxim = Math.abs(ancora - valor);	
				// Calculem la diferencia de ancora amb el valor
				
				/*if (calculProxim<0){
						calculProxim= calculProxim*(-1); 
				}*/
				
				while (valor>=0){ 
				// Mentre que el valor sigui positiu... (ja que és un bucle i el valor pot canviar)
				
					System.out.println("Introdueix un valor");
					valor = Integer.parseInt(Entrada.readLine()); // Obtenim un altre valor
					
					if(valor>=0){ // Si el bucle es positiu seguim, sino, sortirem del bucle
					
						int calcul2 = Math.abs(ancora - valor);
						// Calculem la diferencia de ancora amb el valor actual
						
						/*if (calcul2<0){
							calcul2= calcul2*(-1);
						}*/
						if (calcul2 == calculProxim && valorProxim >= valor){ 
						// Si el calcul de la diferencia actual és igual al calcul anterior i el valor més proxim és mes gran o igual al valor actual, canviem el valor més proxim al valor d'ara
						
							valorProxim = valor;
						}
						if (calcul2 < calculProxim){	
						//	Si el calcul actual és més petit que el calcul anterior, canviem el valor més proxim al actual i el calcul mes proxim al actual
						
							valorProxim = valor;
							calculProxim = calcul2;
						}
					}
					
				}
				
				System.out.println("El valor introduït més pròxim a "+ancora +" és "+valorProxim);
			}
			else { // Si el valor no és positiu...
				System.out.println("No s'ha introduït cap valor positiu");
			}
		
		}
		else { // Si ancora no es positiu...
			System.out.println("Àncora no vàlida");
		}
		
	}
}
