package appli.todolist;

import appli.StartApplication;
import appli.tache.CreateTacheController;
import appli.type.CreateTypeController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import modele.Liste;
import modele.User;
import repository.ListeRepository;
import repository.TacheRepository;

import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class TodolistController implements Initializable {
    private User user;
    private Liste selectedList;

    @FXML
    private Button btnAddList;

    @FXML
    private Button btnModifier;

    @FXML
    private Button btnSupprimer;

    @FXML
    private Button btnArchives;

    @FXML
    private Button btnTache;

    @FXML
    private Button btnCorbeille;

    @FXML
    private Button btnListes;

    @FXML
    private Button btnType;

    @FXML
    private ListView<Liste> lvTodolist;

    @FXML
    void modifier(ActionEvent event) {
        StartApplication.changeScene("/appli/todolist/update-list-view.fxml", new UpdateListController(this.selectedList, this.user),"To-do List - Modification");
    }

    @FXML
    void supprimer(ActionEvent event) throws SQLException {
        Optional<ButtonType> resultat = StartApplication.validationDialog("Supression d'une liste",
                "Toutes ses tâches seront supprimée. Êtes-vous sûr ?");
        if (resultat.get() == ButtonType.OK){
            ListeRepository listeRepository = new ListeRepository();
            TacheRepository tacheRepository = new TacheRepository();
            listeRepository.deleteList(this.selectedList);
            lvTodolist.getItems().remove(this.selectedList);



        }
    }
    @FXML
    void addList(ActionEvent event) {
        StartApplication.changeScene("/appli/todolist/add-list-view.fxml", new CreateListController(this.user),"To-Do List - Ajout");
    }


    @FXML
    void clickArchives(ActionEvent event) {

    }

    @FXML
    void clickTache(ActionEvent event) {
        StartApplication.changeScene("/appli/tache/create-tache-view.fxml", new CreateTacheController(this.user), "Créer une tâche");
    }

    @FXML
    void clickCorbeille(ActionEvent event) {

    }

    @FXML
    void clickListes(ActionEvent event) {
        StartApplication.changeScene("/appli/todolist/todolist-view.fxml", new TodolistController(this.user),"To-Do List - Listes");
    }

    @FXML
    void clickType(ActionEvent event) throws SQLException {
        StartApplication.changeScene("/appli/type/create-type-view.fxml", new CreateTypeController(this.user),"To-Do List - Créer une catégorie");
    }

    @FXML
    void onSelectedRow(MouseEvent event) {
        System.out.println("Selected");
        this.selectedList = lvTodolist.getSelectionModel().getSelectedItem();
        if (selectedList != null){
            btnModifier.setVisible(true);
            btnSupprimer.setVisible(true);
        }else{
            btnModifier.setVisible(false);
            btnSupprimer.setVisible(false);
        }
    }

    public TodolistController(User user) {
        this.user = user;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ListeRepository listeRepository = new ListeRepository();
        this.btnSupprimer.setVisible(false);
        this.btnModifier.setVisible(false);
        try {
            this.lvTodolist.getItems().addAll(listeRepository.showList(this.user));
            this.lvTodolist.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Liste>() {
                @Override
                public void changed(ObservableValue<? extends Liste> observableValue, Liste liste, Liste t1) {
                    Liste currentListes = lvTodolist.getSelectionModel().getSelectedItem();
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
