
/* Aquest programa ens pregunta un mes i any i ens diu el mes anterior i el mes següent */

public class MesosAnys {
	public static void main(String[] args){
		System.out.println("Mes?");
		int mes = Integer.parseInt(Entrada.readLine());
		System.out.println("Any?");
		int any = Integer.parseInt(Entrada.readLine());
		int anyAnterior = any;
		int anySeguent = any;
		int mesAnterior = mes - 1;
		if ( mesAnterior <= 0 ) {	
			mesAnterior = 12;
			anyAnterior = any - 1;
		}
		int mesSeguent = mes + 1;
		if ( mesSeguent > 12 ) {
			mesSeguent = 1;
			anySeguent = any + 1;
		}
		
		
		System.out.println("Mes anterior " + mesAnterior + "/" + anyAnterior + " i mes següent " + mesSeguent + "/" + anySeguent);
	}
}
