package Controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class patientController {

    @FXML // fx:id="name"
    private Label name; // Value injected by FXMLLoader

    @FXML
	public void initialize() {
		name.setText(MainController.patientInQuestion.getFirstName() + " " + MainController.patientInQuestion.getLastName());
	}

    @FXML
    void personalInfo(ActionEvent event) {
        Parent mainCallWindowFXML;
        try {
            mainCallWindowFXML = FXMLLoader.load(getClass().getResource("/GUI/personal_info.fxml"));
            Stage stage = (Stage) name.getScene().getWindow();
            stage.setScene(new Scene(mainCallWindowFXML));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void record(ActionEvent event) {
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
    void message(ActionEvent event) {
        Parent mainCallWindowFXML;
        try {
            mainCallWindowFXML = FXMLLoader.load(getClass().getResource("/GUI/message_portal.fxml"));
            Stage stage = (Stage) name.getScene().getWindow();
            stage.setScene(new Scene(mainCallWindowFXML));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
