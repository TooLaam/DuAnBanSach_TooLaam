/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duan1.Service.Impl;

import com.mycompany.duan1.Entity.NhanVien;
import com.mycompany.duan1.Repository.Impl.NhanVienRepoImpl;
import com.mycompany.duan1.Repository.NhanVienRepo;
import com.mycompany.duan1.Service.NhanVienService;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Admin
 */
public class NhanVienServiceImpl implements NhanVienService {

    private final NhanVienRepo nhanvienrepo = new NhanVienRepoImpl();

    public Optional<NhanVien> findNVByEmail(String email) {
        return nhanvienrepo.findNVByEmail(email);
    }

    public Optional<List<NhanVien>> findAll() {
        return nhanvienrepo.findAll();
    }

//    public Optional<NhanVien> findNVById(Long idnv) {
//        return nhanvienrepo.findNVById(idnv);
//    }

}
