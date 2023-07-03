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
import java.util.List;

/**
 *
 * @author Admin
 */
@Table
@Entity
public class CTSach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    long idCTSach;

//    long idNXB;
    @ManyToOne
    @JoinColumn(name = "idNXB")
    private NhaXuatBan nhaxuatban;

//    long idViTri;
    @ManyToOne
    @JoinColumn(name = "idViTri")
    private ViTri vitri;

//    long idSach;
    @ManyToOne
    @JoinColumn(name = "idSach")
    private Sach sach;

//    long idNamXuatBan;
    @ManyToOne
    @JoinColumn(name = "idNamXuatBan")
    private NamXuatBan namxuatban;

//    long idChatLieu;
    @ManyToOne
    @JoinColumn(name = "idChatLieu")
    private ChatLieu chatlieu;

//    long idNgonNgu;
    @ManyToOne
    @JoinColumn(name = "idNgonNgu")
    private NgonNgu ngonngu;

    @Column
    private int SoLuong;
    @Column
    private BigDecimal GiaBan;
    @Column
    private String Hinh;
    @Column
    private String Mota;
    @Column
    private int SoTrang;

    @OneToMany(mappedBy = "ctsach")
    private List<HoaDonChiTiet> listCTHD;

    public CTSach() {
    }

    public CTSach(long idCTSach, NhaXuatBan nhaxuatban, ViTri vitri, Sach sach, NamXuatBan namxuatban, ChatLieu chatlieu, NgonNgu ngonngu, int SoLuong, BigDecimal GiaBan, String Hinh, String Mota, int SoTrang) {
        this.idCTSach = idCTSach;
        this.nhaxuatban = nhaxuatban;
        this.vitri = vitri;
        this.sach = sach;
        this.namxuatban = namxuatban;
        this.chatlieu = chatlieu;
        this.ngonngu = ngonngu;
        this.SoLuong = SoLuong;
        this.GiaBan = GiaBan;
        this.Hinh = Hinh;
        this.Mota = Mota;
        this.SoTrang = SoTrang;
    }

   

    public long getIdCTSach() {
        return idCTSach;
    }

    public void setIdCTSach(long idCTSach) {
        this.idCTSach = idCTSach;
    }

    public NhaXuatBan getNhaxuatban() {
        return nhaxuatban;
    }

    public void setNhaxuatban(NhaXuatBan nhaxuatban) {
        this.nhaxuatban = nhaxuatban;
    }

    public ViTri getVitri() {
        return vitri;
    }

    public void setVitri(ViTri vitri) {
        this.vitri = vitri;
    }

    public Sach getSach() {
        return sach;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

    public NamXuatBan getNamxuatban() {
        return namxuatban;
    }

    public void setNamxuatban(NamXuatBan namxuatban) {
        this.namxuatban = namxuatban;
    }

    public ChatLieu getChatlieu() {
        return chatlieu;
    }

    public void setChatlieu(ChatLieu chatlieu) {
        this.chatlieu = chatlieu;
    }

    public NgonNgu getNgonngu() {
        return ngonngu;
    }

    public void setNgonngu(NgonNgu ngonngu) {
        this.ngonngu = ngonngu;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public BigDecimal getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(BigDecimal GiaBan) {
        this.GiaBan = GiaBan;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String Mota) {
        this.Mota = Mota;
    }

    public int getSoTrang() {
        return SoTrang;
    }

    public void setSoTrang(int SoTrang) {
        this.SoTrang = SoTrang;
    }

    public List<HoaDonChiTiet> getListCTHD() {
        return listCTHD;
    }

    public void setListCTHD(List<HoaDonChiTiet> listCTHD) {
        this.listCTHD = listCTHD;
    }

}
