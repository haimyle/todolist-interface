package appli.todolist;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import modele.User;

public class TodayController {
    private User user;

    @FXML
    private Label lbArchives;

    @FXML
    private Label lbInbox;

    @FXML
    private Label lbListes;

    @FXML
    private Label lbTrash;

    @FXML
    private Label lbUpcoming;

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

    public TodayController(User user) {
        this.user = user;
    }

}
