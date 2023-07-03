/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package khachHang.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import khachHang.model.DiaChi;
import khachHang.model.KhachHang;
import khachHang.model.KhachHangResponse;

/**
 *
 * @author ASUS
 */
public class DiaChiRepository {

    private DBConnection connection = new DBConnection();

    public Boolean addNew(DiaChi diachi) {
        String query = "INSERT INTO ThongTinChiTiet\n"
                + "(IdKhachHang,DiaChi,SDT,ThanhPho,NgayTao)\n"
                + "VALUES(?,?,?,?,?)";
        try (Connection con = connection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setLong(1, diachi.getIdKhachHang());
            ps.setString(2, diachi.getDiaChi());
            ps.setString(3, diachi.getSdt());
            ps.setString(4, diachi.getThanhPho());
            ps.setObject(5, diachi.getNgayTao());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi" + e.getMessage());
            return false;
        }

    }

    public Boolean updateNew(String id, DiaChi diachi) {
        String query = "Update ThongTinChiTiet set DiaChi=?,SDT=?,ThanhPho=?,NgayTao=? where Id=?";
        try (Connection con = connection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, diachi.getDiaChi());
            ps.setString(2, diachi.getSdt());
            ps.setString(3, diachi.getThanhPho());
            ps.setObject(4, diachi.getNgayTao());
            ps.setString(5, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean DeleteNew(String id) {
        String query = "Delete from ThongTinChiTiet where Id=?";
        try (Connection con = connection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<KhachHangResponse> Tim(String IdKhachHang) {
        ArrayList<KhachHangResponse> list = new ArrayList<>();
        String query = "SELECT ttct.Id,kh.Id,kh.Ten,ttct.SDT,ttct.DiaChi, ttct.ThanhPho, ttct.NgayTao\n"
                + "FROM ThongTinChiTiet ttct\n"
                + "JOIN KhachHang kh ON ttct.IdKhachHang = kh.Id WHERE IdKhachHang=?";
        try (Connection con = connection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, IdKhachHang);
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
                list.add(khrp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
      public boolean KhachHangChuaTonTai(String id) {
        String query = "SELECT COUNT(*) FROM KhachHang WHERE Id = ?";
        try (Connection con = connection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count == 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
