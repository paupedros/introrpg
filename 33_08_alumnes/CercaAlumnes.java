/*
 * Programa que llegeix dades d'un csv amb dades dels alumnes
 * i les seves notes
 */

import java.io.IOException;
import java.nio.Buffer;
import java.io.FileReader;
import java.io.BufferedReader;

public class CercaAlumnes {

    static class Alumne {
        String nom;
        String email;
        int edat;
        boolean esOient;
        int[] notes;
    }

    public static Alumne construeixAlumne(String nom, String email,
            int edat, boolean esOient,
            int[] notes) {
        Alumne alumne = new Alumne();
        alumne.nom = nom;
        alumne.email = email;
        alumne.edat = edat;
        alumne.esOient = esOient;
        alumne.notes = notes;
        return alumne;
    }

    public static void mostraAlumne(Alumne alumne) {
        System.out.println("Alumne: " + alumne.nom);
        System.out.println("- email: " + alumne.email);
        System.out.println("- edat: " + alumne.edat);
        System.out.println("- és oïent: " + (alumne.esOient ? "Sí" : "No"));
        System.out.println("- notes: " + notesACsv(alumne.notes));
    }

    public static String alumneAString(Alumne alumne) {
        return String.format(
                "Alumne(nom: \"%s\", email: \"%s\", " +
                        "edat: %d, esOient: %b, notes: {%s})",
                alumne.nom, alumne.email, alumne.edat, alumne.esOient,
                notesACsv(alumne.notes));
    }

    // converteix un array de notes a CSV
    // Té en comptes els valors NP com a -1
    public static String notesACsv(int[] notes) {
        String notas = "";
        for (int i = 0; i < notes.length; i++) {
            if (i == notes.length - 1) {
                notas += normaNote(notes[i]);
                continue;
            }
            notas += normaNote(notes[i]) + ",";
        }
        return notas;
    }

    // Normalitza les notes, si hi ha una nota -1 la canviarem a NP
    public static String normaNote(int nota) {
        if (nota == -1)
            return "NP";
        return Integer.toString(nota);
    }

    public static String alumneACsv(Alumne alumne) {
        return String.format("%s,%s,%f,%b,%s", alumne.nom, alumne.email, alumne.edat, alumne.esOient,
                notesACsv(alumne.notes));

    }

    public static Alumne csvAAlumne(String csv) {

        // [nom, email, edat, esOient, uf1, uf2, uf3, uf4, uf5, uf6]
        String[] csvArray = csv.split(",");

        boolean esOient = false;
        if (csvArray[3].equals("true"))
            esOient = true;
        if (csvArray[3].equals("false"))
            esOient = false;

        // Creem l'array de notes
        int[] notes = afegirNotes(csvArray);

        Alumne alumne = construeixAlumne(csvArray[0], csvArray[1], Integer.parseInt(csvArray[2]), esOient, notes);
        return alumne;
    }

    public static int[] afegirNotes(String[] csv) {
        int[] notes = new int[6];
        int j = 0;
        for (int i = 4; i < csv.length; i++) {
            // Si la nota equival a NP posarem un -1
            if (csv[i].equals("NP"))
                notes[j] = -1;
            // Sino posarem la nota com a enter
            else
                notes[j] = Integer.parseInt(csv[i]);
            j++;
        }
        return notes;
    }

    public static void main(String[] args) throws IOException {
        // assegura que hi ha el criteri de cerca
        if (args.length < 1) {
            System.out.println("Error: indica el criteri de cerca");
            return;
        }

        // declaracions, inicialitzacions, apertura de fitxer, ignora línia de
        // capçaleres, etc.

        BufferedReader alumnes = new BufferedReader(new FileReader("alumnes.csv"));
        String line = alumnes.readLine(); // Ens passem les capçaleres

        while (true) { // Per cada alumne
            // llegeix entrada i finalitza bucle si no en queden més
            line = alumnes.readLine();
            if (line == null)
                break;

            // converteix l'entrada a Alumne
            Alumne alumne = csvAAlumne(line);

            // comprova si el criteri de cerca es troba dins del nom o
            // el email. Si és així, mostra'l
            String nom = alumne.nom.toLowerCase();
            String email = alumne.email.toLowerCase();
            for (int i = 0; i < args.length; i++) { // Per cada argument
                String argu = args[i].toLowerCase();
                if (nom.contains(argu) || email.contains(argu)) {
                    mostraAlumne(alumne);
                }
            }
        }
        // consideracions finals com ara el tancament del fitxer
        alumnes.close();
    }
}