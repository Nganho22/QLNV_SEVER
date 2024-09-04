package QLNVProfileAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "Check_inout")
public class CheckInout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STT")
    private Integer stt;

    @Column(name = "EmpID")
    private Integer empID;

    @Column(name = "Date_checkin")
    private java.sql.Date dateCheckin;

    @Column(name = "Time_checkin")
    private java.sql.Time timeCheckin;

    @Column(name = "Time_checkout")
    private java.sql.Time timeCheckout;

    @Column(name = "Overtime")
    private Integer overtime;

    @Column(name = "Late")
    private Integer late;

    @Column(name = "WorkFromHome")
    private Integer workFromHome;

    @Column(name = "Nghi")
    private Integer nghi;

    // Constructors
    public CheckInout() {
        super();
    }

    public CheckInout(Integer stt, Integer empID, java.sql.Date dateCheckin, java.sql.Time timeCheckin,
                      java.sql.Time timeCheckout, Integer overtime, Integer late,
                      Integer workFromHome, Integer nghi) {
        super();
        this.stt = stt;
        this.empID = empID;
        this.dateCheckin = dateCheckin;
        this.timeCheckin = timeCheckin;
        this.timeCheckout = timeCheckout;
        this.overtime = overtime;
        this.late = late;
        this.workFromHome = workFromHome;
        this.nghi = nghi;
    }

    // Getters and Setters
    public Integer getStt() {
        return stt;
    }

    public void setStt(Integer stt) {
        this.stt = stt;
    }

    public Integer getEmpID() {
        return empID;
    }

    public void setEmpID(Integer empID) {
        this.empID = empID;
    }

    public java.sql.Date getDateCheckin() {
        return dateCheckin;
    }

    public void setDateCheckin(java.sql.Date dateCheckin) {
        this.dateCheckin = dateCheckin;
    }

    public java.sql.Time getTimeCheckin() {
        return timeCheckin;
    }

    public void setTimeCheckin(java.sql.Time timeCheckin) {
        this.timeCheckin = timeCheckin;
    }

    public java.sql.Time getTimeCheckout() {
        return timeCheckout;
    }

    public void setTimeCheckout(java.sql.Time timeCheckout) {
        this.timeCheckout = timeCheckout;
    }

    public Integer getOvertime() {
        return overtime;
    }

    public void setOvertime(Integer overtime) {
        this.overtime = overtime;
    }

    public Integer getLate() {
        return late;
    }

    public void setLate(Integer late) {
        this.late = late;
    }

    public Integer getWorkFromHome() {
        return workFromHome;
    }

    public void setWorkFromHome(Integer workFromHome) {
        this.workFromHome = workFromHome;
    }

    public Integer getNghi() {
        return nghi;
    }

    public void setNghi(Integer nghi) {
        this.nghi = nghi;
    }
}
