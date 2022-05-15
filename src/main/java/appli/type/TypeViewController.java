package appli.type;

import appli.StartApplication;
import appli.user.AdminController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import modele.Tache;
import modele.Type;
import modele.User;
import repository.TacheRepository;
import repository.TypeRepository;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TypeViewController implements Initializable {
    private User user;
    private Type type;

    @FXML
    private Button btnArchives;

    @FXML
    private Button btnAujourdhui;

    @FXML
    private Button btnCorbeille;

    @FXML
    private Button btnCreate;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnListes;

    @FXML
    private Button btnType;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<Type, Integer> colParent;

    @FXML
    private TableColumn<Type, String> colType;

    @FXML
    private TableView<Type> tbType;
    private Type selectedType;

    @FXML
    void onSelectedRow(MouseEvent event) {
        System.out.println("Selected");
        this.selectedType = tbType.getSelectionModel().getSelectedItem();
        if (selectedType != null){
            System.out.println(this.selectedType);
            btnDelete.setVisible(true);
        }
    }

    ObservableList<Type> observableList = FXCollections.observableArrayList();

    public TypeViewController(User user) {
        this.user = user;
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

    @FXML
    void clickArchives(ActionEvent event) {

    }

    @FXML
    void clickTaches(ActionEvent event) {

    }

    @FXML
    void clickAujourdhui(ActionEvent event) {

    }

    @FXML
    void clickCorbeille(ActionEvent event) {

    }

    @FXML
    void clickListes(ActionEvent event) {

    }

    @FXML
    void clickType(ActionEvent event) {

    }

    @FXML
    void createType(ActionEvent event) {

    }

    @FXML
    void deleteType(ActionEvent event) {

    }

    @FXML
    void updateType(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TypeRepository typeRepository = null;
        try {
            typeRepository = new TypeRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.btnDelete.setVisible(false);

        try {
            observableList.addAll(typeRepository.readType(user));
            System.out.println(observableList);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        colType.setCellValueFactory(new PropertyValueFactory<Type, String>("nomType"));
        colParent.setCellValueFactory(new PropertyValueFactory<Type, Integer>("refType"));
        tbType.getItems().addAll(observableList);
    }
}

