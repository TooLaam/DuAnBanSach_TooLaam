/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duan1.Repository.Impl;

import com.mycompany.duan1.Entity.CapBac;
import com.mycompany.duan1.Repository.CapBacRepo;
import com.mycompany.duan1.Utilities.HibernateUtils;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Admin
 */
public class CapBacRepoImpl implements CapBacRepo{
    public Optional<List<CapBac>> findAllCapBac(){
        Optional<List<CapBac>> otp;
        List<CapBac> list;
        try(Session session = HibernateUtils.getFACTORY().openSession()){
            String hql ="From CapBac";
            Query<CapBac> query = session.createQuery(hql,CapBac.class);
            list = query.getResultList();
            otp = Optional.ofNullable(list);
        }
        return otp;
    }
}
