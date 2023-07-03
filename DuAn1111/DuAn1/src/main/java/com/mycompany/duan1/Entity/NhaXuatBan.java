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
public class NhaXuatBan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long Id;
    @Column
    private String Ma;
    @Column
    private String ten;
    @Column
    private String MoTa;
    @OneToMany(mappedBy = "nhaxuatban")
    private List<CTSach> listCTSach;

    public NhaXuatBan() {
    }

    public NhaXuatBan(long Id, String Ma, String ten, String MoTa, List<CTSach> listCTSach) {
        this.Id = Id;
        this.Ma = Ma;
        this.ten = ten;
        this.MoTa = MoTa;
        this.listCTSach = listCTSach;
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
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public List<CTSach> getListCTSach() {
        return listCTSach;
    }

    public void setListCTSach(List<CTSach> listCTSach) {
        this.listCTSach = listCTSach;
    }

}
