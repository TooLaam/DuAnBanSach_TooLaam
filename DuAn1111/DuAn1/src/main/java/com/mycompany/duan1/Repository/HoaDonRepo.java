/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.duan1.Repository;

import com.mycompany.duan1.Entity.HoaDon;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface HoaDonRepo {

    List<HoaDon> findAll();

    HoaDon findByID(Long id);

    HoaDon find();

    //    public List<Staff> findAll(){
    //       List<Staff> listStaff;
    //        try (Session session = HibernateUtils.getFACTORY().openSession()) {
    //            String hql = "SELECT p FROM Staff p";
    //            Query<Staff> query = session.createQuery(hql,Staff.class);
    //
    //            listStaff = query.getResultList();
    //        }
    //        return listStaff;
    //    }
    void save(HoaDon hd);

    void updateTrangThaiHD(Long idHD, Long idTT);

    void updateHinhThucThanhToan(Long idHD, Long idHTTT);
}
