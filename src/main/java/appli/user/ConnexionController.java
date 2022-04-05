package appli.user;

import appli.StartApplication;
import appli.todolist.ListController;
import database.Bdd;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modele.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnexionController {
    Connection cnx = Bdd.getConnection();
    PreparedStatement req;
    ResultSet res;

    @FXML
    private Button btnConnexion;

    @FXML
    private Button btnBack;

    @FXML
    private Label lbMessage;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfPassword;

    @FXML
    void clickBack(ActionEvent event) {
        StartApplication.changeScene("/appli/welcome1.fxml");
    }

    @FXML
    void clickConnexion(ActionEvent event) {
        try
        {   req = cnx.prepareStatement("SELECT * FROM user WHERE email=? and password=?");
            req.setString(1, tfEmail.getText());
            req.setString(2, tfPassword.getText());
            res = req.executeQuery();
            if(res.next()) {
                User user = new User();
                user.setId_user(res.getInt("id_user"));
                user.setNom(res.getString("nom"));
                user.setPrenom(res.getString("prenom"));
                user.setEmail(res.getString("email"));
                user.setPassword(res.getString("password"));
                //StartApplication.changeScene("/appli/crud/user-view", new ListController()
                        //user.getId_user(),user.getNom(), user.getPrenom(), user.getEmail(), user.getPassword()));
            }
            else{
                //lbMessage.setText("Erreur!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ConnexionController(){};
}
