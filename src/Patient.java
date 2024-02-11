public class Patient extends User{
    String firstName;
    String mInitial;
    String lastName;
    String phoneNo;
    String birthDate;
    String address;
    String allergies;
    String insuranceCompany;
    String insuranceNumber;
    String emergencyContact;
    String emergencyContactName;
    String gender;
    String height;
    String weight;
    String bodyTemp;
    String bloodPressure;
    boolean aboveTwelve;

    public Patient(User.TYPE usertype, String username, String password) {
        super(usertype, username, password);
        //TODO Auto-generated constructor stub
    }
    
}
