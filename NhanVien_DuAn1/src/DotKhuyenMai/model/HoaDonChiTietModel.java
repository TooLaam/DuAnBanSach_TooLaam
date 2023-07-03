/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DotKhuyenMai.model;

/**
 *
 * @author DELL
 */
public class HoaDonChiTietModel {
    private String maHDCT, maHD,maSp,maGiamgia;
  
    public String getMaHDCT() {
        return maHDCT;
    }

    public void setMaHDCT(String maHDCT) {
        this.maHDCT = maHDCT;
    }

    public HoaDonChiTietModel(String maHDCT) {
        this.maHDCT = maHDCT;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getMaGiamgia() {
        return maGiamgia;
    }

    public void setMaGiamgia(String maGiamgia) {
        this.maGiamgia = maGiamgia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public HoaDonChiTietModel(String maHD, String maSp, String maGiamgia, int soLuong) {
        this.maHD = maHD;
        this.maSp = maSp;
        this.maGiamgia = maGiamgia;
        this.soLuong = soLuong;
    }

   

    public HoaDonChiTietModel() {
    }
    private int soLuong;

    
}
