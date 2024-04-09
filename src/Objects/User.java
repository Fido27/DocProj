package Objects;

public class User {
    String ID;
    USERTYPE USERTYPE;

    public User(USERTYPE usertype , String username) {
        this.USERTYPE = usertype;
        this.ID = username;
    }

    protected User(String username) {
        this.USERTYPE = Objects.USERTYPE.PATIENT;
        this.ID = username;
    }

    public USERTYPE getUSERTYPE() {
        return this.USERTYPE;
    }

    public String getUserID() {
        return ID;
    }
}
