package appli.todolist;

import appli.StartApplication;
import appli.tache.CreateTacheController;
import appli.type.CreateTypeController;
import appli.user.AdminController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import modele.Liste;
import modele.User;
import repository.ListeRepository;
import repository.UserRepository;

import java.sql.SQLException;

public class CreateListController {
    private User user;

    @FXML
    private Label lbMessage;

    @FXML
    private Button btnArchives;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnCorbeille;

    @FXML
    private Button btnListes;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnTaches;

    @FXML
    private Button btnType;

    @FXML
    private TextField tfNomListe;

    @FXML
    void clickArchives(ActionEvent event) {

    }

    @FXML
    void clickCancel(ActionEvent event) {

    }

    @FXML
    void clickCorbeille(ActionEvent event) {

    }

    @FXML
    void clickListes(ActionEvent event) {
        StartApplication.changeScene("/appli/todolist/todolist-view.fxml", new TodolistController(this.user),"To-Do List - Listes");
    }

    @FXML
    void clickTaches(ActionEvent event) {
        StartApplication.changeScene("/appli/tache/create-tache-view.fxml", new CreateTacheController(this.user), "Créer une tâche");
    }

    @FXML
    void clickType(ActionEvent event) {
        StartApplication.changeScene("/appli/type/create-type-view.fxml", new CreateTypeController(this.user),"To-Do List - Créer une catégorie");
    }

    @FXML
    void clickSave(ActionEvent event) throws SQLException {
        ListeRepository listeRepository = new ListeRepository();
        Liste liste = listeRepository.createList(tfNomListe.getText(),user);
        if (liste != null) {
            StartApplication.changeScene("/appli/todolist/todolist-view.fxml", new TodolistController(user), "To-Do List - Listes");
        } else {
            lbMessage.setText("Erreur");
        }
    }

    @FXML
    void onActionCompteAdmin(ActionEvent event) {
        System.out.println(user.toString());
        if(this.user.isEstAdmin()){
            StartApplication.changeScene("/appli/user/admin-view.fxml", new AdminController(user), "To-Do List - Admin");
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Admin");
            alert.setHeaderText("Vous n'avez pas les permissions nécessaires !");
            alert.setContentText(this.user.getPrenom()+" vous n'êtes pas administrateur, vous ne pouvez pas gérer les utilisateurs.");
            alert.show();
        }
    }

    @FXML
    void onActionCompteModifier(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Bientôt..");
        alert.setHeaderText("Fonctionnalité non disponible");
        String s ="Cette fonctionnalité n'est pas encore disponible.";
        alert.setContentText(s);
        alert.show();
    }

    @FXML
    void onActionToDoListAPropos(ActionEvent event) {

    }

    @FXML
    void onActionToDoListDocumentation(ActionEvent event) {

    }


    public CreateListController(User user) {
        this.user = user;
    }
}
