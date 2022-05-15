package appli.tache;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modele.Liste;
import modele.Tache;
import modele.Type;
import modele.User;
import repository.ListeRepository;
import repository.TacheRepository;
import repository.TypeRepository;

import java.net.URL;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ResourceBundle;

public class UpdateTacheController implements Initializable {
    private Tache tache;
    private User user;
    ObservableList<Liste> listes;
    ObservableList<Type> types;
    @FXML
    private Button btnArchives;

    @FXML
    private Button btnCorbeille;

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
    private Label lblAdded;

    @FXML
    private Label lblError;

    @FXML
    private TextField tfTitre;

    @FXML
    void clickAnnuler(ActionEvent event) {

    }

    @FXML
    void clickArchives(ActionEvent event) {

    }

    @FXML
    void clickCorbeille(ActionEvent event) {

    }

    @FXML
    void clickListes(ActionEvent event) {

    }

    @FXML
    void clickSauvegarder(ActionEvent event) throws SQLException {
        TacheRepository tacheRepository = new TacheRepository();
        Tache tache = new Tache();
        Type type = new Type();
        java.util.Date date = java.util.Date.from(deadline.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        if (!tfTitre.getText().isBlank()){
            tacheRepository.updateTache(tfTitre.getText(),sqlDate,comboBoxType.getValue().getIdType(),comboBoxListe.getValue().getIdListe(),tache.getIdTache());
        }
        if (tache != null) {
            System.out.println("Enregistrée dans la BDD");
            tfTitre.clear();
            lblAdded.setVisible(true);
            lblError.setVisible(false);
        } else {
            System.out.println("Erreur");
            tfTitre.clear();
            lblAdded.setVisible(false);
            lblError.setVisible(true);
        }
    }

    @FXML
    void clickTaches(ActionEvent event) {

    }

    @FXML
    void clickType(ActionEvent event) {

    }

    @FXML
    void onActionCompteAdmin(ActionEvent event) {

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

    public UpdateTacheController(User user, Tache tache) {
        this.tache = tache;
        this.user = user;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ListeRepository listeRepository = new ListeRepository();
        TypeRepository typeRepository = null;
        try {
            typeRepository = new TypeRepository();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(typeRepository.readType(this.user));
            comboBoxType.getItems().addAll( FXCollections.observableArrayList(typeRepository.readType(user)));
            comboBoxListe.getItems().addAll(FXCollections.observableArrayList(listeRepository.readList(user)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tfTitre.setText(tache.getNomTache());
    }
}
