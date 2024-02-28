package Objects;

enum TYPE {PATIENT, NURSE , DOCTOR}

public class User {
    String ID;
    TYPE TYPE;

    public User(TYPE usertype , String username) {
        this.TYPE = usertype;
        this.ID = username;
    }

    protected User(String username) {
        this.TYPE = Objects.TYPE.PATIENT;
        this.ID = username;
    }

    public String getUserID() {
        return ID;
    }
}