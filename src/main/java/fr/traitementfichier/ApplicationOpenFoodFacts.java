package fr.traitementfichier;

import fr.traitementfichier.entities.Stock;
import fr.traitementfichier.services.ReadFile;
import fr.traitementfichier.services.RechercheMeilleurProduitsMarque;
import fr.traitementfichier.services.RechercheMeilleurProduitsMarqueEtCategorie;

import java.io.IOException;
import java.util.Scanner;

public class ApplicationOpenFoodFacts {
    public static void main(String[] args) throws IOException {
        Stock stock = ReadFile.getStock();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le numéro du mode que vous souhaitez ");
        System.out.print("1 - Rechercher les meilleurs produits pour une Marque donnée ");
        System.out.print("2 - Rechercher les meilleurs produits pour une Catégorie donnée ");
        System.out.print("3 - Rechercher les meilleurs produits par Marque et par Catégorie ");
        System.out.print("4 - Afficher les allergènes les plus courants avec le nb de produits dans lesquels ils apparaissent. ");
        System.out.print("4 - Afficher les additifs les plus courants avec le nb de produits dans lesquels ils apparaissent. ");

        int choix = scanner.nextInt();
        scanner.nextLine();

        switch (choix) {
            case 1:
                RechercheMeilleurProduitsMarque rechercheProduitsMarque = new RechercheMeilleurProduitsMarque();
                rechercheProduitsMarque.traiter(stock, scanner);
                break;
            case 2:
                RechercheMeilleurProduitsMarqueEtCategorie rechercheProduitsMarqueCategorie = new RechercheMeilleurProduitsMarqueEtCategorie();
                rechercheProduitsMarqueCategorie.traiter(stock, scanner);
                break;
        }
    }
}
