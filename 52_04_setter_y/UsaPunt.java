/*
 * Classe per provar els tests amb propietats i setters
 * en aquest cas implementant amb la propietat y del exemple
 */

public class UsaPunt {
    public static void main(String[] args){
        Punt punt = new Punt();
        int x = 0; // args[0] si hi és i és enter, o 0 altrament
        int y = 0; //  args[1] si hi és i és enter, o 0 altrament
        if (args.length > 0) {
            if (UtilString.esEnter(args[0])) x = Integer.parseInt(args[0]);
            if (args.length == 2) {
                if (UtilString.esEnter(args[1])) y = Integer.parseInt(args[1]);
            }
        }
        punt.setX(x);
        punt.setY(y);
        System.out.printf("punt.getX() -> %d%n", punt.getX());
        System.out.printf("punt.getY() -> %d%n", punt.getY());
    }
}