/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NhanVien.Service;


import DomainModel.DM_ChamCong;
import NhanVien.Repository.RP_ChamCong;
import NhanVien.ViewModel.VM_BangCC;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class SV_ChamCong {
     private RP_ChamCong repoCC;
    
    public SV_ChamCong(){
        repoCC = new RP_ChamCong();
    }
    
    public List<VM_BangCC> HienThi(String NgayLam) throws SQLException {
        List<VM_BangCC> chvm = new ArrayList<>();
        List<DM_ChamCong> chdm = repoCC.hienThi(NgayLam);
        for (DM_ChamCong nv : chdm) {
            VM_BangCC vm = new VM_BangCC(nv.getIdCC(), nv.getIDNV(), nv.getNgayLam(), nv.getTenNV(), nv.getTrangThai(),nv.getTrangThaiTinhLuong(), nv.getGioIN(),nv.getGioOUT());
            chvm.add(vm);
        }
        return chvm;
    }
    
     public void insert(VM_BangCC vm) {
        DM_ChamCong chdm = new DM_ChamCong(vm.getIdCC(), vm.getIDNV(), vm.getNgayLam(), "", vm.getTrangThai(),0,vm.getGioIN(), vm.getGioOUT());
        repoCC.insert(chdm);
        
        
    }
     
     
     public List<VM_BangCC> CheckIN(String NgayLam, String idnv) throws SQLException {
        List<VM_BangCC> chvm = new ArrayList<>();
        List<DM_ChamCong> chdm = repoCC.CheckIN(NgayLam, idnv);
        for (DM_ChamCong nv : chdm) {
            VM_BangCC vm = new VM_BangCC(nv.getIdCC(), nv.getIDNV(), nv.getNgayLam(), nv.getTenNV(), nv.getTrangThai(),nv.getTrangThaiTinhLuong(), nv.getGioIN(), nv.getGioOUT());
            chvm.add(vm);
        }
        return chvm;
    }
     
      public List<VM_BangCC> CheckOUT(String NgayLam, String idnv) throws SQLException {
        List<VM_BangCC> chvm = new ArrayList<>();
        List<DM_ChamCong> chdm = repoCC.CheckOUT(NgayLam, idnv);
        for (DM_ChamCong nv : chdm) {
            VM_BangCC vm = new VM_BangCC(nv.getIdCC(), nv.getIDNV(), nv.getNgayLam(), nv.getTenNV(), nv.getTrangThai(),nv.getTrangThaiTinhLuong(), nv.getGioIN(), nv.getGioOUT());
            chvm.add(vm);
        }
        return chvm;
    }
      
      public void update(String IDNV,String ngayLam ) throws SQLException {
      
        repoCC.suaOUT(IDNV, ngayLam);
    }
      
        public List<VM_BangCC> CheckTinhTrangDiLam(String idnv) throws SQLException {
        List<VM_BangCC> chvm = new ArrayList<>();
        List<DM_ChamCong> chdm = repoCC.CheckTinhTrangDiLam(idnv);
        for (DM_ChamCong nv : chdm) {
            VM_BangCC vm = new VM_BangCC(nv.getIdCC(), nv.getIDNV(), nv.getNgayLam(), nv.getTenNV(), nv.getTrangThai(),nv.getTrangThaiTinhLuong(), nv.getGioIN(), nv.getGioOUT());
            chvm.add(vm);
        }
        return chvm;
    }
        
         public List<VM_BangCC> HienThiTrongThang(String Thang,String Nam, String maNV) throws SQLException {
        List<VM_BangCC> chvm = new ArrayList<>();
        List<DM_ChamCong> chdm = repoCC.hienThiTrongThang(Thang, Nam, maNV);
        for (DM_ChamCong nv : chdm) {
            VM_BangCC vm = new VM_BangCC(nv.getIdCC(), nv.getIDNV(), nv.getNgayLam(), nv.getTenNV(), nv.getTrangThai(),nv.getTrangThaiTinhLuong(), nv.getGioIN(),nv.getGioOUT());
            chvm.add(vm);
        }
        return chvm;
    }
}
