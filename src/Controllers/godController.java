package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class godController {

    @FXML // fx:id="personalinfo"
    private Button personalinfo; // Value injected by FXMLLoader

    @FXML // fx:id="doctor"
    private Button doctor; // Value injected by FXMLLoader

    @FXML // fx:id="patient"
    private Button patient; // Value injected by FXMLLoader

    @FXML // fx:id="nurse"
    private Button nurse; // Value injected by FXMLLoader

    @FXML // fx:id="patientlist"
    private Button patientlist; // Value injected by FXMLLoader

    @FXML // fx:id="signup"
    private Button signup; // Value injected by FXMLLoader

    @FXML
    void showSignup(ActionEvent event) {
        Parent mainCallWindowFXML;
        try {
            mainCallWindowFXML = FXMLLoader.load(getClass().getResource("/GUI/personal_info.fxml"));
            Stage stage = (Stage) nurse.getScene().getWindow();
            stage.setScene(new Scene(mainCallWindowFXML));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void showPatientView(ActionEvent event) {
        Parent mainCallWindowFXML;
        try {
            mainCallWindowFXML = FXMLLoader.load(getClass().getResource("/GUI/patient.fxml"));
            Stage stage = (Stage) nurse.getScene().getWindow();
            stage.setScene(new Scene(mainCallWindowFXML));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void showInfoPage(ActionEvent event) {
        Parent mainCallWindowFXML;
        try {
            mainCallWindowFXML = FXMLLoader.load(getClass().getResource("/GUI/personal_info.fxml"));
            Stage stage = (Stage) nurse.getScene().getWindow();
            stage.setScene(new Scene(mainCallWindowFXML));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void showNurseView(ActionEvent event) {
        Parent mainCallWindowFXML;
        try {
            mainCallWindowFXML = FXMLLoader.load(getClass().getResource("/GUI/nurse.fxml"));
            Stage stage = (Stage) nurse.getScene().getWindow();
            stage.setScene(new Scene(mainCallWindowFXML));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void showDocView(ActionEvent event) {
        Parent mainCallWindowFXML;
        try {
            mainCallWindowFXML = FXMLLoader.load(getClass().getResource("/GUI/doctor_view.fxml"));
            Stage stage = (Stage) nurse.getScene().getWindow();
            stage.setScene(new Scene(mainCallWindowFXML));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void showListView(ActionEvent event) {
        Parent mainCallWindowFXML;
        try {
            mainCallWindowFXML = FXMLLoader.load(getClass().getResource("/GUI/patientList.fxml"));
            Stage stage = (Stage) nurse.getScene().getWindow();
            stage.setScene(new Scene(mainCallWindowFXML));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
