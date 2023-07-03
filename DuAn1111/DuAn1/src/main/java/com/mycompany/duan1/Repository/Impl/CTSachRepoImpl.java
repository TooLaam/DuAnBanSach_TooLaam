/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duan1.Repository.Impl;

import com.mycompany.duan1.Entity.CTSach;
import com.mycompany.duan1.Repository.CTSachRepo;
import com.mycompany.duan1.Utilities.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Admin
 */
public class CTSachRepoImpl implements CTSachRepo {

    @Override
    public List<CTSach> findAll() {
        List<CTSach> list;
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            String hql = "From CTSach";
            Query<CTSach> query = session.createQuery(hql, CTSach.class);
            list = query.getResultList();
        }
        return list;
    }

    @Override
    public CTSach findById(Long idctsach) {
        CTSach ctsach;
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            String hql = "From CTSach where IdCTSach = :idctsach";
            Query<CTSach> query = session.createQuery(hql, CTSach.class);
            query.setParameter("idctsach", idctsach);
            ctsach = query.uniqueResult();
        }
        return ctsach;
    }

    @Override
    public void updateSoLuongCTSach(Long idctsach, int soLuong) {
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            Transaction trans = session.beginTransaction();
            String hql = "Update CTSach Set SoLuong = :SL where IdCTSach = :idctsach ";
            Query<CTSach> query = session.createQuery(hql);
            query.setParameter("idctsach", idctsach);
            query.setParameter("SL", soLuong);
            int resultCount = query.executeUpdate();
            trans.commit();
            System.out.println("Số lương bản ghi đã đươch update là :" + resultCount);
        }

    }
}
