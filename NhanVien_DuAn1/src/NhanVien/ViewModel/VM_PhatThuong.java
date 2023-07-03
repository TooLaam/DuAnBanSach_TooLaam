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
public class VM_PhatThuong {
   private String lyDoThuong,lyDoPhat,idThuong,idPhat,idNV,ngayTao;
    private BigDecimal mucPhat,mucThuong;
    private int trangThai;
    public VM_PhatThuong() {
    }

    public VM_PhatThuong(String lyDoThuong, String lyDoPhat, String idThuong, String idPhat, String idNV, String ngayTao, BigDecimal mucPhat, BigDecimal mucThuong, int trangThai) {
        this.lyDoThuong = lyDoThuong;
        this.lyDoPhat = lyDoPhat;
        this.idThuong = idThuong;
        this.idPhat = idPhat;
        this.idNV = idNV;
        this.ngayTao = ngayTao;
        this.mucPhat = mucPhat;
        this.mucThuong = mucThuong;
        this.trangThai = trangThai;
    }

    public String getLyDoThuong() {
        return lyDoThuong;
    }

    public void setLyDoThuong(String lyDoThuong) {
        this.lyDoThuong = lyDoThuong;
    }

    public String getLyDoPhat() {
        return lyDoPhat;
    }

    public void setLyDoPhat(String lyDoPhat) {
        this.lyDoPhat = lyDoPhat;
    }

    public String getIdThuong() {
        return idThuong;
    }

    public void setIdThuong(String idThuong) {
        this.idThuong = idThuong;
    }

    public String getIdPhat() {
        return idPhat;
    }

    public void setIdPhat(String idPhat) {
        this.idPhat = idPhat;
    }

    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public BigDecimal getMucPhat() {
        return mucPhat;
    }

    public void setMucPhat(BigDecimal mucPhat) {
        this.mucPhat = mucPhat;
    }

    public BigDecimal getMucThuong() {
        return mucThuong;
    }

    public void setMucThuong(BigDecimal mucThuong) {
        this.mucThuong = mucThuong;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

   

     public String TrangThai() {
        if (trangThai ==1) {
            return "Chưa tính";
        }
       
        else{
            return  "Đã tính";
        }
      }
}
