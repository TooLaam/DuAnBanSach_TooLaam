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
import java.util.List;

/**
 *
 * @author Admin
 */
@Table
@Entity
public class HinhThucThanhToan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long Id;
    @Column
    private String Ma;
    @Column
    private String TenHinhThucThanhToan;
    @Column
    private int TrangThai;
    @OneToMany(mappedBy = "hinhthucthanhtoan")
    private List<HoaDon> listHoaDon;

    public HinhThucThanhToan() {
    }

    public HinhThucThanhToan(long Id, String Ma, String TenHinhThucThanhToan, int TrangThai, List<HoaDon> listHoaDon) {
        this.Id = Id;
        this.Ma = Ma;
        this.TenHinhThucThanhToan = TenHinhThucThanhToan;
        this.TrangThai = TrangThai;
        this.listHoaDon = listHoaDon;
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

    public String getTenHinhThucThanhToan() {
        return TenHinhThucThanhToan;
    }

    public void setTenHinhThucThanhToan(String TenHinhThucThanhToan) {
        this.TenHinhThucThanhToan = TenHinhThucThanhToan;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public List<HoaDon> getListHoaDon() {
        return listHoaDon;
    }

    public void setListHoaDon(List<HoaDon> listHoaDon) {
        this.listHoaDon = listHoaDon;
    }

}
