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
    private int EmpID;

    @Column(name = "PHONGID")
    private String PhongID;

    @Column(name = "ROLE")
    private String Role;

    @Column(name = "HOTEN")
    private String HoTen;

    @Column(name = "EMAIL")
    private String Email;

    @Column(name = "TENTAIKHOAN")
    private String TenTaiKhoan;

    @Column(name = "MATKHAU")
    private String MatKhau;

    @Column(name = "GIOITINH")
    private String GioiTinh;

    @Column(name = "SODIENTHOAI")
    private String SoDienThoai;

    @Column(name = "CCCD")
    private String CCCD;

    @Column(name = "STK")
    private String STK;

    @Column(name = "LUONG")
    private Float Luong;

    @Column(name = "DIEMTHUONG", columnDefinition = "INT DEFAULT 0")
    private Integer DiemThuong;  // Changed to Integer

    @Column(name = "TINHTRANG", columnDefinition = "INT DEFAULT 1")
    private Integer TinhTrang;  // Changed to Integer

    @Column(name = "DIACHI")
    private String DiaChi;

    @Column(name = "IMAGE")
    private String Image;
    
    @Column(name = "tenPhong")
    private String TenPhong;
    public Profile(String phongID, int empID, String role, String hoTen, String email, String tenTaiKhoan, String matKhau,
                   String gioiTinh, String soDienThoai, String cccd, String stk, Float luong,
                   Integer diemThuong, Integer tinhTrang, String diaChi, String image, String tenPhong) {
        this.PhongID = phongID;
        this.EmpID = empID;
        this.Role = role;
        this.HoTen = hoTen;
        this.Email = email;
        this.TenTaiKhoan = tenTaiKhoan;
        this.MatKhau = matKhau;
        this.GioiTinh = gioiTinh;
        this.SoDienThoai = soDienThoai;
        this.CCCD = cccd;
        this.STK = stk;
        this.Luong = luong;
        this.DiemThuong = diemThuong;
        this.TinhTrang = tinhTrang;
        this.DiaChi = diaChi;
        this.Image = image;
        this.TenPhong = tenPhong;
    }

    public Profile() {}

    // Getters and Setters
    public int getEmpID() {
        return EmpID;
    }

    public void setEmpID(int empID) {
        this.EmpID = empID;
    }

    public String getPhongID() {
        return PhongID;
    }

    public void setPhongID(String phongID) {
        this.PhongID = phongID;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        this.Role = role;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        this.HoTen = hoTen;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getTenTaiKhoan() {
        return TenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.TenTaiKhoan = tenTaiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        this.MatKhau = matKhau;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.GioiTinh = gioiTinh;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.SoDienThoai = soDienThoai;
    }

    public String getCccd() {
        return CCCD;
    }

    public void setCccd(String cccd) {
        this.CCCD = cccd;
    }

    public String getStk() {
        return STK;
    }

    public void setStk(String stk) {
        this.STK = stk;
    }

    public Float getLuong() {
        return Luong;
    }

    public void setLuong(Float luong) {
        this.Luong = luong;
    }

    public Integer getDiemThuong() {
        return DiemThuong;
    }

    public void setDiemThuong(Integer diemThuong) {
        this.DiemThuong = diemThuong;
    }

    public Integer getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(Integer tinhTrang) {
        this.TinhTrang = tinhTrang;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        this.DiaChi = diaChi;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        this.Image = image;
    }
    
    public String getTenPhong() {
        return TenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.TenPhong = tenPhong;
    }
}
