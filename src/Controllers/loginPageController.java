package Controllers;

import Objects.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class loginPageController {

	@FXML // fx:id="createAccountButton"
	private Button createAccountButton; // Value injected by FXMLLoader

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

	@FXML
	void loginButtonPressed(ActionEvent event) {
		if (doctorLoginRadio.isSelected()) {
			User doc = new User(Objects.USERTYPE.DOCTOR, "doc");
			MainController.setLoggedInUser(doc);
		}
		String enteredID = userID.getText();
	}

	@FXML
	void createNewAccount(ActionEvent event) {
		// Open the signuo controller page
	}

}
 