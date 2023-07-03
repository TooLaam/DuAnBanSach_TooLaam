/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NhanVien.Repository;

import DomainModel.DM_NhanVIen;
import DomainModel.DM_TinhLuong;
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
public class RP_TinhLuong {

    public List<DM_TinhLuong> hienThiThuongPhat(int Thang, int Nam, String maNVCHeck) throws SQLException {
        List<DM_TinhLuong> CV = new ArrayList<>();
        String SQL = " select NhanVien.id,NhanVien.ma, sum(PHIEUPHAT.Muc),sum(PHIEUTHUONG.Muc)\n"
                + " from NhanVien join CTPhatTHUONG   on CTPhatTHUONG.IdNhanVien = NhanVien.Id\n"
                + "							join PHIEUPHAT on CTPhatTHUONG.IdPhieuPhat = PHIEUPHAT.Id\n"
                + "							join PHIEUTHUONG on CTPhatTHUONG.IdPhieuTHUONG = PHIEUTHUONG.Id\n"
                + "							group by NhanVien.id,CTPhatTHUONG.NgayPhat,NhanVien.ma\n"
                + "							having MONTH(CTPhatTHUONG.NgayPhat)  = ?"
                + " and YEAR(CTPhatTHUONG.NgayPhat) = ?"
                + "							and NhanVien.Ma = ?";
        Connection con = DBContext.getConnection();
        PreparedStatement ps = con.prepareStatement(SQL);
        ps.setInt(1, Thang);
        ps.setInt(2, Nam);
        ps.setString(3, maNVCHeck);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String idNV = rs.getString(1);
            String maNV = rs.getString(2);
            BigDecimal tongTienPhat = rs.getBigDecimal(3);
            BigDecimal tongTienThuong = rs.getBigDecimal(4);

            DM_TinhLuong cv = new DM_TinhLuong("", idNV, maNV, 0, 0, tongTienPhat, tongTienThuong, BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE);
            CV.add(cv);

        }
        rs.close();
        con.close();
        ps.close();
        return CV;
    }

    public List<DM_TinhLuong> hienThiGioCong(int Thang, int Nam, String maNVCHeck) throws SQLException {
        List<DM_TinhLuong> CV = new ArrayList<>();
        String SQL = "select NhanVien.id,NhanVien.ma,ChucVu.MucLuong, sum(DATEDIFF(SECOND,GioIN,GioOUT)) from NhanVien					\n"
                + "							join ChucVu on NhanVien.idChucVu = ChucVu.id\n"
                + "							join ChamCong on ChamCong.IdNhanVien = NhanVien.id\n"
                + "							group by NhanVien.id, NhanVien.ma, ChucVu.MucLuong,ChamCong.NgayLam\n"
                + "							having MONTH(ChamCong.NgayLam) = ?\n"
                + "							and YEAR(ChamCong.NgayLam) = ?\n"
                + "							and NhanVien.Ma = ?";
        Connection con = DBContext.getConnection();
        PreparedStatement ps = con.prepareStatement(SQL);
        ps.setInt(1, Thang);
        ps.setInt(2, Nam);
        ps.setString(3, maNVCHeck);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String idNV = rs.getString(1);
            String maNV = rs.getString(2);
            BigDecimal MucLuong = rs.getBigDecimal(3);
            int tongCong = rs.getInt(4);

            DM_TinhLuong cv = new DM_TinhLuong("", idNV, maNV, 0, tongCong, BigDecimal.ONE, BigDecimal.ONE, MucLuong, BigDecimal.ONE, BigDecimal.ONE);
            CV.add(cv);

        }
        rs.close();
        con.close();
        ps.close();
        return CV;
    }

    public boolean insert(DM_TinhLuong ch) {
        String sql = "INSERT INTO [dbo].[BANGLUONG]\n"
                + "           ([IdNhanVien]\n"
                + "           ,[TongTienPhat]\n"
                + "           ,[TongTienThuong]\n"
                + "           ,[TongTienCong]\n"
                + "           ,[Thang],trangThai)\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,1)";
        try {
            Connection con = DBContext.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ch.getIdNV());
            ps.setBigDecimal(2, ch.getTongTienPhat());
            ps.setBigDecimal(3, ch.getTongTienThuong());
            ps.setBigDecimal(4, ch.getTongTienCong());
            ps.setInt(5, ch.getThang());

            int aff = ps.executeUpdate();
            return aff > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<DM_TinhLuong> hienThiTinhLuong() throws SQLException {
        List<DM_TinhLuong> CV = new ArrayList<>();
        String SQL = " select BANGLUONG.Id,NhanVien.Id,NhanVien.Ma,Thang,TongTienPhat,TongTienThuong,TongTienCong,((TongTienCong+TongTienThuong)-TongTienPhat),BANGLUONG.trangThai\n"
                + " from BANGLUONG join NhanVien on BANGLUONG.IdNhanVien =NhanVien.Id";
        Connection con = DBContext.getConnection();
        PreparedStatement ps = con.prepareStatement(SQL);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String idBangLuong = rs.getString(1);
            String idNV = rs.getString(2);
            String maNV = rs.getString(3);
            int thang = rs.getInt(4);

            BigDecimal tongTienPhat = rs.getBigDecimal(5);
            BigDecimal tongTienThuong = rs.getBigDecimal(6);
            BigDecimal tongTienCong = rs.getBigDecimal(7);
            BigDecimal tongLuong = rs.getBigDecimal(8);
            int trangThai = rs.getInt(9);

            DM_TinhLuong cv = new DM_TinhLuong(idBangLuong, idNV, maNV, thang, trangThai, tongTienPhat, tongTienThuong, tongLuong, tongTienCong, tongLuong);
            CV.add(cv);

        }
        rs.close();
        con.close();
        ps.close();
        return CV;
    }

    public List<DM_TinhLuong> check(String idnv, int thang) throws SQLException {
        List<DM_TinhLuong> CV = new ArrayList<>();
        String SQL = " select IdNhanVien from BANGLUONG where IdNhanVien =? and Thang = ? and trangThai = 1";
        Connection con = DBContext.getConnection();
        PreparedStatement ps = con.prepareStatement(SQL);
        ps.setString(1, idnv);
        ps.setInt(2, thang);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {

            String idNV = rs.getString(1);

            DM_TinhLuong cv = new DM_TinhLuong("", idNV, "", 0, 0, BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE);
            CV.add(cv);

        }
        rs.close();
        con.close();
        ps.close();
        return CV;
    }
    
    public void suaTrangThaiCC(String id, int thang) throws SQLException{
        String sql = " update ChamCong set trangthaitinhluong =2 where MONTH(NgayLam) = ? and IdNhanVien = ?";
        Connection con = DBContext.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, thang);
        ps.setString(2, id);
       
        
        int aff = ps.executeUpdate();
        con.close();
        ps.close();
    }
     public void suaTrangThaiTP(String id, int thang) throws SQLException{
        String sql = " update CTPhatThuong set trangthai =2 where MONTH(NgayPhat) = ? and IdNhanVien = ?";
        Connection con = DBContext.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, thang);
        ps.setString(2, id);
       
        
        int aff = ps.executeUpdate();
        con.close();
        ps.close();
    }
     
     public List<DM_NhanVIen> hienThiNVChuaChamCOng(int Thang) throws SQLException{
      List<DM_NhanVIen> CV = new ArrayList<>();
      String SQL = "SELECT nhanvien.id\n" +
"      ,chucVu.Ten\n" +
"      ,NhanVien.Ma\n" +
"      ,NhanVien.Ten\n" +
"      ,[GioiTinh]\n" +
"      ,[NgaySinh]\n" +
"      ,[Email]\n" +
"      ,[SDT]\n" +
"      ,[DiaChi]\n" +
"      ,[MatKhau]\n" +
"      ,[TrangThaiDiLam]\n" +
"      ,[TrangThaiShipper]\n" +
"  FROM [dbo].[NhanVien] join ChucVu on nhanVien.IdChucVu= ChucVu.id where NhanVien.Id not in (select IdNhanVien from BANGLUONG where Thang = ?) order by NhanVien.id desc";
      Connection con = DBContext.getConnection();
      PreparedStatement ps = con.prepareStatement(SQL);
      ps.setInt(1, Thang);
      ResultSet rs = ps.executeQuery();
      while(rs.next()){
          String idNV = rs.getString(1);
          String tenCV = rs.getString(2);
          String ma = rs.getString(3);
          String ten = rs.getString(4);
          String gioiTinh = rs.getString(5);
          String ngaySinh = rs.getString(6);
          String email = rs.getString(7);
          String diaChi = rs.getString(9);
          String SDT = rs.getString(8);
          String matKhau = rs.getString(10);
         
          int trangThaiDiLam = Integer.valueOf(rs.getString(11));
          int trangThaiShipper = Integer.valueOf(rs.getString(12));
          DM_NhanVIen cv = new DM_NhanVIen(idNV, tenCV, ma, ten, gioiTinh, ngaySinh, email, SDT, diaChi, matKhau, trangThaiDiLam, trangThaiShipper);
          CV.add(cv);
          
      }
      rs.close();
      con.close();
      ps.close();
      return CV;
  }
}
