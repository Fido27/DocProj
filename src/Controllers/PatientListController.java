package Controllers;

import java.io.File;
import java.io.IOException;

import Objects.Patient;
import Objects.USERTYPE;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PatientListController {

    @FXML
    private Button searchButton;

    @FXML
    private TextField patientIDtextField;

    @FXML
    private ListView<Button> patientListView;

    ObservableList<Button> patientList = FXCollections.observableArrayList();
    File[] listingAllFiles;

    @FXML
    public void initialize() {
        File filePath = new File("src/Data/Patients/");
        listingAllFiles = filePath.listFiles();

        for (File file : listingAllFiles) {
            if(file != null) {
                if (file.getName().length() > 16) {
                    continue;
                }
                String patientID = file.getName().substring(0,10);
                Button temp = new Button(patientID);
                temp.setOnAction(event -> {
                    Patient questionablePatient = new Patient(patientID);
                    MainController.patientInQuestion = questionablePatient;
                    Parent mainCallWindowFXML;
                    try {
                        if (MainController.userInQuestion.equals(USERTYPE.NURSE))
                            mainCallWindowFXML = FXMLLoader.load(getClass().getResource("/GUI/nurse.fxml"));
                        else 
                            mainCallWindowFXML = FXMLLoader.load(getClass().getResource("/GUI/docview.fxml"));

                        Stage stage = (Stage) patientListView.getScene().getWindow();
                        stage.setScene(new Scene(mainCallWindowFXML));
                        stage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                patientList.add(temp);
            }
        }
        patientListView.setItems(patientList);
    }


    @FXML
    void searchFunc(ActionEvent event) {
        
    }

}
