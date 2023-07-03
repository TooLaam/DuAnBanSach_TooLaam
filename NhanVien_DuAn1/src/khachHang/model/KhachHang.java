/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package khachHang.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class KhachHang {

    private long id;
    private String maKhachHang;
    private String tenKhachHang;
    private String gioiTinh;
    private String Email;
    private String SDT;
    private long diemTichLuy;
    private Date ngayTao;



    public KhachHang() {

    }

  

    public KhachHang(long id, String maKhachHang, String tenKhachHang, String gioiTinh, String Email, String SDT, long diemTichLuy, Date ngayTao) {
        this.id = id;
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.gioiTinh = gioiTinh;
        this.Email = Email;
        this.SDT = SDT;
        this.diemTichLuy = diemTichLuy;
        this.ngayTao = ngayTao;

    }
   

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public long getDiemTichLuy() {
        return diemTichLuy;
    }

    public void setDiemTichLuy(long diemTichLuy) {
        this.diemTichLuy = diemTichLuy;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }
    @Override
    public String toString() {
        return "KhachHang [maKhachHang=" + maKhachHang + ", tenKhachHang=" + tenKhachHang + ", ...]"; // Thay thế ... bằng các thuộc tính khác của KhachHang
    }

    public String Diem() {
        if (diemTichLuy == 1) {
            return "Thường";
        } else {
            return "VIP";
        }
    }

  

  

}
