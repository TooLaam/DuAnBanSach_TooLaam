/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.duan1.View;

import com.mycompany.duan1.Bean.DanhMuc;
import com.mycompany.duan1.Controller.ChuyenManHinhController;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class MainJFrame extends javax.swing.JFrame {

    public MainJFrame() {
        initComponents();

        setTitle("QUẢN LÍ BÁN SÁCH");
        //Căn giữa
        setLocationRelativeTo(null);
        ChuyenManHinhController controller = new ChuyenManHinhController(jpnView);
        controller.setViewStart(jpnTrangChu, jlbTrangChu);

        List<DanhMuc> listDanhMuc = new ArrayList<>();
//        listDanhMuc.add(new DanhMuc("Main","TrangChu", jpnTrangChu, jlbTrangChu));
//        listDanhMuc.add(new DanhMuc("Main","QLKM", jpnQLKM, jlbQLKM));
//        listDanhMuc.add(new DanhMuc("Main","QLNS", jpnQuanLiNhanVien, jlbQunaLiNhanVien));
        listDanhMuc.add(new DanhMuc("Main","QLHD", jpnHoaDon, jlbHoaDon));
       
        controller.setEvent(listDanhMuc);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnRoot = new javax.swing.JPanel();
        jpnMenu = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jpnTrangChu = new javax.swing.JPanel();
        jlbTrangChu = new javax.swing.JLabel();
        jpnQuanLiSach = new javax.swing.JPanel();
        jlbQuanLiSach = new javax.swing.JLabel();
        jpnQuanLiNhanVien = new javax.swing.JPanel();
        jlbQunaLiNhanVien = new javax.swing.JLabel();
        jpnHoaDon = new javax.swing.JPanel();
        jlbHoaDon = new javax.swing.JLabel();
        jpnQLKM = new javax.swing.JPanel();
        jlbQLKM = new javax.swing.JLabel();
        jpnKhachHang = new javax.swing.JPanel();
        jlbKhachHang = new javax.swing.JLabel();
        jpnDoanhThu = new javax.swing.JPanel();
        jlbDoanhThu = new javax.swing.JLabel();
        jpnView = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setSize(new java.awt.Dimension(1000, 800));

        jpnRoot.setPreferredSize(new java.awt.Dimension(1000, 700));

        jpnMenu.setBackground(new java.awt.Color(102, 102, 102));
        jpnMenu.setPreferredSize(new java.awt.Dimension(300, 70));

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 70));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÍ BÁN SÁCH");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        jpnTrangChu.setBackground(new java.awt.Color(102, 102, 102));
        jpnTrangChu.setPreferredSize(new java.awt.Dimension(280, 70));
        jpnTrangChu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jpnTrangChuMousePressed(evt);
            }
        });

        jlbTrangChu.setBackground(new java.awt.Color(0, 102, 0));
        jlbTrangChu.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jlbTrangChu.setForeground(new java.awt.Color(255, 255, 255));
        jlbTrangChu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jpnTrangChuLayout = new javax.swing.GroupLayout(jpnTrangChu);
        jpnTrangChu.setLayout(jpnTrangChuLayout);
        jpnTrangChuLayout.setHorizontalGroup(
            jpnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnTrangChuLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jlbTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jpnTrangChuLayout.setVerticalGroup(
            jpnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnTrangChuLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jlbTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        jpnQuanLiSach.setBackground(new java.awt.Color(102, 102, 102));
        jpnQuanLiSach.setPreferredSize(new java.awt.Dimension(280, 70));
        jpnQuanLiSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jpnQuanLiSachMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpnQuanLiSachMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jpnQuanLiSachMouseReleased(evt);
            }
        });

        jlbQuanLiSach.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jlbQuanLiSach.setForeground(new java.awt.Color(255, 255, 255));
        jlbQuanLiSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jlbQuanLiSachMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jpnQuanLiSachLayout = new javax.swing.GroupLayout(jpnQuanLiSach);
        jpnQuanLiSach.setLayout(jpnQuanLiSachLayout);
        jpnQuanLiSachLayout.setHorizontalGroup(
            jpnQuanLiSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnQuanLiSachLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jlbQuanLiSach, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jpnQuanLiSachLayout.setVerticalGroup(
            jpnQuanLiSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnQuanLiSachLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jlbQuanLiSach, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        jpnQuanLiNhanVien.setBackground(new java.awt.Color(102, 102, 102));
        jpnQuanLiNhanVien.setPreferredSize(new java.awt.Dimension(280, 70));

        jlbQunaLiNhanVien.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jlbQunaLiNhanVien.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jpnQuanLiNhanVienLayout = new javax.swing.GroupLayout(jpnQuanLiNhanVien);
        jpnQuanLiNhanVien.setLayout(jpnQuanLiNhanVienLayout);
        jpnQuanLiNhanVienLayout.setHorizontalGroup(
            jpnQuanLiNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnQuanLiNhanVienLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jlbQunaLiNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jpnQuanLiNhanVienLayout.setVerticalGroup(
            jpnQuanLiNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnQuanLiNhanVienLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jlbQunaLiNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        jpnHoaDon.setBackground(new java.awt.Color(76, 175, 80));
        jpnHoaDon.setPreferredSize(new java.awt.Dimension(280, 70));

        jlbHoaDon.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jlbHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        jlbHoaDon.setText("Hoá Đơn");

        javax.swing.GroupLayout jpnHoaDonLayout = new javax.swing.GroupLayout(jpnHoaDon);
        jpnHoaDon.setLayout(jpnHoaDonLayout);
        jpnHoaDonLayout.setHorizontalGroup(
            jpnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHoaDonLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jlbHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jpnHoaDonLayout.setVerticalGroup(
            jpnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHoaDonLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jlbHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        jpnQLKM.setBackground(new java.awt.Color(102, 102, 102));
        jpnQLKM.setPreferredSize(new java.awt.Dimension(280, 70));

        jlbQLKM.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jlbQLKM.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jpnQLKMLayout = new javax.swing.GroupLayout(jpnQLKM);
        jpnQLKM.setLayout(jpnQLKMLayout);
        jpnQLKMLayout.setHorizontalGroup(
            jpnQLKMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnQLKMLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jlbQLKM, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jpnQLKMLayout.setVerticalGroup(
            jpnQLKMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnQLKMLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jlbQLKM, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        jpnKhachHang.setBackground(new java.awt.Color(102, 102, 102));
        jpnKhachHang.setPreferredSize(new java.awt.Dimension(280, 70));

        jlbKhachHang.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jlbKhachHang.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jpnKhachHangLayout = new javax.swing.GroupLayout(jpnKhachHang);
        jpnKhachHang.setLayout(jpnKhachHangLayout);
        jpnKhachHangLayout.setHorizontalGroup(
            jpnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnKhachHangLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jlbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jpnKhachHangLayout.setVerticalGroup(
            jpnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnKhachHangLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jlbKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        jpnDoanhThu.setBackground(new java.awt.Color(102, 102, 102));
        jpnDoanhThu.setPreferredSize(new java.awt.Dimension(280, 70));

        jlbDoanhThu.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jlbDoanhThu.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jpnDoanhThuLayout = new javax.swing.GroupLayout(jpnDoanhThu);
        jpnDoanhThu.setLayout(jpnDoanhThuLayout);
        jpnDoanhThuLayout.setHorizontalGroup(
            jpnDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnDoanhThuLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jlbDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jpnDoanhThuLayout.setVerticalGroup(
            jpnDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDoanhThuLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jlbDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jpnMenuLayout = new javax.swing.GroupLayout(jpnMenu);
        jpnMenu.setLayout(jpnMenuLayout);
        jpnMenuLayout.setHorizontalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpnDoanhThu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                    .addGroup(jpnMenuLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jpnQuanLiNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                            .addComponent(jpnQuanLiSach, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                            .addComponent(jpnTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                            .addComponent(jpnHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                            .addComponent(jpnQLKM, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                            .addComponent(jpnKhachHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE))))
                .addGap(15, 15, 15))
        );
        jpnMenuLayout.setVerticalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jpnTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jpnQuanLiSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jpnQuanLiNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jpnHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jpnQLKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jpnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jpnDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jpnView.setBackground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpnRootLayout = new javax.swing.GroupLayout(jpnRoot);
        jpnRoot.setLayout(jpnRootLayout);
        jpnRootLayout.setHorizontalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jpnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnRootLayout.setVerticalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
            .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jpnQuanLiSachMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnQuanLiSachMouseReleased

    }//GEN-LAST:event_jpnQuanLiSachMouseReleased

    private void jpnQuanLiSachMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnQuanLiSachMouseExited

    }//GEN-LAST:event_jpnQuanLiSachMouseExited

    private void jpnQuanLiSachMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnQuanLiSachMouseEntered

    }//GEN-LAST:event_jpnQuanLiSachMouseEntered

    private void jlbQuanLiSachMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbQuanLiSachMousePressed
        //        jpnQuanLiSach.setBackground(new Color(200,0,0));
    }//GEN-LAST:event_jlbQuanLiSachMousePressed

    private void jpnTrangChuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnTrangChuMousePressed

    }//GEN-LAST:event_jpnTrangChuMousePressed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlbDoanhThu;
    private javax.swing.JLabel jlbHoaDon;
    private javax.swing.JLabel jlbKhachHang;
    private javax.swing.JLabel jlbQLKM;
    private javax.swing.JLabel jlbQuanLiSach;
    private javax.swing.JLabel jlbQunaLiNhanVien;
    private javax.swing.JLabel jlbTrangChu;
    private javax.swing.JPanel jpnDoanhThu;
    private javax.swing.JPanel jpnHoaDon;
    private javax.swing.JPanel jpnKhachHang;
    private javax.swing.JPanel jpnMenu;
    private javax.swing.JPanel jpnQLKM;
    private javax.swing.JPanel jpnQuanLiNhanVien;
    private javax.swing.JPanel jpnQuanLiSach;
    private javax.swing.JPanel jpnRoot;
    private javax.swing.JPanel jpnTrangChu;
    public javax.swing.JPanel jpnView;
    // End of variables declaration//GEN-END:variables
}
