package repository;

import database.Bdd;
import modele.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserRepository {
    private Bdd cnx;

    public UserRepository() {
        this.cnx = new Bdd();
    }

    public void inscription (User user) throws SQLException {
        String sql = "INSERT INTO user ( `nom`, `prenom`, `mail`,`mdp`,`est_admin`) VALUES (?,?,?,md5(?),?)";

        PreparedStatement req = Bdd.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        req.setString(1, user.getNom());
        req.setString(2, user.getPrenom());
        req.setString(3, user.getMail());
        req.setString(4, user.getMdp());
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
        User user = new User();
        try {
            PreparedStatement req = Bdd.getConnection().prepareStatement("SELECT * FROM user WHERE mail=? and mdp=?");
            req.setString(1, email);
            req.setString(2, password);
            ResultSet res = req.executeQuery();
            if  (res.next()) {
                user.setIdUser(res.getInt("id_user"));
                user.setNom(res.getString("nom"));
                user.setPrenom(res.getString("prenom"));
                user.setMail(res.getString("mail"));
                user.setMdp(res.getString("mdp"));
                user.setEstAdmin(res.getBoolean("est_admin"));
                user = new User(user.getIdUser(),user.getNom(),user.getPrenom(),user.getMail(), user.getMdp(), user.isEstAdmin());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(user);

        return user;
    }

    public User update (User user) throws SQLException {
        if(user.getIdUser()>0) {
            String sql = "UPDATE user SET `nom`=?,`prenom`=?,`mail`=?,`est_admin`=? WHERE id_user=?";
            PreparedStatement req = Bdd.getConnection().prepareStatement(sql);
            req.setString(1, user.getNom());
            req.setString(2, user.getPrenom());
            req.setString(3, user.getMail());
            req.setBoolean(4, user.isEstAdmin());
            req.setInt(5, user.getIdUser());
            req.executeUpdate();
        }
        return user;
    }

    public void delete (User user) throws SQLException {
        if (user.getIdUser() >0){
            String sql = "DELETE FROM user WHERE id_user=?;";
            PreparedStatement req = Bdd.getConnection().prepareStatement(sql);
            req.setInt(1, user.getIdUser());
            req.executeUpdate();
        }
    }

    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();
        User user;
        String sql = "SELECT * FROM user";
        PreparedStatement pstm;
        try {
            pstm = Bdd.getConnection().prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                user = new User(rs.getInt("id_user"), rs.getString("nom"), rs.getString("prenom"), rs.getString("mail"),  rs.getString("mdp"),  rs.getBoolean("est_admin"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
