package appli.tache;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import modele.Tache;

import java.sql.Date;

public class TacheViewController {

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
    private TableColumn<Tache, Date> colDeadline;

    @FXML
    private TableColumn<Tache, String> colTache;

    @FXML
    private TableColumn<Tache, Integer> colType;

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
    void clickType(ActionEvent event) {

    }

}

