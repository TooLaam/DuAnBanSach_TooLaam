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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 *
 * @a uthor Admin
 */
@Table
@Entity
public class DotKhuyenMai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    long Id;
    @Column

    long idNV;
    @Column

    String Ma;
    @Column

    String Ten;
    @Column

    double PhanTramKM;
    @Column

    Date NgayBatDau;
    @Column

    Date NgayKetThuc;
    @Column

    String TrangThai;
    @Column

    Date NgayTao;
    
    @OneToMany(mappedBy = "dotkhuyenmai")
    private List<HoaDon> listHoaDon;

    public DotKhuyenMai() {
    }

    public DotKhuyenMai(long Id, long idNV, String Ma, String Ten, double PhanTramKM, Date NgayBatDau, Date NgayKetThuc, String TrangThai, Date NgayTao) {
        this.Id = Id;
        this.idNV = idNV;
        this.Ma = Ma;
        this.Ten = Ten;
        this.PhanTramKM = PhanTramKM;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
        this.TrangThai = TrangThai;
        this.NgayTao = NgayTao;
    }

    public DotKhuyenMai(long Id, long idNV, String Ma, String Ten, double PhanTramKM, Date NgayBatDau, Date NgayKetThuc, String TrangThai, Date NgayTao, List<HoaDon> listHoaDon) {
        this.Id = Id;
        this.idNV = idNV;
        this.Ma = Ma;
        this.Ten = Ten;
        this.PhanTramKM = PhanTramKM;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
        this.TrangThai = TrangThai;
        this.NgayTao = NgayTao;
        this.listHoaDon = listHoaDon;
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public long getIdNV() {
        return idNV;
    }

    public void setIdNV(long idNV) {
        this.idNV = idNV;
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

    public double getPhanTramKM() {
        return PhanTramKM;
    }

    public void setPhanTramKM(double PhanTramKM) {
        this.PhanTramKM = PhanTramKM;
    }

    public Date getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(Date NgayBatDau) {
        this.NgayBatDau = NgayBatDau;
    }

    public Date getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(Date NgayKetThuc) {
        this.NgayKetThuc = NgayKetThuc;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public List<HoaDon> getListHoaDon() {
        return listHoaDon;
    }

    public void setListHoaDon(List<HoaDon> listHoaDon) {
        this.listHoaDon = listHoaDon;
    }

}
