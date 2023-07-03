/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DotKhuyenMai.model;

/**
 *
 * @author DELL
 */
public class Hienthigannhat {
    private String maHD,maNV, tenKH, tenHTTT, ngayTao,ghiChu;
    private int trangThai;

    public Hienthigannhat() {
    }

    public Hienthigannhat(String maHD, String maNV, String tenKH, String tenHTTT, String ngayTao, String ghiChu, int trangThai) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.tenKH = tenKH;
        this.tenHTTT = tenHTTT;
        this.ngayTao = ngayTao;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getTenHTTT() {
        return tenHTTT;
    }

    public void setTenHTTT(String tenHTTT) {
        this.tenHTTT = tenHTTT;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String TrangThaiHDGH() {
        if (trangThai ==1) {
            return "Đang thanh toán";
        }
        if (trangThai ==2) {
            return "Thanh toán thành công";
        }
        else{
            return  "Hủy";
        }
}
}
