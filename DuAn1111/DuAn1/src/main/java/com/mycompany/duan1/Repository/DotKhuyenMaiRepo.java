/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duan1.Repository;

import com.mycompany.duan1.Entity.DotKhuyenMai;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Admin
 */
public interface DotKhuyenMaiRepo {

    Optional<List<DotKhuyenMai>> findAll();

    void save(DotKhuyenMai dotkhuyenmai);

    void update(DotKhuyenMai dotkhuyenmai);

    Optional<List<DotKhuyenMai>> findByTrangThai(String tenTrangThai);
    
}
