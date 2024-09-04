package QLNVProfileAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
public class PhongBan {

    @Id
    @Column(name = "PhongID")
    private String phongID;

    @Column(name = "TenPhong")
    private String tenPhong;

    @Column(name = "QuanLyID")
    private int quanLyID;

    @Column(name = "SoThanhVien")
    private int soThanhVien;

    // Constructors, getters, and setters
    public PhongBan() {super();}

    public PhongBan(String phongID, String tenPhong, int quanLyID, int soThanhVien) {
    	super();
        this.phongID = phongID;
        this.tenPhong = tenPhong;
        this.quanLyID = quanLyID;
        this.soThanhVien = soThanhVien;
    }

    public String getPhongID() {
        return phongID;
    }

    public void setPhongID(String phongID) {
        this.phongID = phongID;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public int getQuanLyID() {
        return quanLyID;
    }

    public void setQuanLyID(int quanLyID) {
        this.quanLyID = quanLyID;
    }

    public int getSoThanhVien() {
        return soThanhVien;
    }

    public void setSoThanhVien(int soThanhVien) {
        this.soThanhVien = soThanhVien;
    }
}
