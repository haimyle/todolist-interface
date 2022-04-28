package appli.user;

import appli.StartApplication;
import appli.todolist.TodolistController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private TextField tfPassword;

    @FXML
    private Label lbMessage;

    public ConnexionController(User user) {
        this.user = user;
    }

    public ConnexionController() {
    }

    @FXML
    void clickQuitter(ActionEvent event) {

    }

    @FXML
    void clickRetour(ActionEvent event) {

    }

    @FXML
    void clickBack(ActionEvent event) {
        StartApplication.changeScene("/appli/accueil-view.fxml", "To-Do List - Accueil");
    }

    @FXML
    void clickConnexion(ActionEvent event) throws Exception {
        //StartApplication.changeScene("/appli/crud/user-view", new ListController()
        //user.getId_user(),user.getNom(), user.getPrenom(), user.getEmail(), user.getPassword()));
        UserRepository userRepository = new UserRepository();
        User user = userRepository.connexion(tfEmail.getText(), tfPassword.getText());
        if (user != null) {
            //StartApplication.changeScene("/appli/tache/today-view.fxml", new TodayController(user),"To-Do List - Application");
            StartApplication.changeScene("/appli/todolist/todolist-view.fxml", new TodolistController(user),"To-Do List - Application");
        } else {
            lbMessage.setText("Erreur");
        }
    }
}

