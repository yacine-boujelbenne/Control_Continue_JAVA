import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Receveur_de_demande receveur = new Receveur_de_demende_Essai();
        List<Demande> demandes = receveur.getNouvellesDemandes();
        List<Taxi> taxis = new LinkedList<>();
        Localisation localisationT1 = new Localisation(20, 50);
        Localisation localisationT2 = new Localisation(61, 40);
        Localisation localisationT3 = new Localisation(10, 20);
        taxis.add(new Taxi("T1", localisationT1));
        taxis.add(new Taxi("T2", localisationT2));
        taxis.add(new Taxi("T3", localisationT3));
        Central_de_reservation central = new Central_de_reservation(taxis, demandes, 10);
        central.supprimer_Taxi("T1");
        central.traiterDemandes();
        for (Demande demande : demandes) {
            System.out.println(demande.getId_client());
        }
        System.out.println("Demandes en attente : " + demandes.size());
        System.out.println("Taxis : " + taxis.size());
        System.out.println("Demandes traitées : ");
        for (Demande demande : demandes) {
            System.out.println(demande);
        }
        for (Taxi taxi : taxis) {
            System.out.println("Taxi : " + taxi.getMatricule());
            System.out.println(taxi.getDemende());
        }

    }

}
