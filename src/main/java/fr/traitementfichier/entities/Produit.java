package fr.traitementfichier.entities;

import java.util.List;

public class Produit {
    String libelle;
    Categorie categorie;
    Marque marque;
    char scoreNutritionelle;
    List <Ingredient> ingredients;
    double energie100g = 0;
    double graisse100g = 0;
    double sucres100g = 0;
    double fibres100g = 0;
    double proteines100g = 0;
    double sel100g = 0;
    double vitA100g = 0;
    double vitD100g = 0;
    double vitE100g = 0;
    double vitK100g = 0;
    double vitC100g = 0;
    double vitB1100g = 0;
    double vitB2100g = 0;
    double vitPP100g = 0;
    double vitB6100g = 0;
    double vitB9100g = 0;
    double vitB12100g = 0;
    double calcium100g = 0;
    double magnesium100g = 0;
    double iron100g = 0;
    double fer100g = 0;
    double bertaCarotene100g = 0;
    Boolean presenceHuilePalme = false;
    List <Allergene> allergenes;
    List <Additif> additifs;

    public Produit(String libelle, Categorie categorie, Marque marque, char scoreNutritionelle, List <Ingredient> ingredients, double energie100g, double graisse100g, double sucres100g, double fibres100g, double proteines100g, double sel100g, double vitA100g, double vitD100g, double vitE100g, double vitK100g, double vitC100g, double vitB1100g, double vitB2100g, double vitPP100g, double vitB6100g, double vitB9100g, double vitB12100g, double calcium100g, double magnesium100g, double iron100g, double fer100g, double bertaCarotene100g, Boolean presenceHuilePalme, List<Allergene> allergenes, List<Additif> additifs) {
        this.libelle = libelle;
        this.categorie = categorie;
        this.marque = marque;
        this.scoreNutritionelle = scoreNutritionelle;
        this.ingredients = ingredients;
        this.energie100g = energie100g;
        this.graisse100g = graisse100g;
        this.sucres100g = sucres100g;
        this.fibres100g = fibres100g;
        this.proteines100g = proteines100g;
        this.sel100g = sel100g;
        this.vitA100g = vitA100g;
        this.vitD100g = vitD100g;
        this.vitE100g = vitE100g;
        this.vitK100g = vitK100g;
        this.vitC100g = vitC100g;
        this.vitB1100g = vitB1100g;
        this.vitB2100g = vitB2100g;
        this.vitPP100g = vitPP100g;
        this.vitB6100g = vitB6100g;
        this.vitB9100g = vitB9100g;
        this.vitB12100g = vitB12100g;
        this.calcium100g = calcium100g;
        this.magnesium100g = magnesium100g;
        this.iron100g = iron100g;
        this.fer100g = fer100g;
        this.bertaCarotene100g = bertaCarotene100g;
        this.presenceHuilePalme = presenceHuilePalme;
        this.allergenes = allergenes;
        this.additifs = additifs;
    }



    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public char getScoreNutritionelle() {
        return scoreNutritionelle;
    }

    public void setScoreNutritionelle(char scoreNutritionelle) {
        this.scoreNutritionelle = scoreNutritionelle;
    }

    public List <Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List <Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Additif> getAdditifs() {
        return additifs;
    }

    public void setAdditifs(List<Additif> additifs) {
        this.additifs = additifs;
    }

    public List<Allergene> getAllergenes() {
        return allergenes;
    }

    public void setAllergenes(List <Allergene> allergenes) {
        this.allergenes = allergenes;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
