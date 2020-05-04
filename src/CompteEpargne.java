import java.io.Serializable;
import java.util.Scanner;

public class CompteEpargne extends Compte implements Serializable {

    private double taux;

    public CompteEpargne() {
        super("Epargne");
        taux = controleTaux();
    }

    public void afficherCpte() {
        super.afficherCompte();
        System.out.println(" Taux d'epargne du compte :" + taux);
    }

    public double quelTaux() {
        return taux;
    }

    private double controleTaux() {
        Scanner lectureClavier = new Scanner(System.in);
        double tmp;
        do {
            System.out.print("Taux de placement : ");
            tmp = lectureClavier.nextDouble();
        } while (tmp < 0);
        return tmp;
    }
}
