package fr.traitementfichier.services;

import fr.traitementfichier.entities.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadFile {
    public static Stock getStock() throws IOException {
        Path pathOrigine = Paths.get("src/main/resources/open-food-facts.csv");
        boolean exists = Files.exists(pathOrigine);
        ArrayList<Produit> produits = new ArrayList<>();
        ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(pathOrigine, StandardCharsets.UTF_8);

        if (exists) {
            for (int i = 1; i < lines.size(); i++) {

                String[] tokens = lines.get(i).split("\\|");
                Categorie categorie = new Categorie(tokens[0]);
                Marque marque = new Marque(tokens[1]);
                List<Ingredient> ingredients = getIngredients(tokens[4]);
                Boolean presenceHuileDeCalme = tokens[26].equals(0) ? false : true;
                List<Allergene> allergenes = getAllergenes(tokens[27]);
                List<Additif> additifs = tokens.length >= 29 ? getAllAdditifs(tokens[28]) : Collections.emptyList();
                Produit newProduit = new Produit(
                        tokens[2],
                        categorie,
                        marque,
                        tokens[3].charAt(0),
                        ingredients,
                        getValeurNutritionnelle(tokens[5]),
                        getValeurNutritionnelle(tokens[6]),
                        getValeurNutritionnelle(tokens[7]),
                        getValeurNutritionnelle(tokens[8]),
                        getValeurNutritionnelle(tokens[9]),
                        getValeurNutritionnelle(tokens[10]),
                        getValeurNutritionnelle(tokens[11]),
                        getValeurNutritionnelle(tokens[12]),
                        getValeurNutritionnelle(tokens[13]),
                        getValeurNutritionnelle(tokens[14]),
                        getValeurNutritionnelle(tokens[15]),
                        getValeurNutritionnelle(tokens[16]),
                        getValeurNutritionnelle(tokens[17]),
                        getValeurNutritionnelle(tokens[18]),
                        getValeurNutritionnelle(tokens[19]),
                        getValeurNutritionnelle(tokens[20]),
                        getValeurNutritionnelle(tokens[21]),
                        getValeurNutritionnelle(tokens[22]),
                        getValeurNutritionnelle(tokens[23]),
                        getValeurNutritionnelle(tokens[24]),
                        getValeurNutritionnelle(tokens[25]),
                        getValeurNutritionnelle(tokens[26]),
                        presenceHuileDeCalme,
                        allergenes,
                        additifs
                );
                produits.add(newProduit);

            }
            return new Stock(produits);
        }
        return new Stock(produits);
    }

    private static List<Additif> getAllAdditifs(String additifs) {
        List<Additif> additifList = new ArrayList<>();
        String[] additifNames = additifs.split(",");
        for (String additifName : additifNames) {
            Additif newAdditif = new Additif(additifName);
            additifList.add(newAdditif);
        }
        return additifList;

    }

    private static List<Allergene> getAllergenes(String allergenes) {
        String[] allergeneNames = allergenes.split(",");
        List<Allergene> allergenesList = new ArrayList<>();
        for (String allergeneName : allergeneNames) {
            Allergene newAllergene = new Allergene(allergeneName);
            allergenesList.add(newAllergene);
        }
        return allergenesList;

    }

    private static List<Ingredient> getIngredients(String ingredients) {
        String[] ingredientNames = ingredients.split(",");
        List<Ingredient> ingredientList = new ArrayList<>();
        for (String ingredientName : ingredientNames) {
            Ingredient newIngredient = new Ingredient(ingredientName);
            ingredientList.add(newIngredient);
        }
        return ingredientList;
    }

    private static double getValeurNutritionnelle(String valeurNutritionnelle) {
        if (!valeurNutritionnelle.isEmpty()) {
            try {
                return Double.parseDouble(valeurNutritionnelle);
            } catch (NumberFormatException e) {
                return 0;
            }
        }
        return 0;
    }
}
