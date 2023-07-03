/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duan1.Service.Impl;

import com.mycompany.duan1.Entity.DotKhuyenMai;
import com.mycompany.duan1.Repository.DotKhuyenMaiRepo;
import com.mycompany.duan1.Repository.Impl.DotKhuyenMaiRepoImpl;
import com.mycompany.duan1.Service.DotKhuyenMaiService;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Admin
 */
public class DotKhuyenMaiServiceImpl implements DotKhuyenMaiService{
    private final DotKhuyenMaiRepo dotkhuyenmairepo = new DotKhuyenMaiRepoImpl();

    public Optional<List<DotKhuyenMai>> findAll() {
        return dotkhuyenmairepo.findAll();
    }

    public void update(DotKhuyenMai dotkhuyenmai) {
        dotkhuyenmairepo.update(dotkhuyenmai);
    }

    

    public void save(DotKhuyenMai dotkhuyenmai) {
        dotkhuyenmairepo.save(dotkhuyenmai);
    }

    public Optional<List<DotKhuyenMai>> findByTrangThai(String tenTrangThai) {
        return dotkhuyenmairepo.findByTrangThai(tenTrangThai);
    }
    
}
