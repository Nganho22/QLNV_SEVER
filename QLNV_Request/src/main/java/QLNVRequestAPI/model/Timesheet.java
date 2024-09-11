package QLNVRequestAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.util.Date;

@Entity
//@Table(name = "time_sheet")
public class Timesheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TIME_SHEETID")
    private Integer time_sheetid;

    @Column(name = "PROJECTID")
    private Integer projectid;

    @Column(name = "EMPID")
    private int empid;

    @Column(name = "TENDUAN")
    private String tenduan;

    @Column(name = "NGUOIGUI")
    private String nguoigui;

    @Column(name = "PHONGBAN")
    private String phongban;

    @Column(name = "TRANGTHAI")
    private String trangthai;

    @Column(name = "SOGIOTHUCHIEN")
    private int sogiothuchien;

    @Column(name = "NGAYGIAO")
    private Date ngaygiao;

    @Column(name = "HANCHOT")
    private Date hanchot;

    @Column(name = "DIEMTHUONG")
    private int diemthuong;

    @Column(name = "TRE")
    private int tre;

    @Column(name = "NOIDUNG")
    private String noidung;

public Timesheet() {super();}
	
	public Timesheet (Integer timeSheetId, Integer projectId, int empId, String tenDuAn, String nguoiGui, 
					java.sql.Date ngayGiao,	java.sql.Date hanChot, String phongBan, String trangThai, int soGioThucHien,
					int Up_TidiemThuongnhTrang_Timesheet, int tre, String noiDung) {
		super();
		this.time_sheetid = timeSheetId;
		this.projectid = projectId;
		this.empid = empId;
		this.tenduan = tenDuAn;
		this.nguoigui = nguoiGui;
		this.ngaygiao = ngayGiao;
		this.hanchot = hanChot;
		this.phongban = phongBan;
		this.trangthai = trangThai;
		this.sogiothuchien = soGioThucHien;
		this.diemthuong = Up_TidiemThuongnhTrang_Timesheet;
		this.tre = tre;
		this.noidung = noiDung;
	}
	
    // Getters and Setters

    public Integer gettimesheetid() {
        return time_sheetid;
    }

    public void settimesheetid(Integer timeSheetId) {
        this.time_sheetid = timeSheetId;
    }

    public Integer getprojectid() {
        return projectid;
    }

    public void setprojectid(Integer projectId) {
        this.projectid = projectId;
    }

    public int getempid() {
        return empid;
    }

    public void setempid(int empId) {
        this.empid = empId;
    }

    public String gettenduan() {
        return tenduan;
    }

    public void settenduan(String tenDuAn) {
        this.tenduan = tenDuAn;
    }

    public String getnguoigui() {
        return nguoigui;
    }

    public void setnguoigui(String nguoiGui) {
        this.nguoigui = nguoiGui;
    }

    public String getPhongBan() {
        return phongban;
    }

    public void setPhongBan(String phongBan) {
        this.phongban = phongBan;
    }

    public String getTrangThai() {
        return trangthai;
    }

    public void setTrangThai(String trangThai) {
        this.trangthai = trangThai;
    }

    public int getsogiothuchien() {
        return sogiothuchien;
    }

    public void setsogiothuchien(int soGioThucHien) {
        this.sogiothuchien = soGioThucHien;
    }

    public Date getngaygiao() {
        return ngaygiao;
    }

    public void setngaygiao(Date ngayGiao) {
        this.ngaygiao = ngayGiao;
    }

    public Date gethanchot() {
        return hanchot;
    }

    public void sethanchot(Date hanChot) {
        this.hanchot = hanChot;
    }

    public int getdiemthuong() {
        return diemthuong;
    }

    public void setdiemthuong(int diemThuong) {
        this.diemthuong = diemThuong;
    }

    public int gettre() {
        return tre;
    }

    public void settre(int tre) {
        this.tre = tre;
    }

    public String getnoidung() {
        return noidung;
    }

    public void setnoidung(String noiDung) {
        this.noidung = noiDung;
    }
}
