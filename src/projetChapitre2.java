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
        do {
            choix = menuPrincipal();
            //Selon option choisie
            switch (choix) {

                case 1:
                    do {
                        System.out.print("Type de compte [Types possibles : (c) courant, (j) joint ,(e) épargne] :");
                        typeCompte = lectureClavier.next().charAt(0);
                    } while (typeCompte != 'c' && typeCompte != 'j' && typeCompte != 'e');
                    System.out.print("Numéro du compte : ");
                    numeroCompte = lectureClavier.nextLong();
                    System.out.print("Première valeur créditée : ");
                    valeur_courante = lectureClavier.nextDouble();
                    //option 1 : cas du compte epargne, demande du taux
                    if (typeCompte == 'e') {
                        System.out.print("Taux de placement : ");
                        taux = lectureClavier.nextDouble();
                    }
                    break;
                case 2:
                    //demander à l'utilisateur un numero de compte à afficher
                    System.out.print("Quel compte souhaitez-vous afficher ? : ");
                    numeroLu = lectureClavier.nextLong();
                    //verifier que le compte existe
                    if (numeroLu == numeroCompte) {
                        System.out.println("Le compte " + numeroCompte + " est un compte");
                        if (typeCompte == 'c') {
                            System.out.println("courant");
                        } else if (typeCompte == 'j') {
                            System.out.println("joint");
                        } else if (typeCompte == 'e') {
                            System.out.println("épargne dont le taux de placement est de " + taux);
                        }
                        System.out.println("Première valeur créditée " + valeur_courante);
                    } else {
                        //compte non reconnu
                        System.out.println("Le système ne reconnaît pas le compte " + numeroLu);
                    }
                    break;
                case 3:
                    System.out.println("Cette fonction n'est pas encore implémentée");
                    break;
                case 4:
                    sortir();
                    break;
                case 5:
                    //option 5 menu d'aide
                    aide();
                    break;
                default:
                    System.out.println("Cette option n'existe pas ");
            }

        } while (choix != 4);
    }

    public static byte menuPrincipal() {
        byte tmp;
        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("1.Créer un compte");
        System.out.println("2.Afficher un compte");
        System.out.println("3.Créer une ligne comptable");
        System.out.println("4.Sortir");
        System.out.println("5.Aide");
        System.out.println();
        System.out.print("Votre choix : ");
        tmp = lectureClavier.nextByte();
        return tmp;

    }

    public static void sortir() {
        System.out.println("Merci et à bientôt");
        System.exit(0);
    }

    public static void aide() {
        System.out.println("Option 1. Pour créer un compte Courant entrer c ");
        System.out.println("Pour créer un compte Joint entrer c ");
        System.out.println("Pour créer un compte Epargne entrer e");
        System.out.print("Puis, entrer le numero du compte, et");
        System.out.println(" sa premiere valeur créditee ");
        System.out.println("Dans le cas d'un compte epargne, entrer le taux ");
        System.out.println("Option 2. Le système affiche les données du compte choisi ");
        System.out.println("Option 3. Ecrire une ligne comptable");
        System.out.println("Option 4. Pour quitter le programme");
        System.out.println("Option 5. Pour afficher de l'aide");

    }
}
