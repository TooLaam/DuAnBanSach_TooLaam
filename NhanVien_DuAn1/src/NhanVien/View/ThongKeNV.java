/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package NhanVien.View;

import NhanVien.Service.SV_NhanVien;
import NhanVien.Service.SV_ThongKe;
import NhanVien.ViewModel.VM_BangNV;
import NhanVien.ViewModel.VM_ThongKe;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class ThongKeNV extends javax.swing.JFrame {
private SV_ThongKe service;
private SV_NhanVien serviceNV;
    /**
     * Creates new form ThongKeNV
     */
    public ThongKeNV() throws SQLException {
        initComponents();
        service = new SV_ThongKe();
        serviceNV = new SV_NhanVien();
        loadThongKeGioiTinh();
        loadTableNV();
         setLocationRelativeTo(null);
    }

    
    private void loadThongKeGioiTinh() throws SQLException {
        List<VM_ThongKe> NVNam = service.HienThiGioiTinh("Nam");
       txtNVNam.setText(String.valueOf(NVNam.get(0).getTongSoNam()) );
       List<VM_ThongKe> NVNu = service.HienThiGioiTinh("Nữ");
        txtNu.setText(String.valueOf(NVNu.get(0).getTongSoNam()) );
        List<VM_ThongKe> NVall = service.HienThiAll();
        txtAll.setText(String.valueOf(NVall.get(0).getTongSoNam()) );
        
         List<VM_ThongKe> NVLam = service.HienThiTrangThaiDiLam("1");
        txtDangLam.setText(String.valueOf(NVLam.get(0).getTongSoNam()) );
         List<VM_ThongKe> NVTamNghi = service.HienThiTrangThaiDiLam("2");
        txtTamNghi.setText(String.valueOf(NVTamNghi.get(0).getTongSoNam()) );
         List<VM_ThongKe> NVNghi = service.HienThiTrangThaiDiLam("3");
        txtNghi.setText(String.valueOf(NVNghi.get(0).getTongSoNam()) );
        
        List<VM_ThongKe> NVShip = service.HienThiTrangThaiShip("1");
        txtShip.setText(String.valueOf(NVShip.get(0).getTongSoNam()) );
        List<VM_ThongKe> NVkoShip = service.HienThiTrangThaiShip("2");
        txtkoship.setText(String.valueOf(NVkoShip.get(0).getTongSoNam()) );
    }
    
     private void loadTableNV() throws SQLException {
        List<VM_BangNV> CV = serviceNV.HienThi();
        DefaultTableModel model = (DefaultTableModel) tblNV.getModel();
        model.setRowCount(0);
        for (VM_BangNV nv : CV) {
            Object[] row = {nv.getIDNV(), nv.getMa(), nv.getTen(), nv.getGioiTinh(), nv.getNgaySinh(), nv.getEmail(), nv.getSDT(), nv.getDiaChi(), nv.TrangThaiLam(), nv.TrangThaiship(), nv.getTenCV()};
            model.addRow(row);
        }
    }
     
      private void loadTableGioiTinhNam() throws SQLException {
        List<VM_BangNV> CV = service.HienThiTableGioiTinh("Nam");
        DefaultTableModel model = (DefaultTableModel) tblNV.getModel();
        model.setRowCount(0);
        for (VM_BangNV nv : CV) {
            Object[] row = {nv.getIDNV(), nv.getMa(), nv.getTen(), nv.getGioiTinh(), nv.getNgaySinh(), nv.getEmail(), nv.getSDT(), nv.getDiaChi(), nv.TrangThaiLam(), nv.TrangThaiship(), nv.getTenCV()};
            model.addRow(row);
        }
    }
      
       private void loadTableGioiTinhNu() throws SQLException {
        List<VM_BangNV> CV = service.HienThiTableGioiTinh("Nữ");
        DefaultTableModel model = (DefaultTableModel) tblNV.getModel();
        model.setRowCount(0);
        for (VM_BangNV nv : CV) {
            Object[] row = {nv.getIDNV(), nv.getMa(), nv.getTen(), nv.getGioiTinh(), nv.getNgaySinh(), nv.getEmail(), nv.getSDT(), nv.getDiaChi(), nv.TrangThaiLam(), nv.TrangThaiship(), nv.getTenCV()};
            model.addRow(row);
        }
    }
       
         private void loadTabletrangThaiLam() throws SQLException {
        List<VM_BangNV> CV = service.HienThiTableDiLam("1");
        DefaultTableModel model = (DefaultTableModel) tblNV.getModel();
        model.setRowCount(0);
        for (VM_BangNV nv : CV) {
            Object[] row = {nv.getIDNV(), nv.getMa(), nv.getTen(), nv.getGioiTinh(), nv.getNgaySinh(), nv.getEmail(), nv.getSDT(), nv.getDiaChi(), nv.TrangThaiLam(), nv.TrangThaiship(), nv.getTenCV()};
            model.addRow(row);
        }
    }
         private void loadTabletrangThaiTamNghi() throws SQLException {
        List<VM_BangNV> CV = service.HienThiTableDiLam("2");
        DefaultTableModel model = (DefaultTableModel) tblNV.getModel();
        model.setRowCount(0);
        for (VM_BangNV nv : CV) {
            Object[] row = {nv.getIDNV(), nv.getMa(), nv.getTen(), nv.getGioiTinh(), nv.getNgaySinh(), nv.getEmail(), nv.getSDT(), nv.getDiaChi(), nv.TrangThaiLam(), nv.TrangThaiship(), nv.getTenCV()};
            model.addRow(row);
        }
    }
         private void loadTabletrangNghi() throws SQLException {
        List<VM_BangNV> CV = service.HienThiTableDiLam("3");
        DefaultTableModel model = (DefaultTableModel) tblNV.getModel();
        model.setRowCount(0);
        for (VM_BangNV nv : CV) {
            Object[] row = {nv.getIDNV(), nv.getMa(), nv.getTen(), nv.getGioiTinh(), nv.getNgaySinh(), nv.getEmail(), nv.getSDT(), nv.getDiaChi(), nv.TrangThaiLam(), nv.TrangThaiship(), nv.getTenCV()};
            model.addRow(row);
        }
    }
         
          private void loadTabletrangThaiCoShip() throws SQLException {
        List<VM_BangNV> CV = service.HienThiTableShip("1");
        DefaultTableModel model = (DefaultTableModel) tblNV.getModel();
        model.setRowCount(0);
        for (VM_BangNV nv : CV) {
            Object[] row = {nv.getIDNV(), nv.getMa(), nv.getTen(), nv.getGioiTinh(), nv.getNgaySinh(), nv.getEmail(), nv.getSDT(), nv.getDiaChi(), nv.TrangThaiLam(), nv.TrangThaiship(), nv.getTenCV()};
            model.addRow(row);
        }
    }
          private void loadTabletrangThaikoShip() throws SQLException {
        List<VM_BangNV> CV = service.HienThiTableShip("2");
        DefaultTableModel model = (DefaultTableModel) tblNV.getModel();
        model.setRowCount(0);
        for (VM_BangNV nv : CV) {
            Object[] row = {nv.getIDNV(), nv.getMa(), nv.getTen(), nv.getGioiTinh(), nv.getNgaySinh(), nv.getEmail(), nv.getSDT(), nv.getDiaChi(), nv.TrangThaiLam(), nv.TrangThaiship(), nv.getTenCV()};
            model.addRow(row);
        }
    }
      
      
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtAll = new javax.swing.JTextField();
        txtDangLam = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTamNghi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNghi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNVNam = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtShip = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtkoship = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNu = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblNV = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        dateNgayBD = new com.github.lgooddatepicker.components.DatePicker();
        jLabel13 = new javax.swing.JLabel();
        dateNgayKT = new com.github.lgooddatepicker.components.DatePicker();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        txtTóngP = new javax.swing.JTextField();
        txtTongDoanhThu = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtTongHD = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Tổng số nhân viên");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        txtAll.setEditable(false);

        txtDangLam.setEditable(false);
        txtDangLam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDangLamActionPerformed(evt);
            }
        });

        jLabel3.setText("Tổng số nhân viên đang làm");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        txtTamNghi.setEditable(false);

        jLabel4.setText("Tổng số nhân viên tạm thời nghỉ");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        txtNghi.setEditable(false);

        jLabel5.setText("Tổng số nhân viên đã nghỉ");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        txtNVNam.setEditable(false);

        jLabel6.setText("Tổng số Nam");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        txtShip.setEditable(false);
        txtShip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtShipActionPerformed(evt);
            }
        });

        jLabel7.setText("Tổng số nhân viên có thể giao hàng");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        txtkoship.setEditable(false);
        txtkoship.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkoshipActionPerformed(evt);
            }
        });

        jLabel8.setText("Tổng số nhân viên không thể giao hàng");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        jLabel9.setText("Tổng số Nữ");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        txtNu.setEditable(false);

        tblNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã", "Tên", "Giới tính", "Ngày sinh", "Email", "SĐT", "Địa chỉ", "Trạng thái làm việc", "Trạng thái shipper", "Chức vụ"
            }
        ));
        tblNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNVMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblNV);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAll, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNVNam, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNu, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDangLam, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTamNghi, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtShip, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtkoship, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNghi, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addComponent(jScrollPane3)
                    .addGap(11, 11, 11)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtDangLam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtTamNghi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtNghi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNVNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(txtkoship, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtShip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtNu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(210, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(123, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(22, 22, 22)))
        );

        jLabel1.setText("Thống kê nhân viên");
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel10.setText("Thống kê nhân viên bán hàng");
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel11.setText("Nhập mã nhân viên");

        jLabel12.setText("Từ");

        jLabel13.setText("Đến");

        jButton1.setText("Thống kê");
        jButton1.setBackground(new java.awt.Color(41, 183, 212));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã NV", "Mã sản phẩm", "Tên sản phẩm", "Số lượng đã bán", "Doanh thu theo sản phẩm"
            }
        ));
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblNhanVien);

        jLabel14.setText("Tổng sản phẩm nhân viên bán được");

        txtTóngP.setEditable(false);

        txtTongDoanhThu.setEditable(false);

        jLabel15.setText("Tổng doanh thu nhân viên bán được");

        txtTongHD.setEditable(false);

        jLabel16.setText("Tổng hóa đơn nhân viên bán được");

        jButton3.setText("Làm mới");
        jButton3.setBackground(new java.awt.Color(41, 183, 212));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTóngP, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTongDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTongHD, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(dateNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(dateNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTongHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTóngP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTongDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jButton2.setText("EXIT");
        jButton2.setBackground(new java.awt.Color(41, 183, 212));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(422, 422, 422)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(108, 108, 108))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtShipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtShipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtShipActionPerformed

    private void txtkoshipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkoshipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkoshipActionPerformed

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        // TODO add your handling code here:
       
           
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void tblNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNVMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblNVMouseClicked

    private void txtDangLamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDangLamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDangLamActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
    try {
        // TODO add your handling code here:
        loadTableGioiTinhNam();
    } catch (SQLException ex) {
        Logger.getLogger(ThongKeNV.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
    try {
        // TODO add your handling code here:
        loadTableGioiTinhNu();
    } catch (SQLException ex) {
        Logger.getLogger(ThongKeNV.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
    try {
        // TODO add your handling code here:
        loadTabletrangThaiLam();
    } catch (SQLException ex) {
        Logger.getLogger(ThongKeNV.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
    try {
        // TODO add your handling code here:
        loadTabletrangThaiTamNghi();
    } catch (SQLException ex) {
        Logger.getLogger(ThongKeNV.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
    try {
        // TODO add your handling code here:
        loadTabletrangNghi();
    } catch (SQLException ex) {
        Logger.getLogger(ThongKeNV.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
    try {
        // TODO add your handling code here:
        loadTabletrangThaiCoShip();
    } catch (SQLException ex) {
        Logger.getLogger(ThongKeNV.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
    try {
        // TODO add your handling code here:
        loadTabletrangThaikoShip();
    } catch (SQLException ex) {
        Logger.getLogger(ThongKeNV.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
         if (txtMaNV.getText().isBlank()||dateNgayBD.getText().isBlank()||dateNgayKT.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Bạn phải nhập đầy đủ thông tin trước");
            return;
        }
           if (dateNgayBD.getDate().isAfter(dateNgayKT.getDate())) {
            JOptionPane.showMessageDialog(this, "Ngày bắt đầu phải bằng hoặc nhỏ hơn ngày kết thúc");
            return;
        }
            String maNV =txtMaNV.getText();
            String ngayBD = dateNgayBD.getText();
            String ngayKT = dateNgayKT.getText();
             List<VM_ThongKe> CV;
    try {
         List<VM_ThongKe> TongSPBanDc = service.HienThiTongSPNVBan(maNV, ngayBD, ngayKT);
         List<VM_ThongKe> TongHD = service.HienThiTongHD(maNV, ngayBD, ngayKT);
         List<VM_BangNV> hienThiTheoMa = serviceNV.HienThitheoMa(maNV);
         if (hienThiTheoMa.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên theo mã");
            return;
        }
         if (TongHD.get(0).getTongHDBan() == 0) {
            JOptionPane.showMessageDialog(this, "Nhân viên này chưa bán được hóa đơn nào");
            return;
        }
        CV = service.HienThiDoanhThuTheoNV(maNV, ngayBD, ngayKT);
        DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
        model.setRowCount(0);
        for (VM_ThongKe nv : CV) {
            Object[] row = {nv.getMaNV(),nv.getMaSP(),nv.getTenSP(),nv.getSLBan(),nv.getDoanhThuTheoSP()};
            model.addRow(row);
        }
       
       txtTóngP.setText(String.valueOf(TongSPBanDc.get(0).getTongSPBan()) );
      
       txtTongDoanhThu.setText(String.valueOf(TongSPBanDc.get(0).getTongDoanhThuBan()) );
       txtTongHD.setText(String.valueOf(TongHD.get(0).getTongHDBan()));
       
    } catch (SQLException ex) {
        Logger.getLogger(ThongKeNV.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        txtMaNV.setText("");
        txtTongHD.setText("");
        txtTongDoanhThu.setText("");
        txtTóngP.setText("");
        dateNgayBD.setText("");
        dateNgayKT.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
    try {
        // TODO add your handling code here:
        loadTableNV();
    } catch (SQLException ex) {
        Logger.getLogger(ThongKeNV.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jLabel2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThongKeNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKeNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKeNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKeNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ThongKeNV().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeNV.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.github.lgooddatepicker.components.DatePicker dateNgayBD;
    private com.github.lgooddatepicker.components.DatePicker dateNgayKT;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblNV;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtAll;
    private javax.swing.JTextField txtDangLam;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtNVNam;
    private javax.swing.JTextField txtNghi;
    private javax.swing.JTextField txtNu;
    private javax.swing.JTextField txtShip;
    private javax.swing.JTextField txtTamNghi;
    private javax.swing.JTextField txtTongDoanhThu;
    private javax.swing.JTextField txtTongHD;
    private javax.swing.JTextField txtTóngP;
    private javax.swing.JTextField txtkoship;
    // End of variables declaration//GEN-END:variables
}
