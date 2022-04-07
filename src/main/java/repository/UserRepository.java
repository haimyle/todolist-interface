package repository;

import database.Bdd;
import modele.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRepository {
    private Bdd cnx;

    public UserRepository() {
        this.cnx = new Bdd();
    }

    public void inscription (User user) throws SQLException {
        String sql = "INSERT INTO user ( `nom`, `prenom`, `mail`,`mdp`,`est_admin`) VALUES (?,?,?,md5(?),?)";

        PreparedStatement req = cnx.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        req.setString(1, user.getNom());
        req.setString(2, user.getPrenom());
        req.setString(3, user.getEmail());
        req.setString(4, user.getPassword());
        req.setBoolean(5, user.isEstAdmin());
        req.executeUpdate();
        ResultSet rs = req.getGeneratedKeys();
        if(rs.next())
        {
            int last_inserted_id = rs.getInt(1);
            user.setIdUser(last_inserted_id);
        }
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

    public User update (User user) throws SQLException {
        if(user.getIdUser()>0) {
            String sql = "UPDATE user SET `nom`=?,`prenom`=?,`email`=?,`estAdmin`=? WHERE id_user=?";
            PreparedStatement req = cnx.getConnection().prepareStatement(sql);
            req.setString(1, user.getNom());
            req.setString(2, user.getPrenom());
            req.setString(3, user.getEmail());
            req.setBoolean(4, user.isEstAdmin());
            req.setInt(5, user.getIdUser());
            req.executeUpdate();
        }
        return user;
    }

    public void delete (User user) throws SQLException {
        if (user.getIdUser() >0){
            String sql = "DELETE FROM user where id_user=?;";
            PreparedStatement req = cnx.getConnection().prepareStatement(sql);
            req.setInt(1, user.getIdUser());
            req.executeUpdate();
        }
    }


}
