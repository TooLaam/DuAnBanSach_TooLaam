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
import java.util.Date;

/**
 *
 * @author Admin
 */
@Entity
@Table
public class LichSuGiaoHang {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long Id;
    
    @Column
    private Date ngayGiaoHang;
    @Column
    private String trangThai;
    @Column
    private String ghiChu;

    @ManyToOne()
    @JoinColumn(name = "idNV")
    private NhanVien nhanvienLSGH;

    @ManyToOne
    @JoinColumn(name = "phieuGiaoHangId")
    private PhieuGiaoHang pghLSGH;

    public LichSuGiaoHang() {
    }

    public LichSuGiaoHang(long Id, Date ngayGiaoHang, String trangThai, String ghiChu, NhanVien nhanvienLSGH, PhieuGiaoHang pghLSGH) {
        this.Id = Id;
        this.ngayGiaoHang = ngayGiaoHang;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
        this.nhanvienLSGH = nhanvienLSGH;
        this.pghLSGH = pghLSGH;
    }

  

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    
    public Date getNgayGiaoHang() {
        return ngayGiaoHang;
    }

    public void setNgayGiaoHang(Date ngayGiaoHang) {
        this.ngayGiaoHang = ngayGiaoHang;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public NhanVien getNhanvien() {
        return nhanvienLSGH;
    }

    public void setNhanvien(NhanVien nhanvien) {
        this.nhanvienLSGH = nhanvien;
    }

    public PhieuGiaoHang getPghLSGH() {
        return pghLSGH;
    }

    public void setPghLSGH(PhieuGiaoHang pghLSGH) {
        this.pghLSGH = pghLSGH;
    }

   
}
