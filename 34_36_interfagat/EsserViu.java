/* Interface que determina els moduls que tindran els essers vius
 * metodes:
 * esviu
 * mor
 * reviu
 * 
 * Aquests metodes serveixen per jugar amb les vides dels essers vius i fer comprovacions
 */
public interface EsserViu {
    public boolean esViu();
    public String mor();  
    public String reviu();  
}