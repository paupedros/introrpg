/*
 * Llibreria que anirem omplint amb eines per a poder utilitzar i 
 * reutilitzar sobre el zoo
 */

import java.util.List;

public class ZooUtils {

    public static void mostraCategories(List<Categoria> categories) {
        if (categories.size() < 1) {
            System.out.println("Cap categoria");
            return;
        }
        // Indiquem el nombre de categories
        System.out.println(String.format("Nombre de categories: %d", categories.size()));
        for (Categoria cat : categories) {
            System.out.println("\t" + cat);
        }
    }

    public static void mostraAnimals(List<Animal> animals) {
        if (animals.size() < 1) {
            System.out.println("Cap animal");
            return;
        }
        String result = "Nombre de categories: " + animals.size();
        for (Animal animal : animals) {
            result += "\n\t" + animal;
        }
        System.out.println(result);
    }

}