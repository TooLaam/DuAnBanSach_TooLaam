/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duan1.Repository.Impl;

import com.mycompany.duan1.Entity.HoaDon;
import com.mycompany.duan1.Repository.HoaDonRepo;
import com.mycompany.duan1.Utilities.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.engine.transaction.internal.TransactionImpl;
import org.hibernate.query.Query;

/**
 *
 * @author Admin
 */
public class HoaDonRepoImpl implements HoaDonRepo {
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

    public void save(HoaDon hd) {
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            Transaction tran = session.beginTransaction();
            session.save(hd);
            tran.commit();
        }
    }

    public List<HoaDon> findAll() {
        List<HoaDon> listStaff;
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            String hql = "SELECT p FROM HoaDon p";
            Query<HoaDon> query = session.createQuery(hql, HoaDon.class);
            listStaff = query.getResultList();
        }
        return listStaff;
    }

    public HoaDon findByID(Long id) {
        HoaDon hoadon;
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            String hql = "FROM HoaDon WHERE id = :MHD";
            Query<HoaDon> query = session.createQuery(hql, HoaDon.class);
            query.setParameter("MHD", id);
            hoadon = query.getSingleResult();
        }
        return hoadon;
    }

    @Override
    public HoaDon find() {
        HoaDon hoadon;
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            String hql = "FROM HoaDon ORDER BY Id desc";
            Query<HoaDon> query = session.createQuery(hql, HoaDon.class);
            query.setMaxResults(1);
            hoadon = (HoaDon) query.uniqueResult();
        }
        return hoadon;
    }

    @Override
    public void updateTrangThaiHD(Long idHD, Long idTT) {
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            Transaction tran = session.beginTransaction();
            String hql = "Update HoaDon set IdTrangThaiHD = :idTT where Id = :idHD";
            Query<HoaDon> query = session.createQuery(hql);
            query.setParameter("idTT", idTT);
            query.setParameter("idHD", idHD);
            int countRowUpdate = query.executeUpdate();
            tran.commit();
            System.out.println("Có các trường đường update: " + countRowUpdate);
        }

    }
     public void updateHinhThucThanhToan(Long idHD, Long idHTTT) {
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            Transaction tran = session.beginTransaction();
            String hql = "Update HoaDon set IdHinhThucThanhToan = :ididHTTT where Id = :idHD";
            Query<HoaDon> query = session.createQuery(hql);
            query.setParameter("ididHTTT", idHTTT);
            query.setParameter("idHD", idHD);
            int countRowUpdate = query.executeUpdate();
            tran.commit();
            System.out.println("Có các trường đươc update: " + countRowUpdate);
        }

    }
}
