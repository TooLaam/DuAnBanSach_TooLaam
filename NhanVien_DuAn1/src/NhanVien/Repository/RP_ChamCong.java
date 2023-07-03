/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NhanVien.Repository;

import DomainModel.DM_ChamCong;
import DomainModel.DM_ChucVu;
import DomainModel.DM_NhanVIen;
import NhanVien.Utilities.DBContext;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class RP_ChamCong {
    
     public List<DM_ChamCong> hienThi(String NgayLam) throws SQLException{
      List<DM_ChamCong> CV = new ArrayList<>();
      String SQL = "SELECT ChamCong.Id\n" +
"	, NhanVien.Ten\n" +
"      ,NhanVien.Ma\n" +
"      ,[NgayLam]\n" +
"      ,[GioIN]\n" +
"      ,[GioOUT]\n" +
"      ,[TrangThai],trangThaiTinhLuong\n" +
"  FROM [dbo].[ChamCong] join NhanVien on ChamCong.IdNhanVien = NhanVien.Id where NgayLam =? order by chamCong.id desc";
      Connection con = DBContext.getConnection();
      PreparedStatement ps = con.prepareStatement(SQL);
      ps.setString(1, NgayLam);
      ResultSet rs = ps.executeQuery();
      while(rs.next()){
         String idCC = rs.getString(1);
          String tenNV = rs.getString(2);
          String IDNV = rs.getString(3);
          String ngayLam = rs.getString(4);
          String gioIN = rs.getString(5);
          String gioOUT = rs.getString(6);
          int trangThai = Integer.valueOf(rs.getString(7)) ;
          int trangThaiTinhLuong = Integer.valueOf(rs.getString(8)) ;

          DM_ChamCong cv = new DM_ChamCong(idCC, IDNV, ngayLam, tenNV, trangThai, trangThaiTinhLuong, gioIN, gioOUT);
          CV.add(cv);
          
      }
      rs.close();
      con.close();
      ps.close();
      return CV;
  }
    
     
     public boolean insert(DM_ChamCong ch){
        String sql = "INSERT INTO [dbo].[ChamCong]\n" +
"           ([IdNhanVien]\n" +
"           ,[NgayLam]\n" +
"           ,[GioIN]\n" +

"           ,[TrangThai],trangThaiTinhLuong)\n" +
"     VALUES\n" +
"           (?,?,getdate(),?,1)";
        try {
            Connection con = DBContext.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,ch.getIDNV() );
            ps.setString(2,ch.getNgayLam());
            
            ps.setInt(3,ch.getTrangThai() );
           
            java.util.Date dateUtl = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(dateUtl.getTime());
            
            int aff = ps.executeUpdate();
            return aff >0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
     
     
     public List<DM_ChamCong> CheckIN(String NgayLam, String idNV) throws SQLException{
      List<DM_ChamCong> CV = new ArrayList<>();
      String SQL = "select TrangThai from ChamCong where IdNhanVien = ? and NgayLam = ? and TrangThai = 1";
      Connection con = DBContext.getConnection();
      PreparedStatement ps = con.prepareStatement(SQL);
      ps.setString(1, idNV);
      ps.setString(2, NgayLam);
      ResultSet rs = ps.executeQuery();
      while(rs.next()){
         
          int trangThai = Integer.valueOf(rs.getString(1)) ;
          

          DM_ChamCong cv = new DM_ChamCong();
          cv.setTrangThai(trangThai);
          CV.add(cv);
          
      }
      rs.close();
      con.close();
      ps.close();
      return CV;
  }
     
      public List<DM_ChamCong> CheckOUT(String NgayLam, String idNV) throws SQLException{
      List<DM_ChamCong> CV = new ArrayList<>();
      String SQL = "select TrangThai from ChamCong where IdNhanVien = ? and NgayLam = ? and TrangThai = 2";
      Connection con = DBContext.getConnection();
      PreparedStatement ps = con.prepareStatement(SQL);
      ps.setString(1, idNV);
      ps.setString(2, NgayLam);
      ResultSet rs = ps.executeQuery();
      while(rs.next()){
         
          int trangThai = Integer.valueOf(rs.getString(1)) ;
          

          DM_ChamCong cv = new DM_ChamCong();
          cv.setTrangThai(trangThai);
          CV.add(cv);
          
      }
      rs.close();
      con.close();
      ps.close();
      return CV;
  }
      
      public void suaOUT(String IDNV,String ngayLam) throws SQLException{
        String sql = "UPDATE [dbo].[ChamCong]\n" +
"   SET \n" +
"      [GioOUT] = getdate()\n" +
"      ,[TrangThai] = 2\n" +
" WHERE IdNhanVien = ? and NgayLam = ? and TrangThai = 1";
        Connection con = DBContext.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, IDNV);
        ps.setString(2, ngayLam);
       
        
        int aff = ps.executeUpdate();
        con.close();
        ps.close();
    }
      
       public List<DM_ChamCong> CheckTinhTrangDiLam( String idNV) throws SQLException{
      List<DM_ChamCong> CV = new ArrayList<>();
      String SQL = "select TrangThaiDiLam from NhanVien where id = ? and TrangThaiDiLam = 1";
      Connection con = DBContext.getConnection();
      PreparedStatement ps = con.prepareStatement(SQL);
      ps.setString(1, idNV);
      
      ResultSet rs = ps.executeQuery();
      while(rs.next()){
         
          int trangThai = Integer.valueOf(rs.getString(1)) ;
          

          DM_ChamCong cv = new DM_ChamCong();
          cv.setTrangThai(trangThai);
          CV.add(cv);
          
      }
      rs.close();
      con.close();
      ps.close();
      return CV;
  }
       
        public List<DM_ChamCong> hienThiTrongThang(String Thang,String Nam, String maNV) throws SQLException{
      List<DM_ChamCong> CV = new ArrayList<>();
      String SQL = "SELECT ChamCong.Id\n" +
"	, NhanVien.Ten\n" +
"      ,NhanVien.Ma\n" +
"      ,[NgayLam]\n" +
"      ,[GioIN]\n" +
"      ,[GioOUT]\n" +
"      ,[TrangThai],trangThaiTinhLuong\n" +
"  FROM [dbo].[ChamCong] join NhanVien on ChamCong.IdNhanVien = NhanVien.Id where MONTH(ChamCong.NgayLam) = ?\n"
                + "							and YEAR(ChamCong.NgayLam) = ?\n"
                + "							and NhanVien.Ma = ?";
      Connection con = DBContext.getConnection();
      PreparedStatement ps = con.prepareStatement(SQL);
      ps.setString(1, Thang);
      ps.setString(2, Nam);
      ps.setString(3, maNV);
      ResultSet rs = ps.executeQuery();
      while(rs.next()){
         String idCC = rs.getString(1);
          String tenNV = rs.getString(2);
          String IDNV = rs.getString(3);
          String ngayLam = rs.getString(4);
          String gioIN = rs.getString(5);
          String gioOUT = rs.getString(6);
          int trangThai = Integer.valueOf(rs.getString(7)) ;
          int trangThaiTinhLuong = Integer.valueOf(rs.getString(8)) ;

          DM_ChamCong cv = new DM_ChamCong(idCC, IDNV, ngayLam, tenNV, trangThai, trangThaiTinhLuong, gioIN, gioOUT);
          CV.add(cv);
          
      }
      rs.close();
      con.close();
      ps.close();
      return CV;
  }
}
