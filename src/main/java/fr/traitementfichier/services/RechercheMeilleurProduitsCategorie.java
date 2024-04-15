package fr.traitementfichier.services;

import fr.traitementfichier.entities.Produit;
import fr.traitementfichier.entities.Stock;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RechercheMeilleurProduitsCategorie extends RechercheMeilleurProduitsMarque{
    @Override
    public void traiter(Stock stock, Scanner scanner) {
        System.out.print("Entrez le nom de la catégorie dont vous souhaitez obtenir les meilleurs produits ");

        String nomCategorie = scanner.nextLine();

        System.out.println("Vous avez choisi la catégorie : " + nomCategorie);

        List<Produit> produitsCategorie = filterListBy(stock, nomCategorie);

        afficheMeilleursProduits(produitsCategorie, 'a');
    }

    protected static List<Produit> filterListBy (Stock stock, String nomCategorie) {
        List<Produit> produitsFiltered = new ArrayList<>();
        stock.getProduits().forEach(produit -> {
            if (nomCategorie.toLowerCase().equals(produit.getCategorie().getLibelle().toLowerCase())) {
                produitsFiltered.add(produit);
            }
        });
        return produitsFiltered;
    }
}
