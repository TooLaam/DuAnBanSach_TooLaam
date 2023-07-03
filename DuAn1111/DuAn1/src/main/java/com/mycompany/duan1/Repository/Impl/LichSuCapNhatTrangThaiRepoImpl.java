/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duan1.Repository.Impl;

import com.mycompany.duan1.Entity.LichSuCapNhatTrangThai;
import com.mycompany.duan1.Repository.LichSuCapNhatTrangThaiRepo;
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
public class LichSuCapNhatTrangThaiRepoImpl implements LichSuCapNhatTrangThaiRepo {

    public void save(LichSuCapNhatTrangThai lichSuCapNhatTrangThai) {
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(lichSuCapNhatTrangThai);
            transaction.commit();
        }
    }

    public Optional<List<LichSuCapNhatTrangThai>> findByIdPGH(Long IdPGH) {
        Optional<List<LichSuCapNhatTrangThai>> otp;
        List<LichSuCapNhatTrangThai> list;
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            String hql = "From LichSuCapNhatTrangThai where idPGH = :IdPGH";
            Query<LichSuCapNhatTrangThai> query = session.createQuery(hql, LichSuCapNhatTrangThai.class);
            query.setParameter("IdPGH", IdPGH);
            list = query.getResultList();
            otp = Optional.ofNullable(list);
        }
        return otp;
    }

}
