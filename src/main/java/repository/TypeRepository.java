package repository;

import database.Bdd;
import modele.Type;
import modele.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TypeRepository {
    private Bdd cnx;
    private Type type;

    public TypeRepository() throws SQLException {
        this.cnx = new Bdd();
    }

    public Type createTypeWithSousType(String nomType, User user, int refType) throws SQLException {
        type = new Type();
        String sql = "INSERT INTO type (nom_type, ref_type, ref_user) VALUE(?,?,?)";
        PreparedStatement req = cnx.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        req.setString(1,nomType);
        req.setInt(2,user.getIdUser());
        req.setInt(3,refType);
        req.executeUpdate();
        ResultSet res = req.getGeneratedKeys();
        if (res.next()){
            type.setIdType(res.getInt(1));
            System.out.println("Sucess");
        }else {
            System.out.println("Erreur");
        }
        return type;
    }

    public Type createTypeWithoutSousType(String nomType, User user) throws SQLException {
        type = new Type();
        String sql = "INSERT INTO type (nom_type, ref_user) VALUE(?,?)";
        PreparedStatement req = cnx.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        req.setString(1,nomType);
        req.setInt(2,user.getIdUser());
        req.executeUpdate();
        ResultSet res = req.getGeneratedKeys();
        if (res.next()){
            type.setIdType(res.getInt(1));
            System.out.println("Sucess");
        }else {
            System.out.println("Erreur");
        }
        return type;
    }

    public ArrayList<Type> readType(User user) throws SQLException {
        ArrayList<Type> types= new ArrayList<Type>();
        Type type;
        String sql = "SELECT * FROM type WHERE ref_user = ?";
        PreparedStatement req = cnx.getConnection().prepareStatement(sql);
        req.setInt(1,user.getIdUser());
        ResultSet res = req.executeQuery();
        while (res.next()){
            type = new Type();
            type.setIdType(res.getInt("id_type"));
            type.setNomType(res.getString("nom_type"));
            type.setRefType(res.getInt("ref_type"));
            types.add(type);
        }
        return types;
    }
    public void updateType(String nomType) throws SQLException {
        String sql = "UPDATE type SET type=? WHERE type=?";
        PreparedStatement req = cnx.getConnection().prepareStatement(sql);
        req.setString(1,nomType);
        //req.setInt(2,list.getIdListe());
        req.executeUpdate();
    }
    public void deleteType(int id_type) throws SQLException {
        String sql = "DELETE FROM type WHERE id_type = ?";
        PreparedStatement req = cnx.getConnection().prepareStatement(sql);
        req.setInt(1,type.getIdType());
        req.executeUpdate();
    }
    public int getIdType (String nom_type) throws SQLException {
        Type type = new Type();
        PreparedStatement req = cnx.getConnection().prepareStatement("SELECT * FROM type WHERE nom_type=?");
        req.setString(1, nom_type);
        ResultSet res = req.executeQuery();
        if (res.next()) {
            type.setIdType(res.getInt("id_type"));
        }
        return type.getIdType();
    }
}
