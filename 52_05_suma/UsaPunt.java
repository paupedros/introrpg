/*
 * Classe que prova la implementacio de la funcionalitat suma de dos punts
 */

public class UsaPunt {
    public static void main(String[] args){
        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
        if (args.length > 0 && UtilString.esEnter(args[0])) x1 = Integer.parseInt(args[0]);
        if (args.length > 1 && UtilString.esEnter(args[1])) y1 = Integer.parseInt(args[1]);
        if (args.length > 2 && UtilString.esEnter(args[2])) x2 = Integer.parseInt(args[2]);
        if (args.length > 3 && UtilString.esEnter(args[3])) y2 = Integer.parseInt(args[3]);
        Punt p1 = new Punt(x1, y1);
        Punt p2 = new Punt(x2, y2);
        System.out.printf("p1: (%d, %d)%n", p1.getX(), p1.getY());
        System.out.printf("p2: (%d, %d)%n", p2.getX(), p2.getY());
        p1.suma(p2);
        System.out.printf("p1+p2: (%d, %d)%n", p1.getX(), p1.getY());
    }
}