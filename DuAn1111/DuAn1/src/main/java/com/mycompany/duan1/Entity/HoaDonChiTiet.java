/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duan1.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author Admin
 */
@Table
@Entity

public class HoaDonChiTiet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long Id;

    @Column
    private int SoLuong;

//    long IdHoaDon;
    @ManyToOne()
    @JoinColumn(name = "IdHoaDon")
    private HoaDon hoadonCTHD;

//    long IdCTSach;
    @ManyToOne()
    @JoinColumn(name = "IdCTSach")
    private CTSach ctsach;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(long Id, int SoLuong, HoaDon hoadonCTHD, CTSach ctsach) {
        this.Id = Id;
        this.SoLuong = SoLuong;
        this.hoadonCTHD = hoadonCTHD;
        this.ctsach = ctsach;
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public HoaDon getHoadon() {
        return hoadonCTHD;
    }

    public void setHoadon(HoaDon hoadonCTHD) {
        this.hoadonCTHD = hoadonCTHD;
    }

    public CTSach getCtsach() {
        return ctsach;
    }

    public void setCtsach(CTSach ctsach) {
        this.ctsach = ctsach;
    }

}
