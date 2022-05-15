package appli.user;

import appli.StartApplication;
import appli.todolist.TodolistController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import modele.User;
import repository.UserRepository;

public class ConnexionController {
    private User user;

    @FXML
    private Button btnQuitter;

    @FXML
    private Button btnRetour;

    @FXML
    private Button btnSeConnecter;

    @FXML
    private TextField tfEmail;

    @FXML
    private PasswordField pfPassword;

    @FXML
    private Label lbMessage;

    public ConnexionController(User user) {
        this.user = user;
    }

    public ConnexionController() {
    }

    @FXML
    void clickQuitter(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void clickRetour(ActionEvent event) {
        StartApplication.changeScene("/appli/accueil-view","To-Do List - Accueil");
    }

    @FXML
    void clickConnexion(ActionEvent event) throws Exception {
        UserRepository userRepository = new UserRepository();
        User user = userRepository.connexion(tfEmail.getText(), pfPassword.getText());
        if (user != null) {
            StartApplication.changeScene("/appli/todolist/todolist-view.fxml", new TodolistController(user),"To-Do List - Application");
        }
        else {
            lbMessage.setText("Erreur, veuillez ressayer.");
        }
    }
}

