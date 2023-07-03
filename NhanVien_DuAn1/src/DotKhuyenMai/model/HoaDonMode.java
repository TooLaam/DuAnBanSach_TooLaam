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
public class HoaDonMode {

    
    private String mKH,maNV,maHD, ngayTao,thanhToan,khuyenMai;
    private int trangThai;
    private BigDecimal tongTien;

    public HoaDonMode() {
    }

    public String getmKH() {
        return mKH;
    }

    public void setmKH(String mKH) {
        this.mKH = mKH;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(String thanhToan) {
        this.thanhToan = thanhToan;
    }

    public String getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(String khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    public HoaDonMode(String mKH, String maNV, String maHD, String ngayTao, String thanhToan, String khuyenMai, int trangThai, BigDecimal tongTien) {
        this.mKH = mKH;
        this.maNV = maNV;
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.thanhToan = thanhToan;
        this.khuyenMai = khuyenMai;
        this.trangThai = trangThai;
        this.tongTien = tongTien;
    }

    
     public String TrangThaiHD() {
        if (trangThai == 1) {
            return "Đang thanh toán";
        }
        if (trangThai == 2) {
            return "Thanh toán thành công";
        }
        else{
            return  "Hủy";
        }
    }

    


    

   
}
