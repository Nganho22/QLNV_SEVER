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
    private int empid;

    @Column(name = "PHONGID")
    private String phongid;

    @Column(name = "ROLE")
    private String role;

    @Column(name = "HOTEN")
    private String hoten;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "TENTAIKHOAN")
    private String tentaikhoan;

    @Column(name = "MATKHAU")
    private String matkhau;

    @Column(name = "GIOITINH")
    private String gioitinh;

    @Column(name = "SODIENTHOAI")
    private String sodienthoai;

    @Column(name = "CCCD")
    private String cccd;

    @Column(name = "STK")
    private String stk;

    @Column(name = "LUONG")
    private Float luong;

    @Column(name = "DIEMTHUONG", columnDefinition = "INT DEFAULT 0")
    private Integer diemthuong;  // Changed to Integer

    @Column(name = "TINHTRANG", columnDefinition = "INT DEFAULT 1")
    private Integer tinhtrang;  // Changed to Integer

    @Column(name = "DIACHI")
    private String diachi;

    @Column(name = "IMAGE")
    private String image;
    
    private String tenphong;
    public Profile(String phongID, int empID, String role, String hoTen, String email, String tenTaiKhoan, String matKhau,
                   String gioiTinh, String soDienThoai, String cccd, String stk, Float luong,
                   Integer diemThuong, Integer tinhTrang, String diaChi, String image, String tenPhong) {
        this.phongid = phongID;
        this.empid = empID;
        this.role = role;
        this.hoten = hoTen;
        this.email = email;
        this.tentaikhoan = tenTaiKhoan;
        this.matkhau = matKhau;
        this.gioitinh = gioiTinh;
        this.sodienthoai = soDienThoai;
        this.cccd = cccd;
        this.stk = stk;
        this.luong = luong;
        this.diemthuong = diemThuong;
        this.tinhtrang = tinhTrang;
        this.diachi = diaChi;
        this.image = image;
        this.tenphong = tenPhong;
    }

    public Profile() {}

    // Getters and Setters
    public int getempid() {
        return empid;
    }

    public void setempid(int empID) {
        this.empid = empID;
    }

    public String getphongid() {
        return phongid;
    }

    public void setphongid(String phongID) {
        this.phongid = phongID;
    }

    public String getrole() {
        return role;
    }

    public void setrole(String role) {
        this.role = role;
    }

    public String gethoten() {
        return hoten;
    }

    public void sethoten(String hoTen) {
        this.hoten = hoTen;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String gettentaikhoan() {
        return tentaikhoan;
    }

    public void settentaikhoan(String tenTaiKhoan) {
        this.tentaikhoan = tenTaiKhoan;
    }

    public String getmatkhau() {
        return matkhau;
    }

    public void setmatkhau(String matKhau) {
        this.matkhau = matKhau;
    }

    public String getgioitinh() {
        return gioitinh;
    }

    public void setgioitinh(String gioiTinh) {
        this.gioitinh = gioiTinh;
    }

    public String getsodienthoai() {
        return sodienthoai;
    }

    public void setsodienthoai(String soDienThoai) {
        this.sodienthoai = soDienThoai;
    }

    public String getcccd() {
        return cccd;
    }

    public void setcccd(String cccd) {
        this.cccd = cccd;
    }

    public String getstk() {
        return stk;
    }

    public void setstk(String stk) {
        this.stk = stk;
    }

    public Float getluong() {
        return luong;
    }

    public void setluong(Float luong) {
        this.luong = luong;
    }

    public Integer getdiemthuong() {
        return diemthuong;
    }

    public void setdiemthuong(Integer diemThuong) {
        this.diemthuong = diemThuong;
    }

    public Integer gettinhtrang() {
        return tinhtrang;
    }

    public void settinhtrang(Integer tinhTrang) {
        this.tinhtrang = tinhTrang;
    }

    public String getdiachi() {
        return diachi;
    }

    public void setdiachi(String diaChi) {
        this.diachi = diaChi;
    }

    public String getimage() {
        return image;
    }

    public void setimage(String image) {
        this.image = image;
    }
    
    public String gettenphong() {
        return tenphong;
    }

    public void settenphong(String tenPhong) {
        this.tenphong = tenPhong;
    }
}
