package repository;

import database.Bdd;
import modele.Liste;
import modele.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListRepository {
    private Bdd cnx;
    private Liste liste;
    private ArrayList <Liste> listes;

    public ListRepository() {
        this.cnx = new Bdd();
    }

    public ArrayList showList(User user) throws SQLException {
        String sql = "SELECT * FROM liste WHERE ref_user =?";
        PreparedStatement req = cnx.getConnection().prepareStatement(sql);
        req.setInt(1,user.getIdUser());
        ResultSet res = req.executeQuery();
        if (res.next()==false){
            String message="Vide";
        }
        else{
            do{
                this.listes = new ArrayList<Liste>();
                Liste liste = new Liste();
                liste.setIdListe(res.getInt("id_liste"));
                liste.setNomListe(res.getString("nom_liste"));
                this.listes.add(liste);
            } while (res.next());
        }
        return listes;
    }

}
