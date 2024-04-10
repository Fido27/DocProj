package Controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import Objects.USERTYPE;
import Objects.Visit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DocViewController {

    @FXML // fx:id="allergies"
    private TextField allergies; // Value injected by FXMLLoader

    @FXML // fx:id="medicines"
    private TextField medicines; // Value injected by FXMLLoader

    @FXML // fx:id="notes"
    private TextField notes; // Value injected by FXMLLoader

    @FXML // fx:id="summaryBox"
    private TextArea summaryBox; // Value injected by FXMLLoader

    @FXML // fx:id="clear"
    private Button clear; // Value injected by FXMLLoader

    @FXML // fx:id="date"
    private TextField date; // Value injected by FXMLLoader

    @FXML // fx:id="save"
    private Button save; // Value injected by FXMLLoader

    File file;
    String text = "";
    Path path;

    @FXML
	public void initialize() {

        if (MainController.loggedInUser.getUSERTYPE().equals(USERTYPE.PATIENT)) {
            date.setDisable(true);
            allergies.setDisable(true);
            medicines.setDisable(true);
            notes.setDisable(true);
        }

        MainController.patientInQuestion.readVisits();

        for (int i = 0; i < MainController.patientInQuestion.visitSummaries.size(); i++) {
            text += MainController.patientInQuestion.visitSummaries.get(i).toString();
        }

        summaryBox.setText(text);
	}

    @FXML
    void clearFunc(ActionEvent event) {
        date.clear();
        allergies.clear();
        medicines.clear();
        notes.clear();
    }

    @FXML
    void saveBtn(ActionEvent event) {

        // if (!MainController.loggedInUser.getUSERTYPE().equals(USERTYPE.PATIENT)) {
        //     String filePath = "src/Data/Patients/" + MainController.patientInQuestion.getUserID() + "_visits.txt";
        //     path = Path.of(filePath);
        //     file = new File(filePath);
    
        //     Visit v = new Visit(date.getText(), allergies.getText(), medicines.getText(), notes.getText());
        //     text = v.toString() + text;
                            
        //     try {
        //         file.createNewFile();
        //         Files.writeString(path, text);
        //     } catch (IOException e) {
        //         e.printStackTrace();
        //     }
        // }

        Parent mainCallWindowFXML;
        try {
            mainCallWindowFXML = FXMLLoader.load(getClass().getResource("/GUI/patient.fxml"));
            Stage stage = (Stage) notes.getScene().getWindow();
            stage.setScene(new Scene(mainCallWindowFXML));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
