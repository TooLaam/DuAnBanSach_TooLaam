/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duan1.Service.Impl;

import com.mycompany.duan1.Entity.CTSach;
import com.mycompany.duan1.Repository.CTSachRepo;
import com.mycompany.duan1.Repository.Impl.CTSachRepoImpl;
import com.mycompany.duan1.Service.CTSachService;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CTSachServiceImpl implements CTSachService{
    private final CTSachRepo ctsachrepo = new CTSachRepoImpl();

    @Override
    public List<CTSach> findAll() {
        return ctsachrepo.findAll();
    }

    @Override
    public CTSach findById(Long idctsach) {
        return ctsachrepo.findById(idctsach);
    }

    @Override
    public void updateSoLuongCTSach(Long idctsach, int soLuong) {
        ctsachrepo.updateSoLuongCTSach(idctsach, soLuong);
    }
    
    
}
