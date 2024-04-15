package fr.traitementfichier.entities;

public class Allergene {
    String libelle;

    public Allergene(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
