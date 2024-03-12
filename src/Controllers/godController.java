package Controllers;

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
        // try {
        //     Parent root = FXMLLoader.load(getClass().getResource("./GUI/nurse.fxml"));
        //     Scene scene = new Scene(root);
        //     stage.setScene(scene);
        //     stage.show();
        
        // } catch(Exception e) {
        //     e.printStackTrace();
        // }
    }

    @FXML
    void showPatientView(ActionEvent event) {
        //   try
        // {
        //     FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginScreen.fxml"));
        //     Parent root = (Parent)fxmlLoader.load();
        //     LoginScreenController loginScreenController = fxmlLoader.<LoginScreenController>getController();
        //     loginScreenController.setHashMap(usersInfo);
        //     Scene scene = new Scene(root);
        //     Stage stage = new Stage();
        //     stage.setTitle("Login Screen");
        //     stage.setScene(scene);
        //     stage.show();            
            
        //     ((Node)(event.getSource())).getScene().getWindow().hide(); //close current window after opening new Scene           
        // }
        // catch (IOException ex)
        // {
        //     Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        // }
    }

    @FXML
    void showInfoPage(ActionEvent event) {

    }

    @FXML
    void showNurseView(ActionEvent event) {
        Parent mainCallWindowFXML;
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        try {
            mainCallWindowFXML = FXMLLoader.load(getClass().getResource("/Users/fido/Documents/ASU/Spring 2024/CSE 360/DocProj/src/GUI/nurse.fxml"));
            System.out.println("Working Directory = " + System.getProperty("user.dir"));
            Stage stage = (Stage) personalinfo.getScene().getWindow();
            stage.setScene(new Scene(mainCallWindowFXML));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void showDocView(ActionEvent event) {

    }

    @FXML
    void showListView(ActionEvent event) {

    }

}
