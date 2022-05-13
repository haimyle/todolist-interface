package repository;

import database.Bdd;
import modele.Liste;
import modele.Tache;
import modele.User;

import java.sql.*;

public class TacheRepository {
    private Bdd cnx;

    public TacheRepository() {
        this.cnx = new Bdd();
    }

    public void deleteTache(User user, Liste liste) throws SQLException {
        String sql = "DELETE FROM tache WHERE ref_liste = ? AND ref_type = ?";
        PreparedStatement req = cnx.getConnection().prepareStatement(sql);
        req.setInt(1,liste.getIdListe());
        req.setInt(2, user.getIdUser());
        req.executeUpdate();
    }

    public Tache createTache(String titre, Date deadline, int ref_type, int ref_liste) throws SQLException {
        Tache tache = new Tache();
        String sql = "INSERT INTO tache (nom_tache, deadline, ref_type, ref_liste) VALUE(?,?,?,?)";
        PreparedStatement req = cnx.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        req.setString(1,titre);
        req.setDate(2, deadline);
        req.setInt(3,ref_type);
        req.setInt(4,ref_liste);
        req.executeUpdate();
        ResultSet res = req.getGeneratedKeys();
        if (res.next()){
            tache.setIdTache(res.getInt(1));
            System.out.println("Sucess");
        }else {
            System.out.println("Erreur");
        }
        return tache;
    }
}
