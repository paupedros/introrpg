public class Properties {
    public static void main(String[] args) {
        try {
            getProps();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void getProps() {
        // Propietats a cercar
        String ref = null;
        String nom = null;
        int preu = -1;
        int estoc = -1;
        Origen origen = null;
        Tipus tipus = null;
        String collita = null;

        String[] props = {"nom> ", "preu max.> ", "estoc min.> ", "D.O.> ", "tipus> ", "collita> "};

        for (String prop : props) {
            System.out.print(prop);
            String input = Entrada.readLine();
            if (!input.isBlank()){
                if (!input.equals("!")){
                    // Si estem demanant el preu o el estoc els tractem debidament
                    if (prop.equals("preu max.> ") || prop.equals("estoc min.> ")) {
                        // Si el input no es un enter llencem exception
                        if (!UtilString.esEnter(input)) {
                            throw new IllegalArgumentException("ERROR: el valor ha de ser un enter positiu");
                        }
                    }
                    else {

                    }
                }
                else break;
            }
        }
    }

    private Especificacio crearPlantilla(String[] propietats) {
        // Crear objeto Vi con las propiedades
        return new Especificacio(
                propietats[0], // nom
                Origen.fromString(propietats[3]), // origen
                Tipus.fromString(propietats[4]), // tipus
                propietats[5]);
    }
}
