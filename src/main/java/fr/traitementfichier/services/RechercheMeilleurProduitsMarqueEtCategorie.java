package fr.traitementfichier.services;

import fr.traitementfichier.entities.Produit;
import fr.traitementfichier.entities.Stock;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RechercheMeilleurProduitsMarqueEtCategorie extends RechercheMeilleurProduitsMarque {

    @Override
    public void traiter(Stock stock, Scanner scanner) {
        System.out.print("Entrez le nom de la marque dont vous souhaitez obtenir les meilleurs produits ");
        String nomMarque = scanner.nextLine();
        System.out.print("Entrez la catégorie ");
        String nomCategorie = scanner.nextLine();
        List<Produit> produitsMarque = filterListBy(stock, nomMarque, nomCategorie);
        afficheMeilleursProduits(produitsMarque, 'a');
    }

    private static List<Produit> filterListBy(Stock stock, String nomMarque, String nomCategorie) {
        List<Produit> produitsMarque = new ArrayList<>();
        stock.getProduits().forEach(produit -> {
            if (nomMarque.toLowerCase().equals(produit.getMarque().getNom().toLowerCase()) && nomCategorie.toLowerCase().equals(produit.getCategorie().getLibelle().toLowerCase())) {
                produitsMarque.add(produit);
            }
        });
        return produitsMarque;
    }

}
