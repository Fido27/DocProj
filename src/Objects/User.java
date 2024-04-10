package Objects;

public class User {
    String ID;
    USERTYPE USERTYPE;

    public User() {}

    public User(USERTYPE usertype , String id) {
        this.USERTYPE = usertype;
        this.ID = id;
    }

    public USERTYPE getUSERTYPE() {
        return this.USERTYPE;
    }

    public String getUserID() {
        return ID;
    }
}
