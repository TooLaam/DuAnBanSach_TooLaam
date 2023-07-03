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
public class KhachHangResponse {
    private long idDC;
    private long id;
    private String ten;
    private String sdt;
    private String diaChi;
    private String thanhPho;
    private Date ngayTao;



    public KhachHangResponse(long idDC, long id, String ten, String sdt, String diaChi, String thanhPho, Date ngayTao) {
        this.idDC = idDC;
        this.id = id;
        this.ten = ten;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.thanhPho = thanhPho;
        this.ngayTao = ngayTao;
    }


  
    
    public KhachHangResponse(){
        
    }

    public long getIdDC() {
        return idDC;
    }

    public void setIdDC(long idDC) {
        this.idDC = idDC;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
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

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    
    
    
}
