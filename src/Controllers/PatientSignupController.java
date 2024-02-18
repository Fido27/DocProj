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

    @FXML
    void savePatientInfo(ActionEvent event) {
        String ID = firstName.getText();
        Patient tmpPatient = new Patient(ID);
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
        System.out.println(tmpPatient.getFirstName());
    }

}

