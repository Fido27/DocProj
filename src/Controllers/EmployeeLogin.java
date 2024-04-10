package Controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import Objects.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EmployeeLogin {

    @FXML // fx:id="firstNameText"
    private TextField firstNameText; // Value injected by FXMLLoader

    @FXML // fx:id="phoneText"
    private TextField phoneText; // Value injected by FXMLLoader

    @FXML // fx:id="dobText"
    private TextField dobText; // Value injected by FXMLLoader

    @FXML // fx:id="patientIDLabel"
    private Label patientIDLabel; // Value injected by FXMLLoader

    @FXML // fx:id="lastNameText"
    private TextField lastNameText; // Value injected by FXMLLoader

    @FXML // fx:id="passText"
    private TextField passText; // Value injected by FXMLLoader

    @FXML // fx:id="saveAccountButton"
    private Button saveAccountButton; // Value injected by FXMLLoader

    @FXML // fx:id="emailText"
    private TextField emailText; // Value injected by FXMLLoader

    @FXML // fx:id="patientIDLabel1"
    private Label patientIDLabel1; // Value injected by FXMLLoader

    @FXML // fx:id="confirmPassText"
    private TextField confirmPassText; // Value injected by FXMLLoader

    @FXML // fx:id="idText"
    private TextField idText; // Value injected by FXMLLoader


    // TODO - Remove this 
    @FXML // fx:id="patientIDLabel2"
    private Label patientIDLabel2; // Value injected by FXMLLoader

    String ID_patient = "_________";

    @FXML
	public void initialize() {
		idText.setDisable(true);

        firstNameText.textProperty().addListener((observable, oldValue, newValue) -> {
            firstNameChanged();
        });
        lastNameText.textProperty().addListener((observable, oldValue, newValue) -> {
            lastNameChanged();
        });
        dobText.textProperty().addListener((observable, oldValue, newValue) -> {
            birthDateChanged();
        });
        idText.setText(ID_patient);
	}

    @FXML
    void savePatientInfo(ActionEvent event) {

        String top = "";
        if (MainController.userInQuestion.equals(Objects.USERTYPE.DOCTOR)) 
            top = "D";
        else
            top = "N";

        String fName = firstNameText.getText();
        String lName = lastNameText.getText();
        String bDate = dobText.getText();

        String ID_patient = fName.substring(0,3)
                    + lName.substring(0,3) 
                    + bDate.substring(0,2) 
                    + bDate.substring(3,5);
        ID_patient = ID_patient.toLowerCase();
        idText.setText(ID_patient);

        String filePath = "src/Data/Auth/" + ID_patient + ".txt";
        Path path = Path.of(filePath);
        File file = new File(filePath);
        String text = "" + 
                        top + "\n" +
                        passText.getText() + "\n"; // TODO - Encrypt Password

        try {
            file.createNewFile();
            Files.writeString(path, text);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Employee tmpDoc = new Employee(ID_patient);
        tmpDoc.setFirstName(firstNameText.getText());
        tmpDoc.setLastName(lastNameText.getText());
        tmpDoc.setPhoneNo(phoneText.getText());
        tmpDoc.setEmail(emailText.getText());
        tmpDoc.setBirthDate(dobText.getText());

        tmpDoc.saveToFile();

        Parent mainCallWindowFXML;
        try {
            mainCallWindowFXML = FXMLLoader.load(getClass().getResource("/GUI/login.fxml"));
            Stage stage = (Stage) dobText.getScene().getWindow();
            stage.setScene(new Scene(mainCallWindowFXML));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    void firstNameChanged() {
        String tmp = firstNameText.getText() + "____";

        ID_patient = tmp.substring(0, 3).toLowerCase() + ID_patient.substring(3);
        idText.setText(ID_patient);
        System.out.println("fName Changed new id: " + this.ID_patient);
    }

    void lastNameChanged() {
        String tmp = lastNameText.getText() + "____";

        ID_patient = ID_patient.substring(0, 3) + tmp.substring(0,3).toLowerCase() + ID_patient.substring(6);
        idText.setText(ID_patient);
        System.out.println("lName Changed new id: " + this.ID_patient);
    }

    void birthDateChanged() {
        String tmp = dobText.getText() + "____";
        tmp = tmp.replace("/", "");

        ID_patient = ID_patient.substring(0, 6) + tmp.substring(0, 4).toLowerCase();
        idText.setText(ID_patient);
        System.out.println("Bdate Changed new id: " + this.ID_patient);
    }

}