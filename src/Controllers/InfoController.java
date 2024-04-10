package Controllers;

import java.io.IOException;
import Objects.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InfoController {

    @FXML // fx:id="emergencyContactNum"
    private TextField emergencyContactNum; // Value injected by FXMLLoader

    @FXML 
    private TextField password; // Value injected by FXMLLoader

    @FXML 
    private TextField confirmPass; // Value injected by FXMLLoader

    @FXML 
    private TextField allergies; // Value injected by FXMLLoader

    @FXML // fx:id="firstName"
    private TextField firstName; // Value injected by FXMLLoader

    @FXML // fx:id="patientID"
    private TextField patientID; // Value injected by FXMLLoader

    @FXML // fx:id="lastName"
    private TextField lastName; // Value injected by FXMLLoader

    @FXML // fx:id="address"
    private TextArea address; // Value injected by FXMLLoader

    @FXML // fx:id="insuranceNum"
    private TextField insuranceNum; // Value injected by FXMLLoader

    @FXML // fx:id="emergencyContactName"
    private TextField emergencyContactName; // Value injected by FXMLLoader

    @FXML // fx:id="saveAccountButton"
    private Button saveAccountButton; // Value injected by FXMLLoader

    @FXML // fx:id="insuranceCo"
    private TextField insuranceCo; // Value injected by FXMLLoader

    @FXML // fx:id="middleInit"
    private TextField middleInit; // Value injected by FXMLLoader

    @FXML // fx:id="birthDate"
    private TextField birthDate; // Value injected by FXMLLoader

    @FXML // fx:id="phoneNo"
    private TextField phoneNo; // Value injected by FXMLLoader
    
    Patient p = MainController.patientInQuestion;

    @FXML
    public void initialize() {
        firstName.setDisable(true);
        lastName.setDisable(true);
        birthDate.setDisable(true);;
        phoneNo.setText(p.getPhoneNo());
        firstName.setText(p.getFirstName());
        lastName.setText(p.getLastName());
        birthDate.setText(p.getBirthDate());
        middleInit.setText(p.getMInitial());
        insuranceCo.setText(p.getInsuranceCompany());
        insuranceNum.setText(p.getInsuranceNumber());
        emergencyContactName.setText(p.getEmergencyContactName());
        emergencyContactNum.setText(p.getEmergencyContact());
        address.setText(p.getAddress());
        patientID.setText(p.getUserID());
    }
    
    @FXML
    void saveBtn(ActionEvent event) {

        p.setAddress(address.getText());
        p.setPhoneNo(phoneNo.getText());
        p.setMInitial(middleInit.getText());
        p.setAllergies(allergies.getText());
        p.setInsuranceCompany(insuranceCo.getText());
        p.setInsuranceNumber(insuranceNum.getText());
        p.setEmergencyContact(emergencyContactNum.getText());
        p.setEmergencyContactName(emergencyContactName.getText());
        p.saveToFile();

        Parent mainCallWindowFXML;
        try {
            mainCallWindowFXML = FXMLLoader.load(getClass().getResource("/GUI/patient.fxml"));
            Stage stage = (Stage) saveAccountButton.getScene().getWindow();
            stage.setScene(new Scene(mainCallWindowFXML));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}