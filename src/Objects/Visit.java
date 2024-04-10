package Objects;

public class Visit {
    String notes;
    String date;
    String meds;
    String allergies;

    public Visit(String date , String allergies , String meds , String notes) {
        this.allergies = allergies;
        this.date = date;
        this.meds = meds;
        this.notes = notes;
    }

    public String getMeds() {
        return this.meds;
    }

    public void setMeds(String meds) {
        this.meds = meds;
    }

    public String getAllergies() {
        return this.allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String toString(){
        return ("Date: " + date + "\nAllergies: " + allergies + "\nMedication: " + meds + "\nNotes: " + notes + "\n\n");
    }

    
}
