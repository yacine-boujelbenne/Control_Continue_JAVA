import java.util.List;

public class RouteurStandard implements Routeur {
    @Override
    public Taxi traiterDemande(List<Taxi> flotte, Demande demande) {
        Taxi taxi = null;
        double distanceMin = 0.0;

        for (Taxi t : flotte) {
            if (t.estLibre()) {

                if (distanceMin > Demande.distance(t.getPosition(), demande.getPosition())) {
                    distanceMin = Demande.distance(t.getPosition(), demande.getPosition());
                    taxi = t;
                }

            }
        }
        if (taxi == null) {
            System.out.println("Pas taxi disponible pour l'instant.");
        }
        return taxi;
    }

}
