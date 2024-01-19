import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.shape.Path;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MainSceneController {

    @FXML
    private TextArea OriginalText;

    @FXML
    private TextArea OutputText;

    @FXML
    void btnCopyClicked(ActionEvent event) {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent content = new ClipboardContent();
        content.putString(OutputText.getText());
        clipboard.setContent(content);
    }

    @FXML
    void btnOpenClicked(ActionEvent event) {
        java.nio.file.Path file = Paths.get(ChooseFile(App.GetPrimaryStage()));

        Charset charset = Charset.forName("US-ASCII");
        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            String line = null;
            OriginalText.clear();
            while ((line = reader.readLine()) != null) {
                OriginalText.setText(OriginalText.getText() + line + "\n");
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

    }

    @FXML
    void btnMinifyClicked(ActionEvent event) {
        OutputText.setText(Minifier.Minify(OriginalText.getText()));
    }

    private String ChooseFile(Stage p) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose a file");
        fileChooser.setInitialDirectory(new File("C:\\"));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSS Files", "*.css"));
        File selectedFile = fileChooser.showOpenDialog(p);
        if (selectedFile != null) {
            return selectedFile.getAbsolutePath();

        }
        return "";
    }
}
