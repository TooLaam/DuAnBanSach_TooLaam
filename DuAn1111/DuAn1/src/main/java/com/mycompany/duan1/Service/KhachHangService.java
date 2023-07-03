/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.duan1.Service;

import com.mycompany.duan1.Entity.KhachHang;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Admin
 */
public interface KhachHangService {

    Optional<KhachHang> findByID(Long id);

    Optional<KhachHang> findKHByName(String name);

    List<KhachHang> findAll();

    void save(KhachHang kh);
    
}
