/*
 * Classe que defineix les propietats i els comportaments que tenen
 * els animals dintre del nostre Zoo
 */

public class Animal {
    private int id = -1;
    private String nom;
    private Categoria categoria;

    Animal(String nom, Categoria categoria) {
        if (nom == null || nom.isBlank()) throw new IllegalArgumentException("El nom no pot ser null ni blanc");
        if (categoria == null) throw new IllegalArgumentException("La categoria no pot ser null");
        this.nom = nom;
        this.categoria = categoria;
    }

    Animal(int id, String nom, Categoria categoria) {
        this(nom, categoria);
        if (id < 0) {
            throw new IllegalArgumentException("L'identificador ha de ser positiu");
        }
        this.id = id;
    }

    public int getId() {
        if (!idIndefinit()) return id;
        return -1;
    }
    public void setId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("L'identificador ha de ser positiu");
        }
        this.id = id;
    }
    public String getNom() {return nom;}
    public Categoria getCategoria() {return categoria;}
    public void setCategoria(Categoria categoria) {
        if (categoria == null) throw new IllegalArgumentException("La categoria no pot ser null");
        this.categoria = categoria;
    }

    public boolean idIndefinit() {
        return id < 0 ? true : false;
    }

    @Override
    public String toString() {
        return "Animal(id:" +
            (id < 0 ? "indefinit" : id) +
            ", " + nom + ", " + categoria + ")";
    }
}
