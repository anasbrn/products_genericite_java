package gestion.products;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IMetier<Produit> metier = new MetierProduitImpl();
        boolean running = true;

        while (running) {
            // Affichage du menu
            System.out.println("\nMenu:");
            System.out.println("1. Afficher la liste des produits.");
            System.out.println("2. Rechercher un produit par son id.");
            System.out.println("3. Ajouter un nouveau produit.");
            System.out.println("4. Supprimer un produit par id.");
            System.out.println("5. Quitter.");
            System.out.print("Choisissez une option : ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    // Afficher tous les produits
                    List<Produit> produits = metier.getAll();
                    if (produits.isEmpty()) {
                        System.out.println("Aucun produit dans la liste.");
                    } else {
                        System.out.println("| ID   | Nom                 | Marque          | Prix      | Description                    | Stock      |");
                        System.out.println("------------------------------------------------------------------------------------------------------");
                        for (int i = 0; i < produits.size(); i++) {
                            Produit p = produits.get(i);
                            System.out.println(p.toString());
                        }
                    }
                    break;

                case 2:
                    // Rechercher un produit par id
                    System.out.print("Entrez l'ID du produit : ");
                    long id = scanner.nextLong();
                    Produit produit = metier.findById(id);
                    if (produit != null) {
                        System.out.println("| ID   | Nom                 | Marque          | Prix      | Description                    | Stock      |");
                        System.out.println("------------------------------------------------------------------------------------------------------");
                        System.out.println(produit.toString());
                    } else {
                        System.out.println("Produit non trouvé.");
                    }
                    break;

                case 3:
                    // Ajouter un produit
                    System.out.print("Entrez l'ID du produit : ");
                    long newId = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Entrez le nom du produit : ");
                    String nom = scanner.nextLine();
                    System.out.print("Entrez la marque du produit : ");
                    String marque = scanner.nextLine();
                    System.out.print("Entrez le prix du produit : ");
                    double prix = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Entrez la description du produit : ");
                    String description = scanner.nextLine();
                    System.out.print("Entrez le nombre en stock : ");
                    int stock = scanner.nextInt();

                    Produit nouveauProduit = new Produit(newId, nom, marque, prix, description, stock);
                    metier.add(nouveauProduit);
                    System.out.println("Produit ajouté.");
                    break;

                case 4:
                    // Supprimer un produit par ID
                    System.out.print("Entrez l'ID du produit à supprimer : ");
                    long idToDelete = scanner.nextLong();
                    boolean isDeleted = metier.delete(idToDelete);
                    String message = isDeleted ? "Produit supprimé" : "Produit non trouvé";
                    System.out.println(message);
                    break;

                case 5:
                    // Quitter le programme
                    running = false;
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Option invalide. Essayez à nouveau.");
                    break;
            }
        }

        scanner.close();
    }
}
