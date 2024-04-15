package fr.traitementfichier;

import fr.traitementfichier.entities.Produit;
import fr.traitementfichier.services.ReadFile;

import java.io.IOException;
import java.util.ArrayList;

public class ApplicationOpenFoodFacts {
    public static void main(String[] args) throws IOException {
        ArrayList<Produit> produits = ReadFile.getProduits();

    }
}
