package fr.traitementfichier.services;

import fr.traitementfichier.entities.Stock;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AfficherAdditifsPlusCourants extends Menuservice{
    @Override
    public void traiter(Stock stock, Scanner scanner) {
        Map<String, Integer> additifsMap = new HashMap<>();
        stock.getProduits().forEach(produit -> {
            produit.getAdditifs().forEach(additif -> {
                additifsMap.put(additif.getLibelle(), additifsMap.getOrDefault(additif, 0) + 1);
            });
        });
        for (Map.Entry<String, Integer> additif : additifsMap.entrySet()) {
            System.out.println(additif.getKey() + " nb produits: " + additif.getValue());
        }
    }
}
