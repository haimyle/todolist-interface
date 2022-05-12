package modele;

public class Liste {
    private int idListe;
    private String nomListe;
    private int refUser;

    public Liste() {
    }

    public Liste(int idListe) {
        this.idListe = idListe;
    }

    public int getIdListe() {
        return idListe;
    }

    public void setIdListe(int idListe) {
        this.idListe = idListe;
    }

    public String getNomListe() {
        return nomListe;
    }

    public void setNomListe(String nomListe) {
        this.nomListe = nomListe;
    }

    public int getRefUser() {
        return refUser;
    }

    public void setRefUser(int refUser) {
        this.refUser = refUser;
    }

    @Override
    public String toString() {
        return nomListe;
    }
}
