package Controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Objects.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MessagePortal {

    @FXML // fx:id="message"
    private TextField message; // Value injected by FXMLLoader

    @FXML // fx:id="messageBox"
    private TextArea messageBox; // Value injected by FXMLLoader

    String filePath = "src/Data/Patients/" + MainController.patientInQuestion.getUserID() + "_messages.txt";
    File file = new File(filePath);
    Path path = Path.of(filePath);
    String text = "";

    @FXML
	public void initialize() {

        MainController.patientInQuestion.readConversation();

        for (int i = 0; i < MainController.patientInQuestion.conversation.size(); i++) {
            text += MainController.patientInQuestion.conversation.get(i).toString();
        }

        messageBox.setText(text);
	}

    @FXML
    void sendPressed(ActionEvent event) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");  
        LocalDateTime now = LocalDateTime.now();  
     
        Message m = new Message(dtf.format(now) , MainController.loggedInUser.getUserID() , message.getText());
        text = m.toString() + text;
        
        try {
            file.createNewFile();
            Files.writeString(path, text);
            MainController.patientInQuestion.conversation.clear();
            text = "";
            message.clear();
            initialize();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
