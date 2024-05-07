/*
 * Classe Vehicle: representa un vehicle que pot ser llogat per un client. Té com a propietats
 * la marca, el model i la categoria (BASIC, GENERAL o LUXE). 
 */

public class Vehicle {
    public static final int BASIC = 1;
    public static final int GENERAL = 2;
    public static final int LUXE = 3;

    private String model;
    private String marca;
    private int categoria;

    Vehicle(String marca, String model, int categoria) {
        this.marca = marca;
        this.model = model;
        this.categoria = categoria;
    }

    public String getMarca() { return marca; }
    public String getModel() { return model; }
    public int getCategoria() { return categoria; }

    public void setModel(String model) { this.model = model; }
    public void setMarca(String marca) { this.marca = marca; }
    public void setCategoria(int categoria) { this.categoria = categoria; }

}
