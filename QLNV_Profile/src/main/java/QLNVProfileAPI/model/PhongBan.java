package QLNVProfileAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
public class PhongBan {

    @Id
    @Column(name = "PHONGID")
    private String phongid;

    @Column(name = "TENPHONG")
    private String tenphong;

    @Column(name = "QUANLYID")
    private int quanlyid;

    @Column(name = "SOTHANHVIEN")
    private int sothanhvien;

    // Constructors, getters, and setters
    public PhongBan() {super();}

    public PhongBan(String phongID, String tenPhong, int quanLyID, int soThanhVien) {
    	super();
        this.phongid = phongID;
        this.tenphong = tenPhong;
        this.quanlyid = quanLyID;
        this.sothanhvien = soThanhVien;
    }

    public String getphongid() {
        return phongid;
    }

    public void setphongid(String phongID) {
        this.phongid = phongID;
    }

    public String gettenphong() {
        return tenphong;
    }

    public void settenphong(String tenPhong) {
        this.tenphong = tenPhong;
    }

    public int getquanlyid() {
        return quanlyid;
    }

    public void setquanlyid(int quanLyID) {
        this.quanlyid = quanLyID;
    }

    public int getsothanhvien() {
        return sothanhvien;
    }

    public void setsothanhvien(int soThanhVien) {
        this.sothanhvien = soThanhVien;
    }
}
