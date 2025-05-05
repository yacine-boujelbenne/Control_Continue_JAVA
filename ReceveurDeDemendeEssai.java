import java.util.LinkedList;
import java.util.List;

public class ReceveurDeDemendeEssai implements ReceveurDeDemande {

    @Override
    public List<Demande> getNouvellesDemandes() {
        List<Demande> listDemande = new LinkedList<>();
        Localisation localisation = new Localisation(0, 0);
        Localisation localisation2 = new Localisation(1, 0);
        for (int i = 0; i < 10; i++) {
            localisation.setPosition(i + 2, i - 2);
            localisation2.setPosition(i + 3, i - 3);
            Demande demande = new Demande("Demande : " + i, localisation, localisation2);
            listDemande.add(demande);
        }
        return listDemande;
    }

}