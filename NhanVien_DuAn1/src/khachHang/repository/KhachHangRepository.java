/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package khachHang.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import khachHang.model.CapBac;
import khachHang.model.DiaChi;
import khachHang.model.KhachHang;
import khachHang.model.KhachHangResponse;

/**
 *
 * @author ASUS
 */
public class KhachHangRepository {

    private DBContext connection = new DBContext();

    public ArrayList<KhachHang> getListKhachHang() {
        ArrayList<KhachHang> listKhachHang = new ArrayList<>();
        String query = "SELECT KhachHang.Id,KhachHang.Ma, KhachHang.Ten, KhachHang.GioiTinh, KhachHang.Email, KhachHang.SDT, CapBac.Id, KhachHang.NgayTao\n"
                + "FROM KhachHang\n"
                + "JOIN CapBac ON KhachHang.IdCapBac = CapBac.Id";
        try (Connection con = connection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang khachhang = new KhachHang();
                khachhang.setId(rs.getLong(1));
                khachhang.setMaKhachHang(rs.getString(2));
                khachhang.setTenKhachHang(rs.getString(3));
                khachhang.setGioiTinh(rs.getString(4));
                khachhang.setEmail(rs.getString(5));
                khachhang.setSDT(rs.getString(6));
                khachhang.setDiemTichLuy(rs.getLong(7));
                khachhang.setNgayTao(rs.getDate(8));
                listKhachHang.add(khachhang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKhachHang;
    }

    public ArrayList<KhachHangResponse> getListDiaChi() {
        ArrayList<KhachHangResponse> listKhachHang = new ArrayList<>();

        String query = "SELECT ttct.Id,kh.Id,kh.Ten,ttct.SDT,ttct.DiaChi, ttct.ThanhPho, ttct.NgayTao\n"
                + "FROM ThongTinChiTiet ttct\n"
                + "JOIN KhachHang kh ON ttct.IdKhachHang = kh.Id";
        try (Connection con = connection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHangResponse khrp = new KhachHangResponse();
                khrp.setIdDC(rs.getLong(1));
                khrp.setId(rs.getLong(2));
                khrp.setTen(rs.getString(3));
                khrp.setSdt(rs.getString(4));
                khrp.setDiaChi(rs.getString(5));
                khrp.setThanhPho(rs.getString(6));
                khrp.setNgayTao(rs.getDate(7));

                listKhachHang.add(khrp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKhachHang;
    }

    public Boolean addNew(KhachHang khachhang) {
        String query = "insert into KhachHang(Ma, Ten, GioiTinh, Email, SDT, IdCapBac, NgayTao) values(?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = connection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, khachhang.getMaKhachHang());
            ps.setObject(2, khachhang.getTenKhachHang());
            ps.setObject(3, khachhang.getGioiTinh());
            ps.setObject(4, khachhang.getEmail());
            ps.setObject(5, khachhang.getSDT());
            ps.setLong(6, khachhang.getDiemTichLuy()); // Đặt giá trị cho cột DiemTichLuy
            ps.setObject(7, khachhang.getNgayTao());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public Boolean updateNew(String idKhachHang, KhachHang khachhang) {
        String query = "Update KhachHang set Ten=?,GioiTinh=?,Email=?,SDT=?,IdCapBac=?,NgayTao=? where Ma=?";
        try (Connection con = connection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, khachhang.getTenKhachHang());
            ps.setObject(2, khachhang.getGioiTinh());
            ps.setObject(3, khachhang.getEmail());
            ps.setObject(4, khachhang.getSDT());
            ps.setObject(5, khachhang.getDiemTichLuy());
            ps.setObject(6, khachhang.getNgayTao());
            ps.setObject(7, idKhachHang);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<KhachHang> Tim(String SDT) {
        ArrayList<KhachHang> list = new ArrayList<>();
        String query = "SELECT KhachHang.Id,KhachHang.Ma, KhachHang.Ten, KhachHang.GioiTinh,KhachHang.Email,KhachHang.SDT,CapBac.Id,KhachHang.NgayTao\n"
                + "FROM KhachHang\n"
                + "JOIN CapBac ON KhachHang.IdCapBac = CapBac.Id Where SDT=?";
        try (Connection con = connection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, SDT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang khachhang = new KhachHang();
                khachhang.setId(rs.getLong(1));
                khachhang.setMaKhachHang(rs.getString(2));
                khachhang.setTenKhachHang(rs.getString(3));
                khachhang.setGioiTinh(rs.getString(4));
                khachhang.setEmail(rs.getString(5));
                khachhang.setSDT(rs.getString(6));
                khachhang.setDiemTichLuy(rs.getLong(7));
                khachhang.setNgayTao(rs.getDate(8));
                list.add(khachhang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean sdtDaTonTai(String SDT) {
        String query = "SELECT COUNT(*) FROM KhachHang WHERE SDT = ?";
        try (Connection con = connection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, SDT);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean MaKHDaTonTai(String maKhachHang) {
        String query = "SELECT COUNT(*) FROM KhachHang WHERE Ma = ?";
        try (Connection con = connection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, maKhachHang);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean EmailDaTonTai(String Email) {
        String query = "SELECT COUNT(*) FROM KhachHang WHERE Email = ?";
        try (Connection con = connection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, Email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<String> getListCBKhachHang() {
        ArrayList<String> list = new ArrayList<>();
        String sql = "Select CapBac.Id from CapBac";
        try (Connection con = connection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String isPrimary = rs.getString(1);
                list.add(isPrimary);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    

}
