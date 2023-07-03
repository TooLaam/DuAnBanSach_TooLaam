/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NhanVien.Repository;

import DomainModel.DM_NhanVIen;
import DomainModel.DM_ThongKe;
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
public class RP_ThongKe {
    public List<DM_ThongKe> hienThiGioiTinh(String yeuCau) throws SQLException{
      List<DM_ThongKe> CV = new ArrayList<>();
      String SQL = "select COUNT(Id) from NhanVien where gioiTinh = ?";
      Connection con = DBContext.getConnection();
      PreparedStatement ps = con.prepareStatement(SQL);
      ps.setString(1, yeuCau);
      ResultSet rs = ps.executeQuery();
      while(rs.next()){
         int idCC = rs.getInt(1);
         

          DM_ThongKe cv = new DM_ThongKe(idCC, idCC, idCC, idCC, idCC, idCC, idCC, idCC);
          CV.add(cv);
          
      }
      rs.close();
      con.close();
      ps.close();
      return CV;
  }
    
    public List<DM_ThongKe> hienThiAll() throws SQLException{
      List<DM_ThongKe> CV = new ArrayList<>();
      String SQL = "select COUNT(Id) from NhanVien ";
      Connection con = DBContext.getConnection();
      PreparedStatement ps = con.prepareStatement(SQL);
      
      ResultSet rs = ps.executeQuery();
      while(rs.next()){
         int idCC = rs.getInt(1);
         

          DM_ThongKe cv = new DM_ThongKe(idCC, idCC, idCC, idCC, idCC, idCC, idCC, idCC);
          CV.add(cv);
          
      }
      rs.close();
      con.close();
      ps.close();
      return CV;
  }
    
     public List<DM_ThongKe> hienThiTrangThaiDiLam(String trangThai) throws SQLException{
      List<DM_ThongKe> CV = new ArrayList<>();
      String SQL = "select COUNT(Id) from NhanVien where trangThaiDiLam = ? ";
      Connection con = DBContext.getConnection();
      PreparedStatement ps = con.prepareStatement(SQL);
      ps.setString(1, trangThai);
      ResultSet rs = ps.executeQuery();
      while(rs.next()){
         int idCC = rs.getInt(1);
         

          DM_ThongKe cv = new DM_ThongKe(idCC, idCC, idCC, idCC, idCC, idCC, idCC, idCC);
          CV.add(cv);
          
      }
      rs.close();
      con.close();
      ps.close();
      return CV;
  }
     
