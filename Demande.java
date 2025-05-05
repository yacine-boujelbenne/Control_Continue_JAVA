public class Demande {
    private String id_client;
    private Localisation position;
    private Localisation destination;

    public Demande(String id_client, Localisation position, Localisation destination) {
        this.id_client = id_client;
        this.position = position;
        this.destination = destination;
    }

    public String getId_client() {
        return id_client;
    }

    public Localisation getPosition() {
        return position;
    }

    public Localisation getDestination() {
        return destination;

    }

    public static double distance(Localisation a, Localisation b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }

}
