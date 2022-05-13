package modele;

import java.sql.Date;

public class Tache {
    private int idTache;
    private String nomTache;
    private boolean terminee;
    private Date deadline;
    private int retfType;
    private int refListe;

    public Tache() {
    }

    public int getIdTache() {
        return idTache;
    }

    public void setIdTache(int idTache) {
        this.idTache = idTache;
    }

    public String getNomTache() {
        return nomTache;
    }

    public void setNomTache(String nomTache) {
        this.nomTache = nomTache;
    }

    public boolean isTerminee() {
        return terminee;
    }

    public void setTerminee(boolean terminee) {
        this.terminee = terminee;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public int getRetfType() {
        return retfType;
    }

    public void setRetfType(int retfType) {
        this.retfType = retfType;
    }

    public int getRefListe() {
        return refListe;
    }

    public void setRefListe(int refListe) {
        this.refListe = refListe;
    }

    @Override
    public String toString() {
        return idTache + " . " + nomTache + " (deadline := " + deadline + " )";
    }
}
