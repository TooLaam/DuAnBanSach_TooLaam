/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.duan1.Service;

import com.mycompany.duan1.Entity.LichSuGiaoHang;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Admin
 */
public interface LichSuGiaoHangService {

    void Update(LichSuGiaoHang lichSuGiaoHang);

    void save(LichSuGiaoHang lichSuGiaoHang);

    Optional<List<LichSuGiaoHang>> findAll();
    
}
