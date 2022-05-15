package appli.user;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AccueilController {

    @FXML
    private Button btnSeConnecter;

    @FXML
    void btnQuitOnAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void clickConnexion(ActionEvent event) {
        StartApplication.changeScene("/appli/user/connexion-view.fxml",new ConnexionController(),"To-Do List - Connexion");
    }



}