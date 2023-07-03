/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duan1.Repository.Impl;

import com.mycompany.duan1.Entity.HinhThucThanhToan;
import com.mycompany.duan1.Repository.HinhThucThanhToanRepo;
import com.mycompany.duan1.Utilities.HibernateUtils;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Admin
 */
public class HinhThucThanhToanRepoImpl implements HinhThucThanhToanRepo{


    public List<HinhThucThanhToan> findAll() {
        List<HinhThucThanhToan> hinhThucThanhToans;
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            String hql = "From HinhThucThanhToan";
            Query<HinhThucThanhToan> query = session.createQuery(hql,HinhThucThanhToan.class);
            hinhThucThanhToans = query.getResultList();
        }
        return hinhThucThanhToans;
    }
}
