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
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
@Table
@Entity
public class HoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long Id;

//    private long IDNhanVien;
    @ManyToOne()
    @JoinColumn(name = "IdNhanVien")
    NhanVien nhanvienHD;

    @Column
    private String Ma;

    @Column
    private BigDecimal TongTien;
    @Column
    private Date NgayTao;

//    private int TrangThai;
    @ManyToOne
    @JoinColumn(name="IdTrangThaiHD")
    private TrangThaiHoaDon tthd;
    

    @OneToMany(mappedBy = "hoadonCTHD")
    private List<HoaDonChiTiet> listCTHD;

    @OneToMany(mappedBy = "hoadon")
    private List<PhieuGiaoHang> listPGH;

    //     private long idKH;
    @ManyToOne
    @JoinColumn(name = "IdKhachHang")
    private KhachHang khachhangHD;

    @ManyToOne
    @JoinColumn(name = "IdHinhThucThanhToan")
    private HinhThucThanhToan hinhthucthanhtoan;

    @ManyToOne
    @JoinColumn(name = "idKM")
    private DotKhuyenMai dotkhuyenmai;

    public HoaDon() {
    }

    public HoaDon(long Id, NhanVien nhanvienHD, String Ma, BigDecimal TongTien, Date NgayTao, TrangThaiHoaDon tthd, List<HoaDonChiTiet> listCTHD, List<PhieuGiaoHang> listPGH, KhachHang khachhangHD, HinhThucThanhToan hinhthucthanhtoan, DotKhuyenMai dotkhuyenmai) {
        this.Id = Id;
        this.nhanvienHD = nhanvienHD;
        this.Ma = Ma;
        this.TongTien = TongTien;
        this.NgayTao = NgayTao;
        this.tthd = tthd;
        this.listCTHD = listCTHD;
        this.listPGH = listPGH;
        this.khachhangHD = khachhangHD;
        this.hinhthucthanhtoan = hinhthucthanhtoan;
        this.dotkhuyenmai = dotkhuyenmai;
    }

   

    public NhanVien getNhanvienHD() {
        return nhanvienHD;
    }

    public void setNhanvienHD(NhanVien nhanvienHD) {
        this.nhanvienHD = nhanvienHD;
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

    public TrangThaiHoaDon getTthd() {
        return tthd;
    }

    public void setTthd(TrangThaiHoaDon tthd) {
        this.tthd = tthd;
    }

    
    public BigDecimal getTongTien() {
        return TongTien;
    }

    public void setTongTien(BigDecimal TongTien) {
        this.TongTien = TongTien;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public List<HoaDonChiTiet> getListCTHD() {
        return listCTHD;
    }

    public void setListCTHD(List<HoaDonChiTiet> listCTHD) {
        this.listCTHD = listCTHD;
    }

    public List<PhieuGiaoHang> getListPGH() {
        return listPGH;
    }

    public void setListPGH(List<PhieuGiaoHang> listPGH) {
        this.listPGH = listPGH;
    }

    public KhachHang getKhachhangHD() {
        return khachhangHD;
    }

    public void setKhachhangHD(KhachHang khachhangHD) {
        this.khachhangHD = khachhangHD;
    }

    public HinhThucThanhToan getHinhthucthanhtoan() {
        return hinhthucthanhtoan;
    }

    public void setHinhthucthanhtoan(HinhThucThanhToan hinhthucthanhtoan) {
        this.hinhthucthanhtoan = hinhthucthanhtoan;
    }

    public DotKhuyenMai getDotkhuyenmai() {
        return dotkhuyenmai;
    }

    public void setDotkhuyenmai(DotKhuyenMai dotkhuyenmai) {
        this.dotkhuyenmai = dotkhuyenmai;
    }

}
