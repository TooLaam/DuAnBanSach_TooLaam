/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.duan1.Repository;

import com.mycompany.duan1.Entity.ThongTinChiTiet;

/**
 *
 * @author Admin
 */
public interface ThongTinChiTietRepo {

    void Save(ThongTinChiTiet ttct);

    void updateAllTrangThai(Long idKH);

    void update(ThongTinChiTiet ttct);
    
}
