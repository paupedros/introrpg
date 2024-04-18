/**
 * Classe que crea una nova excepcio per a utilitzar a la botiga,
 * per defecte el missatge sera: "Botiga plena"
 */

public class BotigaException extends Exception {
    
    BotigaException() {
        super("Botiga plena");
    }

    BotigaException(String missatge) {
        super(missatge);
    }
}
