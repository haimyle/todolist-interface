package appli.todolist;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import modele.Liste;
import modele.User;
import repository.ListeRepository;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UpdateListController implements Initializable {
    private Liste liste;
    private User user;
    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSave;

    @FXML
    private Label lbArchives;

    @FXML
    private Label lbCategories;

    @FXML
    private Label lbCorbeille;

    @FXML
    private Label lbInbox;

    @FXML
    private Label lbListes;

    @FXML
    private Label lbToday;

    @FXML
    private Label lbMessage;

    @FXML
    private TextField tfNomListe;

    public UpdateListController (Liste liste, User user) {
        this.liste = liste;
        this.user = user;
    }

    @FXML
    void clickCancel(ActionEvent event) {
        StartApplication.changeScene("/appli/todolist/todolist-view.fxml", new TodolistController(user),"To-do List - Application");
    }

    @FXML
    void clickSave(ActionEvent event) throws SQLException {
        ListeRepository listeRepository = new ListeRepository();
        listeRepository.updateList(tfNomListe.getText(),this.liste);
        if (this.liste != null) {
            StartApplication.changeScene("/appli/todolist/todolist-view.fxml", new TodolistController(user), "To-Do List - Listes");
        } else {
            lbMessage.setText("Erreur");
        }
    }

    @FXML
    void clickShowArchive(MouseEvent event) {

    }

    @FXML
    void clickShowCategories(MouseEvent event) {

    }

    @FXML
    void clickShowCorbeille(MouseEvent event) {

    }

    @FXML
    void clickshowListes(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tfNomListe.setText(this.liste.getNomListe());
    }
}