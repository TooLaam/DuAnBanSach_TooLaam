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
public class PhieuGiaoHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String sdtNguoiNhan;
    @Column
    private String diaChiNguoiNhan;
    @Column
    private Date ngayTaoPhieu;
    @Column
    private String ghiChu;
    @Column
    private double tienCuoc;

    @ManyToOne
    @JoinColumn(name = "idNV")
    private NhanVien nhanvien;
    @ManyToOne
    @JoinColumn(name = "idTrangThai")
    private TrangThaiPhieuGiaoHang trangthaiPGH;

    @ManyToOne
    @JoinColumn(name = "hoaDonId")
    private HoaDon hoadon;

    @OneToMany(mappedBy = "pghLSGH")
    private List<LichSuGiaoHang> listLSGH;

    @OneToMany(mappedBy = "pghLSCNTT")
    private List<LichSuCapNhatTrangThai> listLSCNTT;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSdtNguoiNhan() {
        return sdtNguoiNhan;
    }

    public void setSdtNguoiNhan(String sdtNguoiNhan) {
        this.sdtNguoiNhan = sdtNguoiNhan;
    }

    public String getDiaChiNguoiNhan() {
        return diaChiNguoiNhan;
    }

    public void setDiaChiNguoiNhan(String diaChiNguoiNhan) {
        this.diaChiNguoiNhan = diaChiNguoiNhan;
    }

    public Date getNgayTaoPhieu() {
        return ngayTaoPhieu;
    }

    public void setNgayTaoPhieu(Date ngayTaoPhieu) {
        this.ngayTaoPhieu = ngayTaoPhieu;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public double getTienCuoc() {
        return tienCuoc;
    }

    public void setTienCuoc(double tienCuoc) {
        this.tienCuoc = tienCuoc;
    }

    public NhanVien getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(NhanVien nhanvien) {
        this.nhanvien = nhanvien;
    }

    public TrangThaiPhieuGiaoHang getTrangthaiPGH() {
        return trangthaiPGH;
    }

    public void setTrangthaiPGH(TrangThaiPhieuGiaoHang trangthaiPGH) {
        this.trangthaiPGH = trangthaiPGH;
    }

    public HoaDon getHoadon() {
        return hoadon;
    }

    public void setHoadon(HoaDon hoadon) {
        this.hoadon = hoadon;
    }

    public List<LichSuGiaoHang> getListLSGH() {
        return listLSGH;
    }

    public void setListLSGH(List<LichSuGiaoHang> listLSGH) {
        this.listLSGH = listLSGH;
    }

    public PhieuGiaoHang() {
    }

    public PhieuGiaoHang(long id, String sdtNguoiNhan, String diaChiNguoiNhan, Date ngayTaoPhieu, String ghiChu, double tienCuoc, NhanVien nhanvien, TrangThaiPhieuGiaoHang trangthaiPGH, HoaDon hoadon) {
        this.id = id;
        this.sdtNguoiNhan = sdtNguoiNhan;
        this.diaChiNguoiNhan = diaChiNguoiNhan;
        this.ngayTaoPhieu = ngayTaoPhieu;
        this.ghiChu = ghiChu;
        this.tienCuoc = tienCuoc;
        this.nhanvien = nhanvien;
        this.trangthaiPGH = trangthaiPGH;
        this.hoadon = hoadon;
    }

    public PhieuGiaoHang(long id, String sdtNguoiNhan, String diaChiNguoiNhan, Date ngayTaoPhieu, String ghiChu, double tienCuoc, NhanVien nhanvien, TrangThaiPhieuGiaoHang trangthaiPGH, HoaDon hoadon, List<LichSuGiaoHang> listLSGH) {
        this.id = id;
        this.sdtNguoiNhan = sdtNguoiNhan;
        this.diaChiNguoiNhan = diaChiNguoiNhan;
        this.ngayTaoPhieu = ngayTaoPhieu;
        this.ghiChu = ghiChu;
        this.tienCuoc = tienCuoc;
        this.nhanvien = nhanvien;
        this.trangthaiPGH = trangthaiPGH;
        this.hoadon = hoadon;
        this.listLSGH = listLSGH;
    }

    public List<LichSuCapNhatTrangThai> getListLSCNTT() {
        return listLSCNTT;
    }

    public void setListLSCNTT(List<LichSuCapNhatTrangThai> listLSCNTT) {
        this.listLSCNTT = listLSCNTT;
    }
    
}   
