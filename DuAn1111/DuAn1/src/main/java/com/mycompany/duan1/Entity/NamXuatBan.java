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
public class NamXuatBan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String Ma;
    @Column
    private String Nam;
    @Column
    private String Mota;
    @OneToMany(mappedBy = "namxuatban")
    private List<CTSach> listCTSach;

    public NamXuatBan() {
    }

    public NamXuatBan(long id, String Ma, String Nam, List<CTSach> listCTSach) {
        this.id = id;
        this.Ma = Ma;
        this.Nam = Nam;
        this.listCTSach = listCTSach;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public String getNam() {
        return Nam;
    }

    public void setNam(String Nam) {
        this.Nam = Nam;
    }

    public List<CTSach> getListCTSach() {
        return listCTSach;
    }

    public void setListCTSach(List<CTSach> listCTSach) {
        this.listCTSach = listCTSach;
    }

}
