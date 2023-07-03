/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DotKhuyenMai.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DotKhuyenMai.model.khuyenMaiModel;

/**
 *
 * @author DELL
 */
public class Repository {

    public boolean insert(khuyenMaiModel ch) {
        String sql = "INSERT INTO [dbo].[DotKhuyenMai]\n"
                + "           (\n"
                + "           [Ma]\n"
                + "           ,[Ten]\n"
                + "           ,[PhanTramKM]\n"
                + "           ,[NgayBatDau]\n"
                + "           ,[NgayKetThuc]\n"
                + "           ,[TrangThai]\n"
                + "           ,[NgayTao])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,getdate())";
        try {
            Connection con = DBContext.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ch.getMa());
            ps.setString(2, ch.getTen());
            ps.setString(4, ch.getNgayBD());
            ps.setString(5, ch.getNgayKT());
            ps.setString(6, ch.getTrangThai());

            ps.setDouble(3, ch.getMucGiam());

            int aff = ps.executeUpdate();
            return aff > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<khuyenMaiModel> checkMa(String ma) throws SQLException {
        List<khuyenMaiModel> CV = new ArrayList<>();
        String SQL = "select id from DotKhuyenMai where Ma =?";
        Connection con = DBContext.getConnection();
        PreparedStatement ps = con.prepareStatement(SQL);
        ps.setString(1, ma);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String maC = rs.getString(1);

            khuyenMaiModel cv = new khuyenMaiModel(ma, ma, maC, maC, maC, maC, maC, 0);
            CV.add(cv);

        }
        rs.close();
        con.close();
        ps.close();
        return CV;
    }

    public List<khuyenMaiModel> hienThi() throws SQLException {
        List<khuyenMaiModel> CV = new ArrayList<>();
        String SQL = "select id,ma,ten,PhanTramKM,NgayBatDau,NgayKetThuc,TrangThai,NgayTao from DotKhuyenMai";
        Connection con = DBContext.getConnection();
        PreparedStatement ps = con.prepareStatement(SQL);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String id = rs.getString(1);
            String ma = rs.getString(2);
            String ten = rs.getString(3);
            double muc = rs.getDouble(4);
            String ngayBD = rs.getString(5);
            String ngayKT = rs.getString(6);
            String trangThai = rs.getString(7);
            String ngayTao = rs.getString(8);

            khuyenMaiModel cv = new khuyenMaiModel(id, ma, ten, ngayBD, ngayKT, trangThai, ngayTao, muc);
            CV.add(cv);

        }
        rs.close();
        con.close();
        ps.close();
        return CV;
    }

    public List<khuyenMaiModel> hienThiDang() throws SQLException {
        List<khuyenMaiModel> CV = new ArrayList<>();
        String SQL = "select id,ma,ten,PhanTramKM,NgayBatDau,NgayKetThuc,TrangThai,NgayTao from DotKhuyenMai where TrangThai= N'Đang diễn ra'";
        Connection con = DBContext.getConnection();
        PreparedStatement ps = con.prepareStatement(SQL);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String id = rs.getString(1);
            String ma = rs.getString(2);
            String ten = rs.getString(3);
            double muc = rs.getDouble(4);
            String ngayBD = rs.getString(5);
            String ngayKT = rs.getString(6);
            String trangThai = rs.getString(7);
            String ngayTao = rs.getString(8);

            khuyenMaiModel cv = new khuyenMaiModel(id, ma, ten, ngayBD, ngayKT, trangThai, ngayTao, muc);
            CV.add(cv);

        }
        rs.close();
        con.close();
        ps.close();
        return CV;
    }

    public void update(khuyenMaiModel ch) throws SQLException {
        String sql = "UPDATE [dbo].[DotKhuyenMai]\n"
                + "   SET \n"
                + "      [Ma] = ?\n"
                + "      ,[Ten] =? \n"
                + "      ,[PhanTramKM] =? \n"
                + "      ,[NgayBatDau] =? \n"
                + "      ,[NgayKetThuc] = ?\n"
                + "      ,[TrangThai] =? \n"
                + "      \n"
                + " WHERE id =? ";
        Connection con = DBContext.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, ch.getMa());
        ps.setString(2, ch.getTen());
        ps.setString(4, ch.getNgayBD());
        ps.setString(5, ch.getNgayKT());
        ps.setString(6, ch.getTrangThai());
        ps.setString(7, ch.getId());

        ps.setDouble(3, ch.getMucGiam());
        int aff = ps.executeUpdate();
        ps.close();
        con.close();

    }

    public List<khuyenMaiModel> hienThitheoma(String matim) throws SQLException {
        List<khuyenMaiModel> CV = new ArrayList<>();
        String SQL = "select id,ma,ten,PhanTramKM,NgayBatDau,NgayKetThuc,TrangThai,NgayTao from DotKhuyenMai where ma = ?";
        Connection con = DBContext.getConnection();
        PreparedStatement ps = con.prepareStatement(SQL);
        ps.setString(1, matim);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String id = rs.getString(1);
            String ma = rs.getString(2);
            String ten = rs.getString(3);
            double muc = rs.getDouble(4);
            String ngayBD = rs.getString(5);
            String ngayKT = rs.getString(6);
            String trangThai = rs.getString(7);
            String ngayTao = rs.getString(8);

            khuyenMaiModel cv = new khuyenMaiModel(id, ma, ten, ngayBD, ngayKT, trangThai, ngayTao, muc);
            CV.add(cv);

        }
        rs.close();
        con.close();
        ps.close();
        return CV;
    }
    public List<khuyenMaiModel> hienThiDangtheoma(String matim) throws SQLException {
        List<khuyenMaiModel> CV = new ArrayList<>();
        String SQL = "select id,ma,ten,PhanTramKM,NgayBatDau,NgayKetThuc,TrangThai,NgayTao from DotKhuyenMai where TrangThai= N'Đang diễn ra' and ma = ?";
        Connection con = DBContext.getConnection();
        PreparedStatement ps = con.prepareStatement(SQL);
         ps.setString(1, matim);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String id = rs.getString(1);
            String ma = rs.getString(2);
            String ten = rs.getString(3);
            double muc = rs.getDouble(4);
            String ngayBD = rs.getString(5);
            String ngayKT = rs.getString(6);
            String trangThai = rs.getString(7);
            String ngayTao = rs.getString(8);

            khuyenMaiModel cv = new khuyenMaiModel(id, ma, ten, ngayBD, ngayKT, trangThai, ngayTao, muc);
            CV.add(cv);

        }
        rs.close();
        con.close();
        ps.close();
        return CV;
    }
}