     public List<DM_ThongKe> hienThiTrangThaiShip(String trangThai) throws SQLException{
      List<DM_ThongKe> CV = new ArrayList<>();
      String SQL = "select COUNT(Id) from NhanVien where trangThaiShipper = ? ";
      Connection con = DBContext.getConnection();
      PreparedStatement ps = con.prepareStatement(SQL);
      ps.setString(1, trangThai);
      ResultSet rs = ps.executeQuery();
      while(rs.next()){
         int idCC = rs.getInt(1);
         

          DM_ThongKe cv = new DM_ThongKe(idCC, idCC, idCC, idCC, idCC, idCC, idCC, idCC);
          CV.add(cv);
          
      }
      rs.close();
      con.close();
      ps.close();
      return CV;
  }
     
     
      public List<DM_NhanVIen> hienThiTableGioiTinh(String gioiTinhMuon) throws SQLException{
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
"  FROM [dbo].[NhanVien] join ChucVu on nhanVien.IdChucVu= ChucVu.id where gioiTinh = ? ";
      Connection con = DBContext.getConnection();
      PreparedStatement ps = con.prepareStatement(SQL);
      ps.setString(1, gioiTinhMuon);
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
      
        public List<DM_NhanVIen> hienThiTableTrangThaiLam(String trangThaiLam) throws SQLException{
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
"  FROM [dbo].[NhanVien] join ChucVu on nhanVien.IdChucVu= ChucVu.id where trangThaiDiLam = ? ";
      Connection con = DBContext.getConnection();
      PreparedStatement ps = con.prepareStatement(SQL);
      ps.setString(1, trangThaiLam);
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
        
         public List<DM_NhanVIen> hienThiTableTrangThaiShip(String trangThaiSHip) throws SQLException{
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
"  FROM [dbo].[NhanVien] join ChucVu on nhanVien.IdChucVu= ChucVu.id where trangThaiShipper = ? ";
      Connection con = DBContext.getConnection();
      PreparedStatement ps = con.prepareStatement(SQL);
      ps.setString(1, trangThaiSHip);
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
         
           public List<DM_ThongKe> hienThiDoanhThuTheoNV(String maNVtim,String ngayBD, String ngayKT) throws SQLException{
      List<DM_ThongKe> CV = new ArrayList<>();
      String SQL = "select NhanVien.Ma,Sach.Ma,Sach.Ten,sum(HoaDonChiTiet.SoLuong),sum(HoaDonChiTiet.SoLuong*CTSach.GiaBan) from NhanVien join hoaDon on NhanVien.Id = HoaDon.IdNhanVien\n" +
"					   join HoaDonChiTiet on HoaDon.Id = HoaDonChiTiet.IdHoaDon\n" +
"					   join CTSach on HoaDonChiTiet.IdCTSach = CTSach.IdCTSach\n" +
"					   join Sach on CTSach.IdSach = Sach.Id\n" +
"					   group by NhanVien.Ma,Sach.Ma,Sach.Ten,NgayTao\n" +
"					   having NhanVien.Ma = ? and HoaDon.NgayTao <= ? and HoaDon.NgayTao >= ?";
      Connection con = DBContext.getConnection();
      PreparedStatement ps = con.prepareStatement(SQL);
      ps.setString(1, maNVtim);
      ps.setString(2, ngayKT);
      ps.setString(3, ngayBD);
      ResultSet rs = ps.executeQuery();
      while(rs.next()){
          String maNV = rs.getString(1);
          String maSach = rs.getString(2);
          String tenSach = rs.getString(3);
          int tongSL = rs.getInt(4);
          BigDecimal DSTheoSP = rs.getBigDecimal(5);
         
          DM_ThongKe cv = new DM_ThongKe(ngayBD, ngayKT, maNV, maSach, tenSach, tongSL, DSTheoSP, tongSL, DSTheoSP, tongSL);
          CV.add(cv);
          
      }
      rs.close();
      con.close();
      ps.close();
      return CV;
  }
           
            public List<DM_ThongKe> hienThiTongSPNVBanDuoc(String maNVtim,String ngayBD, String ngayKT) throws SQLException{
      List<DM_ThongKe> CV = new ArrayList<>();
      String SQL = "select sum(HoaDonChiTiet.SoLuong),sum(HoaDonChiTiet.SoLuong*CTSach.GiaBan)from NhanVien join hoaDon on NhanVien.Id = HoaDon.IdNhanVien\n" +
"					   join HoaDonChiTiet on HoaDon.Id = HoaDonChiTiet.IdHoaDon\n" +
"					   join CTSach on HoaDonChiTiet.IdCTSach = CTSach.IdCTSach\n" +
"					   join Sach on CTSach.IdSach = Sach.Id\n" +
"					   group by NhanVien.Ma,NgayTao" +
"					   having NhanVien.Ma = ? and HoaDon.NgayTao <= ? and HoaDon.NgayTao >= ?";
      Connection con = DBContext.getConnection();
      PreparedStatement ps = con.prepareStatement(SQL);
      ps.setString(1, maNVtim);
      ps.setString(2, ngayKT);
      ps.setString(3, ngayBD);
      ResultSet rs = ps.executeQuery();
      while(rs.next()){
         
          int tongSLNVBan = rs.getInt(1);
          BigDecimal tongDS = rs.getBigDecimal(2);
         
          
        
         
          DM_ThongKe cv = new DM_ThongKe(ngayBD, ngayKT, maNVtim, SQL, SQL, tongSLNVBan, BigDecimal.ONE, tongSLNVBan, tongDS, tongSLNVBan);
          CV.add(cv);
          
      }
      rs.close();
      con.close();
      ps.close();
      return CV;
  }
            
              public List<DM_ThongKe> hienThiTongHD(String maNVtim,String ngayBD, String ngayKT) throws SQLException{
      List<DM_ThongKe> CV = new ArrayList<>();
      String SQL = "select count(HoaDon.Id) from NhanVien join hoaDon on NhanVien.Id = HoaDon.IdNhanVien" +
"					   where NhanVien.Ma = ? and HoaDon.NgayTao <= ? and HoaDon.NgayTao >= ?";
      Connection con = DBContext.getConnection();
      PreparedStatement ps = con.prepareStatement(SQL);
      ps.setString(1, maNVtim);
      ps.setString(2, ngayKT);
      ps.setString(3, ngayBD);
      ResultSet rs = ps.executeQuery();
      while(rs.next()){
         
          int tongSLNVBan = rs.getInt(1);
         
         
          
        
         
          DM_ThongKe cv = new DM_ThongKe(ngayBD, ngayKT, maNVtim, SQL, SQL, tongSLNVBan, BigDecimal.ONE, tongSLNVBan, BigDecimal.ONE, tongSLNVBan);
          CV.add(cv);
          
      }
      rs.close();
      con.close();
      ps.close();
      return CV;
  }
}
