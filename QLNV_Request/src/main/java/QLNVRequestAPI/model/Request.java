package QLNVRequestAPI.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Request")
public class Request {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REQUESTID")
	private Integer requestid;
	
	@Column(name = "EMPID")
	private int empid;
	
	@Column(name = "NGUOIGUI")
	private String nguoigui;
	
	@Column(name = "LOAI")
	private String loai;
	
	@Column(name = "TIEUDE")
	private String tieude;
	
	@Column(name = "NGAYGUI")
	private java.sql.Date ngaygui;
	
	@Column(name = "NGAYXULY")
	private java.sql.Date ngayxuly;
	
	@Column(name = "NGAYCHON")
	private java.sql.Date ngaychon;
	
	@Column(name = "TRANGTHAI", columnDefinition = "INT DEFAULT 0")
	private Integer trangthai;
	
	@Column(name = "NOIDUNG")
	private String noidung;
	
	@Column(name = "PHANHOI")
	private String phanhoi;
	
	@Column(name = "TIME_SHEETID")
	private Integer time_sheetid;
	
	@Column(name = "UP_TINHTRANG_TIMESHEET")
	private String up_tinhtrang_timesheet;
	
	@Column(name = "UP_THOIGIAN_TIMESHEET")
	private Integer up_thoigian_timesheet;

	public Request() {super();}
	
	public Request (Integer RequestID, int EmpID, String NguoiGui, String Loai, String TieuDe, 
					java.sql.Date NgayGui, java.sql.Date NgayXuLy, java.sql.Date NgayChon,
					Integer TrangThai, String NoiDung, String PhanHoi, Integer Time_sheetID,
					String Up_TinhTrang_Timesheet, Integer Up_ThoiGian_Timesheet) {
		super();
		this.requestid = RequestID;
		this.empid = EmpID;
		this.nguoigui = NguoiGui;
		this.loai = Loai;
		this.tieude = TieuDe;
		this.ngaygui = NgayGui;
		this.ngayxuly = NgayXuLy;
		this.ngaychon = NgayChon;
		this.trangthai = TrangThai;
		this.noidung = NoiDung;
		this.phanhoi = PhanHoi;
		this.time_sheetid = Time_sheetID;
		this.up_tinhtrang_timesheet = Up_TinhTrang_Timesheet;
		this.up_thoigian_timesheet = Up_ThoiGian_Timesheet;
	}

    // Getters and Setters
	public Integer getrequestid() {
		return requestid;
	}
	
    public void setrequestid(Integer requestID) {
    	this.requestid = requestID;
    }

    public int getempid() {
        return empid;
    }

    public void setempid(int empID) {
    	this.empid = empID;
    }

    public String getnguoigui() {
        return nguoigui;
    }

    public void setnguoigui(String nguoiGui) {
    	this.nguoigui = nguoiGui;
    }

    public String getloai() {
        return loai;
    }

    public void setloai(String loai) {
        this.loai = loai;
    }

    public String gettieude() {
        return tieude;
    }

    public void settieude(String tieuDe) {
    	this.tieude = tieuDe;
    }

    public java.sql.Date getngaygui() {
        return ngaygui;
    }

    public void setngaygui(java.sql.Date ngayGui) {
    	this.ngaygui = ngayGui;
    }

    public java.sql.Date getngayxuly() {
        return ngayxuly;
    }

    public void setngayxuly(java.sql.Date ngayXuLy) {
    	this.ngayxuly = ngayXuLy;
    }

    public java.sql.Date getngaychon() {
        return ngaychon;
    }

    public void setngaychon(java.sql.Date ngayChon) {
    	this.ngaychon = ngayChon;
    }

    public Integer gettrangthai() {
        return trangthai;
    }

    public void settrangthai(Integer trangThai) {
    	this.trangthai = trangThai;
    }

    public String getnoidung() {
        return noidung;
    }

    public void setnoidung(String noiDung) {
    	this.noidung = noiDung;
    }

    public String getphanhoi() {
        return phanhoi;
    }

    public void setphanhoi(String phanHoi) {
    	this.phanhoi = phanHoi;
    }

    public Integer gettime_sheetid() {
        return time_sheetid;
    }

    public void settime_sheetid(Integer time_sheetID) {
    	this.time_sheetid = time_sheetID;
    }

    public String getup_tinhtrang_timesheet() {
        return up_tinhtrang_timesheet;
    }

    public void setup_tinhtrang_timesheet(String up_TinhTrang_Timesheet) {
    	this.up_tinhtrang_timesheet = up_TinhTrang_Timesheet;
    }

    public Integer getup_thoigian_timesheet() {
        return up_thoigian_timesheet;
    }

    public void setup_thoigian_timesheet(Integer up_ThoiGian_Timesheet) {
    	this.up_thoigian_timesheet = up_ThoiGian_Timesheet;
    }
}
