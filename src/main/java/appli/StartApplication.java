package appli;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class StartApplication extends Application {
    private static Stage stage;
    private static FXMLLoader fxmlLoader;

    @Override
    public void start(Stage firstStage) throws IOException {

        stage = firstStage;
        fxmlLoader = new FXMLLoader(StartApplication.class.getResource("/appli/accueil-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("To-Do List - Accueil");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void newWindow(String fxml,Object controller, String title) {
        try {
            fxmlLoader = new FXMLLoader(StartApplication.class.getResource(fxml));
            fxmlLoader.setController(controller);
            Parent root = fxmlLoader.  load();
            Stage stage = new Stage();
            stage.setTitle(title);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.err.println(String.format("Error: %s", e.getMessage()));
        }
    }

    public static void changeScene(String fxml,Object controller, String title) {
        stage.close();
        try {
            fxmlLoader = new FXMLLoader(StartApplication.class.getResource(fxml));
            fxmlLoader.setController(controller);
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.err.println(String.format("Error: %s", e.getMessage()));
        }
    }
    public static void changeScene(String fxml, String title) {
        stage.close();
        try {
            fxmlLoader = new FXMLLoader(StartApplication.class.getResource(fxml+".fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.err.println(String.format("Error: %s", e.getMessage()));
        }
    }

    public static Optional<ButtonType> validationDialog(String titre, String message){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"titre alert");
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(stage);
        alert.getDialogPane().setContentText(message);
        alert.getDialogPane().setHeaderText(titre);
        return alert.showAndWait();
    }

}