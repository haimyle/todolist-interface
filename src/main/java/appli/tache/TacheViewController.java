package appli.tache;

<<<<<<< HEAD
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import modele.Tache;

import java.sql.Date;

public class TacheViewController {

=======
import appli.StartApplication;
import appli.user.AdminController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import modele.User;

public class TacheViewController {

    public TacheViewController(User user) {
        this.user = user;
    }

    private User user;

>>>>>>> 176b4943cecbcca51abf946a51a2c1fb99426581
    @FXML
    private Button btnArchives;

    @FXML
    private Button btnCorbeille;

    @FXML
    private Button btnCreateTache;

    @FXML
    private Button btnListes;

    @FXML
    private Button btnModifier;

    @FXML
    private Button btnSupprimer;

    @FXML
    private Button btnTache;

    @FXML
    private Button btnType;

    @FXML
<<<<<<< HEAD
    private TableColumn<Tache, Date> colDeadline;

    @FXML
    private TableColumn<Tache, String> colTache;

    @FXML
    private TableColumn<Tache, Integer> colType;
=======
    private TableColumn<?, ?> colDeadline;

    @FXML
    private TableColumn<?, ?> colTache;

    @FXML
    private TableColumn<?, ?> colType;
>>>>>>> 176b4943cecbcca51abf946a51a2c1fb99426581

    @FXML
    private Label lbNomListe;

<<<<<<< HEAD
=======


>>>>>>> 176b4943cecbcca51abf946a51a2c1fb99426581
    @FXML
    void clickArchives(ActionEvent event) {

    }

    @FXML
    void clickCorbeille(ActionEvent event) {

    }

    @FXML
    void clickCreateTache(ActionEvent event) {

    }

    @FXML
    void clickListes(ActionEvent event) {

    }

    @FXML
    void clickModifier(ActionEvent event) {

    }

    @FXML
    void clickSupprimer(ActionEvent event) {

    }

    @FXML
    void clickTache(ActionEvent event) {

    }

    @FXML
    void clickType(ActionEvent event) {

    }

<<<<<<< HEAD
=======
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

>>>>>>> 176b4943cecbcca51abf946a51a2c1fb99426581
}

