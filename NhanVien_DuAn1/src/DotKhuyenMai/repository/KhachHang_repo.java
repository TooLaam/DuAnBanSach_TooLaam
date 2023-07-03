/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DotKhuyenMai.repository;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import DotKhuyenMai.model.GioHangModel;
import DotKhuyenMai.model.Hienthigannhat;
import DotKhuyenMai.model.HoaDonChiTietModel;
import DotKhuyenMai.model.HoaDonMode;
import DotKhuyenMai.model.KhachHangModel;
import DotKhuyenMai.model.SanPhamModel;
import DotKhuyenMai.model.giamGiamodel;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author DELL
 */
public class KhachHang_repo {

    public List<KhachHangModel> timKiemKH(String SDT) throws SQLException {
        List<KhachHangModel> KH = new ArrayList();
        String sql = "select KhachHang.id,KhachHang.Ten,SDT,GioiTinh,CapBac.Ten from KhachHang join CapBac on KhachHang.IdCapBac = CapBac.Id where SDT like ? ";
        Connection con = DBContext.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, SDT);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String maKH = rs.getString(1);
            String tenKH = rs.getString(2);
            String sdt = rs.getString(3);
            String gioiTinh = rs.getString(4);
            String CapBac = rs.getString(5);
            KhachHangModel khach = new KhachHangModel();
            khach.setMaKH(maKH);
            khach.setGioiTinh(gioiTinh);
            khach.setTk(CapBac);
            khach.setTenKH(tenKH);
            khach.setSdt(sdt);
            KH.add(khach);

        }
        rs.close();
        ps.close();
        con.close();
        return KH;
    }

    public List<SanPhamModel> timKiemSP(String maSP) throws SQLException {
        List<SanPhamModel> SP = new ArrayList();
        String sql = "select CTSach.IdCTSach , Sach.Ten,SoLuong,GiaBan  from CTSach join Sach on CTSach.IdSach = Sach.Id where IdCTSach = ?";
        Connection con = DBContext.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, maSP);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String masp = rs.getString(1);
            String tensp = rs.getString(2);
          
            double gia = rs.getDouble(4);
            int soLuong = rs.getInt(3);
            SanPhamModel san = new SanPhamModel(masp, tensp, tensp, tensp, masp, gia, soLuong);
            
            SP.add(san);

        }
        rs.close();
        ps.close();
        con.close();
        return SP;
    }

    public boolean insert(HoaDonMode HD) {
        String sql = "INSERT INTO [dbo].[HoaDon]\n" +
"           ([IdNhanVien]\n" +
"           ,[IdKM]\n" +
"           ,[IdKhachHang]\n" +
"           ,[IdHinhThucThanhToan]\n" +
"           ,[NgayTao]\n" +
"           ,[IdTrangThaiHD])\n" +
"     VALUES\n" +
"           (?,?,?,?,getdate(),1)";
        try (Connection con = DBContext.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setString(1, HD.getMaNV());
            pstmt.setString(2, HD.getKhuyenMai());
            pstmt.setString(3, HD.getmKH());
            pstmt.setString(4, HD.getThanhToan());
            int affectadRows = pstmt.executeUpdate();
            return affectadRows > 0;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;
    }

    public List<Hienthigannhat> Hienthigannhat() throws SQLException {
        List<Hienthigannhat> HTGN = new ArrayList();
        String sql = "select top (1) HoaDon.Id, KhachHang.Ten,HinhThucThanhToan.TenHinhThucThanhToan,HoaDon.NgayTao,DotKhuyenMai.PhanTramKM,TrangThaiHoaDon.Ten from HoaDon \n" +
"												join KhachHang on HoaDon.IdKhachHang = KhachHang.Id\n" +
"                								join HinhThucThanhToan on HoaDon.IdHinhThucThanhToan = HinhThucThanhToan.Id\n" +
"												join NhanVien on NhanVien.Id = HoaDon.IdNhanVien\n" +
"												join DotKhuyenMai on HoaDon.IdKM = DotKhuyenMai.Id\n" +
"												join TrangThaiHoaDon on TrangThaiHoaDon.Id = HoaDon.IdTrangThaiHD\n" +
"                								order by HoaDon.Id desc";
        Connection con = DBContext.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String idHD = rs.getString(1);
            String TenKH = rs.getString(2);
            String HTTT = rs.getString(3);
            String NgayTao = rs.getString(4);
            String MucGiam = rs.getString(5);

            String trangThai = rs.getString(6);
           
            Hienthigannhat htgn = new Hienthigannhat(idHD, trangThai, TenKH, HTTT, NgayTao, MucGiam, 0);
           

            HTGN.add(htgn);

        }
        rs.close();
        ps.close();
        con.close();
        return HTGN;
    }

    public List<Hienthigannhat> Hienthidanhsach(String idNV) throws SQLException {
        List<Hienthigannhat> HTGN = new ArrayList();
        String sql = "select  HoaDon.Id, KhachHang.Ten,HinhThucThanhToan.TenHinhThucThanhToan,HoaDon.NgayTao,DotKhuyenMai.PhanTramKM,TrangThaiHoaDon.Ten from HoaDon \n" +
"												join KhachHang on HoaDon.IdKhachHang = KhachHang.Id\n" +
"                								                join HinhThucThanhToan on HoaDon.IdHinhThucThanhToan = HinhThucThanhToan.Id\n" +
"												join NhanVien on NhanVien.Id = HoaDon.IdNhanVien\n" +
"												join DotKhuyenMai on HoaDon.IdKM = DotKhuyenMai.Id\n" +
"												join TrangThaiHoaDon on TrangThaiHoaDon.Id = HoaDon.IdTrangThaiHD where nhanvien.id = ? \n";
        Connection con = DBContext.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, idNV);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String idHD = rs.getString(1);
            String TenKH = rs.getString(2);
            String HTTT = rs.getString(3);
            String NgayTao = rs.getString(4);
            String MucGiam = rs.getString(5);

            String trangThai = rs.getString(6);
           
            Hienthigannhat htgn = new Hienthigannhat(idHD, trangThai, TenKH, HTTT, NgayTao, MucGiam, 0);
           

            HTGN.add(htgn);

        }
        rs.close();
        ps.close();
        con.close();
        return HTGN;
    }

    public void huyHoaDon(String maHD) throws SQLException {
        String sql = "update hoadon set idtrangthaiHD = 3 where id = ?";
        Connection con = DBContext.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, maHD);
        int aff = pstmt.executeUpdate();
        pstmt.close();
        con.close();

    }

    public List<Hienthigannhat> HienthiHDtheomaKH(String maKH) throws SQLException {
        List<Hienthigannhat> HTGN = new ArrayList();
        String sql = "select  HoaDon.Id, KhachHang.Ten,HinhThucThanhToan.TenHinhThucThanhToan,HoaDon.NgayTao,DotKhuyenMai.PhanTramKM,TrangThaiHoaDon.Ten from HoaDon \n" +
"												join KhachHang on HoaDon.IdKhachHang = KhachHang.Id\n" +
"                								                join HinhThucThanhToan on HoaDon.IdHinhThucThanhToan = HinhThucThanhToan.Id\n" +
"												join NhanVien on NhanVien.Id = HoaDon.IdNhanVien\n" +
"												join DotKhuyenMai on HoaDon.IdKM = DotKhuyenMai.Id\n" +
"												join TrangThaiHoaDon on TrangThaiHoaDon.Id = HoaDon.IdTrangThaiHD where KhachHang.id = ?";
        Connection con = DBContext.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, maKH);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
             String idHD = rs.getString(1);
            String TenKH = rs.getString(2);
            String HTTT = rs.getString(3);
            String NgayTao = rs.getString(4);
            String MucGiam = rs.getString(5);

            String trangThai = rs.getString(6);
           
            Hienthigannhat htgn = new Hienthigannhat(idHD, trangThai, TenKH, HTTT, NgayTao, MucGiam, 0);
           

            HTGN.add(htgn);


        }
        rs.close();
        ps.close();
        con.close();
        return HTGN;
    }

    public List<Hienthigannhat> HienthiHDtheomaHD(String maHDCanTim) throws SQLException {
        List<Hienthigannhat> HTGN = new ArrayList();
        String sql = "select  HoaDon.Id, KhachHang.Ten,HinhThucThanhToan.TenHinhThucThanhToan,HoaDon.NgayTao,DotKhuyenMai.PhanTramKM,TrangThaiHoaDon.id from HoaDon \n" +
"												join KhachHang on HoaDon.IdKhachHang = KhachHang.Id\n" +
"                								                join HinhThucThanhToan on HoaDon.IdHinhThucThanhToan = HinhThucThanhToan.Id\n" +
"												join NhanVien on NhanVien.Id = HoaDon.IdNhanVien\n" +
"												join DotKhuyenMai on HoaDon.IdKM = DotKhuyenMai.Id\n" +
"												join TrangThaiHoaDon on TrangThaiHoaDon.Id = HoaDon.IdTrangThaiHD where HoaDon.id = ?";
        Connection con = DBContext.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, maHDCanTim);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String idHD = rs.getString(1);
            String TenKH = rs.getString(2);
            String HTTT = rs.getString(3);
            String NgayTao = rs.getString(4);
            String MucGiam = rs.getString(5);

            int trangThai = rs.getInt(6);
           
            Hienthigannhat htgn = new Hienthigannhat(idHD, HTTT, TenKH, HTTT, NgayTao, MucGiam, trangThai);
           

            HTGN.add(htgn);

        }
        rs.close();
        ps.close();
        con.close();
        return HTGN;
    }

    public boolean insertHDchitiet(HoaDonChiTietModel HDCT) {
        String sql = "INSERT INTO [dbo].[HoaDonChiTiet]\n" +
"           ([IdHoaDon]\n" +
"           ,[IdCTSach]\n" +
"           ,[SoLuong])\n" +
"     VALUES\n" +
"           (?,?,?)";
        try (Connection con = DBContext.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setString(1, HDCT.getMaHD());
            pstmt.setString(2, HDCT.getMaSp());

            pstmt.setInt(3, HDCT.getSoLuong());
           

            int affectadRows = pstmt.executeUpdate();
            return affectadRows > 0;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;
    }

    public List<SanPhamModel> listSP() throws SQLException {
        List<SanPhamModel> SP = new ArrayList();
        String sql = "select MaCTSP, SoLuong from ChiTietSanPham";
        Connection con = DBContext.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String masp = rs.getString(1);

            int soLuong = rs.getInt(2);
            SanPhamModel san = new SanPhamModel();

            san.setMaSP(masp);

            san.setSoLuong(soLuong);
            SP.add(san);

        }
        rs.close();
        ps.close();
        con.close();
        return SP;
    }

    public List<giamGiamodel> listGiamGia() throws SQLException {
        List<giamGiamodel> GG = new ArrayList();
        String sql = "select id,ma,ten,PhanTramKM,NgayBatDau,NgayKetThuc from DotKhuyenMai where getdate()>= NgayBatDau and getdate()  <=NgayKetThuc";
        Connection con = DBContext.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String id = rs.getString(1);
            String magg = rs.getString(2);
            String tenkm = rs.getString(3);
            int mucGiam = rs.getInt(4);
            String ngayBD = rs.getString(5);
            String ngayKT = rs.getString(6);
            giamGiamodel san = new giamGiamodel(id, tenkm, magg, ngayBD, ngayKT, mucGiam);

           
            GG.add(san);

        }
        rs.close();
        ps.close();
        con.close();
        return GG;
    }

    public List<GioHangModel> listGioHang(String maHDtim) throws SQLException {
        List<GioHangModel> GH = new ArrayList();
        String sql = "select HoaDonChiTiet.Id,HoaDon.Id,Sach.Ten,HoaDonChiTiet.SoLuong,GiaBan,CTSach.idCTSach from HoaDon join HoaDonChiTiet on HoaDon.Id = HoaDonChiTiet.IdHoaDon \n" +
"					 join CTSach on HoaDonChiTiet.IdCTSach =CTSach.IdCTSach\n" +
"					 join Sach on CTSach.IdSach = Sach.Id where HoaDon.Id = ?";
        Connection con = DBContext.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, maHDtim);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String id = rs.getString(1);
            String maHD = rs.getString(2);
            String tenSP = rs.getString(3);
            String idCTSach = rs.getString(6);
            int soLuong = rs.getInt(4);
           
            double giaBan = rs.getDouble(5);
          

            GioHangModel gh = new GioHangModel(id, maHD, tenSP, tenSP, tenSP, idCTSach, giaBan,giaBan,soLuong);
            

            GH.add(gh);

        }
        rs.close();
        ps.close();
        con.close();
        return GH;
    }

    public void deleteHDCT(String maHDCT) throws SQLException {
        String sql = "delete from HoaDonchitiet where id = ?";
        Connection con = DBContext.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, maHDCT);
        int aff = pstmt.executeUpdate();
        pstmt.close();
        con.close();

    }

    public List<GioHangModel> tinhTong(String IDHDtinh) throws SQLException {
        List<GioHangModel> GH = new ArrayList();
        String sql = "select sum(GiaBan*HoaDonChiTiet.SoLuong),(sum(GiaBan*HoaDonChiTiet.SoLuong)/100)*(100-DotKhuyenMai.PhanTramKM) from HoaDonChiTiet join CTSach on HoaDonChiTiet.IdCTSach = CTSach.IdCTSach\n" +
"															join HoaDon on HoaDonChiTiet.IdHoaDon = HoaDon.Id\n" +
"															join DotKhuyenMai on HoaDon.IdKM = DotKhuyenMai.Id\n" +
"															where HoaDonChiTiet.IdHoaDon = ?\n" +
"group by PhanTramKM";
        Connection con = DBContext.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, IDHDtinh);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String maHD = rs.getString(1);

            double tienTong = rs.getDouble(1);
            double tienGia = rs.getDouble(2);

            GioHangModel gh = new GioHangModel();

            gh.setTongTien(tienTong);
            gh.setTienGiam(tienGia);
            gh.setMaHD(maHD);

            GH.add(gh);

        }
        rs.close();
        ps.close();
        con.close();
        return GH;
    }

    public void thanhToanthanhcong(String maHD,double tongTien) throws SQLException {
        String sql = "update HoaDon set IdTrangThaiHD = 2, TongTien = ? where id = ?";
        Connection con = DBContext.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(2, maHD);
        pstmt.setDouble(1, tongTien);
        int aff = pstmt.executeUpdate();
        pstmt.close();
        con.close();

    }

    public void suaSlSP(int soLuongXoa, String maSp) throws SQLException {
        String sql = "update CTSach set SoLuong= SoLuong- ? where idCTSach = ?";
        Connection con = DBContext.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, soLuongXoa);
        pstmt.setString(2, maSp);

        int aff = pstmt.executeUpdate();
        pstmt.close();
        con.close();

    }

    public void ThemSlSP(int soLuongthem, String maSp) throws SQLException {
        String sql = "update CTSach set SoLuong= SoLuong+ ? where idCTSach = ?";
        Connection con = DBContext.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, soLuongthem);
        pstmt.setString(2, maSp);

        int aff = pstmt.executeUpdate();
        pstmt.close();
        con.close();

    }

    public List<GioHangModel> yeuCau(String Email, String MatKhau) throws SQLException {
        List<GioHangModel> GG = new ArrayList();
        String sql = "select idChucVu from NhanVien where Email like ? and MatKhau like ?";
        Connection con = DBContext.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, Email);
        ps.setString(2, MatKhau);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {

            int ChucVu = rs.getInt(1);
            GioHangModel san = new GioHangModel();

            san.setSoLuong(ChucVu);
            GG.add(san);

        }
        rs.close();
        ps.close();
        con.close();
        return GG;
    }

     public List<KhachHangModel> dangNhap(String manv, String matKhau) throws SQLException{
      List<KhachHangModel> CV = new ArrayList<>();
      String SQL = "select nhanvien.ma,nhanvien.id,nhanvien.ten from nhanvien join chucvu on nhanvien.idchucvu = chucvu.id where nhanvien.email = ? and matKhau = ?";
      Connection con = DBContext.getConnection();
      PreparedStatement ps = con.prepareStatement(SQL);
       ps.setString(1, manv);
        ps.setString(2, matKhau);
      ResultSet rs = ps.executeQuery();
      while(rs.next()){
          
          String manvv = rs.getString(1);
          String idnv = rs.getString(2);
          String tennv = rs.getString(3);
         
          KhachHangModel Cv = new KhachHangModel(manvv, tennv, manvv, SQL, idnv);
          
          CV.add(Cv);
          
      }
      rs.close();
      con.close();
      ps.close();
      return CV;
  }
}
