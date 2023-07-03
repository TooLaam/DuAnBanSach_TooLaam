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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author Admin
 */
@Table
@Entity
public class TacGiaSach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long Id;
    @ManyToOne
    @JoinColumn(name = "idTacGia")
    private TacGia tacgia;
    
    @ManyToOne
    @JoinColumn(name = "idSach")
    private Sach sachTGS;

    public TacGia getTacgia() {
        return tacgia;
    }

    public void setTacgia(TacGia tacgia) {
        this.tacgia = tacgia;
    }

    public Sach getSach() {
        return sachTGS;
    }

    public void setSach(Sach sach) {
        this.sachTGS = sach;
    }
    
}
