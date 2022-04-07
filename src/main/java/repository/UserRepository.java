package repository;

import database.Bdd;
import modele.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {
    private Bdd cnx;

    public UserRepository() {
        this.cnx = new Bdd();
    }

    public User connexion(String email, String password) {
        User user = null;
        String sql = "SELECT * FROM user WHERE email=? and password=md5(?)";
        PreparedStatement req;
        try {
            req = cnx.getConnection().prepareStatement(sql);
            req.setString(1, email);
            req.setString(2, password);
            ResultSet res = req.executeQuery();
            if (res.next()) {
                user = new User(res.getInt("id_user"), res.getString("nom"), res.getString("prenom"), res.getString("email"), res.getString("password"), res.getBoolean("estAdmin"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

}
