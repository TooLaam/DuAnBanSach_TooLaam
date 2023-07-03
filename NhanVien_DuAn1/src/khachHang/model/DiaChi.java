/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package khachHang.model;

import java.util.Date;


/**
 *
 * @author ASUS
 */
public class DiaChi {
    private long id;
    private long IdKhachHang;
    private String diaChi;
    private String thanhPho;
    private String  sdt;
    private Date ngayTao;
    public DiaChi(){
        
    }

    public DiaChi(long id, long IdKhachHang, String diaChi, String thanhPho, String sdt, Date ngayTao) {
        this.id = id;
        this.IdKhachHang = IdKhachHang;
        this.diaChi = diaChi;
        this.thanhPho = thanhPho;
        this.sdt = sdt;
        this.ngayTao = ngayTao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdKhachHang() {
        return IdKhachHang;
    }

    public void setIdKhachHang(long IdKhachHang) {
        this.IdKhachHang = IdKhachHang;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getThanhPho() {
        return thanhPho;
    }

    public void setThanhPho(String thanhPho) {
        this.thanhPho = thanhPho;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    
    
}
