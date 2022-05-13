package appli.tache;

import appli.StartApplication;
import appli.todolist.TodolistController;
import appli.type.CreateTypeController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import modele.Liste;
import modele.Type;
import modele.User;
import repository.ListeRepository;
import repository.TypeRepository;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CreateTacheController implements Initializable {
    private User user;

    ObservableList<Liste> listes;
    ObservableList<Type> types;

    @FXML
    private Button btnArchives;

    @FXML
    private Button btnCorbeille;

    @FXML
    private Button btnEnregistrer;

    @FXML
    private Button btnListes;

    @FXML
    private Button btnTaches;

    @FXML
    private Button btnType;

    @FXML
    private ComboBox<Liste> comboBoxListe = new ComboBox<>(listes);

    @FXML
    private ComboBox<Type> comboBoxType = new ComboBox<>(types);

    @FXML
    private DatePicker deadline;

    @FXML
    private TextField lbTitre;

    @FXML
    void clickArchives(ActionEvent event) {

    }

    @FXML
    void clickCorbeille(ActionEvent event) {

    }

    @FXML
    void clickEnregistrer(ActionEvent event) {

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

    public CreateTacheController(User user) {
        this.user = user;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ListeRepository listeRepository = new ListeRepository();
        TypeRepository typeRepository = new TypeRepository();

        try {
            System.out.println(typeRepository.readType(this.user));
            comboBoxType.getItems().addAll( FXCollections.observableArrayList(typeRepository.readType(user)));
            comboBoxListe.getItems().addAll(FXCollections.observableArrayList(listeRepository.showList(user)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
