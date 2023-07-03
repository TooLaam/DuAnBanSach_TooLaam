/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import java.math.BigDecimal;

/**
 *
 * @author DELL
 */
public class DM_ThongKe {
    private int tongSoNV,tongSoNamNu,tongSoNam,tongSoDangLam,tongSoTamNghi,tongSoNghi,tongSoCoTheGiaoHang,tongSoKhongTheGiaoHang;
    private String ngayBD,ngayKT,maNV,maSP,tenSP;
    private int SLBan,tongSPBan,tongHDBan;
    private BigDecimal doanhThuTheoSP,tongDoanhThuBan;

    public DM_ThongKe(String ngayBD, String ngayKT, String maNV, String maSP, String tenSP, int SLBan, BigDecimal doanhThuTheoSP, int tongSPBan, BigDecimal tongDoanhThuBan, int tongHDBan) {
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.maNV = maNV;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.SLBan = SLBan;
        this.doanhThuTheoSP = doanhThuTheoSP;
        this.tongSPBan = tongSPBan;
        this.tongDoanhThuBan = tongDoanhThuBan;
        this.tongHDBan = tongHDBan;
    }

    public int getTongSoNV() {
        return tongSoNV;
    }

    public void setTongSoNV(int tongSoNV) {
        this.tongSoNV = tongSoNV;
    }

    public int getTongSoNamNu() {
        return tongSoNamNu;
    }

    public void setTongSoNamNu(int tongSoNamNu) {
        this.tongSoNamNu = tongSoNamNu;
    }

    public int getTongSoNam() {
        return tongSoNam;
    }

    public String getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(String ngayBD) {
        this.ngayBD = ngayBD;
    }

    public String getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(String ngayKT) {
        this.ngayKT = ngayKT;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSLBan() {
        return SLBan;
    }

    public void setSLBan(int SLBan) {
        this.SLBan = SLBan;
    }

    public BigDecimal getDoanhThuTheoSP() {
        return doanhThuTheoSP;
    }

    public void setDoanhThuTheoSP(BigDecimal doanhThuTheoSP) {
        this.doanhThuTheoSP = doanhThuTheoSP;
    }

    public int getTongSPBan() {
        return tongSPBan;
    }

    public void setTongSPBan(int tongSPBan) {
        this.tongSPBan = tongSPBan;
    }

    public BigDecimal getTongDoanhThuBan() {
        return tongDoanhThuBan;
    }

    public void setTongDoanhThuBan(BigDecimal tongDoanhThuBan) {
        this.tongDoanhThuBan = tongDoanhThuBan;
    }

    public int getTongHDBan() {
        return tongHDBan;
    }

    public void setTongHDBan(int tongHDBan) {
        this.tongHDBan = tongHDBan;
    }

    public void setTongSoNam(int tongSoNam) {
        this.tongSoNam = tongSoNam;
    }

    public int getTongSoDangLam() {
        return tongSoDangLam;
    }

    public void setTongSoDangLam(int tongSoDangLam) {
        this.tongSoDangLam = tongSoDangLam;
    }

    public int getTongSoTamNghi() {
        return tongSoTamNghi;
    }

    public void setTongSoTamNghi(int tongSoTamNghi) {
        this.tongSoTamNghi = tongSoTamNghi;
    }

    public int getTongSoNghi() {
        return tongSoNghi;
    }

    public void setTongSoNghi(int tongSoNghi) {
        this.tongSoNghi = tongSoNghi;
    }

    public int getTongSoCoTheGiaoHang() {
        return tongSoCoTheGiaoHang;
    }

    public void setTongSoCoTheGiaoHang(int tongSoCoTheGiaoHang) {
        this.tongSoCoTheGiaoHang = tongSoCoTheGiaoHang;
    }

    public int getTongSoKhongTheGiaoHang() {
        return tongSoKhongTheGiaoHang;
    }

    public void setTongSoKhongTheGiaoHang(int tongSoKhongTheGiaoHang) {
        this.tongSoKhongTheGiaoHang = tongSoKhongTheGiaoHang;
    }

    public DM_ThongKe(int tongSoNV, int tongSoNamNu, int tongSoNam, int tongSoDangLam, int tongSoTamNghi, int tongSoNghi, int tongSoCoTheGiaoHang, int tongSoKhongTheGiaoHang) {
        this.tongSoNV = tongSoNV;
        this.tongSoNamNu = tongSoNamNu;
        this.tongSoNam = tongSoNam;
        this.tongSoDangLam = tongSoDangLam;
        this.tongSoTamNghi = tongSoTamNghi;
        this.tongSoNghi = tongSoNghi;
        this.tongSoCoTheGiaoHang = tongSoCoTheGiaoHang;
        this.tongSoKhongTheGiaoHang = tongSoKhongTheGiaoHang;
    }

    public DM_ThongKe() {
    }
    
}
