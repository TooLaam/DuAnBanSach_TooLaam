/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duan1.Repository.Impl;

import com.mycompany.duan1.Entity.HoaDonChiTiet;
import com.mycompany.duan1.Repository.ChiTietHoaDonRepo;
import com.mycompany.duan1.Utilities.HibernateUtils;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Admin
 */
public class HoaDonChiTietRepoImpl implements ChiTietHoaDonRepo{

    public void save(HoaDonChiTiet cthd) {
        try(Session session = HibernateUtils.getFACTORY().openSession()){
            Transaction tran = session.beginTransaction();
            session.save(cthd);
            tran.commit();
        }
    }
    public Optional<List<HoaDonChiTiet>> findByIDHD(Long idHD){
        List<HoaDonChiTiet> listHDCT;
        try(Session session = HibernateUtils.getFACTORY().openSession()){
            String hql = "FROM HoaDonChiTiet Where IdHoaDon = :idHD";
            Query<HoaDonChiTiet> query = session.createQuery(hql,HoaDonChiTiet.class);
            query.setParameter("idHD", idHD);
            listHDCT = query.getResultList();
        }
        return Optional.ofNullable(listHDCT);
    }
}
