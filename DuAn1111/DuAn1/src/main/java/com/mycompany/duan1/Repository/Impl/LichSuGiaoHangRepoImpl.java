/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duan1.Repository.Impl;

import com.mycompany.duan1.Entity.LichSuGiaoHang;
import com.mycompany.duan1.Entity.NhanVien;
import com.mycompany.duan1.Repository.LichSuGiaoHangRepo;
import com.mycompany.duan1.Utilities.HibernateUtils;
import java.util.List;
import java.util.Optional;
import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Admin
 */
public class LichSuGiaoHangRepoImpl implements LichSuGiaoHangRepo {

    public void save(LichSuGiaoHang lichSuGiaoHang) {
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(lichSuGiaoHang);
            transaction.commit();
        }
    }

    public void Update(LichSuGiaoHang lichSuGiaoHang) {
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(lichSuGiaoHang);
            transaction.commit();
        }
    }

    public Optional<List<LichSuGiaoHang>> findAll() {
        Optional<List<LichSuGiaoHang>> otp;
        List<LichSuGiaoHang> listLSGH;
        String hql = "FROM LichSuGiaoHang";
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            Query<LichSuGiaoHang> query = session.createQuery(hql, LichSuGiaoHang.class);
            listLSGH = query.getResultList();
            otp = Optional.ofNullable(listLSGH);
        }
        return otp;
    }
}
