/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NhanVien.Repository;

import DomainModel.DM_NhanVIen;
import NhanVien.Utilities.DBContext;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author DELL
 */
public class RP_NhanVien {
    public List<DM_NhanVIen> hienThi() throws SQLException{
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
"  FROM [dbo].[NhanVien] join ChucVu on nhanVien.IdChucVu= ChucVu.id order by NhanVien.id desc";
      Connection con = DBContext.getConnection();
      PreparedStatement ps = con.prepareStatement(SQL);
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
    
    
    public void suaNV(String Ma, DM_NhanVIen dm) throws SQLException{
        String sql = "UPDATE [dbo].[NhanVien]\n" +
"   SET [IdChucVu] = ?\n" +
"      ,[Ma] = ?\n" +
"      ,[Ten] = ?\n" +
"      ,[GioiTinh] = ?\n" +
"      ,[NgaySinh] = ?\n" +
"      ,[Email] = ?\n" +
"      ,[SDT] = ?\n" +
"      ,[DiaChi] = ?\n" +
"      ,[MatKhau] = ?\n" +
"      ,[TrangThaiDiLam] = ?\n" +
"      ,[TrangThaiShipper] = ? \n" +
" WHERE Ma = ?";
        Connection con = DBContext.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, dm.getIDCV());
        ps.setString(2, dm.getMa());
        ps.setString(3, dm.getTen());
        ps.setString(4, dm.getGioiTinh());
        ps.setString(5, dm.getNgaySinh());
        ps.setString(6, dm.getEmail());
        ps.setString(7, dm.getSDT());
        ps.setString(8, dm.getDiaChi());
        ps.setString(9, dm.getMatKhau());
        ps.setInt(10, dm.getTrangThaiDiLam());
        ps.setInt(11, dm.getTrangTháihipper());
        ps.setString(12, Ma);
        
        int aff = ps.executeUpdate();
        con.close();
        ps.close();
    }
    
    
    public boolean insert(DM_NhanVIen ch){
        String sql = "INSERT INTO [dbo].[NhanVien]\n" +
"           (\n" +
"           [IdChucVu]\n" +
"           ,[Ma]\n" +
"           ,[Ten]\n" +
"           ,[GioiTinh]\n" +
"           ,[NgaySinh]\n" +
"           ,[Email]\n" +
"           ,[SDT]\n" +
"           ,[DiaChi]\n" +
"           ,[MatKhau]\n" +
"           ,[TrangThaiDiLam]\n" +
"           ,[TrangThaiShipper])\n" +
"     VALUES\n" +
"           (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            Connection con = DBContext.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,ch.getIDCV() );
            ps.setString(2,ch.getMa());
            ps.setString(3,ch.getTen() );
            ps.setString(4,ch.getGioiTinh() );
            ps.setString(5,ch.getNgaySinh() );
            ps.setString(6,ch.getEmail() );
            ps.setString(7,ch.getSDT());
            ps.setString(8,ch.getDiaChi() );
            
            ps.setString(9,ch.getMatKhau() );
            
            ps.setInt(10,ch.getTrangThaiDiLam() );
            ps.setInt(11,ch.getTrangTháihipper() );
            
            int aff = ps.executeUpdate();
            return aff >0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
     public List<DM_NhanVIen> hienThitheoMa(String Ma) throws SQLException{
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
"  FROM [dbo].[NhanVien] join ChucVu on nhanVien.IdChucVu= ChucVu.id  where  NhanVien.Ma = ?";
      Connection con = DBContext.getConnection();
      PreparedStatement ps = con.prepareStatement(SQL);
      ps.setString(1,Ma );
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
     
     
     public List<DM_NhanVIen> dangNhap(String manv, String matKhau) throws SQLException{
      List<DM_NhanVIen> CV = new ArrayList<>();
      String SQL = "select chucvu.Ma,nhanvien.ten from nhanvien join chucvu on nhanvien.idchucvu = chucvu.id where nhanvien.Email = ? and matKhau = ?";
      Connection con = DBContext.getConnection();
      PreparedStatement ps = con.prepareStatement(SQL);
       ps.setString(1, manv);
        ps.setString(2, matKhau);
      ResultSet rs = ps.executeQuery();
      while(rs.next()){
          String idCV = rs.getString(1);
          String tennv = rs.getString(2);
          DM_NhanVIen cv = new DM_NhanVIen(idCV, idCV, manv, tennv, idCV, manv, manv, SQL, idCV, matKhau, 0, 0);
          CV.add(cv);
          
      }
      rs.close();
      con.close();
      ps.close();
      return CV;
  }
     
      public List<DM_NhanVIen> hienThitheoEmail(String Email) throws SQLException{
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
"  FROM [dbo].[NhanVien] join ChucVu on nhanVien.IdChucVu= ChucVu.id  where  NhanVien.Email = ?";
      Connection con = DBContext.getConnection();
      PreparedStatement ps = con.prepareStatement(SQL);
      ps.setString(1,Email);
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



