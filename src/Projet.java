import java.util.Scanner;

public class Projet {


    public static void main(String[] args) {
        byte choix = 0;
        String numeroLu = "";
        String vide = "";
        Scanner lectureClavier = new Scanner(System.in);
        ListeCompte C = new ListeCompte();

        //Affichage du menu principal
        do {
            choix = menuPrincipal();
            //Selon option choisie
            switch (choix) {
                case 1:
                    System.out.print(" Compte Epargne (o/n) : ");
                    if (lectureClavier.next().charAt(0) == 'o') {
                        C.ajouteUnCompte("E");
                    } else {
                        C.ajouteUnCompte("A");
                    }
                    break;
                case 2:
                    //demander à l'utilisateur un numero de compte à afficher
                    System.out.print("Quel compte souhaitez-vous afficher ? : ");
                    numeroLu = lectureClavier.next();
                    //verifier que le compte existe
                    C.rechercheUnCompte(numeroLu);
                    break;
                case 3:
                    C.afficheLesComptes();
                    break;
                case 4:
                    System.out.print("Pour quel compte souhaitez vous créer une ligne ? : ");
                    numeroLu = lectureClavier.next();
                    C.ajouteUneLigne(numeroLu);
                    break;
                case 5:
                    System.out.print("Quel compte souhaitez vous supprimer ? : ");
                    numeroLu = lectureClavier.next();
                    C.supprimeUnCompte(numeroLu);
                case 6:
                    sortir();
                    break;
                case 7:
                    //option 5 menu d'aide
                    aide();
                    break;
                default:
                    System.out.println("Cette option n'existe pas ");
            }

        } while (choix != 4);
    }


//    public static void afficherCompte(long num,char type,double taux,double val){
//        System.out.println("Le compte " + num + " est un compte");
//        if (type == 'c') {
//            System.out.println("courant");
//        } else if (type == 'j') {
//            System.out.println("joint");
//        } else if (type == 'e') {
//            System.out.println("épargne dont le taux de placement est de " + taux);
//        }
//        System.out.println("Première valeur créditée " + val);
//    }

    public static byte menuPrincipal() {
        byte tmp;
        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("1. Création d'un compte");
        System.out.println("2. Affichage d'un compte");
        System.out.println("3. Affichage de tous les comptes");
        System.out.println("4. Ecrire une ligne comptable");
        System.out.println("5. Supprimer un compte ");
        System.out.println("6. Sortir");
        System.out.println("7. Aide");
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
