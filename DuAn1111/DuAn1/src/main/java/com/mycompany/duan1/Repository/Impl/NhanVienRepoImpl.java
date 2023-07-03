/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duan1.Repository.Impl;

import com.mycompany.duan1.Entity.NhanVien;
import com.mycompany.duan1.Repository.NhanVienRepo;
import com.mycompany.duan1.Utilities.HibernateUtils;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Admin
 */
public class NhanVienRepoImpl implements NhanVienRepo {

    @Override
    public Optional<NhanVien> findNVByEmail(String email) {
        Optional<NhanVien> otp;
        String hql = "FROM NhanVien WHERE Email = :email";
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            Query<NhanVien> query = session.createQuery(hql, NhanVien.class);
            query.setParameter("email", email);
            NhanVien nhanVien = query.uniqueResult();
            otp = Optional.ofNullable(nhanVien);
        }
        return otp;
    }
    @Override
    public Optional<NhanVien> findNVById(Long IdNV) {
        Optional<NhanVien> otp;
        String hql = "FROM NhanVien WHERE Id = :IdNV";
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            Query<NhanVien> query = session.createQuery(hql, NhanVien.class);
            query.setParameter("IdNV", IdNV);
            NhanVien nhanVien = query.uniqueResult();
            otp = Optional.ofNullable(nhanVien);
        }
        return otp;
    }

    @Override
    public Optional<List<NhanVien>> findAll() {
        Optional<List<NhanVien>> otp;
        List<NhanVien> listNV;
        String hql = "FROM NhanVien";
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            Query<NhanVien> query = session.createQuery(hql, NhanVien.class);
            listNV = query.getResultList();
            otp = Optional.ofNullable(listNV);
        }
        return otp;
    }

}
