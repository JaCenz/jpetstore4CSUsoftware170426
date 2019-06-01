package domain;

public class Journal {
    private String userID;
    private String action;
    private String time;

    public Journal(){}

    public String getUserID() {
        return userID;
    }

    public String getAction() {
        return action;
    }

    public String getTime() {
        return time;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
