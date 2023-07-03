/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package khachHang.model;

/**
 *
 * @author ASUS
 */
public class CapBac {
    private long idCB;
    private String maCB;
    private String tenCB;
    private float mucGiam;
    public CapBac(){
        
    }

    public CapBac(long idCB, String maCB, String tenCB, float mucGiam) {
        this.idCB = idCB;
        this.maCB = maCB;
        this.tenCB = tenCB;
        this.mucGiam = mucGiam;
    }

    public long getIdCB() {
        return idCB;
    }

    public void setIdCB(long idCB) {
        this.idCB = idCB;
    }

    public String getMaCB() {
        return maCB;
    }

    public void setMaCB(String maCB) {
        this.maCB = maCB;
    }

    public String getTenCB() {
        return tenCB;
    }

    public void setTenCB(String tenCB) {
        this.tenCB = tenCB;
    }

    public float getMucGiam() {
        return mucGiam;
    }

    public void setMucGiam(float mucGiam) {
        this.mucGiam = mucGiam;
    }



    
}
