/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duan1.Service.Impl;

import com.mycompany.duan1.Entity.LichSuCapNhatTrangThai;
import com.mycompany.duan1.Repository.Impl.LichSuCapNhatTrangThaiRepoImpl;
import com.mycompany.duan1.Repository.LichSuCapNhatTrangThaiRepo;
import com.mycompany.duan1.Service.LichSuCapNhatTrangThaiService;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Admin
 */
public class LichSuCapNhatTrangThaiServiceImpl implements LichSuCapNhatTrangThaiService{
    private final LichSuCapNhatTrangThaiRepo lichSuCapNhatTrangThaiRepo = new LichSuCapNhatTrangThaiRepoImpl();

    public void save(LichSuCapNhatTrangThai lichSuCapNhatTrangThai) {
        lichSuCapNhatTrangThaiRepo.save(lichSuCapNhatTrangThai);
    }

    public Optional<List<LichSuCapNhatTrangThai>> findByIdPGH(Long IdPGH) {
        return lichSuCapNhatTrangThaiRepo.findByIdPGH(IdPGH);
    }
      
}
