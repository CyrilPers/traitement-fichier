package fr.traitementfichier.services;

import fr.traitementfichier.entities.Marque;
import fr.traitementfichier.entities.Produit;
import fr.traitementfichier.entities.Stock;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RechercheMeilleurProduitsMarque extends Menuservice {

    @Override
    public void traiter(Stock stock, Scanner scanner) {
        System.out.print("Entrez le nom de la marque dont vous souhaitez obtenir les meilleurs produits ");

        String nomMarque = scanner.nextLine();

        System.out.println("Vous avez choisi le marque : " + nomMarque);

        List<Produit> produitsMarque = filterListBy(stock, nomMarque);

        afficheMeilleursProduits(produitsMarque, 'a');
    }

    protected static List<Produit> getProduitsByScore ( List<Produit> produits, char score ) {
            return produits.stream()
            .filter(produit -> produit.getScoreNutritionelle() == score)
            .toList();
    }

    protected static void afficheMeilleursProduits (List<Produit>  produitsMarque, char lettreScore) {

        List<Produit> produitsMeilleurScore = getProduitsByScore(produitsMarque, lettreScore);

        if (produitsMeilleurScore.size() > 0) {
            for (Produit produitMeilleurScore : produitsMeilleurScore) {
                System.out.println(produitMeilleurScore.getLibelle());
            }
        } else {
            lettreScore = (char) (lettreScore + 1);
            produitsMeilleurScore = getProduitsByScore(produitsMarque, lettreScore);
            afficheMeilleursProduits(produitsMeilleurScore, lettreScore);
        }
    }

    protected static List<Produit> filterListBy (Stock stock, String nomMarque) {
        List<Produit> produitsMarque = new ArrayList<>();
        stock.getProduits().forEach(produit -> {
            if (nomMarque.toLowerCase().equals(produit.getMarque().getNom().toLowerCase())) {
                produitsMarque.add(produit);
            }
        });
        return produitsMarque;
    }
}
