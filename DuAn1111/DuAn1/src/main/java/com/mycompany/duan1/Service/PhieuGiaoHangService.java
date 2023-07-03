/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.duan1.Service;

import com.mycompany.duan1.Entity.PhieuGiaoHang;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Admin
 */
public interface PhieuGiaoHangService {

    Optional<List<PhieuGiaoHang>> findByHoaDonID(Long idHD);

    void save(PhieuGiaoHang PGH);

    Optional<PhieuGiaoHang> findByID(Long id);

    void Update(PhieuGiaoHang PGH);

    void setTrangThai(Long idTrangThai, Long idPGH);

    Optional<PhieuGiaoHang> findPGHByHDAndNewest(Long idHD);
    
}
