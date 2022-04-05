package appli;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartApplication extends Application {
    private static Stage stage;
    private static FXMLLoader fxmlLoader;

    @Override
    public void start(Stage firstStage) throws IOException {

        stage = firstStage;
        fxmlLoader = new FXMLLoader(StartApplication.class.getResource("/appli/welcome1.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Bienvenue!");
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
    public static void changeScene(String fxml) {
        stage.close();
        try {
            fxmlLoader = new FXMLLoader(StartApplication.class.getResource(fxml+".fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.err.println(String.format("Error: %s", e.getMessage()));
        }
    }

}