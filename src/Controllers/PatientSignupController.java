package Controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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

public class PatientSignupController {

    @FXML // fx:id="emergencyContactNum"
    private TextField emergencyContactNum; // Value injected by FXMLLoader

    @FXML 
    private TextField password; // Value injected by FXMLLoader

    @FXML 
    private TextField confirmPass; // Value injected by FXMLLoader

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

    private String ID_patient = "__________";

    @FXML
    private void initialize() {
        firstName.textProperty().addListener((observable, oldValue, newValue) -> {
            firstNameChanged();
        });
        lastName.textProperty().addListener((observable, oldValue, newValue) -> {
            lastNameChanged();
        });
        birthDate.textProperty().addListener((observable, oldValue, newValue) -> {
            birthDateChanged();
        });
        patientID.setText(ID_patient);
    }

    @FXML
    void savePatientInfo(ActionEvent event) {
        String fName = firstName.getText();
        String lName = lastName.getText();
        String bDate = birthDate.getText();

        ID_patient = fName.substring(0,3)
                    + lName.substring(0,3) 
                    + bDate.substring(0,2) 
                    + bDate.substring(3,5);
        ID_patient = ID_patient.toLowerCase();
        patientID.setText(ID_patient);

        Patient tmpPatient = new Patient(ID_patient);
        tmpPatient.setFirstName(firstName.getText());
        tmpPatient.setMInitial(middleInit.getText());
        tmpPatient.setLastName(lastName.getText());
        tmpPatient.setPhoneNo(phoneNo.getText());
        tmpPatient.setBirthDate(birthDate.getText());
        tmpPatient.setAddress(address.getText());
        tmpPatient.setInsuranceCompany(insuranceCo.getText());
        tmpPatient.setInsuranceNumber(insuranceNum.getText());
        tmpPatient.setEmergencyContact(emergencyContactNum.getText());
        tmpPatient.setEmergencyContactName(emergencyContactName.getText());

        tmpPatient.saveToFile();

        MainController.setLoggedInUser(tmpPatient);
        MainController.patientInQuestion = tmpPatient;

        String top = "P";

        String filePath = "src/Data/Auth/" + ID_patient + ".txt";
        Path path = Path.of(filePath);
        File file = new File(filePath);
        String text = "" + 
                        top + "\n" +
                        password.getText() + "\n"; // TODO - Encrypt Password

        try {
            file.createNewFile();
            Files.writeString(path, text);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent mainCallWindowFXML;
        try {
            mainCallWindowFXML = FXMLLoader.load(getClass().getResource("/GUI/login.fxml"));
            Stage stage = (Stage) saveAccountButton.getScene().getWindow();
            stage.setScene(new Scene(mainCallWindowFXML));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void firstNameChanged() {
        String tmp = firstName.getText() + "____";

        ID_patient = tmp.substring(0, 3).toLowerCase() + ID_patient.substring(3);
        patientID.setText(ID_patient);
        System.out.println("fName Changed new id: " + this.ID_patient);
    }

    void lastNameChanged() {
        String tmp = lastName.getText() + "____";

        ID_patient = ID_patient.substring(0, 3) + tmp.substring(0,3).toLowerCase() + ID_patient.substring(6);
        patientID.setText(ID_patient);
        System.out.println("lName Changed new id: " + this.ID_patient);
    }

    void birthDateChanged() {
        String tmp = birthDate.getText() + "____";
        tmp = tmp.replace("/", "");

        ID_patient = ID_patient.substring(0, 6) + tmp.substring(0, 4).toLowerCase();
        patientID.setText(ID_patient);
        System.out.println("Bdate Changed new id: " + this.ID_patient);
    }

}