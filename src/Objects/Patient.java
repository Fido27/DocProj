package Objects;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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
    String height;
    String weight;
    String bodyTemp;
    String bloodPressure;
    boolean aboveTwelve;

    public String getFirstName() {
        return this.lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMInitial() {
        return this.mInitial;
    }

    public void setMInitial(String mInitial) {
        this.mInitial = mInitial;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNo() {
        return this.phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAllergies() {
        return this.allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getInsuranceCompany() {
        return this.insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public String getInsuranceNumber() {
        return this.insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public String getEmergencyContact() {
        return this.emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getEmergencyContactName() {
        return this.emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public String getHeight() {
        return this.height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return this.weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBodyTemp() {
        return this.bodyTemp;
    }

    public void setBodyTemp(String bodyTemp) {
        this.bodyTemp = bodyTemp;
    }

    public String getBloodPressure() {
        return this.bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public boolean isAboveTwelve() {
        return this.aboveTwelve;
    }

    public void setAboveTwelve(boolean aboveTwelve) {
        this.aboveTwelve = aboveTwelve;
    }

    public Patient(String username) {
        super(username);
    }

    public void saveToFile() {
        String filePath = "src/Objects/Patients/" + getUserID() + ".txt";
        Path path = Path.of(filePath);
        File file = new File(filePath);
        String text = "" + 
                        firstName + "\n" +
                        mInitial + "\n" + 
                        lastName + "\n" +
                        phoneNo + "\n" +
                        birthDate + "\n" +
                        address + "\n" +
                        allergies + "\n" +
                        insuranceCompany + "\n" +
                        insuranceNumber + "\n" +
                        emergencyContact + "\n" +
                        emergencyContactName + "\n" +
                        height + "\n" +
                        weight + "\n" +
                        bodyTemp + "\n" +
                        bloodPressure + "\n" +
                        aboveTwelve + "\n";

        try {
            file.createNewFile();
            Files.writeString(path, text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // public void readFromFile() {
    //     File filePath = new File("./Patients/");
    //     File[] listingAllFiles = filePath.listFiles();

    //     for (File file : listingAllFiles) {
    //         if(file != null) {
    //             String fileName = file.getName();
    //             this.ID = fileName;

                
                
    //         }
    //     }
    // }

    public void readFromFile(String filePath) {
        try {
			List<String> allLines = Files.readAllLines(Paths.get(filePath));

            setFirstName(allLines.get(0));
            setMInitial(allLines.get(1));
            setLastName(allLines.get(2));
            setPhoneNo(allLines.get(3));
            setBirthDate(allLines.get(4));
            setAddress(allLines.get(5));
            setAllergies(allLines.get(6));
            setInsuranceCompany(allLines.get(7));
            setInsuranceNumber(allLines.get(8));
            setEmergencyContact(allLines.get(9));
            setEmergencyContactName(allLines.get(10));
            setHeight(allLines.get(11));
            setWeight(allLines.get(12));
            setBodyTemp(allLines.get(13));
            setBloodPressure(allLines.get(14));
            if (allLines.get(15).startsWith("f")) setAboveTwelve(false);
            else setAboveTwelve(true);

		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}