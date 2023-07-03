/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duan1.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 *
 * @author Admin
 */
@Table
@Entity
public class CapBac {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long Id;
    @Column
    private String Ma;
    @Column
    private String Ten;
    @Column
    private double MucGiam;
    @OneToMany(mappedBy = "capbac")
    private List<KhachHang> listKH;

    public CapBac() {
    }

    public CapBac(long Id, String Ma, String Ten, double MucGiam, List<KhachHang> listKH) {
        this.Id = Id;
        this.Ma = Ma;
        this.Ten = Ten;
        this.MucGiam = MucGiam;
        this.listKH = listKH;
    }

   

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    

    public double getMucGiam() {
        return MucGiam;
    }

    public void setMucGiam(double MucGiam) {
        this.MucGiam = MucGiam;
    }

    public List<KhachHang> getListKH() {
        return listKH;
    }

    public void setListKH(List<KhachHang> listKH) {
        this.listKH = listKH;
    }

   
}
