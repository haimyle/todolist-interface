package appli.tache;


import appli.StartApplication;
import appli.user.AdminController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.Liste;
import modele.Tache;
import modele.User;
import repository.TacheRepository;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TacheViewController implements Initializable {
    private User user;
    private Liste liste;

    public TacheViewController(User user, Liste liste) {
        this.user = user;
        this.liste = liste;
    }

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
    private Button btnTerminer;

    @FXML
    private Button btnType;

    @FXML

    private TableColumn<Tache, Date> colDeadline;

    @FXML
    private TableColumn<Tache, String> colTache;

    @FXML
    private TableColumn<Tache, Integer> colType;

    @FXML
    private TableView<Tache> tbTache;

    ObservableList<Tache> observableList = FXCollections.observableArrayList();

    @FXML
    private Label lbNomListe;


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
    void clickTerminer(ActionEvent event) {

    }

    @FXML
    void clickType(ActionEvent event) {

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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TacheRepository tacheRepository = new TacheRepository();
        this.btnModifier.setVisible(false);
        this.btnSupprimer.setVisible(false);
        this.btnTerminer.setVisible(false);

        try {
            observableList.addAll(tacheRepository.readTache(this.liste));
            System.out.println(observableList);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        colTache.setCellValueFactory(new PropertyValueFactory<Tache,String>("nom_tache"));
        colDeadline.setCellValueFactory(new PropertyValueFactory<Tache,Date>("deadline"));
        colType.setCellValueFactory(new PropertyValueFactory<Tache,Integer>("ref_type"));
        tbTache.setItems(observableList);


    }
}

