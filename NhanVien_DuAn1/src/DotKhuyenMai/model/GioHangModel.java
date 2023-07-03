/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DotKhuyenMai.model;

/**
 *
 * @author DELL
 */
public class GioHangModel {
    private String maHDCT, maHD,tenSp, tenkichthuoc,tenkhuyemai,maSP;
    private double tongTien,tienGiam;
    private int soLuong;

    
    public GioHangModel() {
    }

    public GioHangModel(String maHDCT, String maHD, String tenSp, String tenkichthuoc, String tenkhuyemai, String maSP, double tongTien,double tienGiam,int soLuong) {
        this.maHDCT = maHDCT;
        this.maHD = maHD;
        this.tenSp = tenSp;
        this.tenkichthuoc = tenkichthuoc;
        this.tenkhuyemai = tenkhuyemai;
        this.maSP = maSP;
        this.tongTien = tongTien;
        this.soLuong = soLuong;
        this.tienGiam = tienGiam;
    }

    public double getTienGiam() {
        return tienGiam;
    }

    public void setTienGiam(double tienGiam) {
        this.tienGiam = tienGiam;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMaHDCT() {
        return maHDCT;
    }

    public void setMaHDCT(String maHDCT) {
        this.maHDCT = maHDCT;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getTenkichthuoc() {
        return tenkichthuoc;
    }

    public void setTenkichthuoc(String tenkichthuoc) {
        this.tenkichthuoc = tenkichthuoc;
    }

    public String getTenkhuyemai() {
        return tenkhuyemai;
    }

    public void setTenkhuyemai(String tenkhuyemai) {
        this.tenkhuyemai = tenkhuyemai;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    
}
