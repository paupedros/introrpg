
/* Aquest programa funciona com un ascensor, li direm un pis i quants pisos volem pujar o baixar */

public class Ascensor {
	public static void main(String[] args){
		System.out.println("pis?");
        String pis = Entrada.readLine();
        System.out.println("botó?");
        String boto = Entrada.readLine();
        String pis0 = "planta baixa";
        String pis1 = "primer pis";
        String pis2 = "segon pis";
        int numPis = 0;
        
        if (pis.equals(pis0)){
        	numPis = 0;
        }
        else if (pis.equals(pis1)){
        	numPis = 1;
        }
        else if (pis.equals(pis2)){
        	numPis = 2;
        }
        
        if (boto.equals("pujar un")){
        	numPis = numPis + 1;
        	if (numPis >= 3){
        		System.out.println("error");
        	}
        	else if (numPis == 1){
        		System.out.println(pis1);
        	}
        	else if (numPis == 2){
        		System.out.println(pis2);
        	}
        }
        if (boto.equals("pujar dos")){
        	numPis = numPis + 2;
        	if (numPis >= 3){
        		System.out.println("error");
        	}
        	else if (numPis == 2){
        		System.out.println(pis2);
        	}
        }
        if (boto.equals("baixar un")){
        	numPis = numPis - 1;
        	if (numPis < 0){
        		System.out.println("error");
        	}
        	else if (numPis == 0){
        		System.out.println(pis0);
        	}
        	else if (numPis == 1){
        		System.out.println(pis1);
        	}
        }
        if (boto.equals("baixar dos")){
        	numPis = numPis - 2;
        	if (numPis < 0){
        		System.out.println("error");
        	}
        	else if (numPis == 1){
        		System.out.println(pis1);
        	}
        	else if (numPis == 0){
        		System.out.println(pis0);
        	}
        }
        
	}
}


