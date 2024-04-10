package Controllers;

import java.io.IOException;

import Objects.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class nurseViewController {

    @FXML // fx:id="bloodPressure"
    private TextField bloodPressure; // Value injected by FXMLLoader

    @FXML // fx:id="notes"
    private TextArea notes; // Value injected by FXMLLoader

    @FXML // fx:id="name"
    private Label name; // Value injected by FXMLLoader

    @FXML // fx:id="prevRecord"
    private TextArea prevRecord; // Value injected by FXMLLoader

    @FXML // fx:id="weight"
    private TextField weight; // Value injected by FXMLLoader

    @FXML // fx:id="bodyTemp"
    private TextField bodyTemp; // Value injected by FXMLLoader

    @FXML // fx:id="teenCheck"
    private CheckBox teenCheck; // Value injected by FXMLLoader

    @FXML // fx:id="height"
    private TextField height; // Value injected by FXMLLoader

    // TODO - Change this
    Patient patientInQuestion = MainController.patientInQuestion;
    boolean isTeen = false;

    @FXML
	public void initialize() {
        name.setText("Patient: " + patientInQuestion.getFirstName() + " " + patientInQuestion.getLastName());
        bloodPressure.setDisable(true);
    }

    @FXML
    void checkedTeen(ActionEvent event) {
        if (teenCheck.isSelected()) {
            isTeen = true;
            bloodPressure.setDisable(false);
        }
    }

    @FXML
    void saveAddedPatientInfo(ActionEvent event) {
        patientInQuestion.setBloodPressure(bloodPressure.getText());
        patientInQuestion.setWeight(weight.getText());
        patientInQuestion.setBodyTemp(bodyTemp.getText());
        patientInQuestion.setHeight(height.getText());
        patientInQuestion.setAboveTwelve(isTeen);
        patientInQuestion.saveToFile();

        Parent mainCallWindowFXML;
        try {
            mainCallWindowFXML = FXMLLoader.load(getClass().getResource("/GUI/health_record.fxml"));
            Stage stage = (Stage) name.getScene().getWindow();
            stage.setScene(new Scene(mainCallWindowFXML));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void clearFields(ActionEvent event) {
        bloodPressure.clear();
        weight.clear();
        bodyTemp.clear();
        height.clear();
        teenCheck.setSelected(false);
    }
}