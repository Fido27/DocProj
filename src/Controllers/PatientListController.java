package Controllers;

import java.io.File;

import Objects.Patient;
import Objects.USERTYPE;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PatientListController {

    @FXML
    private Button searchButton;

    @FXML
    private TextField patientIDtextField;

    @FXML
    private ListView<Button> patientListView;

    ObservableList<Button> patientList = FXCollections.observableArrayList();
    File[] listingAllFiles;

    public void initialize() {
        File filePath = new File("../Objects/Patients/");
        listingAllFiles = filePath.listFiles();

        for (File file : listingAllFiles) {
            if(file != null) {
                String patientID = file.getName();
                Button temp = new Button(patientID);
                temp.setOnAction(e -> {
                    Patient questionablePatient = new Patient(patientID);
                    questionablePatient.readFromFile();
                    MainController.patientInQuestion = questionablePatient;
                    if (MainController.loggedInUser.getUSERTYPE() == USERTYPE.DOCTOR) {
                        // TODO - do something doctory
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
