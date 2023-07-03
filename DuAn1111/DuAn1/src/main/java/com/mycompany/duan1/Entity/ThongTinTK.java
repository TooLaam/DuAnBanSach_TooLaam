/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duan1.Entity;

/**
 *
 * @author Admin
 */
public class ThongTinTK {

    private String chuThe;
    private String nganHang;
    private String Stk;

    public ThongTinTK(String chuThe, String nganHang, String Stk) {
        this.chuThe = chuThe;
        this.nganHang = nganHang;
        this.Stk = Stk;
    }

    public String getChuThe() {
        return chuThe;
    }

    public void setChuThe(String chuThe) {
        this.chuThe = chuThe;
    }

    public String getNganHang() {
        return nganHang;
    }

    public void setNganHang(String nganHang) {
        this.nganHang = nganHang;
    }

    public String getStk() {
        return Stk;
    }

    public void setStk(String Stk) {
        this.Stk = Stk;
    }
    

}
