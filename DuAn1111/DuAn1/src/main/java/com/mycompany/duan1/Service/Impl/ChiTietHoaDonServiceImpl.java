/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duan1.Service.Impl;

import com.mycompany.duan1.Entity.HoaDonChiTiet;
import com.mycompany.duan1.Repository.ChiTietHoaDonRepo;
import com.mycompany.duan1.Repository.Impl.HoaDonChiTietRepoImpl;
import com.mycompany.duan1.Service.ChiTietHoaDonService;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class ChiTietHoaDonServiceImpl implements ChiTietHoaDonService{
    private final ChiTietHoaDonRepo chitiethoadonrepo = new HoaDonChiTietRepoImpl();

    public void save(HoaDonChiTiet cthd) {
        chitiethoadonrepo.save(cthd);
    }

    public Optional<List<HoaDonChiTiet>> findByIDHD(Long idHD) {
        return chitiethoadonrepo.findByIDHD(idHD);
    }
    
}
