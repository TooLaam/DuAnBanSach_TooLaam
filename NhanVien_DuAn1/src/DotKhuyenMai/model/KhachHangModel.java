/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DotKhuyenMai.model;

/**
 *
 * @author DELL
 */
public class KhachHangModel {

    private String maKH, tenKH, capBac, sdt;
    private String gioiTinh;
    private String MK,Tk;

    public String getCapBac() {
        return capBac;
    }

    public void setCapBac(String capBac) {
        this.capBac = capBac;
    }

    public String getTk() {
        return Tk;
    }

    public void setTk(String Tk) {
        this.Tk = Tk;
    }

    public KhachHangModel(String MK, String Tk) {
        this.MK = MK;
        this.Tk = Tk;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getNgaySinh() {
        return capBac;
    }

    public void setNgaySinh(String ngaySinh) {
        this.capBac = capBac;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public KhachHangModel(String maKH, String tenKH, String capBac, String sdt, String gioiTinh) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.capBac = capBac;
        this.sdt = sdt;
        this.gioiTinh = gioiTinh;
    }

    public KhachHangModel() {
    }
  

   

}
