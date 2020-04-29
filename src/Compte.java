import java.util.Scanner;

public class Compte {
    private String typeCompte;
    private double valeur_courante;
    private double taux;
    private String numeroCompte;
    private LigneComptable ligne;
    private int nombreLigneReel;

    public String quelTypeDeCompte() {
        return typeCompte;
    }

    public String quelNuméroDeCompte() {
        return numeroCompte;
    }

    public double quelleValeurCourante() {
        return valeur_courante;
    }

    public double quelTaux() {
        return taux;
    }

    public Compte() {
        Scanner lectureClavier = new Scanner(System.in);
        typeCompte = contrôleType();
        System.out.print("Numéro du compte : ");
        numeroCompte = lectureClavier.next();
        if (typeCompte.equalsIgnoreCase("Epargne")) {
            System.out.print("Taux de placement : ");
            taux = lectureClavier.nextDouble();
        }
        valeur_courante = contrôleValinit();
        nombreLigneReel = 0;
    }

    public Compte(String num) {
        numeroCompte = num;
        nombreLigneReel = 0;
    }

    public void creerCompte() {
        char tmp;
        typeCompte = contrôleType();
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
        valeur_courante = contrôleValinit();
        nombreLigneReel = 0;
    }

    public void creerLigne() {
        ligne = new LigneComptable();
        nombreLigneReel = 1;
        valeur_courante = valeur_courante + ligne.quelleValeur();
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

    private String contrôleType() {
        char tmpc;
        Scanner lectureClavier = new Scanner(System.in);
        String tmpS = "";
        do {
            System.out.print("Type du compte [Types possibles :");
            System.out.print("C(ourant), J(oint), E(pargne)] : ");
            tmpc = lectureClavier.next().charAt(0);
        } while (tmpc != 'C' && tmpc != 'J' && tmpc != 'E');
        switch (tmpc) {
            case 'C':
                typeCompte = "Courant";
                break;
            case 'J':
                typeCompte = "Joint";
                break;
            case 'E':
                typeCompte = "Epargne";
                break;
        }
        return tmpS;
    }

    private double contrôleValinit() {
        double tmp, tmpval;
        Scanner lectureClavier = new Scanner(System.in);
        do {
            System.out.print("Valeur initiale du compte : ");
            tmpval = lectureClavier.nextDouble();
        } while (tmpval <= 0);
        return tmpval;
    }


}
