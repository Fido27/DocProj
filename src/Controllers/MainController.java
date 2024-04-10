package Controllers;

import Objects.Patient;
import Objects.USERTYPE;
import Objects.User;

public class MainController {
    public static User loggedInUser;
    public static Patient patientInQuestion;
    public static USERTYPE userInQuestion;

    public User getLoggedInUser() {
        return MainController.loggedInUser;
    }

    public static void setLoggedInUser(User user) {
        MainController.loggedInUser = user;
    }

    public Patient getPatientInQuestion() {
        return MainController.patientInQuestion;
    }

    public void setPatientInQuestion(Patient patientInQuestion) {
        MainController.patientInQuestion = patientInQuestion;
    }

}

// TODO - Visit Notes
// TODO - err if all texboxes are not filled