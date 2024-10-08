package QLNVActivityAPI.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Document(collection = "Activity")
public class Activity {

    @Id
    private String _id;

    @Field("ActivityID")
    private int activityID;

    @Field("TenHoatDong")
    private String tenHoatDong;
    @Field("Point")
    private int point;

    @Field("NoiDung")
    private String noiDung;

    @Field("ChiTiet")
    private String chiTiet;

    @Field("SoNguoiThamGia")
    private int soNguoiThamGia;

    @Field("ChiPhi")
    private int chiPhi;

    @Field("HanCuoiDangKy")
    private LocalDate hanCuoiDangKy;

    @Field("NgayBatDau")
    private LocalDate ngayBatDau;

    @Field("NgayKetThuc")
    private LocalDate ngayKetThuc;
    

    @Field("Loai")
    private int loai;

    // Constructor with parameters
    public Activity(int activityID, String tenHoatDong, int point, String noiDung, 
                    String chiTiet, int soNguoiThamGia, int chiPhi, LocalDate hanCuoiDangKy, LocalDate ngayBatDau, LocalDate ngayKetThuc, int loai) {
        this.activityID = activityID;
        this.tenHoatDong = tenHoatDong;

        this.point = point;
        this.noiDung = noiDung;
        this.chiTiet = chiTiet;
        this.soNguoiThamGia = soNguoiThamGia;
        this.chiPhi = chiPhi;
        this.hanCuoiDangKy = hanCuoiDangKy;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.loai = loai;    }


    public Activity() {
    }

    // Getters and Setters
    public int getActivityID() {
        return activityID;
    }

    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    public String getTenHoatDong() {
        return tenHoatDong;
    }

    public void setTenHoatDong(String tenHoatDong) {
        this.tenHoatDong = tenHoatDong;
    }


    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getChiTiet() {
        return chiTiet;
    }

    public void setChiTiet(String chiTiet) {
        this.chiTiet = chiTiet;
    }
    
    public int getLoai() {
        return loai;
    }

    public void setLoai(int loai) {
        this.loai = loai;
    }

    public int getSoNguoiThamGia() {
        return soNguoiThamGia;
    }

    public void setSoNguoiThamGia(int soNguoiThamGia) {
        this.soNguoiThamGia = soNguoiThamGia;
    }

    public int getChiPhi() {
        return chiPhi;
    }

    public void setChiPhi(int chiPhi) {
        this.chiPhi = chiPhi;
    }

    public LocalDate getHanCuoiDangKy() {
        return hanCuoiDangKy;
    }

    public void setHanCuoiDangKy(LocalDate hanCuoiDangKy) {
        this.hanCuoiDangKy = hanCuoiDangKy;
    }

    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public LocalDate getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(LocalDate ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
}
