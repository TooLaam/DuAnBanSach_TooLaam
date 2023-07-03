/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NhanVien.Service;

import DomainModel.DM_NhanVIen;
import DomainModel.DM_ThongKe;
import NhanVien.Repository.RP_ThongKe;
import NhanVien.ViewModel.VM_BangNV;
import NhanVien.ViewModel.VM_ThongKe;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class SV_ThongKe {

    private RP_ThongKe repo;

    public SV_ThongKe() {
        repo = new RP_ThongKe();
    }

    public List<VM_ThongKe> HienThiGioiTinh(String yeuCau) throws SQLException {
        List<VM_ThongKe> chvm = new ArrayList<>();
        List<DM_ThongKe> chdm = repo.hienThiGioiTinh(yeuCau);
        for (DM_ThongKe nv : chdm) {
            VM_ThongKe vm = new VM_ThongKe(nv.getTongSoNV(), nv.getTongSoNamNu(), nv.getTongSoNam(), nv.getTongSoDangLam(), nv.getTongSoTamNghi(), nv.getTongSoNghi(), nv.getTongSoCoTheGiaoHang(), nv.getTongSoKhongTheGiaoHang());
            chvm.add(vm);
        }
        return chvm;
    }

    public List<VM_ThongKe> HienThiAll() throws SQLException {
        List<VM_ThongKe> chvm = new ArrayList<>();
        List<DM_ThongKe> chdm = repo.hienThiAll();
        for (DM_ThongKe nv : chdm) {
            VM_ThongKe vm = new VM_ThongKe(nv.getTongSoNV(), nv.getTongSoNamNu(), nv.getTongSoNam(), nv.getTongSoDangLam(), nv.getTongSoTamNghi(), nv.getTongSoNghi(), nv.getTongSoCoTheGiaoHang(), nv.getTongSoKhongTheGiaoHang());
            chvm.add(vm);
        }
        return chvm;
    }

    public List<VM_ThongKe> HienThiTrangThaiDiLam(String trangThai) throws SQLException {
        List<VM_ThongKe> chvm = new ArrayList<>();
        List<DM_ThongKe> chdm = repo.hienThiTrangThaiDiLam(trangThai);
        for (DM_ThongKe nv : chdm) {
            VM_ThongKe vm = new VM_ThongKe(nv.getTongSoNV(), nv.getTongSoNamNu(), nv.getTongSoNam(), nv.getTongSoDangLam(), nv.getTongSoTamNghi(), nv.getTongSoNghi(), nv.getTongSoCoTheGiaoHang(), nv.getTongSoKhongTheGiaoHang());
            chvm.add(vm);
        }
        return chvm;
    }

    public List<VM_ThongKe> HienThiTrangThaiShip(String trangThai) throws SQLException {
        List<VM_ThongKe> chvm = new ArrayList<>();
        List<DM_ThongKe> chdm = repo.hienThiTrangThaiShip(trangThai);
        for (DM_ThongKe nv : chdm) {
            VM_ThongKe vm = new VM_ThongKe(nv.getTongSoNV(), nv.getTongSoNamNu(), nv.getTongSoNam(), nv.getTongSoDangLam(), nv.getTongSoTamNghi(), nv.getTongSoNghi(), nv.getTongSoCoTheGiaoHang(), nv.getTongSoKhongTheGiaoHang());
            chvm.add(vm);
        }
        return chvm;
    }

    public List<VM_BangNV> HienThiTableGioiTinh(String gioiTinhMuon) throws SQLException {
        List<VM_BangNV> chvm = new ArrayList<>();
        List<DM_NhanVIen> chdm = repo.hienThiTableGioiTinh(gioiTinhMuon);
        for (DM_NhanVIen nv : chdm) {
            VM_BangNV vm = new VM_BangNV(nv.getIDNV(), nv.getIDCV(), nv.getMa(), nv.getTen(), nv.getGioiTinh(), nv.getNgaySinh(), nv.getEmail(), nv.getSDT(), nv.getDiaChi(), nv.getMatKhau(), nv.getTrangThaiDiLam(), nv.getTrangTháihipper());
            chvm.add(vm);
        }
        return chvm;
    }

    public List<VM_BangNV> HienThiTableDiLam(String trangThaiLam) throws SQLException {
        List<VM_BangNV> chvm = new ArrayList<>();
        List<DM_NhanVIen> chdm = repo.hienThiTableTrangThaiLam(trangThaiLam);
        for (DM_NhanVIen nv : chdm) {
            VM_BangNV vm = new VM_BangNV(nv.getIDNV(), nv.getIDCV(), nv.getMa(), nv.getTen(), nv.getGioiTinh(), nv.getNgaySinh(), nv.getEmail(), nv.getSDT(), nv.getDiaChi(), nv.getMatKhau(), nv.getTrangThaiDiLam(), nv.getTrangTháihipper());
            chvm.add(vm);
        }
        return chvm;
    }
    
    public List<VM_BangNV> HienThiTableShip(String trangThaiLam) throws SQLException {
        List<VM_BangNV> chvm = new ArrayList<>();
        List<DM_NhanVIen> chdm = repo.hienThiTableTrangThaiShip(trangThaiLam);
        for (DM_NhanVIen nv : chdm) {
            VM_BangNV vm = new VM_BangNV(nv.getIDNV(), nv.getIDCV(), nv.getMa(), nv.getTen(), nv.getGioiTinh(), nv.getNgaySinh(), nv.getEmail(), nv.getSDT(), nv.getDiaChi(), nv.getMatKhau(), nv.getTrangThaiDiLam(), nv.getTrangTháihipper());
            chvm.add(vm);
        }
        return chvm;
    }
    
    public List<VM_ThongKe> HienThiDoanhThuTheoNV(String maNVtim,String ngayBD, String ngayKT) throws SQLException {
        List<VM_ThongKe> chvm = new ArrayList<>();
        List<DM_ThongKe> chdm = repo.hienThiDoanhThuTheoNV(maNVtim, ngayBD, ngayKT);
        for (DM_ThongKe nv : chdm) {
            VM_ThongKe vm = new VM_ThongKe(nv.getNgayBD(), nv.getNgayKT(), nv.getMaNV(), nv.getMaSP(), nv.getTenSP(), nv.getSLBan(), nv.getDoanhThuTheoSP(), nv.getTongSPBan(), nv.getTongDoanhThuBan(), nv.getTongHDBan());
            chvm.add(vm);
        }
        return chvm;
    }
    
    public List<VM_ThongKe> HienThiTongSPNVBan(String maNVtim,String ngayBD, String ngayKT) throws SQLException {
        List<VM_ThongKe> chvm = new ArrayList<>();
        List<DM_ThongKe> chdm = repo.hienThiTongSPNVBanDuoc(maNVtim, ngayBD, ngayKT);
        for (DM_ThongKe nv : chdm) {
            VM_ThongKe vm = new VM_ThongKe(nv.getNgayBD(), nv.getNgayKT(), nv.getMaNV(), nv.getMaSP(), nv.getTenSP(), nv.getSLBan(), nv.getDoanhThuTheoSP(), nv.getTongSPBan(), nv.getTongDoanhThuBan(), nv.getTongHDBan());
            chvm.add(vm);
        }
        return chvm;
    }

    public List<VM_ThongKe> HienThiTongHD(String maNVtim,String ngayBD, String ngayKT) throws SQLException {
        List<VM_ThongKe> chvm = new ArrayList<>();
        List<DM_ThongKe> chdm = repo.hienThiTongHD(maNVtim, ngayBD, ngayKT);
        for (DM_ThongKe nv : chdm) {
            VM_ThongKe vm = new VM_ThongKe(nv.getNgayBD(), nv.getNgayKT(), nv.getMaNV(), nv.getMaSP(), nv.getTenSP(), nv.getSLBan(), nv.getDoanhThuTheoSP(), nv.getTongSPBan(), nv.getTongDoanhThuBan(), nv.getTongHDBan());
            chvm.add(vm);
        }
        return chvm;
    }
}
