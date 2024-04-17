package fr.traitementfichier.services;
import fr.traitementfichier.entities.Allergene;
import fr.traitementfichier.entities.Stock;

import java.util.*;
import java.util.stream.Collectors;

public class AfficherAllergenesPlusCourants extends Menuservice{
    @Override
    public void traiter(Stock stock, Scanner scanner) {
        Map<String, Integer> allergenesMap = new HashMap<>();
        stock.getProduits().forEach(produit -> {
            produit.getAllergenes().forEach(allergene -> {
                allergenesMap.put(allergene.getLibelle(), allergenesMap.getOrDefault(allergene.getLibelle(), 0) + 1);
            });
        });

        Map<String, Integer> allergenesMapSorted = allergenesMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(10)
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));
        System.out.println("Les 10 allergènes les plus présents : ");

        for (Map.Entry<String, Integer> allergene : allergenesMapSorted.entrySet()) {
            System.out.println(allergene.getKey() + " nb produits: " + allergene.getValue());
        }


    }
}
