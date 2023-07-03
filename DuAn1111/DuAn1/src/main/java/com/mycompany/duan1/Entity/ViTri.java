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
@Entity
@Table
public class ViTri {
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
    @OneToMany(mappedBy = "vitri")
    private List<CTSach> listCTSach;

    public ViTri() {
    }

    public ViTri(long Id, String Ma, String Ten, String MoTa, List<CTSach> listCTSach) {
        this.Id = Id;
        this.Ma = Ma;
        this.Ten = Ten;
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

    public List<CTSach> getListCTSach() {
        return listCTSach;
    }

    public void setListCTSach(List<CTSach> listCTSach) {
        this.listCTSach = listCTSach;
    }
    
    
}
