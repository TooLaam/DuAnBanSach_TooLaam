/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duan1.Service.Impl;

import com.mycompany.duan1.Entity.PhieuGiaoHang;
import com.mycompany.duan1.Repository.Impl.PhieuGiaoHangRepoImpl;
import com.mycompany.duan1.Repository.PhieuGiaoHangRepo;
import com.mycompany.duan1.Service.PhieuGiaoHangService;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Admin
 */
public class PhieuGiaoHangServiceImpl implements PhieuGiaoHangService {

    private PhieuGiaoHangRepo phieugiaohangRepo = new PhieuGiaoHangRepoImpl();

    public Optional<List<PhieuGiaoHang>> findByHoaDonID(Long idHD) {
        return phieugiaohangRepo.findByHoaDonID(idHD);
    }

    public void save(PhieuGiaoHang PGH) {
        phieugiaohangRepo.save(PGH);
    }

    public Optional<PhieuGiaoHang> findByID(Long id) {
        return phieugiaohangRepo.findByID(id);
    }

    public void Update(PhieuGiaoHang PGH) {
        phieugiaohangRepo.Update(PGH);
    }

    public void setTrangThai(Long idTrangThai, Long idPGH) {
        phieugiaohangRepo.setTrangThai(idTrangThai, idPGH);
    }

    public Optional<PhieuGiaoHang> findPGHByHDAndNewest(Long idHD) {
        return phieugiaohangRepo.findPGHByHDAndNewest(idHD);
    }

    

}
