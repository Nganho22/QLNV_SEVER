package QLNVProfileAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
@Table(name = "Felicitation")
public class Felicitation {
    @Column(name = "PHONGID")
    private String phongid;

    @Column(name = "TENPHONG")
    private String tenphong;

    @Column(name = "QUANLYID")
    private int quanlyid;

    @Column(name = "SOTHANHVIEN")
    private int sothanhvien;
}