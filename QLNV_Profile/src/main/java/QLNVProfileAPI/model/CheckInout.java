package QLNVProfileAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class CheckInout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STT")
    private int stt;

    @Column(name = "EMPID")
    private int empid;

    @Column(name = "DATE_CHECKIN")
    private java.sql.Date datecheckin;

    @Column(name = "TIME_CHECKIN")
    private java.sql.Time timecheckin;

    @Column(name = "TIME_CHECKOUT")
    private java.sql.Time timecheckout;

    @Column(name = "OVERTIME")
    private Integer overtime;

    @Column(name = "LATE")
    private Integer late;

    @Column(name = "WORKFROMHOME")
    private Integer workfromhome;

    @Column(name = "NGHI")
    private Integer nghi;

    // Constructors
    public CheckInout() {
        super();
    }

    public CheckInout(int stt, int empID, java.sql.Date dateCheckin, java.sql.Time timeCheckin,
                      java.sql.Time timeCheckout, Integer overtime, Integer late,
                      Integer workFromHome, Integer nghi) {
        super();
        this.stt = stt;
        this.empid = empID;
        this.datecheckin = dateCheckin;
        this.timecheckin = timeCheckin;
        this.timecheckout = timeCheckout;
        this.overtime = overtime;
        this.late = late;
        this.workfromhome = workFromHome;
        this.nghi = nghi;
    }

    // Getters and Setters
    public int getstt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public int getEmpID() {
        return empid;
    }

    public void setEmpID(int empID) {
        this.empid = empID;
    }

    public java.sql.Date getDateCheckin() {
        return datecheckin;
    }

    public void setDateCheckin(java.sql.Date dateCheckin) {
        this.datecheckin = dateCheckin;
    }

    public java.sql.Time getTimeCheckin() {
        return timecheckin;
    }

    public void setTimeCheckin(java.sql.Time timeCheckin) {
        this.timecheckin = timeCheckin;
    }

    public java.sql.Time getTimeCheckout() {
        return timecheckout;
    }

    public void setTimeCheckout(java.sql.Time timeCheckout) {
        this.timecheckout = timeCheckout;
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
        return workfromhome;
    }

    public void setWorkFromHome(Integer workFromHome) {
        this.workfromhome = workFromHome;
    }

    public Integer getNghi() {
        return nghi;
    }

    public void setNghi(Integer nghi) {
        this.nghi = nghi;
    }
}
