/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NhanVien.Repository;

import DomainModel.DM_PhatThuong;
import DomainModel.DM_Thuong;
import DomainModel.DM_Phat;
import NhanVien.Utilities.DBContext;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class RP_ThuongPhat {

    public List<DM_Thuong> hienThiThuong() throws SQLException {
        List<DM_Thuong> CV = new ArrayList<>();
        String SQL = "Select Id, Lydo, Muc from PhieuThuong";
        Connection con = DBContext.getConnection();
        PreparedStatement ps = con.prepareStatement(SQL);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String id = rs.getString(1);
            String Lydo = rs.getString(2);
            BigDecimal Muc = rs.getBigDecimal(3);

            DM_Thuong cv = new DM_Thuong(Lydo, id, Muc);

            CV.add(cv);

        }
        rs.close();
        con.close();
        ps.close();
        return CV;
    }

    public boolean insertThuong(DM_Thuong cv) {
        String SQL = "insert into PhieuThuong(LyDo,Muc) values (?,?)";
        try {
            Connection con = DBContext.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, cv.getLyDo());
            ps.setBigDecimal(2, cv.getMuc());
            int aff = ps.executeUpdate();
            return aff > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void SuaThuong(String ID, String LyDo, BigDecimal Muc) throws SQLException {
        String sql = "update PhieuThuong set LyDo= ?, Muc = ? where Id like ?";
        Connection con = DBContext.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, LyDo);
        ps.setBigDecimal(2, Muc);
        ps.setString(3, ID);

        int aff = ps.executeUpdate();
        con.close();
        ps.close();
    }

    public List<DM_Phat> hienThiPhat() throws SQLException {
        List<DM_Phat> CV = new ArrayList<>();
        String SQL = "Select Id, Lydo, Muc from PhieuPhat";
        Connection con = DBContext.getConnection();
        PreparedStatement ps = con.prepareStatement(SQL);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String id = rs.getString(1);
            String Lydo = rs.getString(2);
            BigDecimal Muc = rs.getBigDecimal(3);

            DM_Phat cv = new DM_Phat(Lydo, id, Muc);

            CV.add(cv);

        }
        rs.close();
        con.close();
        ps.close();
        return CV;
    }

    public boolean insertPhat(DM_Phat cv) {
        String SQL = "insert into PhieuPhat(LyDo,Muc) values (?,?)";
        try {
            Connection con = DBContext.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, cv.getLyDo());
            ps.setBigDecimal(2, cv.getMuc());
            int aff = ps.executeUpdate();
            return aff > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void SuaPhat(String ID, String LyDo, BigDecimal Muc) throws SQLException {
        String sql = "update PhieuPhat set LyDo= ?, Muc = ? where Id like ?";
        Connection con = DBContext.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, LyDo);
        ps.setBigDecimal(2, Muc);
        ps.setString(3, ID);

        int aff = ps.executeUpdate();
        con.close();
        ps.close();
    }

    public boolean insertCTThuong(DM_PhatThuong cv) {
        String SQL = "INSERT INTO [dbo].[CTPhatTHUONG]\n"
                + "           ([IdNhanVien]\n"
                + "           ,[IdPhieuTHUONG]\n"
                + "           \n"
                + "           ,[IdPhieuPhat]\n"
                + "           ,[TrangThai]\n"
                + "           ,[NgayPhat])\n"
                + "     VALUES\n"
                + "           (?,?,1,1,getdate())";
        try {
            Connection con = DBContext.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, cv.getIdNV());
            ps.setString(2, cv.getIdThuong());
            int aff = ps.executeUpdate();
            return aff > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean insertCTPhat(DM_PhatThuong cv) {
        String SQL = "INSERT INTO [dbo].[CTPhatTHUONG]\n"
                + "           ([IdNhanVien]\n"
                + "           \n"
                + "           ,[IdPhieuPhat]\n"
                + "           ,[IdPhieuTHUONG]\n"
                + "           ,[TrangThai]\n"
                + "           ,[NgayPhat])\n"
                + "     VALUES\n"
                + "           (?,?,1,1,getdate())";
        try {
            Connection con = DBContext.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, cv.getIdNV());
            ps.setString(2, cv.getIdPhat());
            int aff = ps.executeUpdate();
            return aff > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<DM_PhatThuong> hienThiCTThuongPhat() throws SQLException {
        List<DM_PhatThuong> CV = new ArrayList<>();
        String SQL = " select CTPhatTHUONG.Id,NhanVien.Ma,PHIEUTHUONG.LyDo,PHIEUTHUONG.Muc\n"
                + " ,PHIEUPHAT.LyDo,PHIEUPHAT.Muc,CTPhatTHUONG.NgayPhat,CTPhatTHUONG.TrangThai\n"
                + " from CTPhatTHUONG join NhanVien on CTPhatTHUONG.IdNhanVien = NhanVien.Id\n"
                + "							join PHIEUPHAT on CTPhatTHUONG.IdPhieuPhat = PHIEUPHAT.Id\n"
                + "							join PHIEUTHUONG on CTPhatTHUONG.IdPhieuTHUONG = PHIEUTHUONG.Id order by CTPhatTHUONG.Id desc ";
        Connection con = DBContext.getConnection();
        PreparedStatement ps = con.prepareStatement(SQL);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String idCTThuongPhat = rs.getString(1);
            String ngayTao = rs.getString(7);
            int trangThai = rs.getInt(8);
            String lyDoThuong = rs.getString(3);
            String lyDoPhat = rs.getString(5);
            String MaNV = rs.getString(2);
            BigDecimal MucThuong = rs.getBigDecimal(4);
            BigDecimal MucPhat = rs.getBigDecimal(6);

            DM_PhatThuong cv = new DM_PhatThuong(lyDoThuong, lyDoPhat, idCTThuongPhat, "", MaNV, ngayTao, MucPhat, MucThuong, trangThai);

            CV.add(cv);

        }
        rs.close();
        con.close();
        ps.close();
        return CV;
    }
//  
//  public List<DM_PhatThuong> hienThiCTPhat() throws SQLException{
//      List<DM_PhatThuong> CV = new ArrayList<>();
//      String SQL = "    select CTPhat.id,CTPhat.ngayPhat,CTPhat.trangThai,PhieuPhat.LyDo,PHIEUPhat.Muc,NhanVien.Ma from CTPhat join PhieuPhat on phieuPhat.id = CTPhat.idPhieuPhat join NhanVien on NhanVien.Id = CTPhat.idNhanVien";
//      Connection con = DBContext.getConnection();
//      PreparedStatement ps = con.prepareStatement(SQL);
//      ResultSet rs = ps.executeQuery();
//      while(rs.next()){
//          String idCTThuong = rs.getString(1);
//          String ngayTao = rs.getString(2);
//          int trangThai = rs.getInt(3);
//          String lyDo = rs.getString(4);
//          String MaNV = rs.getString(6);
//          BigDecimal Muc = rs.getBigDecimal(5);
//          
//          DM_PhatThuong cv = new DM_PhatThuong(lyDo, idCTThuong, MaNV, ngayTao, Muc, trangThai);
//          
//          CV.add(cv);
//          
//      }
//      rs.close();
//      con.close();
//      ps.close();
//      return CV;
//  }
}
