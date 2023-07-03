/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duan1.Repository.Impl;

import com.mycompany.duan1.Entity.ThongTinChiTiet;
import com.mycompany.duan1.Repository.ThongTinChiTietRepo;
import com.mycompany.duan1.Utilities.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Admin
 */
public class ThongTinChiTietRepoImple implements ThongTinChiTietRepo {

    @Override
    public void Save(ThongTinChiTiet ttct) {
        Transaction transaction;
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(ttct);
            transaction.commit();
        }
    }

    @Override
    public void update(ThongTinChiTiet ttct) {

        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.update(ttct);
                transaction.commit();

            } catch (Exception e) {
                transaction.rollback();
            } finally {
                session.close();
            }

        }
    }

    @Override
    public void updateAllTrangThai(Long idKH) {
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                String hql = "UPDATE ThongTinChiTiet "
                        + "SET is_primary = 0 "
                        + "WHERE IdKhachHang = :idKhachHang";
                Query query = session.createQuery(hql);
                query.setParameter("idKhachHang", idKH);
                int rowCount = query.executeUpdate();
                System.out.println(rowCount);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
            }
        }
    }
}
