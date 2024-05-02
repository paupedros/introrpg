/*
 * Programa que mostra els punts i els segments de dos 
 * punts donats per l'usuari i la longitud dels segments
 */

public class UsaSegment {
    public static void main(String[] args){
        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
        if (args.length > 0 && UtilString.esEnter(args[0])) x1 = Integer.parseInt(args[0]);
        if (args.length > 1 && UtilString.esEnter(args[1])) y1 = Integer.parseInt(args[1]);
        if (args.length > 2 && UtilString.esEnter(args[2])) x2 = Integer.parseInt(args[2]);
        if (args.length > 3 && UtilString.esEnter(args[3])) y2 = Integer.parseInt(args[3]);
        Punt punt1 = new Punt(x1, y1);
        Punt punt2 = new Punt(x2, y2);
        Segment segment1 = new Segment(punt1, punt2);
        Segment segment2 = new Segment();
        segment2.setP1(segment1.getP2());
        segment2.setP2(segment1.getP1());
        System.out.printf("p1: %s%n", punt1);
        System.out.printf("p2: %s%n", punt2);
        System.out.printf("s1: %s s1.longitud: %.02f%n", segment1, segment1.longitud());
        System.out.printf("s2: %s s2.longitud: %.02f%n", segment2, segment2.longitud());
    }
}