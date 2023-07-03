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
public class NgonNgu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    long Id;
    @Column
    String Ma;
    @Column
    String Ten;
    @Column
    String Mota;
    @OneToMany(mappedBy = "ngonngu")
    private List<CTSach> listCTSach;

    public NgonNgu() {
    }

    public NgonNgu(long Id, String Ma, String Ten, String Mota, List<CTSach> listCTSach) {
        this.Id = Id;
        this.Ma = Ma;
        this.Ten = Ten;
        this.Mota = Mota;
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

    public String getMota() {
        return Mota;
    }

    public void setMota(String Mota) {
        this.Mota = Mota;
    }

    public List<CTSach> getListCTSach() {
        return listCTSach;
    }

    public void setListCTSach(List<CTSach> listCTSach) {
        this.listCTSach = listCTSach;
    }
    
}
