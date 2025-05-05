
public class Taxi {
    // private final String matricule;
    private Localisation position;
    private final String matricule;
    private Demande demende = null;
    public char[] getDemendeEtat;

    public Taxi(String matricule, Localisation position) {
        this.position = position;
        this.matricule = matricule;
    }

    public Localisation getPosition() {
        return position;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setPosition(Localisation position) {
        this.position = position;
    }

    public boolean estLibre() {
        if (getDemendeEtat()) {
            return false;
        }
        return true;
    }

    public void setDemende(Demande demende) {
        this.demende = demende;
    }

    public Demande getDemende() {
        return demende;
    }

    public boolean getDemendeEtat() {
        return demende != null;
    }

}
