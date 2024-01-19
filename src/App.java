import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    private static Stage primaryStage;

    public static Stage GetPrimaryStage() {
        return primaryStage;
    }

    @Override
    public void start(Stage myStage) {
        primaryStage = myStage;

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
            Scene scene = new Scene(root);

            primaryStage.setTitle("CSS Minifier");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}