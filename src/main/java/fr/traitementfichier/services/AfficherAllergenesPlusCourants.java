package fr.traitementfichier.services;
import fr.traitementfichier.entities.Stock;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AfficherAllergenesPlusCourants extends Menuservice{
    @Override
    public void traiter(Stock stock, Scanner scanner) {
        Map<String, Integer> allergenesMap = new HashMap<>();
        stock.getProduits().forEach(produit -> {
            produit.getAllergenes().forEach(allergene -> {
                allergenesMap.put(allergene.getLibelle(), allergenesMap.getOrDefault(allergene, 0) + 1);
            });
        });
        for (Map.Entry<String, Integer> allergene : allergenesMap.entrySet()) {
            System.out.println(allergene.getKey() + " nb produits: " + allergene.getValue());
        }
    }
}
