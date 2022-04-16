package repository;

import database.Bdd;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import modele.Liste;
import modele.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ListeRepository {
    private Bdd cnx;
    private Liste liste;
    private ArrayList <Liste> listes;

    public ListeRepository() {
        this.cnx = new Bdd();
    }

    public Liste addList(String titre, User user) throws SQLException {
        Liste liste = new Liste();
        String sql = "INSERT INTO liste (nom_liste, ref_user) VALUE(?,?)";
        PreparedStatement req = cnx.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        req.setString(1,titre);
        req.setInt(2,user.getIdUser());
        req.executeUpdate();
        ResultSet res = req.getGeneratedKeys();
        if (res.next()){
            liste.setIdListe(res.getInt(1));
            System.out.println("Sucess");
        }else {
            System.out.println("Erreur");
        }
        return liste;
    }

    public ArrayList<Liste> showList(User user) throws SQLException {
        ArrayList<Liste> listes = new ArrayList<Liste>();
        Liste liste;
        String sql = "SELECT * FROM liste WHERE ref_user =?";
        PreparedStatement req = cnx.getConnection().prepareStatement(sql);
        req.setInt(1,user.getIdUser());
        ResultSet res = req.executeQuery();
        while (res.next()){
            liste = new Liste();
            liste.setIdListe(res.getInt("id_liste"));
            liste.setNomListe(res.getString("nom_liste"));
            listes.add(liste);
        }

        return listes;
    }

}
