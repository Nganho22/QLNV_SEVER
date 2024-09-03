package QLNVProfileAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
@Table(name = "Profile")
public class Profile {

    @Id
    @Column(name = "EMPID")
    private int empID;

    @Column(name = "PHONGID")
    private String phongID;

    @Column(name = "ROLE")
    private String role;

    @Column(name = "HOTEN")
    private String hoTen;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "TENTAIKHOAN")
    private String tenTaiKhoan;

    @Column(name = "MATKHAU")
    private String matKhau;

    @Column(name = "GIOITINH")
    private String gioiTinh;

    @Column(name = "SODIENTHOAI")
    private String soDienThoai;

    @Column(name = "CCCD")
    private String cccd;

    @Column(name = "STK")
    private String stk;

    @Column(name = "LUONG")
    private Float luong;

    @Column(name = "DIEMTHUONG", columnDefinition = "INT DEFAULT 0")
    private Integer diemThuong;  // Changed to Integer

    @Column(name = "TINHTRANG", columnDefinition = "INT DEFAULT 1")
    private Integer tinhTrang;  // Changed to Integer

    @Column(name = "DIACHI")
    private String diaChi;

    @Column(name = "IMAGE")
    private String image;

    public Profile(String phongID, int empID, String role, String hoTen, String email, String tenTaiKhoan, String matKhau,
                   String gioiTinh, String soDienThoai, String cccd, String stk, Float luong,
                   Integer diemThuong, Integer tinhTrang, String diaChi, String image) {
        this.phongID = phongID;
        this.empID = empID;
        this.role = role;
        this.hoTen = hoTen;
        this.email = email;
        this.tenTaiKhoan = tenTaiKhoan;
        this.matKhau = matKhau;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.cccd = cccd;
        this.stk = stk;
        this.luong = luong;
        this.diemThuong = diemThuong;
        this.tinhTrang = tinhTrang;
        this.diaChi = diaChi;
        this.image = image;
    }

    public Profile() {}

    // Getters and Setters
    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getPhongID() {
        return phongID;
    }

    public void setPhongID(String phongID) {
        this.phongID = phongID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getStk() {
        return stk;
    }

    public void setStk(String stk) {
        this.stk = stk;
    }

    public Float getLuong() {
        return luong;
    }

    public void setLuong(Float luong) {
        this.luong = luong;
    }

    public Integer getDiemThuong() {
        return diemThuong;
    }

    public void setDiemThuong(Integer diemThuong) {
        this.diemThuong = diemThuong;
    }

    public Integer getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(Integer tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
