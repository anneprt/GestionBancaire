import java.util.Scanner;

public class LigneComptable {
    private double valeur;
    private String date;
    private String motif;
    private String mode;

    public void creerLigneComptable() {
        Scanner lectureClavier = new Scanner(System.in);
        System.out.print("Entrer la valeur à créditer (+) ou débiter (-) : ");
        valeur = lectureClavier.nextDouble();
        System.out.print("Date de l'opération [jj/mm/an] ");
        date = lectureClavier.next();
        System.out.print("Motif de l'operation [s(alaire),l(oyer), a(limentation), d(ivers)]");
        motif = lectureClavier.next();
        System.out.print("Mode [C(B), N(° Chèque), V(irement ) ]: ");
        mode = lectureClavier.next();
    }

    public double quelleValeur() {
        return valeur;
    }

    public String quelMotif() {
        return motif;
    }

    public String quelMode() {
        return mode;
    }

    public String quelleDate() {
        return date;
    }

    public void afficherLigne() {
        if (valeur < 0) {
            System.out.println("Débiter: " + valeur);
        } else {
            System.out.println("Créditer: " + valeur);
        }
        System.out.println(" le : " + date + " motif : " + motif + " mode : " + mode);
    }
}
