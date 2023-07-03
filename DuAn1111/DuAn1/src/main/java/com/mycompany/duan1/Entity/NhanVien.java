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
 * @author Admin
 */
@Entity
@Table
public class NhanVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column
    private long IdChucVu;

    @Column
    private String Ten;

    @Column
    private String Ma;

    @Column
    private String GioiTinh;

    @Column
    private Date NgaySinh;

    @Column
    private String email;

    @Column
    private String SDT;

    @Column
    private String DiaChi;

    @Column
    private String MatKhau;

    @Column
    private int TrangThaiDiLam;

    @Column
    private int TrangThaiShipper;
    @OneToMany(mappedBy = "nhanvien")
    private List<PhieuGiaoHang> listPGH;

    @OneToMany(mappedBy = "nhanvienHD")
    private List<HoaDon> listHD;

    @OneToMany(mappedBy = "nhanvienLSGH")
    private List<LichSuGiaoHang> listLSGH;

    @OneToMany(mappedBy = "nhanvienLSCNTT")
    private List<LichSuCapNhatTrangThai> listLSCNTT;

    

    public NhanVien() {
    }

    public NhanVien(long id, long IdChucVu, String Ten, String Ma, String GioiTinh, Date NgaySinh, String email, String SDT, String DiaChi, String MatKhau, int TrangThaiDiLam, int TrangThaiShipper, List<PhieuGiaoHang> listPGH, List<HoaDon> listHD) {
        this.id = id;
        this.IdChucVu = IdChucVu;
        this.Ten = Ten;
        this.Ma = Ma;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.email = email;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
        this.MatKhau = MatKhau;
        this.TrangThaiDiLam = TrangThaiDiLam;
        this.TrangThaiShipper = TrangThaiShipper;
        this.listPGH = listPGH;
        this.listHD = listHD;
    }

    public List<HoaDon> getListHD() {
        return listHD;
    }

    public void setListHD(List<HoaDon> listHD) {
        this.listHD = listHD;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdChucVu() {
        return IdChucVu;
    }

    public void setIdChucVu(long IdChucVu) {
        this.IdChucVu = IdChucVu;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public int getTrangThaiDiLam() {
        return TrangThaiDiLam;
    }

    public void setTrangThaiDiLam(int TrangThaiDiLam) {
        this.TrangThaiDiLam = TrangThaiDiLam;
    }

    public int getTrangThaiShipper() {
        return TrangThaiShipper;
    }

    public void setTrangThaiShipper(int TrangThaiShipper) {
        this.TrangThaiShipper = TrangThaiShipper;
    }

    public List<PhieuGiaoHang> getListPGH() {
        return listPGH;
    }

    public void setListPGH(List<PhieuGiaoHang> listPGH) {
        this.listPGH = listPGH;
    }

    public List<LichSuGiaoHang> getListLSGH() {
        return listLSGH;
    }

    public void setListLSGH(List<LichSuGiaoHang> listLSGH) {
        this.listLSGH = listLSGH;
    }

    public List<LichSuCapNhatTrangThai> getListLSCNTT() {
        return listLSCNTT;
    }

    public void setListLSCNTT(List<LichSuCapNhatTrangThai> listLSCNTT) {
        this.listLSCNTT = listLSCNTT;
    }

}
