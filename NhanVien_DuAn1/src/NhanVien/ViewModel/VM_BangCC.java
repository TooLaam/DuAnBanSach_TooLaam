/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NhanVien.ViewModel;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class VM_BangCC {
     private String idCC,IDNV,NgayLam,tenNV;
    private int trangThai,trangThaiTinhLuong;
    private String gioIN,gioOUT;
    
    

    public VM_BangCC() {
    }

    public VM_BangCC(String idCC, String IDNV, String NgayLam, String tenNV, int trangThai, int trangThaiTinhLuong, String gioIN, String gioOUT) {
        this.idCC = idCC;
        this.IDNV = IDNV;
        this.NgayLam = NgayLam;
        this.tenNV = tenNV;
        this.trangThai = trangThai;
        this.trangThaiTinhLuong = trangThaiTinhLuong;
        this.gioIN = gioIN;
        this.gioOUT = gioOUT;
    }

    public String getIdCC() {
        return idCC;
    }

    public void setIdCC(String idCC) {
        this.idCC = idCC;
    }

    public String getIDNV() {
        return IDNV;
    }

    public void setIDNV(String IDNV) {
        this.IDNV = IDNV;
    }

    public String getNgayLam() {
        return NgayLam;
    }

    public void setNgayLam(String NgayLam) {
        this.NgayLam = NgayLam;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public int getTrangThaiTinhLuong() {
        return trangThaiTinhLuong;
    }

    public void setTrangThaiTinhLuong(int trangThaiTinhLuong) {
        this.trangThaiTinhLuong = trangThaiTinhLuong;
    }

    public String getGioIN() {
        return gioIN;
    }

    public void setGioIN(String gioIN) {
        this.gioIN = gioIN;
    }

    public String getGioOUT() {
        return gioOUT;
    }

    public void setGioOUT(String gioOUT) {
        this.gioOUT = gioOUT;
    }

    

    

   
    
     public String TrangThaiCC() {
        if (trangThai ==1) {
            return "IN";
        }
       
        else{
            return  "OUT";
        }
      }
     public String TrangThaiTL() {
        if (trangThaiTinhLuong ==1) {
            return "Chưa tính";
        }
       
        else{
            return  "Đã tính";
        }
      }
}
