package fr.traitementfichier.entities;

public class Ingredient {
    String libelle;

    public Ingredient(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
