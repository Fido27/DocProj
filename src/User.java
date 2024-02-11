public class User {
    enum TYPE {PATIENT, NURSE , DOCTOR}
    String username;
    String password;
    User.TYPE TYPE;

    public User(TYPE usertype , String username , String password) {
        this.TYPE = usertype;
        this.username = username;
        this.password = password;
    }

    protected String getUsername() {

    }

    protected String getPassword() {

    }

}