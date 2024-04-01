package objects;

public class Message {
    String time;
    String sender;
    String content;

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSender() {
        return this.sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String toString(){
        return ("Sender: " + sender + "\nTime: " + time + "\nContent: " + content);
    }
}
