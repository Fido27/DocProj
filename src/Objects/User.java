package objects;

public class User {
    String ID;
    USERTYPE USERTYPE;

    public User(USERTYPE usertype , String username) {
        this.USERTYPE = usertype;
        this.ID = username;
    }

    protected User(String username) {
        this.USERTYPE = objects.USERTYPE.PATIENT;
        this.ID = username;
    }

    public String getUserID() {
        return ID;
    }
}