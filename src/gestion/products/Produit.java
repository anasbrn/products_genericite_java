package gestion.products;

public class Produit {
    private long id;
    private String nom;
    private String marque;
    private double prix;
    private String description;
    private int nbrStock;

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("| %-5d | %-20s | %-15s | %-10.2f | %-30s | %-10d |",
                id, nom, marque, prix, description, nbrStock);
    }

    public Produit() {
    }

    public Produit(long id, String nom, String marque, double prix, String description, int nbrStock) {
        this.id = id;
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.description = description;
        this.nbrStock = nbrStock;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNbrStock() {
        return nbrStock;
    }

    public void setNbrStock(int nbrStock) {
        this.nbrStock = nbrStock;
    }
}
