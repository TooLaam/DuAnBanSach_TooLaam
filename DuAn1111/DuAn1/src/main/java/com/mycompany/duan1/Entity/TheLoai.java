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
public class TheLoai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long Id;
    @Column
    private String Ma;
    @Column
    private String Ten;
    @Column
    private String MoTa;
    @OneToMany(mappedBy = "theloai")
    private List<ChiTietTheLoai> listCTTL;

    public TheLoai() {
    }

    public TheLoai(long Id, String Ma, String Ten, String MoTa, List<ChiTietTheLoai> listCTTL) {
        this.Id = Id;
        this.Ma = Ma;
        this.Ten = Ten;
        this.MoTa = MoTa;
        this.listCTTL = listCTTL;
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

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public List<ChiTietTheLoai> getListCTTL() {
        return listCTTL;
    }

    public void setListCTTL(List<ChiTietTheLoai> listCTTL) {
        this.listCTTL = listCTTL;
    }
    

}
