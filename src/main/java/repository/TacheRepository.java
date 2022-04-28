package repository;

import database.Bdd;
import modele.Liste;
import modele.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
