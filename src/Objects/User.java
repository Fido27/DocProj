package Objects;
public class User {
    static enum TYPE {PATIENT, NURSE , DOCTOR}
    String username;
    User.TYPE TYPE;

    public User(TYPE usertype , String username) {
        this.TYPE = usertype;
        this.username = username;
    }

    public User(String username) {
        this.TYPE = TYPE.PATIENT;
        this.username = username;
    }

    protected String getUsername() {
        return username;
    }
}