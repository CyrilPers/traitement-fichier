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
import java.util.Optional;

public class ReadFile {

    static List<Additif> additifListAll = new ArrayList<>();
    static List<Ingredient> ingredientListAll = new ArrayList<>();
    static List<Allergene> allergenesListAll = new ArrayList<>();
    static ArrayList<Categorie> categoriesListAll = new ArrayList<>();
    static ArrayList<Marque> marquesListAll = new ArrayList<>();

    public static Stock getStock() throws IOException {


        Path pathOrigine = Paths.get("src/main/resources/open-food-facts.csv");
        boolean exists = Files.exists(pathOrigine);
        ArrayList<Produit> produits = new ArrayList<>();
        ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(pathOrigine, StandardCharsets.UTF_8);


        if (exists) {
            for (int i = 1; i < lines.size(); i++) {

                String[] tokens = lines.get(i).split("\\|");
                Categorie categorie = getCategorie(tokens[0]); // todo getCategorie
                Marque marque = getMarque(tokens[1]); //
                List<Ingredient> ingredients = getIngredients(tokens[4]);
                Boolean presenceHuileDePalme = getPresenceHuilePalme(tokens[26]);
                List<Allergene> allergenes = tokens.length >= 29 ? getAllergenes(tokens[28]) : Collections.emptyList();
                List<Additif> additifs = tokens.length >= 30 ? getAllAdditifs(tokens[29]) : Collections.emptyList();

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
                        presenceHuileDePalme,
                        allergenes,
                        additifs
                );
                produits.add(newProduit);

            }
            return new Stock(produits);
        }
        return new Stock(produits);
    }

    private static Marque getMarque(String marqueName) {
        Optional<Marque> marqueFound = marquesListAll.stream()
                .filter(categorie -> categorie.getNom().equals(marqueName))
                .findFirst();
        if (marqueFound.isPresent()) {
            return marqueFound.get();
        } else {
            Marque newMarque = new Marque(marqueName);
            marquesListAll.add(newMarque);
            return newMarque;
        }

    }

    private static Categorie getCategorie(String categorieName) {
        Optional<Categorie> categorieFound = categoriesListAll.stream()
                .filter(categorie -> categorie.getLibelle().equals(categorieName))
                .findFirst();
        if (categorieFound.isPresent()) {
            return categorieFound.get();
        } else {
            Categorie newCategorie = new Categorie(categorieName);
            categoriesListAll.add(newCategorie);
            return newCategorie;
        }

    }

    private static Boolean getPresenceHuilePalme(String token) {
        if (token.isEmpty()) {
            return false;
        } else {
            return Double.parseDouble(token) != 0;
        }
    }

    private static List<Additif> getAllAdditifs(String additifs) {
        String[] additifNames = additifs.split(",");
        List<Additif> additifList = new ArrayList<>();
        for (String additifName : additifNames) {
            Optional<Additif> foundAdditif = additifListAll.stream()
                    .filter(additif -> additif.getLibelle().equals(additifName))
                    .findFirst();
            if (foundAdditif.isPresent()) {
                additifList.add(foundAdditif.get());
            } else {
                Additif newAdditif = new Additif(additifName);
                additifListAll.add(newAdditif);
                additifList.add(newAdditif);
            }
        }
        return additifList;
}

private static List<Allergene> getAllergenes(String allergenes) {
    String[] allergeneNames = allergenes.split(",");
    List<Allergene> allergenesList = new ArrayList<>();
    for (String allergeneName : allergeneNames) {
        Optional<Allergene> foundAllergene = allergenesListAll.stream()
                .filter(allergene -> allergene.getLibelle().equals(allergeneName))
                .findFirst();
        if (foundAllergene.isPresent()) {
            allergenesList.add(foundAllergene.get());
        } else {
            Allergene newAllergene = new Allergene(allergeneName);
            allergenesListAll.add(newAllergene);
            allergenesList.add(newAllergene);
        }
    }
    return allergenesList;
}

private static List<Ingredient> getIngredients(String ingredients) {
    String[] ingredientNames = ingredients.split(",");
    List<Ingredient> ingredientList = new ArrayList<>();
    for (String ingredientName : ingredientNames) {
        Optional<Ingredient> foundIngredient = ingredientListAll.stream()
                .filter(ingredient -> ingredient.getLibelle().equals(ingredientName))
                .findFirst();
        if (foundIngredient.isPresent()) {
            ingredientList.add(foundIngredient.get());
        } else {
            Ingredient newIngredient = new Ingredient(ingredientName);
            ingredientListAll.add(newIngredient);
            ingredientList.add(newIngredient);
        }
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
