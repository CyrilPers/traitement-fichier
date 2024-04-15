package fr.traitementfichier.services;

import fr.traitementfichier.entities.Produit;
import fr.traitementfichier.entities.Stock;

import java.util.List;
import java.util.Scanner;

public abstract class Menuservice {

    public abstract void traiter(Stock stock, Scanner scanner);

}

