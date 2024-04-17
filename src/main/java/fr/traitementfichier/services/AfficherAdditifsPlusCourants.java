package fr.traitementfichier.services;

import fr.traitementfichier.entities.Stock;

import java.util.*;
import java.util.stream.Collectors;

public class AfficherAdditifsPlusCourants extends Menuservice{
    @Override
    public void traiter(Stock stock, Scanner scanner) {
        Map<String, Integer> additifsMap = new HashMap<>();
        stock.getProduits().forEach(produit -> {
            produit.getAdditifs().forEach(additif -> {
                System.out.println(additif.getLibelle());
                additifsMap.put(additif.getLibelle(), additifsMap.getOrDefault(additif.getLibelle(), 0) + 1);
            });
        });

        Map<String, Integer> additifsMapSorted = additifsMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(10)
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));


        for (Map.Entry<String, Integer> additif : additifsMapSorted.entrySet()) {
            System.out.println(additif.getKey() + " nb produits: " + additif.getValue());
        }


    }
}
