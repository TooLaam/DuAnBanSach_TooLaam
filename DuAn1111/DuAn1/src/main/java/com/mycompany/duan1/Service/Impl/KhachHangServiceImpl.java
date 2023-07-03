/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duan1.Service.Impl;

import com.mycompany.duan1.Entity.KhachHang;
import com.mycompany.duan1.Repository.Impl.KhachHangRepoImple;
import com.mycompany.duan1.Repository.KhachHangRepo;
import com.mycompany.duan1.Service.KhachHangService;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Admin
 */
public class KhachHangServiceImpl implements KhachHangService{
    private KhachHangRepo khachhangrepo = new KhachHangRepoImple();

    public Optional<KhachHang> findByID(Long id) {
        return khachhangrepo.findByID(id);
    }

    public Optional<KhachHang> findKHByName(String name) {
        return khachhangrepo.findKHByName(name);
    }

    public List<KhachHang> findAll() {
        return khachhangrepo.findAll();
    }

    public void save(KhachHang kh) {
        khachhangrepo.save(kh);
    }
    
    
}
