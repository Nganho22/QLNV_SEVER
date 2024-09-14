package QLNVPointAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
@Table(name = "Felicitation")

public class Felicitation {
    @Id
    @Column(name = "FELICITATIONID")
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
    
    public Felicitation() {
        super();
    }

    public Felicitation(int FelicitationID, int Point, java.sql.Date Date, String Noidung, int Nguoinhan, int Nguoitang, int VoucherID) {
        super();
        this.felicitationid = FelicitationID;
        this.point = Point;
        this.date = Date;
        this.noidung = Noidung;
        this.nguoinhan = Nguoinhan;
        this.nguoitang = Nguoitang;
        this.voucherid = VoucherID;
    }

    // Getters and Setters
    public int getfelicitationid() {
        return felicitationid;
    }

    public void setfelicitationid(int FelicitationID) {
        this.felicitationid = FelicitationID;
    }

    
    public int getpoint() {
        return point;
    }

    public void setpoint(int Point) {
        this.point = Point;
    }
    
    public java.sql.Date getdate() {
        return date;
    }

    public void setdate(java.sql.Date Date) {
        this.date = Date;
    }
    
    public String getnoidung() {
        return noidung;
    }

    public void setnoidung(String Noidung) {
        this.noidung = Noidung;
    }
    
    public int getnguoinhan() {
        return nguoinhan;
    }

    public void setnguoinhan(int Nguoinhan) {
        this.nguoinhan = Nguoinhan;
    }
    
    public int getnguoitang() {
        return nguoinhan;
    }

    public void setnguoitang(int Nguoitang) {
        this.nguoitang = Nguoitang;
    }
    
    public int getvoucherid() {
        return voucherid;
    }

    public void setvoucherid(int VoucherID) {
        this.voucherid = VoucherID;
    }
}