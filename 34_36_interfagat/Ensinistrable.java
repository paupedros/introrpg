/* Interface que determina els moduls que tindran els ensinistrables
 * metodes:
 *  esdret
 * esassegut
 * esesteirat
 * aixecat
 * seu
 * estirat
 * 
 * Aquest son els metodes que han de tenir els ensinistrables
 */

public interface Ensinistrable {
    public boolean esDret();
    public boolean esAssegut();
    public boolean esEstirat();
    public String aixecat();
    public String seu();
    public String estirat();
}