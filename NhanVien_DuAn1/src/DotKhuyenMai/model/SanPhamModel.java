/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DotKhuyenMai.model;

import java.math.BigDecimal;

/**
 *
 * @author DELL
 */
public class SanPhamModel {
    String maSP, tenSP, chatLieu, kichThuoc, xuatXu;
    double giaBan;
    int soLuong;

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public SanPhamModel(String maSP, String tenSP, String chatLieu, String kichThuoc, String xuatXu, double giaBan, int soLuong) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.chatLieu = chatLieu;
        this.kichThuoc = kichThuoc;
        this.xuatXu = xuatXu;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
    }

    public SanPhamModel() {
    }

    
   
    
}
