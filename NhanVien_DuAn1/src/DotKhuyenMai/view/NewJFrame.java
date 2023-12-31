/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DotKhuyenMai.view;

import NhanVien.View.dangNhapHD;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import DotKhuyenMai.model.khuyenMaiModel;
import DotKhuyenMai.service.Service;

/**
 *
 * @author DELL
 */
public class NewJFrame extends javax.swing.JFrame {

    private DotKhuyenMai.service.Service service;

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() throws SQLException {
        initComponents();
        service = new Service();
        loadTableALL();
        loadTableDang();
        setLocationRelativeTo(null);
    }

    private void loadTableALL() throws SQLException {
        List<khuyenMaiModel> HT = service.hienThi();
        DefaultTableModel model = (DefaultTableModel) tblAll.getModel();

        model.setRowCount(0);
        for (khuyenMaiModel ht : HT) {
            Object[] row = new Object[]{ht.getId(), ht.getMa(), ht.getTen(), ht.getMucGiam(), ht.getNgayBD(), ht.getNgayKT(),
                ht.getTrangThai(), ht.getNgayTao()};
            model.addRow(row);

        }
    }

    private void loadTableDang() throws SQLException {
        List<khuyenMaiModel> HT = service.hienThiDang();
        DefaultTableModel model = (DefaultTableModel) tblDang.getModel();

        model.setRowCount(0);
        for (khuyenMaiModel ht : HT) {
            Object[] row = new Object[]{ht.getId(), ht.getMa(), ht.getTen(), ht.getMucGiam(), ht.getNgayKT(),};
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbID = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dateBD = new com.github.lgooddatepicker.components.DatePicker();
        jLabel8 = new javax.swing.JLabel();
        dateKT = new com.github.lgooddatepicker.components.DatePicker();
        jLabel9 = new javax.swing.JLabel();
        rdoSap = new javax.swing.JRadioButton();
        rdoDang = new javax.swing.JRadioButton();
        rdoNgung = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtTen = new javax.swing.JTextField();
        txtMuc = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDang = new javax.swing.JTable();
        txtMaDang = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAll = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtmaAll = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Đợt khuyến mãi");
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel2.setText("ID");

        lbID.setText("---");

        jLabel4.setText("Mã khuyến mãi");

        jLabel5.setText("Tên khuyến mãi");

        jLabel6.setText("Mức giảm");

        jLabel7.setText("Ngày bắt đầu");

        jLabel8.setText("Ngày kết thúc");

        jLabel9.setText("Trạng thái");

        buttonGroup1.add(rdoSap);
        rdoSap.setSelected(true);
        rdoSap.setText("Sắp diễn ra");

        buttonGroup1.add(rdoDang);
        rdoDang.setText("Đang diễn ra");

        buttonGroup1.add(rdoNgung);
        rdoNgung.setText("Đang ngừng");
        rdoNgung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNgungActionPerformed(evt);
            }
        });

        jButton1.setText("Thêm");
        jButton1.setBackground(new java.awt.Color(41, 183, 212));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Sửa");
        jButton2.setBackground(new java.awt.Color(41, 183, 212));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Làm mới");
        jButton3.setBackground(new java.awt.Color(41, 183, 212));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdoSap)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(rdoDang)
                        .addGap(18, 18, 18)
                        .addComponent(rdoNgung)
                        .addGap(8, 8, 8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbID, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(dateKT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(dateBD, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(jButton1)
                                .addGap(34, 34, 34)
                                .addComponent(jButton2)
                                .addGap(29, 29, 29)
                                .addComponent(jButton3)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbID))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(dateBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(dateKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(rdoSap)
                    .addComponent(rdoDang)
                    .addComponent(rdoNgung))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jLabel10.setText("Chương trình khuyến mãi đang diễn ra");
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        tblDang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã Khuyến mãi", "Tên khuyến mãi", "Mức giảm", "Ngày kết thúc"
            }
        ));
        jScrollPane2.setViewportView(tblDang);

        jButton4.setText("Tìm kiếm theo mã");
        jButton4.setBackground(new java.awt.Color(41, 183, 212));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaDang, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtMaDang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        tblAll.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã khuyến mãi", "Tên khuyến mãi", "Mức giảm", "Ngày bắt đầu", "Ngày kết thúc", "Trạng thái", "Ngày tạo"
            }
        ));
        tblAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAllMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAll);

        jLabel11.setText("Danh sách chương trình khuyến mãi");
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jButton5.setText("Tìm kiếm theo mã");
        jButton5.setBackground(new java.awt.Color(41, 183, 212));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtmaAll, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 977, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtmaAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5))
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jButton10.setBackground(new java.awt.Color(41, 183, 212));
        jButton10.setText("Đăng xuất");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(430, 430, 430)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton10)
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton10))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdoNgungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNgungActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNgungActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int chon = JOptionPane.showConfirmDialog(this, "Bạn muốn thêm đợt khuyến mãi mới", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (chon == JOptionPane.YES_OPTION) {
            if (txtMa.getText().isBlank() || txtTen.getText().isBlank() || txtMuc.getText().isBlank() || dateBD.getText().isBlank() || dateKT.getText().isBlank()) {
                JOptionPane.showMessageDialog(this, "Bạn phải nhập đầy đủ thông tin");
                return;
            }
            if (Double.valueOf(txtMuc.getText()) < 0 || Double.valueOf(txtMuc.getText()) > 100) {
                JOptionPane.showMessageDialog(this, "Mức giảm giá phải lớn hơn 0 và nhỏ hơn hoặc băng 100");
                return;
            }
            if (dateBD.getDate().isAfter(dateKT.getDate())) {
                JOptionPane.showMessageDialog(this, "Ngày bắt đầu phải bằng hoặc nhỏ hơn ngày kết thúc");
                return;
            }
            List<khuyenMaiModel> SP = service.checkMa(txtMa.getText());
            if (!SP.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Trùng mã");
                return;
            }
            khuyenMaiModel km = new khuyenMaiModel();
            String ma = txtMa.getText();
            String ten = txtTen.getText();
            double muc = Double.valueOf(txtMuc.getText());
            String ngayBD = dateBD.getText();
            String ngayKT = dateKT.getText();
            km.setMa(ma);
            km.setTen(ten);
            km.setMucGiam(muc);
            km.setNgayBD(ngayBD);
            km.setNgayKT(ngayKT);
            if (rdoDang.isSelected()) {
                km.setTrangThai("Đang diễn ra");
            }
            if (rdoSap.isSelected()) {
                km.setTrangThai("Sắp diễn ra");
            }
            if (rdoNgung.isSelected()) {
                km.setTrangThai("Đang ngừng");
            }
            service.insert(km);
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            try {
                loadTableALL();
                loadTableDang();
            } catch (SQLException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAllMouseClicked
        // TODO add your handling code here:
        int index = tblAll.getSelectedRow();
        if (index >= 0) {
            String id = tblAll.getValueAt(index, 0).toString();
            String ma = tblAll.getValueAt(index, 1).toString();
            String ten = tblAll.getValueAt(index, 2).toString();
            String muc = tblAll.getValueAt(index, 3).toString();
            String ngayBD = tblAll.getValueAt(index, 4).toString();
            String ngayKT = tblAll.getValueAt(index, 5).toString();
            String trangThai = tblAll.getValueAt(index, 6).toString();
            String ngayTao = tblAll.getValueAt(index, 7).toString();
            lbID.setText(id);
            txtMa.setText(ma);
            txtTen.setText(ten);
            txtMuc.setText(muc);
            dateBD.setText(ngayBD);
            dateKT.setText(ngayKT);
            if (trangThai.equalsIgnoreCase("Đang diễn ra")) {
                rdoDang.setSelected(true);
            }
            if (trangThai.equalsIgnoreCase("Sắp diễn ra")) {
                rdoSap.setSelected(true);
            }
            if (trangThai.equalsIgnoreCase("Đang ngừng")) {
                rdoNgung.setSelected(true);
            }
        }
    }//GEN-LAST:event_tblAllMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int chon = JOptionPane.showConfirmDialog(this, "Bạn muốn sửa đợt khuyến mãi mới", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (chon == JOptionPane.YES_OPTION) {
            if (txtMa.getText().isBlank() || txtTen.getText().isBlank() || txtMuc.getText().isBlank() || dateBD.getText().isBlank() || dateKT.getText().isBlank()) {
                JOptionPane.showMessageDialog(this, "Bạn phải nhập đầy đủ thông tin");
                return;
            }
            if (Double.valueOf(txtMuc.getText()) < 0 || Double.valueOf(txtMuc.getText()) > 100) {
                JOptionPane.showMessageDialog(this, "Mức giảm giá phải lớn hơn 0 và nhỏ hơn hoặc băng 100");
                return;
            }
            if (dateBD.getDate().isAfter(dateKT.getDate())) {
                JOptionPane.showMessageDialog(this, "Ngày bắt đầu phải bằng hoặc nhỏ hơn ngày kết thúc");
                return;
            }
            List<khuyenMaiModel> SP = service.checkMa(txtMa.getText());
            if (SP.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy đợt khuyến mãi");
                return;
            }

            khuyenMaiModel km = new khuyenMaiModel();
            String ma = txtMa.getText();
            String ten = txtTen.getText();
            double muc = Double.valueOf(txtMuc.getText());
            String ngayBD = dateBD.getText();
            String ngayKT = dateKT.getText();
            String id = lbID.getText();
            km.setId(id);
            km.setMa(ma);
            km.setTen(ten);
            km.setMucGiam(muc);
            km.setNgayBD(ngayBD);
            km.setNgayKT(ngayKT);
            if (rdoDang.isSelected()) {
                km.setTrangThai("Đang diễn ra");
            }
            if (rdoSap.isSelected()) {
                km.setTrangThai("Sắp diễn ra");
            }
            if (rdoNgung.isSelected()) {
                km.setTrangThai("Đang ngừng");
            }
            try {
                service.update(km);
            } catch (SQLException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(this, "Sửa thành công");
            try {
                loadTableALL();
                loadTableDang();
            } catch (SQLException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        txtMa.setText("");
        txtMuc.setText("");
        txtTen.setText("");
        lbID.setText("");
        dateBD.setText("");
        dateKT.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (txtMaDang.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Bạn phải nhập mã đợt khuyến mãi cần tìm ");
            return;
        }
        List<khuyenMaiModel> SP = service.hienThiDangtheoma(txtMaDang.getText());
        if (SP.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy");
            return;
        }
        
        DefaultTableModel model = (DefaultTableModel) tblDang.getModel();

        model.setRowCount(0);
        for (khuyenMaiModel ht : SP) {
            Object[] row = new Object[]{ht.getId(), ht.getMa(), ht.getTen(), ht.getMucGiam(), ht.getNgayKT(),};
            model.addRow(row);

        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
         if (txtmaAll.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Bạn phải nhập mã đợt khuyến mãi cần tìm ");
            return;
        }
        List<khuyenMaiModel> SP = service.hienThitheoma(txtmaAll.getText());
        if (SP.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy");
            return;
        }
        
        DefaultTableModel model = (DefaultTableModel) tblAll.getModel();

        model.setRowCount(0);
        for (khuyenMaiModel ht : SP) {
            Object[] row = new Object[]{ht.getId(), ht.getMa(), ht.getTen(), ht.getMucGiam(), ht.getNgayBD(), ht.getNgayKT(),
                ht.getTrangThai(), ht.getNgayTao()};
            model.addRow(row);

        

        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        new dangNhapHD().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new NewJFrame().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private com.github.lgooddatepicker.components.DatePicker dateBD;
    private com.github.lgooddatepicker.components.DatePicker dateKT;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbID;
    private javax.swing.JRadioButton rdoDang;
    private javax.swing.JRadioButton rdoNgung;
    private javax.swing.JRadioButton rdoSap;
    private javax.swing.JTable tblAll;
    private javax.swing.JTable tblDang;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMaDang;
    private javax.swing.JTextField txtMuc;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtmaAll;
    // End of variables declaration//GEN-END:variables
}
