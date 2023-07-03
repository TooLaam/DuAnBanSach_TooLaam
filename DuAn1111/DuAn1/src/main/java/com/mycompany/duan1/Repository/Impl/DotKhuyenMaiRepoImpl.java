/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duan1.Repository.Impl;

import com.mycompany.duan1.Entity.DotKhuyenMai;
import com.mycompany.duan1.Repository.DotKhuyenMaiRepo;
import com.mycompany.duan1.Utilities.HibernateUtils;
import java.util.Date;

import java.util.List;
import java.util.Optional;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Admin
 */
public class DotKhuyenMaiRepoImpl implements DotKhuyenMaiRepo {

    public Optional<List<DotKhuyenMai>> findAll() {
        List<DotKhuyenMai> listdotkhuyenmai;
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            String hql = " FROM DotKhuyenMai";
            Query<DotKhuyenMai> query = session.createQuery(hql, DotKhuyenMai.class);
            listdotkhuyenmai = query.getResultList();
        }
//        Optional.ofNullable() là một phương thức tĩnh trong lớp Optional trong Java
//        . Phương thức này được sử dụng để tạo một đối tượng Optional từ một giá trị có thể null.
//
//        Optional là một lớp giúp xử lý các giá trị có thể null một cách an toàn trong Java
//        . Nó giúp tránh các lỗi NullPointerException và cung cấp các phương thức tiện ích để kiểm tra 
//        và truy xuất giá trị một cách linh hoạt
//        .
//
//        Phương thức ofNullable() nhận đầu vào là một giá trị có thể null 
//        và trả về một đối tượng Optional.Nếu giá trị đầu vào là null, đối tượng Optional sẽ được khởi tạo với giá trị rỗng(empty).Nếu giá trị đầu vào khác null, đối tượng Optional sẽ được khởi tạo với giá trị được đóng gói trong nó.
        return Optional.ofNullable(listdotkhuyenmai);
    }


    public void save(DotKhuyenMai dotkhuyenmai) {
        Transaction trans;
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            trans = session.beginTransaction();
            session.save(dotkhuyenmai);
            trans.commit();
        }
    }
     public void update(DotKhuyenMai dotkhuyenmai) {
        Transaction trans;
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            trans = session.beginTransaction();
            session.update(dotkhuyenmai);
            trans.commit();
        }
    }
     
      public Optional<List<DotKhuyenMai>> findByTrangThai(String tenTrangThai) {
        List<DotKhuyenMai> listDotKhuyenMai;
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
           String hql = "From DotKhuyenMai Where TrangThai = :ten";
           Query<DotKhuyenMai> query = session.createQuery(hql,DotKhuyenMai.class);
           query.setParameter("ten", tenTrangThai);
           listDotKhuyenMai = query.getResultList();
        }
        return Optional.ofNullable(listDotKhuyenMai);
    }
}
