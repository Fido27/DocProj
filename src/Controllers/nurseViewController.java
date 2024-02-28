package Controllers;

import Objects.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class nurseViewController {
    @FXML
    private TextField bloodPressure;

    @FXML
    private TextField weight;

    @FXML
    private TextField bodyTemp;

    @FXML
    private TextField height;

    Patient patientInQuestion = new Patient("aarjai2710");

    @FXML
    void saveAddedPatientInfo(ActionEvent event) {
        patientInQuestion.readFromFile();
        patientInQuestion.setBloodPressure(bloodPressure.getText());
        patientInQuestion.setWeight(weight.getText());
        patientInQuestion.setBodyTemp(bodyTemp.getText());
        patientInQuestion.setHeight(height.getText());
        patientInQuestion.saveToFile();
    }

    @FXML
    void clearFields(ActionEvent event) {
        bloodPressure.clear();
        weight.clear();
        bodyTemp.clear();
        height.clear();
    }
}