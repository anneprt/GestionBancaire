import java.util.Scanner;

public class Compte {
    public String typeCompte;
    public double valeur_courante;
    public double taux;
    public String numeroCompte;
    public LigneComptable ligne;
    public int nombreLigneReel;

    public void creerCompte() {
        char tmp;
        Scanner lectureClavier = new Scanner(System.in);
        do {
            System.out.print("Type de compte [Types possibles : (c) courant, (j) joint ,(e) épargne] :");
            tmp = lectureClavier.next().charAt(0);
        } while (tmp != 'c' && tmp != 'j' && tmp != 'e');
        switch (tmp) {
            case 'c':
                typeCompte = "Courant";
                break;
            case 'j':
                typeCompte = "Joint";
                break;
            case 'e':
                typeCompte = "Epargne";
                break;
        }
        System.out.print("Numéro du compte : ");
        numeroCompte = lectureClavier.next();
        if (typeCompte.equalsIgnoreCase("Epargne")) {
            System.out.print("Taux de placement : ");
            taux = lectureClavier.nextDouble();
        }
        System.out.print("Valeur initiale du compte : ");
        valeur_courante = lectureClavier.nextDouble();
        nombreLigneReel = 0;
    }

    public void creerLigne() {
        ligne = new LigneComptable();
        ligne.creerLigneComptable();
        nombreLigneReel = 1;
        valeur_courante = valeur_courante + ligne.valeur;
    }

    public void afficherCompte() {
        System.out.println("Le compte " + numeroCompte + " est un compte");
        if (typeCompte.equalsIgnoreCase("Epargne")) {
            System.out.println("épargne dont le taux de placement est de " + taux);
        }
        if (nombreLigneReel > 0) {
            ligne.afficherLigne();
        }
        System.out.println("Première valeur créditée " + valeur_courante);
    }
}
