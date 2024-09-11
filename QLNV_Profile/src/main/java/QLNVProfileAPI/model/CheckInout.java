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

    public void setstt(int stt) {
        this.stt = stt;
    }

    public int getempid() {
        return empid;
    }

    public void setempid(int empID) {
        this.empid = empID;
    }

    public java.sql.Date getdatecheckin() {
        return datecheckin;
    }

    public void setdatecheckin(java.sql.Date dateCheckin) {
        this.datecheckin = dateCheckin;
    }

    public java.sql.Time gettimecheckin() {
        return timecheckin;
    }

    public void settimecheckin(java.sql.Time timeCheckin) {
        this.timecheckin = timeCheckin;
    }

    public java.sql.Time gettimecheckout() {
        return timecheckout;
    }

    public void settimecheckout(java.sql.Time timeCheckout) {
        this.timecheckout = timeCheckout;
    }

    public Integer getovertime() {
        return overtime;
    }

    public void setovertime(Integer overtime) {
        this.overtime = overtime;
    }

    public Integer getLate() {
        return late;
    }

    public void setlate(Integer late) {
        this.late = late;
    }

    public Integer getworkfromhome() {
        return workfromhome;
    }

    public void setworkfromhome(Integer workFromHome) {
        this.workfromhome = workFromHome;
    }

    public Integer getnghi() {
        return nghi;
    }

    public void setnghi(Integer nghi) {
        this.nghi = nghi;
    }
}
