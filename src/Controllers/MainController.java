package controllers;

import objects.Patient;
import objects.User;

public class MainController {
    static User loggedInUser;
    static Patient patientInQuestion;

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