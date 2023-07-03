/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duan1.Service.Impl;

import com.mycompany.duan1.Entity.CapBac;
import com.mycompany.duan1.Repository.CapBacRepo;
import com.mycompany.duan1.Repository.Impl.CapBacRepoImpl;
import com.mycompany.duan1.Service.CapBacService;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Admin
 */
public class CapBacServiceImpl implements CapBacService{
    private final CapBacRepo capBacRepo = new CapBacRepoImpl();

    public Optional<List<CapBac>> findAllCapBac() {
        return capBacRepo.findAllCapBac();
    }
    
}
