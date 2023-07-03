/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duan1.Service;

import com.mycompany.duan1.Entity.CTSach;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface CTSachService {

    List<CTSach> findAll();

    CTSach findById(Long idctsach);

    void updateSoLuongCTSach(Long idctsach, int soLuong);
    
}
