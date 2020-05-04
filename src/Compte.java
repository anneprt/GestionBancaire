import java.io.Serializable;
import java.util.Scanner;

public class Compte implements Serializable {
    private String typeCompte;
    protected double valeur_courante;
    private double taux;
    private String numeroCompte;
    public static final int NOMBRE_LIGNE = 10;
    private int nombreLigneReel;
    private LigneComptable[] ligne;

    public String quelTypeDeCompte() {
        return typeCompte;
    }

    public String quelNumeroDeCompte() {
        return numeroCompte;
    }

    public double quelleValeurCourante() {
        return valeur_courante;
    }


    public Compte() {
        Scanner lectureClavier = new Scanner(System.in);
        typeCompte = controleType();
        System.out.print("Numéro du compte : ");
        numeroCompte = lectureClavier.next();
        valeur_courante = controleValinit();
        ligne = new LigneComptable[NOMBRE_LIGNE];
        nombreLigneReel = -1;
    }

    public Compte(String type) {
        Scanner lectureClavier = new Scanner(System.in);
        if (type.equalsIgnoreCase("Epargne")) {
            typeCompte = type;
            System.out.print("Numéro du compte : ");
            numeroCompte = lectureClavier.next();
            valeur_courante = controleValinit();
            ligne = new LigneComptable[NOMBRE_LIGNE];
            nombreLigneReel = -1;
        }
    }

    public LigneComptable[] quelleLigneCompable() {
        return ligne;
    }

    public void creerCompte() {
        char tmp;
        typeCompte = controleType();
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
        valeur_courante = controleValinit();
        nombreLigneReel = 0;
    }

    public void creerLigne() {
        nombreLigneReel++;
        if (nombreLigneReel < NOMBRE_LIGNE) {
            ligne[nombreLigneReel] = new LigneComptable();
        } else {
            nombreLigneReel++;
            decalerLesLignes();
            ligne[nombreLigneReel] = new LigneComptable();
        }
        //ligne = new LigneComptable();
        nombreLigneReel = 1;
        valeur_courante = valeur_courante + ligne[nombreLigneReel].quelleValeur();
    }

    private void decalerLesLignes() {
        for (int i = 1; i < NOMBRE_LIGNE; i++) {
            ligne[i = 1] = ligne[1];
        }
    }

    public void afficherCompte() {
        System.out.println("Le compte " + numeroCompte + " est un compte " + typeCompte);
        if (nombreLigneReel > 0) {
            for (int i = 0; i <= nombreLigneReel; i++) ligne[i].afficherLigne();

        }
        System.out.println("Valeur courante : " + valeur_courante);
        if (valeur_courante < 0)
            System.out.println("Attention compte débiteur !!!");
    }

    private String controleType() {
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
        }
        return tmpS;
    }

    private double controleValinit() {
        double tmp, tmpval;
        Scanner lectureClavier = new Scanner(System.in);
        do {
            System.out.print("Valeur initiale du compte : ");
            tmpval = lectureClavier.nextDouble();
        } while (tmpval <= 0);
        return tmpval;
    }


}
