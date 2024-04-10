package Controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import Objects.Employee;
import Objects.Patient;
import Objects.USERTYPE;
import Objects.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class loginPageController {

    @FXML // fx:id="createAccountButton"
    private Button createAccountButton; // Value injected by FXMLLoader

    @FXML // fx:id="passwordTextField"
    private TextField passwordTextField; // Value injected by FXMLLoader

    @FXML // fx:id="nurseLoginRadio"
    private RadioButton nurseLoginRadio; // Value injected by FXMLLoader

    @FXML // fx:id="doctorLoginRadio"
    private RadioButton doctorLoginRadio; // Value injected by FXMLLoader

    @FXML // fx:id="loginButton"
    private Button loginButton; // Value injected by FXMLLoader

    @FXML // fx:id="userID"
    private TextField userID; // Value injected by FXMLLoader

    @FXML // fx:id="patientLoginRadio"
    private RadioButton patientLoginRadio; // Value injected by FXMLLoader

	final ToggleGroup group = new ToggleGroup();
	File filePath = new File("src/Data/Auth/");
	File[] listingAllFiles = filePath.listFiles();

	@FXML
	public void initialize() {
		nurseLoginRadio.setToggleGroup(group);
		patientLoginRadio.setToggleGroup(group);
		doctorLoginRadio.setToggleGroup(group);
	}

	@FXML
	void loginButtonPressed(ActionEvent event) {
		String enteredID = userID.getText();
		boolean loginSucc = false;

		try {
			String filePath = "src/Data/Auth/" + enteredID + ".txt";
			List<String> allLines = Files.readAllLines(Paths.get(filePath));

			if (passwordTextField.getText().equals(allLines.get(1))) {
				loginSucc = true;
			}

			if (loginSucc) {
				if (allLines.get(0).equals("P")) {
					MainController.userInQuestion = USERTYPE.PATIENT;
					Patient p = new Patient(enteredID);
					MainController.setLoggedInUser(p);
					MainController.patientInQuestion = p;
					
					Parent mainCallWindowFXML;
					try {
						mainCallWindowFXML = FXMLLoader.load(getClass().getResource("../GUI/patient.fxml"));
						Stage stage = (Stage) nurseLoginRadio.getScene().getWindow();
						stage.setScene(new Scene(mainCallWindowFXML));
						stage.show();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else if (allLines.get(0).equals("D")) {
					MainController.userInQuestion = USERTYPE.DOCTOR;
					Employee e = new Employee(enteredID);
					MainController.setLoggedInUser(e);
					Parent mainCallWindowFXML;
					try {
						mainCallWindowFXML = FXMLLoader.load(getClass().getResource("../GUI/patientList.fxml"));
						Stage stage = (Stage) nurseLoginRadio.getScene().getWindow();
						stage.setScene(new Scene(mainCallWindowFXML));
						stage.show();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				} else if (allLines.get(0).equals("N")) {
					MainController.userInQuestion = USERTYPE.NURSE;
					Employee e = new Employee(enteredID);
					MainController.setLoggedInUser(e);
					Parent mainCallWindowFXML;
					try {
						mainCallWindowFXML = FXMLLoader.load(getClass().getResource("../GUI/patientList.fxml"));
						Stage stage = (Stage) nurseLoginRadio.getScene().getWindow();
						stage.setScene(new Scene(mainCallWindowFXML));
						stage.show();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				} else {
					System.out.println("No header in the auth file for " + enteredID);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Incorrect ID or Pass");
		}
	}

	@FXML
	void createNewAccount(ActionEvent event) {
		if (patientLoginRadio.isSelected()) {

			MainController.userInQuestion = USERTYPE.PATIENT;
			
			Parent mainCallWindowFXML;
			try {
				mainCallWindowFXML = FXMLLoader.load(getClass().getResource("../GUI/patient_signup.fxml"));
				Stage stage = (Stage) nurseLoginRadio.getScene().getWindow();
				stage.setScene(new Scene(mainCallWindowFXML));
				stage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} else if (nurseLoginRadio.isSelected()) {

			MainController.userInQuestion = USERTYPE.NURSE;
			User nurse = new User(Objects.USERTYPE.NURSE, "nurse");
			MainController.setLoggedInUser(nurse);

			Parent mainCallWindowFXML;
			try {
				mainCallWindowFXML = FXMLLoader.load(getClass().getResource("../GUI/employeeLogin.fxml"));
				Stage stage = (Stage) nurseLoginRadio.getScene().getWindow();
				stage.setScene(new Scene(mainCallWindowFXML));
				stage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else if (doctorLoginRadio.isSelected()) {

			MainController.userInQuestion = USERTYPE.DOCTOR;
			User doc = new User(Objects.USERTYPE.DOCTOR, "doc");
			MainController.setLoggedInUser(doc);

			Parent mainCallWindowFXML;
			try {
				mainCallWindowFXML = FXMLLoader.load(getClass().getResource("../GUI/employeeLogin.fxml"));
				Stage stage = (Stage) nurseLoginRadio.getScene().getWindow();
				stage.setScene(new Scene(mainCallWindowFXML));
				stage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
 