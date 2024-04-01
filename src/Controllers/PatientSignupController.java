package Controllers;

import Objects.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PatientSignupController {

    @FXML // fx:id="emergencyContactNum"
    private TextField emergencyContactNum; // Value injected by FXMLLoader

    @FXML // fx:id="allergies"
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

    private String ID_patient = "__________";

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
        tmpPatient.setAllergies(allergies.getText());
        tmpPatient.setInsuranceCompany(insuranceCo.getText());
        tmpPatient.setInsuranceNumber(insuranceNum.getText());
        tmpPatient.setEmergencyContact(emergencyContactNum.getText());
        tmpPatient.setEmergencyContactName(emergencyContactName.getText());

        tmpPatient.saveToFile();
    }

    // TO-DO: Make it so that it's called at every key press 
    // or text changed in the textboxes

    @FXML
    void firstNameChanged(ActionEvent event) {
        String tmp = "___";
        String input = firstName.getText();
        tmp.replace(tmp.substring(0, Math.min(3, input.length())), input.substring(0, Math.min(3, input.length())));
        ID_patient = tmp.toLowerCase() + ID_patient.substring(3);
        patientID.setText(ID_patient);
        System.out.println("fName Changed new id: " + this.ID_patient);
    }

    @FXML
    void lastNameChanged(ActionEvent event) {
        patientID.setText(ID_patient);
        System.out.println("lName Changed new id: " + this.ID_patient);
    }

    @FXML
    void birthDateChanged(ActionEvent event) {
        patientID.setText(ID_patient);
        System.out.println("Bdate Changed new id: " + this.ID_patient);
    }

}