package Objects;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import Controllers.MainController;

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
    public ArrayList<Message> conversation = new ArrayList<>();
    public ArrayList<Visit> visitSummaries = new ArrayList<>();
    String prescription;

    public String getFirstName() {
        return this.firstName;
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
        super(Objects.USERTYPE.PATIENT , username);
        try {
            readFromFile();
        } catch (Exception e) {
            System.out.println("No data found");
        }
    }

    public void sendMessage(String content) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");  
        LocalDateTime now = LocalDateTime.now();  
     
        Message m = new Message(dtf.format(now) , MainController.loggedInUser.getUserID() , content);
        conversation.add(m);
        String text = m.toString();
    }

    public void saveToFile() {
        String filePath = "src/Data/Patients/" + getUserID() + ".txt";
        System.out.println("this worked");
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
                        // TODO - add conversation

        try {
            file.createNewFile();
            file = new File("src/Data/Patients/" + getUserID() + "_visits.txt");
            file.createNewFile();
            Files.writeString(path, text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromFile() {
        try {
            String filePath = "src/Data/Patients/" + getUserID() + ".txt";
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

    public void readVisits() {
        try {
            String filePath = "src/Data/Patients/" + getUserID() + "_visits.txt";
            List<String> allLines = Files.readAllLines(Paths.get(filePath));
        
            String date;
            String allergies;
            String meds;
            String notes;
        
            Visit v;
        
            
            for (int i = 0 ; i <= allLines.size() - 2; i++) {
                date = allLines.get(i++).substring(5);
                allergies = allLines.get(i++).substring(11);
                meds = allLines.get(i++).substring(12);
                notes = allLines.get(i++).substring(7);
                v = new Visit(date, allergies, meds, notes);
                visitSummaries.add(v);
            }
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readConversation() {
        try {
            String filePath = "src/Data/Patients/" + getUserID() + "_messages.txt";
            List<String> allLines = Files.readAllLines(Paths.get(filePath));
        
            String time;
            String sender;
            String content;
        
            
            for (int i = 0 ; i <= allLines.size() - 2; i++) {
                sender = allLines.get(i++).substring(8);
                time = allLines.get(i++).substring(6);
                content = allLines.get(i++).substring(9);
                Message m = new Message(time, sender, content);
                conversation.add(m);
            }
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}