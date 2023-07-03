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
public class LichSuCapNhatTrangThai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long Id;
    @Column
    private Date NgayCapNhat;
    @Column
    private String TenTrangThai;
//    long idPGH;
    @ManyToOne
    @JoinColumn(name = "idPGH")
    private PhieuGiaoHang pghLSCNTT;
//    long idNV;
    @ManyToOne
    @JoinColumn(name = "idNV")
    private NhanVien nhanvienLSCNTT;

    public LichSuCapNhatTrangThai() {
    }

    public LichSuCapNhatTrangThai(long Id, Date NgayCapNhat, String TenTrangThai, PhieuGiaoHang pghLSCNTT, NhanVien nhanvienLSCNTT) {
        this.Id = Id;
        this.NgayCapNhat = NgayCapNhat;
        this.TenTrangThai = TenTrangThai;
        this.pghLSCNTT = pghLSCNTT;
        this.nhanvienLSCNTT = nhanvienLSCNTT;
    }

  

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public Date getNgayCapNhat() {
        return NgayCapNhat;
    }

    public void setNgayCapNhat(Date NgayCapNhat) {
        this.NgayCapNhat = NgayCapNhat;
    }

    public PhieuGiaoHang getPghLSCNTT() {
        return pghLSCNTT;
    }

    public void setPghLSCNTT(PhieuGiaoHang pghLSCNTT) {
        this.pghLSCNTT = pghLSCNTT;
    }

    public NhanVien getNhanvienLSCNTT() {
        return nhanvienLSCNTT;
    }

    public void setNhanvienLSCNTT(NhanVien nhanvienLSCNTT) {
        this.nhanvienLSCNTT = nhanvienLSCNTT;
    }

    public String getTenTrangThai() {
        return TenTrangThai;
    }

    public void setTenTrangThai(String TenTrangThai) {
        this.TenTrangThai = TenTrangThai;
    }

}
