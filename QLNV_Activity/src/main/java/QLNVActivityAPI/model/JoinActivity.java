package QLNVActivityAPI.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Document(collection = "JoinActivity")
public class JoinActivity {

    @Id
    private String _id;

    @Field("ActivityID")
    private int activityID;

    @Field("EmployeeID")
    private int employeeID;

    @Field("DateJoin")
    private LocalDate dateJoin;
    
    private Activity activity;


    // Constructor with parameters
    public JoinActivity(int activityID, int employeeID, LocalDate dateJoin) {
        this.activityID = activityID;
        this.employeeID = employeeID;
        this.dateJoin = dateJoin;
    }

    // Default constructor
    public JoinActivity() {
    }

    // Getters and Setters
    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public int getActivityID() {
        return activityID;
    }

    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public LocalDate getDateJoin() {
        return dateJoin;
    }

    public void setDateJoin(LocalDate dateJoin) {
        this.dateJoin = dateJoin;
    }
}
