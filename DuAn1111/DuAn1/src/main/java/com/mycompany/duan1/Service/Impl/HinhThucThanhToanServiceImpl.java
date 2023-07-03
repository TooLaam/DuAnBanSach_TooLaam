/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duan1.Service.Impl;

import com.mycompany.duan1.Entity.HinhThucThanhToan;
import com.mycompany.duan1.Repository.HinhThucThanhToanRepo;
import com.mycompany.duan1.Repository.Impl.HinhThucThanhToanRepoImpl;
import com.mycompany.duan1.Service.HinhThucThanhToanService;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HinhThucThanhToanServiceImpl implements HinhThucThanhToanService{
    private final HinhThucThanhToanRepo hinhThucThanhToanRepo = new HinhThucThanhToanRepoImpl();

    public List<HinhThucThanhToan> findAll() {
        return hinhThucThanhToanRepo.findAll();
    }
    
}
