package fr.traitementfichier;

import fr.traitementfichier.entities.Stock;
import fr.traitementfichier.services.*;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class ApplicationOpenFoodFacts {
    public static void main(String[] args) throws IOException {
        System.out.println("Génération du stock....");
        Stock stock = ReadFile.getStock();

        boolean continuer = true;
        while (continuer) {

            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrez le numéro du mode que vous souhaitez\n");
            System.out.print("1 - Rechercher les meilleurs produits pour une Marque donnée\n");
            System.out.print("2 - Rechercher les meilleurs produits pour une Catégorie donnée\n");
            System.out.print("3 - Rechercher les meilleurs produits par Marque et par Catégorie\n");
            System.out.print("4 - Afficher les allergènes les plus courants avec le nb de produits dans lesquels ils apparaissent.\n");
            System.out.print("5 - Afficher les additifs les plus courants avec le nb de produits dans lesquels ils apparaissent.");
            scanner.nextLine();

            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    RechercheMeilleurProduitsMarque rechercheProduitsMarque = new RechercheMeilleurProduitsMarque();
                    rechercheProduitsMarque.traiter(stock, scanner);
                    break;
                case 2:
                    RechercheMeilleurProduitsCategorie rechercheProduitsCategorie = new RechercheMeilleurProduitsCategorie();
                    rechercheProduitsCategorie.traiter(stock, scanner);
                    break;
                case 3:
                    RechercheMeilleurProduitsMarqueEtCategorie rechercheProduitsMarqueCategorie = new RechercheMeilleurProduitsMarqueEtCategorie();
                    rechercheProduitsMarqueCategorie.traiter(stock, scanner);
                    break;
                case 4:
                    AfficherAllergenesPlusCourants afficherAllergenesPlusCourants = new AfficherAllergenesPlusCourants();
                    afficherAllergenesPlusCourants.traiter(stock, scanner);
                    break;
                case 5:
                    AfficherAdditifsPlusCourants afficherAdditifsPlusCourants = new AfficherAdditifsPlusCourants();
                    afficherAdditifsPlusCourants.traiter(stock, scanner);
                    break;
            }
            System.out.println("Voulez-vous choisir une autre option du menu ? (oui/non)");
            String reponse = scanner.nextLine();
            if (!reponse.equalsIgnoreCase("oui")) {
                continuer = false;
            }
        }
    }
}
