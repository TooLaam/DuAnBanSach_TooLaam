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
@Table
@Entity
public class ThongTinChiTiet {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column
    private String SDT;
    @Column
    private String DiaChi;
    @Column
    private Date NgayTao;
    @Column
    private String ThanhPho;
    @Column
    private int is_primary;
    @ManyToOne
    @JoinColumn(name = "IdKhachHang")
    private KhachHang khachhang;

    public ThongTinChiTiet() {
    }

    public ThongTinChiTiet(long Id, String SDT, String DiaChi, Date NgayTao, String ThanhPho, int is_primary, KhachHang khachhang) {
        this.Id = Id;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
        this.NgayTao = NgayTao;
        this.ThanhPho = ThanhPho;
        this.is_primary = is_primary;
        this.khachhang = khachhang;
    }
    
    public ThongTinChiTiet(long Id, String SDT, String DiaChi, Date NgayTao,  String ThanhPho) {
        this.Id = Id;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
        this.NgayTao = NgayTao;
       
        this.ThanhPho = ThanhPho;
    }

    public int getIs_primary() {
        return is_primary;
    }

    public void setIs_primary(int is_primary) {
        this.is_primary = is_primary;
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public String getThanhPho() {
        return ThanhPho;
    }

    public void setThanhPho(String ThanhPho) {
        this.ThanhPho = ThanhPho;
    }

    public KhachHang getKhachhang() {
        return khachhang;
    }

    public void setKhachhang(KhachHang khachhang) {
        this.khachhang = khachhang;
    }

}
