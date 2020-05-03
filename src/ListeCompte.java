import java.util.Collection;
import java.util.HashMap;

public class ListeCompte {
    private HashMap<String, Compte> liste;

    public ListeCompte() {
        liste = new HashMap<String, Compte>();
    }

    public void ajouteUnCompte(String t) {
        Compte nouveau = new Compte("");
        if (t.equalsIgnoreCase("A")) {
            nouveau = new Compte();
        } else if (t.equalsIgnoreCase("E")) {
            nouveau = new CompteEpargne();
        }
        String cle = nouveau.quelNumeroDeCompte();
        if (liste.get(cle) == null) {
            liste.put(cle, nouveau);
        } else {
            System.out.println("Ce compte existe déja !");
        }
    }

    public void ajouteUneLigne(String n) {
        String cle = n;
        Compte c = (Compte) liste.get(cle);

        if (c != null) {
            c.creerLigne();
        } else {
            System.out.println("Le système ne connaît pas le compte " + n);
        }
    }

    public Compte quelCompte(String n) {
        String cle = n;
        Compte c = (Compte) liste.get(cle);
        if (c == null)
            System.out.println("Le système ne connaît pas le compte " + n);
        return (c);
    }

    public void rechercheUnCompte(String n) {
        String cle = n;
        Compte c = (Compte) liste.get(cle);
        if (c != null) c.afficherCompte();
        else System.out.println("Le systeme ne connait pas le compte " + n);
    }

    public void supprimeUnCompte(String n) {
        String cle = n;
        Compte c = (Compte) liste.get(cle);
        if (c != null) {
            liste.remove(cle);
            System.out.println(n + " a été supprimé ");
        } else {
            System.out.println(n + " est inconnu ! ");
        }
    }

    public void afficheLesComptes() {
        if (liste.size() != 0) {
            Collection<Compte> colCompte = liste.values();
            for (Compte c : colCompte) {
                c.afficherCompte();
            }
        } else {
            System.out.println("Aucun compte n'a été créé dans cette liste");
        }
    }
}


