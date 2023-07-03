/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DotKhuyenMai.model;

/**
 *
 * @author DELL
 */
public class giamGiamodel {

   
    private String id, tenGiamGIa,magiamgia,ngayBD,ngayKT;
    private double mucGG;

    public giamGiamodel(String id, String tenGiamGIa, String magiamgia, String ngayBD, String ngayKT, double mucGG) {
        this.id = id;
        this.tenGiamGIa = tenGiamGIa;
        this.magiamgia = magiamgia;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.mucGG = mucGG;
    }

    public giamGiamodel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenGiamGIa() {
        return tenGiamGIa;
    }

    public void setTenGiamGIa(String tenGiamGIa) {
        this.tenGiamGIa = tenGiamGIa;
    }

    public String getMagiamgia() {
        return magiamgia;
    }

    public void setMagiamgia(String magiamgia) {
        this.magiamgia = magiamgia;
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

    public double getMucGG() {
        return mucGG;
    }

    public void setMucGG(double mucGG) {
        this.mucGG = mucGG;
    }

    
}
