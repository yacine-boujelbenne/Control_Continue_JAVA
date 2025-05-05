import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Central_de_reservation {
    private double marge;
    private List<Taxi> flott;
    Routeur routeur;
    private List<Demande> demandesEnAttente;

    public Central_de_reservation(List<Taxi> flott, List<Demande> demandesEnAttente, double marge) {
        this.marge = marge;
        this.flott = flott;
        this.demandesEnAttente = demandesEnAttente;
    }

    public void setMarge(double marge) {
        this.marge = marge;
    }

    public boolean ajouTaxi(String matricule, Localisation posistion) {
        Taxi taxi = new Taxi(matricule, posistion);
        if (flott == null) {
            flott = new LinkedList<>();
        }
        for (Taxi t : flott) {
            if (t.getMatricule().equals(matricule)) {
                System.out.println("Taxi est déjà exist !!");
                return false;
            }
        }
        flott.add(taxi);
        return true;
    }

    public void supprimer_Taxi(String matricule) {
        List<Taxi> tempListTaxi = new ArrayList<>();
        for (Taxi taxi : flott) {
            if (!taxi.getMatricule().equals(matricule)) {
                tempListTaxi.add(taxi);
            }
        }
        flott.clear();
        flott.addAll(tempListTaxi);
    }

    public void traiterDemandes() {
        routeur = new Routeur_Standard();
        for (Demande d : demandesEnAttente) {

            Taxi taxi = routeur.traiterDemande(flott, d);
            if (taxi != null) {
                taxi.setDemende(d);

            }
        }
        for (Taxi taxi : flott) {
            if (!taxi.estLibre()) {
                demandesEnAttente.remove(taxi.getDemende());
            }
        }

    }

    public void traiterLesCoursAchevees(List<Taxi> flott) {
        for (Taxi taxi : flott) {
            if (!taxi.estLibre() && marge >= Demande.distance(taxi.getPosition(), taxi.getDemende().getPosition())) {
                taxi.setDemende(null);

            }
        }

    }

}
