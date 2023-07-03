    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duan1.Utilities;

import com.mycompany.duan1.Entity.CTSach;
import com.mycompany.duan1.Entity.CapBac;
import com.mycompany.duan1.Entity.ChatLieu;
import com.mycompany.duan1.Entity.HoaDonChiTiet;
import com.mycompany.duan1.Entity.ChiTietTheLoai;
import com.mycompany.duan1.Entity.DotKhuyenMai;
import com.mycompany.duan1.Entity.HinhThucThanhToan;
import com.mycompany.duan1.Entity.HoaDon;
import com.mycompany.duan1.Entity.KhachHang;
import com.mycompany.duan1.Entity.LichSuCapNhatTrangThai;
import com.mycompany.duan1.Entity.LichSuGiaoHang;
import com.mycompany.duan1.Entity.NamXuatBan;
import com.mycompany.duan1.Entity.NgonNgu;
import com.mycompany.duan1.Entity.NhaXuatBan;
import com.mycompany.duan1.Entity.NhanVien;
import com.mycompany.duan1.Entity.PhieuGiaoHang;
import com.mycompany.duan1.Entity.Sach;
import com.mycompany.duan1.Entity.TacGia;
import com.mycompany.duan1.Entity.TacGiaSach;
import com.mycompany.duan1.Entity.TheLoai;
import com.mycompany.duan1.Entity.ThongTinChiTiet;
import com.mycompany.duan1.Entity.TrangThaiHoaDon;
import com.mycompany.duan1.Entity.TrangThaiPhieuGiaoHang;
import com.mycompany.duan1.Entity.ViTri;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Admin
 */
public class HibernateUtils {

    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=duan1_Nhom3_BanSach1");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "vutuan2003");
        properties.put(Environment.SHOW_SQL, "true");

        conf.setProperties(properties);
        //Khai báo class được ánh xạ
//        conf.addAnnotatedClass(DongVat.class);
        conf.addAnnotatedClass(NhanVien.class);
        conf.addAnnotatedClass(HoaDon.class);
        conf.addAnnotatedClass(KhachHang.class);
        conf.addAnnotatedClass(ThongTinChiTiet.class);
        conf.addAnnotatedClass(PhieuGiaoHang.class);
        conf.addAnnotatedClass(TrangThaiPhieuGiaoHang.class);
        conf.addAnnotatedClass(HinhThucThanhToan.class);
        conf.addAnnotatedClass(CTSach.class);
        conf.addAnnotatedClass(ChatLieu.class);
        conf.addAnnotatedClass(NgonNgu.class);
        conf.addAnnotatedClass(ViTri.class);
        conf.addAnnotatedClass(NamXuatBan.class);
        conf.addAnnotatedClass(NhaXuatBan.class);
        conf.addAnnotatedClass(Sach.class);
        conf.addAnnotatedClass(ChiTietTheLoai.class);
        conf.addAnnotatedClass(TacGiaSach.class);
        conf.addAnnotatedClass(TheLoai.class);
        conf.addAnnotatedClass(TacGia.class);
        conf.addAnnotatedClass(DotKhuyenMai.class);
        conf.addAnnotatedClass(HoaDonChiTiet.class);
        conf.addAnnotatedClass(TrangThaiHoaDon.class);
        conf.addAnnotatedClass(CapBac.class);
        conf.addAnnotatedClass(LichSuCapNhatTrangThai.class);
        conf.addAnnotatedClass(LichSuGiaoHang.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }
}
