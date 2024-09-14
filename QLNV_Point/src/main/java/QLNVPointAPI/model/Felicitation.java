package QLNVProfileAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
@Table(name = "Felicitation")

public class Felicitation {
    @Column(name = "FELICITATION")
    private int felicitationid;

    @Column(name = "POINT")
    private int point;

    @Column(name = "QUANLYID")
    private int quanlyid;

    @Column(name = "SOTHANHVIEN")
    private int sothanhvien;
}