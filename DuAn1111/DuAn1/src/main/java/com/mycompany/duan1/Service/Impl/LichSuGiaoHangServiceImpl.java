/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duan1.Service.Impl;

import com.mycompany.duan1.Entity.LichSuGiaoHang;
import com.mycompany.duan1.Repository.Impl.LichSuGiaoHangRepoImpl;
import com.mycompany.duan1.Repository.LichSuGiaoHangRepo;
import com.mycompany.duan1.Service.LichSuGiaoHangService;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Admin
 */
public class LichSuGiaoHangServiceImpl implements LichSuGiaoHangService{
    private LichSuGiaoHangRepo lichsugiaohangrepo = new LichSuGiaoHangRepoImpl();

    public void Update(LichSuGiaoHang lichSuGiaoHang) {
        lichsugiaohangrepo.Update(lichSuGiaoHang);
    }

    public void save(LichSuGiaoHang lichSuGiaoHang) {
        lichsugiaohangrepo.save(lichSuGiaoHang);
    }

    public Optional<List<LichSuGiaoHang>> findAll() {
        return lichsugiaohangrepo.findAll();
    }
    
}
