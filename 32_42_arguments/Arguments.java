/*
 * En aquest programa identificarem si els arguments del main son o no enters
 */

public class Arguments {
    public static void main(String[] args) {
        
        if(args.length == 0){
            System.out.println("Cap argument");
            return;
        }
    
        for (int i = 0; i < args.length; i++) {
            System.out.print("[" + i + "]" + " "); // La posicio de l'argument
            String text = "";
            if(UtilString.esEnter(args[i], true)){ // text de si es enter o no
                text = "és enter";
            }
            else {
                text = "no és enter";
            }
            System.out.println("\""+ args[i] + "\": " + text);
        }
    }
}
