package appli.user;

import appli.StartApplication;
import appli.todolist.AppController;
import appli.todolist.ListController;
import database.Bdd;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modele.User;
import repository.UserRepository;

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
        StartApplication.changeScene("/appli/accueil-view.fxml", "To-Do List - Accueil");
    }

    @FXML
    void clickConnexion(ActionEvent event) throws Exception {
        //StartApplication.changeScene("/appli/crud/user-view", new ListController()
        //user.getId_user(),user.getNom(), user.getPrenom(), user.getEmail(), user.getPassword()));
        UserRepository userRepository = new UserRepository();

        User user = userRepository.connexion(tfEmail.getText(),tfPassword.getText());
        if (user.getEmail().isBlank() && user.getPassword().isBlank()){
            lbMessage.setVisible(true);
        }
        else{
            StartApplication.changeScene("/appli/crud/main-view", new AppController(), "To-Do List - Application");
        }
    }

    public ConnexionController(){};
}
