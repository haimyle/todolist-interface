package appli.todolist;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import modele.Liste;
import modele.User;
import repository.ListeRepository;
import repository.UserRepository;

import java.sql.SQLException;

public class AddListController {
    private User user;
    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSave;

    @FXML
    private Label lbMessage;

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
    private TextField tfNomListe;

    @FXML
    void clickCancel(ActionEvent event) {
        StartApplication.changeScene("/appli/todolist/todolist-view.fxml",new TodolistController(user),"To-Do List - Listes");
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

    @FXML
    void clickSave(ActionEvent event) throws SQLException {
        ListeRepository listeRepository = new ListeRepository();
        Liste liste = listeRepository.addList(tfNomListe.getText(),user);
        if (liste != null) {
            StartApplication.changeScene("/appli/todolist/todolist-view.fxml", new TodolistController(user), "To-Do List - Listes");
        } else {
            lbMessage.setText("Erreur");
        }
    }


    public AddListController(User user) {
        this.user = user;
    }
}
