package appli.type;

import appli.StartApplication;
import appli.user.AdminController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TreeView;
import modele.Type;
import modele.User;

public class TypeViewController {
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
    private TreeView<?> treeViewType;

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

}

