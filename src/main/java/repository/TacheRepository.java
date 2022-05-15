package repository;

import database.Bdd;
import modele.Liste;
import modele.Tache;
import modele.User;

import java.sql.*;
import java.util.ArrayList;

public class TacheRepository {
    private Bdd cnx;

    public TacheRepository() {
        this.cnx = new Bdd();
    }

    public void updateTache (String titre, Date deadline, int ref_type, int ref_liste, int id_tache) throws SQLException {
        String sql = "UPDATE tache SET nom_tache=? deadline=? ref_type=?, ref_liste=? WHERE id_liste=?";
        PreparedStatement req = cnx.getConnection().prepareStatement(sql);
        req.setString(1,titre);
        req.setDate(2,deadline);
        req.setInt(3,ref_type);
        req.setInt(4,ref_liste);
        req.setInt(5,id_tache);
        req.executeUpdate();
        if (req.executeUpdate()>0){
            System.out.println("Updated");
        }else {
            System.out.println("Erreur");
        }
    }

    public void deleteTache(Tache tache) throws SQLException {
        String sql = "DELETE FROM tache WHERE id_tache=?";
        PreparedStatement req = cnx.getConnection().prepareStatement(sql);
        req.setInt(1,tache.getIdTache());
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

    public ArrayList<Tache> readTache (Liste liste) throws SQLException {
        ArrayList<Tache> taches = new ArrayList<Tache>();
        Tache tache;
        String sql = "SELECT * FROM tache INNER JOIN type ON tache.ref_type=type.id_type WHERE ref_liste =? AND terminee = 0";
        PreparedStatement req = cnx.getConnection().prepareStatement(sql);
        req.setInt(1,liste.getIdListe());
        ResultSet res = req.executeQuery();
        while (res.next()){
            tache = new Tache();
            tache.setIdTache(res.getInt("id_tache"));
            tache.setNomTache(res.getString("nom_tache"));
            tache.setDeadline(res.getDate("deadline"));
            tache.setRefType(res.getInt("ref_type"));
            tache.setNomType(res.getString("nom_type"));
            taches.add(tache);
        }

        return taches;
    }
}
