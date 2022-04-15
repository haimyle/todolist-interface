package appli.todolist;

import appli.StartApplication;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import modele.Liste;
import modele.User;
import repository.ListeRepository;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TodolistController implements Initializable {
    private User user;
    private Liste selectedList;
    ObservableList<Liste> listes = FXCollections.observableArrayList();

    @FXML
    private Button btnAddList;

    @FXML
    private Label lbArchives;

    @FXML
    private Label lbCategories;

    @FXML
    private Label lbCorbeilles;

    @FXML
    private Label lbInbox;

    @FXML
    private Label lbListes;
    @FXML
    private ListView<Liste> lvTodolist;

    @FXML
    void addList(ActionEvent event) {
        StartApplication.changeScene("/appli/todolist/add-list-view.fxml", new AddListController(user),"To-Do List - Ajout");
    }

    @FXML
    void clickDisplayArchive(MouseEvent event) {

    }

    @FXML
    void clickDisplayInbox(MouseEvent event) {

    }

    @FXML
    void clickDisplayList(MouseEvent event) {

    }

    @FXML
    void clickDisplayTrash(MouseEvent event) {

    }

    @FXML
    void clickDisplayUpcoming(MouseEvent event) {

    }

    @FXML
    void onSelectedRow(MouseEvent event) {
        System.out.println("Selected");
        this.selectedList = lvTodolist.getSelectionModel().getSelectedItem();
        if (selectedList != null){

        }

    }

    public TodolistController(User user) {
        this.user = user;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ListeRepository listeRepository = new ListeRepository();
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
