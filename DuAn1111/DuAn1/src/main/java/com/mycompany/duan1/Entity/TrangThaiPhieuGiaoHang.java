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
public class TrangThaiPhieuGiaoHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String name;
    
    @OneToMany(mappedBy = "trangthaiPGH")
    private List<PhieuGiaoHang> listPGH;
    public long getId() {
        return id;
    }

    public TrangThaiPhieuGiaoHang() {
    }
    
    
    public TrangThaiPhieuGiaoHang(long id, String name) {
        this.id = id;
        this.name = name;
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

    public List<PhieuGiaoHang> getListPGH() {
        return listPGH;
    }

    public void setListPGH(List<PhieuGiaoHang> listPGH) {
        this.listPGH = listPGH;
    }
    
}
