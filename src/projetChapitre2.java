import java.util.Scanner;

public class projetChapitre2 {
    public static void main(String[] args) {
        byte choix;
        char typeCompte = '\0';
        double valeur_courante = 0.0;
        double taux = 0.0;
        long numeroCompte = 0;
        long numeroLu = 0;
        Scanner lectureClavier = new Scanner(System.in);

        //Affichage du menu principal
        System.out.println("1.Créer un compte");
        System.out.println("2.Afficher un compte");
        System.out.println("3.Créer une ligne comptable");
        System.out.println("4.Sortir");
        System.out.println("5.Aide");
        System.out.println();
        System.out.print("Votre choix : ");

        choix = lectureClavier.nextByte();

        //option 1 : creation de compte
        System.out.print("Type de compte [Types possibles : (c) courant, (j) joint ,(e) épargne] :");
        typeCompte = lectureClavier.next().charAt(0);
        System.out.print("Numéro du compte : ");
        numeroCompte = lectureClavier.nextLong();
        System.out.print("Première valeur créditée : ");
        valeur_courante = lectureClavier.nextDouble();
        //option 1 : cas du compte epargne
        System.out.print("Taux de placement : ");
        taux = lectureClavier.nextDouble();


    }
}
