package QLNVPointAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer voucherid;
    private String tenvoucher;
    private int trigia;
    private java.sql.Date hansudung;
    private String chitiet;
    private String huongdansudung;
    private String tinhtrang;
    
    public Voucher(Integer voucherID, String tenVoucher, int triGia, java.sql.Date hanSuDung, 
    				String chiTiet, String huongDanSuDung, String tinhTrang) {
    	this.voucherid = voucherID;
    }

}
