package QLNVPointAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
@Table(name = "Felicitation")

public class Felicitation {
    @Id
    @Column(name = "FELICITATION")
    private int felicitationid;

    @Column(name = "POINT")
    private int point;

    @Column(name = "DATE")
    private java.sql.Date date;

    @Column(name = "NOIDUNG")
    private String noidung;
    
    @Column(name = "NGUOINHAN")
    private int nguoinhan;
    
    @Column(name = "NGUOITANG")
    private int nguoitang;
    
    @Column(name = "VOUCHERID")
    private int voucherid;
    
    // Constructors
    public Felicitation() {
        super();
    }

    public Felicitation(int felicitationID, int point, java.sql.Date date, String noidung, int nguoinhan, int nguoitang, int voucherID) {
        super();
        this.felicitationid = felicitationID;
        this.point = point;
        this.date = date;
        this.noidung = noidung;
        this.nguoinhan = nguoinhan;
        this.nguoitang = nguoitang;
        this.voucherid = voucherID;
    }

    // Getters and Setters
    public int getfelicitationid() {
        return felicitationid;
    }

    public void setfelicitationid(int felicitationID) {
        this.felicitationid = felicitationID;
    }
    
    public int getpoint() {
        return point;
    }

    public void setpoint(int point) {
        this.point = point;
    }
    
    public java.sql.Date getdate() {
        return date;
    }

    public void setdate(java.sql.Date date) {
        this.date = date;
    }
    
    public String getnoidung() {
        return noidung;
    }

    public void setnoidung(String noidung) {
        this.noidung = noidung;
    }
    
    public int getnguoinhan() {
        return nguoinhan;
    }

    public void setnguoinhan(int nguoinhan) {
        this.nguoinhan = nguoinhan;
    }
    
    public int getnguoitang() {
        return nguoinhan;
    }

    public void setnguoitang(int nguoitang) {
        this.nguoitang = nguoinhan;
    }
    
    public int getvoucherid() {
        return voucherid;
    }

    public void setvoucherid(int voucherID) {
        this.voucherid = voucherID;
    }
}