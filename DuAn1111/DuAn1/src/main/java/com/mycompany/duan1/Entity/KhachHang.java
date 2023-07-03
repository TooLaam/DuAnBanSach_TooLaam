/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duan1.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;

import java.util.List;


/**
 *
 * @author Admin
 */
@Table
@Entity
public class KhachHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long Id;
    @Column
    private String Ma;
    @Column
    private String Ten;
    @Column
    private String GioiTinh;
    @Column
    private String Email;
    @Column
    private String SDT;
    @Column
    private Date NgayTao;
    @OneToMany(mappedBy = "khachhang", fetch = FetchType.LAZY)
    private List<ThongTinChiTiet> ctkh;
    @OneToMany(mappedBy = "khachhangHD", fetch = FetchType.LAZY)
    private List<HoaDon> danhsachhoadon;
    @ManyToOne
    @JoinColumn(name ="IdCapBac")
    private CapBac capbac;
    
    public KhachHang() {
    }

    public KhachHang(long Id, String Ma, String Ten, String GioiTinh, String Email, String SDT, Date NgayTao, List<ThongTinChiTiet> ctkh, List<HoaDon> danhsachhoadon, CapBac capbac) {
        this.Id = Id;
        this.Ma = Ma;
        this.Ten = Ten;
        this.GioiTinh = GioiTinh;
        this.Email = Email;
        this.SDT = SDT;
        this.NgayTao = NgayTao;
        this.ctkh = ctkh;
        this.danhsachhoadon = danhsachhoadon;
        this.capbac = capbac;
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public List<ThongTinChiTiet> getCtkh() {
        return ctkh;
    }

    public void setCtkh(List<ThongTinChiTiet> ctkh) {
        this.ctkh = ctkh;
    }

    public List<HoaDon> getDanhsachhoadon() {
        return danhsachhoadon;
    }

    public void setDanhsachhoadon(List<HoaDon> danhsachhoadon) {
        this.danhsachhoadon = danhsachhoadon;
    }

    public CapBac getCapbac() {
        return capbac;
    }

    public void setCapbac(CapBac capbac) {
        this.capbac = capbac;
    }

    
}
