/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NhanVien.ViewModel;

import java.math.BigDecimal;

/**
 *
 * @author DELL
 */
public class VM_TinhLuong {
     private String idLuong, idNV, maNV;
    private int thang,second;
    private BigDecimal tongTienPhat,tongTienThuong,mucLuong,tongTienCong,tongLuong;
    

    public String getIdLuong() {
        return idLuong;
    }

    public void setIdLuong(String idLuong) {
        this.idLuong = idLuong;
    }

    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public BigDecimal getTongTienPhat() {
        return tongTienPhat;
    }

    public void setTongTienPhat(BigDecimal tongTienPhat) {
        this.tongTienPhat = tongTienPhat;
    }

    public BigDecimal getTongTienThuong() {
        return tongTienThuong;
    }

    public void setTongTienThuong(BigDecimal tongTienThuong) {
        this.tongTienThuong = tongTienThuong;
    }

    public BigDecimal getMucLuong() {
        return mucLuong;
    }

    public void setMucLuong(BigDecimal mucLuong) {
        this.mucLuong = mucLuong;
    }

    public BigDecimal getTongTienCong() {
        return tongTienCong;
    }

    public void setTongTienCong(BigDecimal tongTienCong) {
        this.tongTienCong = tongTienCong;
    }

    public BigDecimal getTongLuong() {
        return tongLuong;
    }

    public void setTongLuong(BigDecimal tongLuong) {
        this.tongLuong = tongLuong;
    }

    public VM_TinhLuong(String idLuong, String idNV, String maNV, int thang, int second, BigDecimal tongTienPhat, BigDecimal tongTienThuong, BigDecimal mucLuong, BigDecimal tongTienCong, BigDecimal tongLuong) {
        this.idLuong = idLuong;
        this.idNV = idNV;
        this.maNV = maNV;
        this.thang = thang;
        this.second = second;
        this.tongTienPhat = tongTienPhat;
        this.tongTienThuong = tongTienThuong;
        this.mucLuong = mucLuong;
        this.tongTienCong = tongTienCong;
        this.tongLuong = tongLuong;
    }

    public VM_TinhLuong() {
    }
    
    public String TrangThaiTL() {
        if (second ==1) {
            return "Đã tính";
        }
       
        else{
            return  "OUT";
        }
      }
}
