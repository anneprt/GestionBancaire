import java.util.Scanner;

public class LigneComptable {
    public double valeur;
    public String date;
    public String motif;
    public String mode;

    public void creerLigneComptable() {
        Scanner lectureClavier = new Scanner(System.in);
        System.out.print("Entrer la valeur à créditer (+) ou débiter (-) : ");
        valeur = lectureClavier.nextDouble();
        System.out.print("Date de l'opération [jj/mm/an] ");
        date = lectureClavier.next();
        System.out.print("Motif de l'operation [s(alaire),l(oyer), a(limentation), d(ivers)]");
        motif = lectureClavier.next();
        System.out.print("Mode [C(B), N(° Cheque), V(irement ) ]: ");
        mode = lectureClavier.next();
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
