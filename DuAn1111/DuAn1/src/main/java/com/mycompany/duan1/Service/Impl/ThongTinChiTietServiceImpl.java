/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duan1.Service.Impl;

import com.mycompany.duan1.Entity.ThongTinChiTiet;
import com.mycompany.duan1.Repository.Impl.ThongTinChiTietRepoImple;
import com.mycompany.duan1.Repository.ThongTinChiTietRepo;
import com.mycompany.duan1.Service.ThongTinChiTietService;

/**
 *
 * @author Admin
 */
public class ThongTinChiTietServiceImpl implements ThongTinChiTietService{
    private final ThongTinChiTietRepo thongtinchitietrepo = new ThongTinChiTietRepoImple();

    @Override
    public void Save(ThongTinChiTiet ttct) {
        thongtinchitietrepo.Save(ttct);
    }

    @Override
    public void updateAllTrangThai(Long idKH) {
        thongtinchitietrepo.updateAllTrangThai(idKH);
    }

    @Override
    public void update(ThongTinChiTiet ttct) {
        thongtinchitietrepo.update(ttct);
    }
    
}
