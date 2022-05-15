package appli.type;

import appli.StartApplication;
import appli.tache.CreateTacheController;
import appli.todolist.TodolistController;
import appli.user.AdminController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import modele.Type;
import modele.User;
import repository.TypeRepository;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CreateTypeController implements Initializable {
    private User user;

    @FXML
    private Button btnArchives;

    @FXML
    private Button btnAujourdhui;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnCorbeille;

    @FXML
    private Button btnListes;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnType;

    @FXML
    private Label lbMessage;

    @FXML
    private TextField tfNomType;

    public CreateTypeController(User user) {
        this.user = user;
    }


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

    }

    @FXML
    void onActionToDoListAPropos(ActionEvent event) {

    }

    @FXML
    void onActionToDoListDocumentation(ActionEvent event) {

    }

    @FXML
    void clickListes(ActionEvent event) {
        StartApplication.changeScene("/appli/todolist/todolist-view.fxml", new TodolistController(this.user),"To-Do List - Listes");
    }

    @FXML
    void clickSave(ActionEvent event) {

    }

    @FXML
    void clickTaches(ActionEvent event) {
        StartApplication.changeScene("/appli/tache/create-tache-view.fxml", new CreateTacheController(this.user), "Créer une tâche");
    }

    @FXML
    void clickType(ActionEvent event) {
        StartApplication.changeScene("/appli/type/create-type-view.fxml", new CreateTypeController(this.user),"To-Do List - Créer une catégorie");
    }

    ObservableList <Type>types;
    @FXML
    private ComboBox<Type> comboBoxAttacher = new ComboBox<>(types);
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TypeRepository typeRepository = null;
        try {
            typeRepository = new TypeRepository();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            comboBoxAttacher.getItems().addAll(FXCollections.observableArrayList(typeRepository.readType(this.user)));
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
