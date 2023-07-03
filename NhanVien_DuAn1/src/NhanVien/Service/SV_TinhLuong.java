/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NhanVien.Service;

import DomainModel.DM_NhanVIen;
import DomainModel.DM_TinhLuong;
import NhanVien.Repository.RP_TinhLuong;
import NhanVien.ViewModel.VM_BangNV;
import NhanVien.ViewModel.VM_TinhLuong;
import java.math.BigDecimal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class SV_TinhLuong {

    private RP_TinhLuong repo;
    
    public SV_TinhLuong() {
        repo = new RP_TinhLuong();
    }
    
    public List<VM_TinhLuong> hienThiThuong(int Thang, int Nam, String maNVCHeck) throws SQLException {
        List<VM_TinhLuong> QLCV = new ArrayList<>();
        List<DM_TinhLuong> CV = repo.hienThiThuongPhat(Thang, Nam, maNVCHeck);
        
        for (DM_TinhLuong c : CV) {
            VM_TinhLuong CVVM = new VM_TinhLuong("", c.getIdNV(), c.getMaNV(), 0, 0, c.getTongTienPhat(), c.getTongTienThuong(), BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE);
            
            QLCV.add(CVVM);
        }
        return QLCV;
        
    }
    
    public List<VM_TinhLuong> hienThiGioCong(int Thang, int Nam, String maNVCHeck) throws SQLException {
        List<VM_TinhLuong> QLCV = new ArrayList<>();
        List<DM_TinhLuong> CV = repo.hienThiGioCong(Thang, Nam, maNVCHeck);
        
        for (DM_TinhLuong c : CV) {
            VM_TinhLuong CVVM = new VM_TinhLuong("", c.getIdNV(), c.getMaNV(), 0, c.getSecond(), BigDecimal.ONE, BigDecimal.ONE, c.getMucLuong(), BigDecimal.ONE, BigDecimal.ONE);
            
            QLCV.add(CVVM);
        }
        return QLCV;
        
    }
    
    public void insertThuong(VM_TinhLuong c) {
        DM_TinhLuong CVDM = new DM_TinhLuong("", c.getIdNV(), "", c.getThang(), 0, c.getTongTienPhat(), c.getTongTienThuong(), BigDecimal.ONE, c.getTongTienCong(), BigDecimal.ONE);
        
        repo.insert(CVDM);
    }
    
    public List<VM_TinhLuong> hienThiTongLuong() throws SQLException {
        List<VM_TinhLuong> QLCV = new ArrayList<>();
        List<DM_TinhLuong> CV = repo.hienThiTinhLuong();
        
        for (DM_TinhLuong c : CV) {
            VM_TinhLuong CVVM = new VM_TinhLuong(c.getIdLuong(), c.getIdNV(), c.getMaNV(), c.getThang(), c.getSecond(), c.getTongTienPhat(), c.getTongTienThuong(), BigDecimal.ONE, c.getTongTienCong(), c.getTongLuong());
            
            QLCV.add(CVVM);
        }
        return QLCV;
        
    }

    public List<VM_TinhLuong> check(String idnv, int thang) throws SQLException {
        List<VM_TinhLuong> QLCV = new ArrayList<>();
        List<DM_TinhLuong> CV = repo.check(idnv, thang);
        
        for (DM_TinhLuong c : CV) {
            VM_TinhLuong CVVM = new VM_TinhLuong(c.getIdLuong(), c.getIdNV(), c.getMaNV(), c.getThang(), c.getSecond(), c.getTongTienPhat(), c.getTongTienThuong(), BigDecimal.ONE, c.getTongTienCong(), c.getTongLuong());
            
            QLCV.add(CVVM);
        }
        return QLCV;
        
    }
    
    public void suaTrangThaiCC(String ID, int Thang) throws SQLException {
        repo.suaTrangThaiCC(ID, Thang);
    }
    public void suaTrangThaiTP(String ID, int Thang) throws SQLException {
        repo.suaTrangThaiTP(ID, Thang);
    }
    
     public List<VM_BangNV> HienThi(int Thang) throws SQLException {
        List<VM_BangNV> chvm = new ArrayList<>();
        List<DM_NhanVIen> chdm = repo.hienThiNVChuaChamCOng(Thang);
        for (DM_NhanVIen nv : chdm) {
            VM_BangNV vm = new VM_BangNV(nv.getIDNV(), nv.getIDCV(), nv.getMa(), nv.getTen(), nv.getGioiTinh(), nv.getNgaySinh(), nv.getEmail(), nv.getSDT(), nv.getDiaChi(), nv.getMatKhau(), nv.getTrangThaiDiLam(), nv.getTrangTháihipper());
            chvm.add(vm);
        }
        return chvm;
    }
}
