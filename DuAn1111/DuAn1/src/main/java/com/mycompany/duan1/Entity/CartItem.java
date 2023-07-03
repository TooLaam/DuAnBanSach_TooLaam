/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duan1.Entity;

import java.math.BigDecimal;

/**
 *
 * @author Admin
 */
public class CartItem {

    private long id;
    private String name;
    private int soLuong;
    private BigDecimal donGia;

    public CartItem() {
    }

    public CartItem(long id, String name, int soLuong, BigDecimal donGia) {
        this.id = id;
        this.name = name;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }
    
    
}
