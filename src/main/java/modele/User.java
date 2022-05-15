package modele;

public class User {
    private int idUser;
    private String nom;
    private String prenom;
    private String mail;
    private String mdp;
    private boolean estAdmin;

    public User() {
    }

    public User(String nom, String prenom, String mail, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.mdp = mdp;
    }

    public User(int idUser, String nom, String prenom, String mail, String mdp, boolean estAdmin) {
        this.idUser = idUser;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.mdp = mdp;
        this.estAdmin = estAdmin;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String email) {
        this.mail = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public boolean isEstAdmin() {
        return estAdmin;
    }

    public void setEstAdmin(boolean estAdmin) {
        this.estAdmin = estAdmin;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id :" + idUser +
                ", Nom : '" + nom + '\'' +
                ", Prenom : '" + prenom + '\'' +
                ", Mail : " + mail + '\'' +
                ", Mot de passe :'" + mdp + '\'' +
                ", Admin :" + estAdmin +
                '}';
    }
}
