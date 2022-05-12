package appli.type;

/*import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import modele.Type;
import modele.User;
import repository.TypeRepository;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CreateTypeController implements Initializable {
    private User user;

    @FXML
    private ComboBox<Type> CbBxAttacherType;

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
    private Label lbMessage;

    @FXML
    private Label lbToday;

    @FXML
    private TextField tfNomType;

    @FXML
    void clickCancel(ActionEvent event) {

    }

    @FXML
    void clickSave(ActionEvent event) {

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

    ObservableList<Type> observableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TypeRepository typeRepository = new TypeRepository();
        try {
            this.CbBxAttacherType.getItems().addAll(typeRepository.readType(this.user));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}*/
import appli.StartApplication;
import appli.todolist.TodolistController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
        import javafx.scene.control.ComboBox;
        import javafx.scene.control.Label;
        import javafx.scene.control.TextField;
import modele.Type;
import modele.User;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateTypeController implements Initializable {
    private User user;
    ObservableList<Object> observableList = FXCollections.observableArrayList();

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
    private ComboBox<?> comboBoxAttacher;

    @FXML
    private Label lbMessage;

    @FXML
    private TextField tfNomType;

    @FXML
    void clickArchives(ActionEvent event) {

    }

    @FXML
    void clickAujourdhui(ActionEvent event) {

    }

    @FXML
    void clickCancel(ActionEvent event) {

    }

    @FXML
    void clickCorbeille(ActionEvent event) {

    }

    @FXML
    void clickListes(ActionEvent event) {
        StartApplication.changeScene("/appli/todolist/todolist-view.fxml", new TodolistController(user),"To-Do List - Application");
    }

    @FXML
    void clickSave(ActionEvent event) {

    }

    @FXML
    void clickType(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
