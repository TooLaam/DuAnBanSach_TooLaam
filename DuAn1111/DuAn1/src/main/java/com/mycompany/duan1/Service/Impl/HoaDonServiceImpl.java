/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duan1.Service.Impl;

import com.mycompany.duan1.Entity.HoaDon;
import com.mycompany.duan1.Repository.HoaDonRepo;
import com.mycompany.duan1.Repository.Impl.HoaDonRepoImpl;
import com.mycompany.duan1.Service.HoaDonService;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class HoaDonServiceImpl implements HoaDonService {

    private final HoaDonRepo hoadonrepo = new HoaDonRepoImpl();

    @Override
    public List<HoaDon> findAll() {
        return hoadonrepo.findAll();
    }

    @Override
    public HoaDon find() {
        return hoadonrepo.find();
    }

    @Override
    public HoaDon findByID(Long id) {
        return hoadonrepo.findByID(id);
    }

    @Override
    public void save(HoaDon hd) {
        try {
            hoadonrepo.save(hd);
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi");
        }

    }

    @Override
    public void updateTrangThaiHD(Long idHD, Long idTT) {
        hoadonrepo.updateTrangThaiHD(idHD, idTT);
    }

    @Override
    public void updateHinhThucThanhToan(Long idHD, Long idHTTT) {
        hoadonrepo.updateHinhThucThanhToan(idHD, idHTTT);
    }

}
