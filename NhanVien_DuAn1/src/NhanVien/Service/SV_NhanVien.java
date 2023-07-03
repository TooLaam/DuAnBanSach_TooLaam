/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NhanVien.Service;

import DomainModel.DM_NhanVIen;
import NhanVien.Repository.RP_NhanVien;
import NhanVien.ViewModel.VM_BangNV;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class SV_NhanVien {
    private RP_NhanVien repoNV;
    
    public SV_NhanVien(){
        repoNV = new RP_NhanVien();
    }
    
    
     public List<VM_BangNV> HienThi() throws SQLException {
        List<VM_BangNV> chvm = new ArrayList<>();
        List<DM_NhanVIen> chdm = repoNV.hienThi();
        for (DM_NhanVIen nv : chdm) {
            VM_BangNV vm = new VM_BangNV(nv.getIDNV(), nv.getIDCV(), nv.getMa(), nv.getTen(), nv.getGioiTinh(), nv.getNgaySinh(), nv.getEmail(), nv.getSDT(), nv.getDiaChi(), nv.getMatKhau(), nv.getTrangThaiDiLam(), nv.getTrangTháihipper());
            chvm.add(vm);
        }
        return chvm;
    }
     
      public void update(String Ma, VM_BangNV vm) throws SQLException {
        DM_NhanVIen dm = new DM_NhanVIen(vm.getIDNV(), vm.getTenCV(), vm.getMa(), vm.getTen(), vm.getGioiTinh(), vm.getNgaySinh(), vm.getEmail(), vm.getSDT(), vm.getDiaChi(), vm.getMatKhau(), vm.getTrangThaiDiLam(), vm.getTrangTháihipper());
        repoNV.suaNV(Ma, dm);
    }
      
      
       public void insert(VM_BangNV vm) {
        DM_NhanVIen chdm = new DM_NhanVIen(vm.getIDNV(), vm.getTenCV(), vm.getMa(), vm.getTen(), vm.getGioiTinh(), vm.getNgaySinh(), vm.getEmail(), vm.getSDT(), vm.getDiaChi(), vm.getMatKhau(), vm.getTrangThaiDiLam(), vm.getTrangTháihipper());
        repoNV.insert(chdm);
        
        
    }
       
        public List<VM_BangNV> HienThitheoMa(String Ma) throws SQLException {
        List<VM_BangNV> chvm = new ArrayList<>();
        List<DM_NhanVIen> chdm = repoNV.hienThitheoMa(Ma);
        for (DM_NhanVIen nv : chdm) {
            VM_BangNV vm = new VM_BangNV(nv.getIDNV(), nv.getIDCV(), nv.getMa(), nv.getTen(), nv.getGioiTinh(), nv.getNgaySinh(), nv.getEmail(), nv.getSDT(), nv.getDiaChi(), nv.getMatKhau(), nv.getTrangThaiDiLam(), nv.getTrangTháihipper());
            chvm.add(vm);
        }
        return chvm;
    }
        public List<VM_BangNV> HienThitheoEmail(String Ma) throws SQLException {
        List<VM_BangNV> chvm = new ArrayList<>();
        List<DM_NhanVIen> chdm = repoNV.hienThitheoEmail(Ma);
        for (DM_NhanVIen nv : chdm) {
            VM_BangNV vm = new VM_BangNV(nv.getIDNV(), nv.getIDCV(), nv.getMa(), nv.getTen(), nv.getGioiTinh(), nv.getNgaySinh(), nv.getEmail(), nv.getSDT(), nv.getDiaChi(), nv.getMatKhau(), nv.getTrangThaiDiLam(), nv.getTrangTháihipper());
            chvm.add(vm);
        }
        return chvm;
    }
        
         public List<VM_BangNV> dangNhap(String manv, String matKhau) throws SQLException {
        List<VM_BangNV> chvm = new ArrayList<>();
        List<DM_NhanVIen> chdm = repoNV.dangNhap(manv, matKhau);
        for (DM_NhanVIen nv : chdm) {
            VM_BangNV vm = new VM_BangNV(nv.getIDNV(), nv.getIDCV(), nv.getMa(), nv.getTen(), nv.getGioiTinh(), nv.getNgaySinh(), nv.getEmail(), nv.getSDT(), nv.getDiaChi(), nv.getMatKhau(), nv.getTrangThaiDiLam(), nv.getTrangTháihipper());
            chvm.add(vm);
        }
        return chvm;
    }
}
