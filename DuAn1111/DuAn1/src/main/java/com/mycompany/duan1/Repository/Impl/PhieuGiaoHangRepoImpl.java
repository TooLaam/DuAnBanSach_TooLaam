/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duan1.Repository.Impl;

import com.mycompany.duan1.Entity.PhieuGiaoHang;
import com.mycompany.duan1.Entity.TrangThaiPhieuGiaoHang;
import com.mycompany.duan1.Repository.PhieuGiaoHangRepo;
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
public class PhieuGiaoHangRepoImpl implements PhieuGiaoHangRepo {

    public Optional<List<PhieuGiaoHang>> findByHoaDonID(Long idHD) {
        Optional<List<PhieuGiaoHang>> OPT;
        List<PhieuGiaoHang> listPGH;
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            String hql = "FROM PhieuGiaoHang pgh WHERE hoaDonId = :idHD";
            Query<PhieuGiaoHang> query = session.createQuery(hql, PhieuGiaoHang.class);
            query.setParameter("idHD", idHD);
            listPGH = query.getResultList();
            OPT = Optional.ofNullable(listPGH);
        }
        return OPT;
    }

    public void save(PhieuGiaoHang PGH) {
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            session.save(PGH);
        }
    }

    public Optional<PhieuGiaoHang> findByID(Long id) {
        PhieuGiaoHang PGH;
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            String hql = "FROM PhieuGiaoHang pgh WHERE id = :id";
            Query<PhieuGiaoHang> query = session.createQuery(hql, PhieuGiaoHang.class);
            query.setParameter("id", id);
            PGH = query.getSingleResult();
        }
        return Optional.ofNullable(PGH);
    }

    public void Update(PhieuGiaoHang PGH) {
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(PGH);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTrangThai(Long idTrangThai, Long idPGH) {
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            Transaction tx = session.beginTransaction();
            String hql = "UPDATE PhieuGiaoHang SET idTrangThai = :newId WHERE id = :idPGH";
            Query query = session.createQuery(hql);
            query.setParameter("newId", idTrangThai);
            query.setParameter("idPGH", idPGH);
            int rowsAffected = query.executeUpdate();
            tx.commit();
        }
    }

    public Optional<PhieuGiaoHang> findPGHByHDAndNewest(Long idHD) {
        Optional<PhieuGiaoHang> otp;
        PhieuGiaoHang pgh;
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            String hql = "From PhieuGiaoHang WHERE hoaDonId = :idHD Order by ngayTaoPhieu desc";
            Query query = session.createQuery(hql, PhieuGiaoHang.class);
            query.setMaxResults(1);
            query.setParameter("idHD", idHD);
            pgh = (PhieuGiaoHang) query.uniqueResult();
            otp = Optional.ofNullable(pgh);
        }
        return otp;
    }
}
