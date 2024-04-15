package fr.traitementfichier.entities;

public class Stock {
    Produit[] produits;

    public Stock(Produit[] produits) {
        this.produits = produits;
    }

    public Produit[] getProduits() {
        return produits;
    }

    public void setProduits(Produit[] produits) {
        this.produits = produits;
    }
}
