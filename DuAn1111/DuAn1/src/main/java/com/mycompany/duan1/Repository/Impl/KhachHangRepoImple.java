/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duan1.Repository.Impl;

import com.mycompany.duan1.Entity.KhachHang;
import com.mycompany.duan1.Repository.KhachHangRepo;
import com.mycompany.duan1.Utilities.HibernateUtils;
import java.util.List;
import org.hibernate.query.Query;

import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Admin
 */
public class KhachHangRepoImple implements KhachHangRepo {

//    public Optional<KhachHang> findByID(Long id) {
//        Optional<KhachHang> optional;
//        try (Session session = HibernateUtils.getFACTORY().openSession()) {
//            String hql = "FROM KhachHang WHERE id = :MKH";
//            Query<KhachHang> query = session.createQuery(hql, KhachHang.class);
//            query.setParameter("MKH", id);
//            KhachHang khachHang = query.uniqueResult();
//            optional = Optional.ofNullable(khachHang);
//        }
//        return optional;
//    }
    public Optional<KhachHang> findByID(Long id) {
        Optional<KhachHang> optional;
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            // sử dụng câu lện truy vấn trên để tránh lỗi
//        Lỗi "failed to lazily initialize a collection of role: com.mycompany.duan1.Entity.KhachHang.ctkh,"
//        + " could not initialize proxy - no Session" 
//        xuất hiện khi bạn cố gắng truy cập một mối quan hệ nhưng Session đã đóng trong Hibernate.
            String hql = "SELECT kh FROM KhachHang kh LEFT JOIN FETCH kh.ctkh WHERE kh.id = :MKH";
            Query<KhachHang> query = session.createQuery(hql, KhachHang.class);
            query.setParameter("MKH", id);
            KhachHang khachHang = query.uniqueResult();
            optional = Optional.ofNullable(khachHang);
        }
        return optional;

    }

    public Optional<KhachHang> findKHByName(String name) {
        Optional<KhachHang> optional;
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            // sử dụng câu lện truy vấn trên để tránh lỗi
//        Lỗi "failed to lazily initialize a collection of role: com.mycompany.duan1.Entity.KhachHang.ctkh,"
//        + " could not initialize proxy - no Session" 
//        xuất hiện khi bạn cố gắng truy cập một mối quan hệ nhưng Session đã đóng trong Hibernate.
            String hql = "SELECT kh FROM KhachHang kh LEFT JOIN FETCH kh.ctkh WHERE kh.Ten = :MKH";
            Query<KhachHang> query = session.createQuery(hql, KhachHang.class);
            query.setParameter("MKH", name);
            KhachHang khachHang = query.uniqueResult();
            optional = Optional.ofNullable(khachHang);
        }
        return optional;
    }

    public List<KhachHang> findAll() {
        List<KhachHang> danhsachKH;
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            String hql = "FROM KhachHang";
            Query<KhachHang> query = session.createQuery(hql, KhachHang.class);
            danhsachKH = query.getResultList();

        }
        return danhsachKH;
    }

    public void save(KhachHang kh) {
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            Transaction tran = session.beginTransaction();
            session.save(kh);
            tran.commit();
        }
    }
}
