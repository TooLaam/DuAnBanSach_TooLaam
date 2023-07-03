/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duan1.Service;

import com.mycompany.duan1.Entity.HoaDon;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface HoaDonService {

    List<HoaDon> findAll();

    HoaDon findByID(Long id);

    HoaDon find();

    void save(HoaDon hd);

    void updateTrangThaiHD(Long idHD, Long idTT);

    void updateHinhThucThanhToan(Long idHD, Long idHTTT);
    
}
