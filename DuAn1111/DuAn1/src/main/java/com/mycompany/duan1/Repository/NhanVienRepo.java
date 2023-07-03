/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.duan1.Repository;

import com.mycompany.duan1.Entity.NhanVien;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Admin
 */
public interface NhanVienRepo {

    Optional<NhanVien> findNVByEmail(String email);

    Optional<List<NhanVien>> findAll();

    Optional<NhanVien> findNVById(Long idnv);
    
}
