package Objects;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import Controllers.MainController;

public class Employee extends User{

    String firstName;
	String lastName;
	String phoneNo;
	String birthDate;
	String email;

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    public Employee(String username) {
        super(MainController.userInQuestion , username);
    }

	public void saveToFile() {
        String filePath = "src/Data/Auth/" + "deadbeef" + ".txt";
		if (MainController.userInQuestion.equals(Objects.USERTYPE.DOCTOR))
			filePath = "src/Data/Docs/" + getUserID() + ".txt";
		else 
			filePath = "src/Data/Nurse/" + getUserID() + ".txt";
        Path path = Path.of(filePath);
        File file = new File(filePath);
        String text = "" + 
                        firstName + "\n" +
                        lastName + "\n" +
                        phoneNo + "\n" +
                        email + "\n" +
                        birthDate + "\n";

        try {
            file.createNewFile();
            Files.writeString(path, text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
}