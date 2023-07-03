package khachHang.view;

import NhanVien.View.Menu;
import khachHang.implement.DiaChiImplement;
import khachHang.implement.KhachHangImplement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import khachHang.model.DiaChi;
import khachHang.model.KhachHang;
import khachHang.model.KhachHangResponse;
import khachHang.service.DiaChiInterface;
import khachHang.service.KhachHangService;

public class PanelKhachHang extends javax.swing.JFrame {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private KhachHangService khachhangrp = new KhachHangImplement();
    private DiaChiInterface diachirp = new DiaChiImplement();

    public PanelKhachHang() {
        initComponents();
        setLocationRelativeTo(null);
        HienThi(khachhangrp.getAll());
        GetListDC(khachhangrp.getAllDC());
//        CBB(khachhangrp.getListCBKhachHang());
        this.radioNam.setSelected(true);
        this.radioThuong.setSelected(true);

    }

    public void HienThi(ArrayList<KhachHang> list) {
        DefaultTableModel dtm = (DefaultTableModel) tbKhachHang.getModel();
//        tbKhachHang.addMouseListener(mouseListener);
        dtm.setRowCount(0);
        for (KhachHang kh : list) {
            dtm.addRow(new Object[]{kh.getId(), kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getGioiTinh(),
                kh.getEmail(), kh.getSDT(), kh.Diem(), kh.getNgayTao()});
        }
    }

    // MouseListener cho bảng
    MouseListener tblListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            // Lấy chỉ số dòng được click
            int selectedRow = tblDC.getSelectedRow();

            // Kiểm tra xem dòng nào được click
            if (selectedRow != -1) {
                // Lấy dữ liệu từ bảng
                String IdDC = tblDC.getValueAt(selectedRow, 0).toString();
                String IdKH = tblDC.getValueAt(selectedRow, 1).toString();
                String TenKH = tblDC.getValueAt(selectedRow, 2).toString();
                String SDT = tblDC.getValueAt(selectedRow, 3).toString();
                String DC = tblDC.getValueAt(selectedRow, 4).toString();
                String TP = tblDC.getValueAt(selectedRow, 5).toString();
                String NgayTao = tblDC.getValueAt(selectedRow, 6).toString();

                Form form = new Form();
                form.setTextData(IdDC, IdKH, TenKH, SDT, DC, TP, NgayTao);
                form.setVisible(true);
            }
        }
    };

    public void GetListDC(ArrayList<KhachHangResponse> listKhachHangRP) {

        DefaultTableModel dtm = (DefaultTableModel) tblDC.getModel();
        dtm.setRowCount(0);
        for (KhachHangResponse khrp : listKhachHangRP) {
            dtm.addRow(new Object[]{
                khrp.getIdDC(),
                khrp.getId(),
                khrp.getTen(),
                khrp.getSdt(),
                khrp.getDiaChi(),
                khrp.getThanhPho(), khrp.getNgayTao()
            });
        }
        tblDC.addMouseListener(tblListener);

    }
// Gán MouseListener cho bảng

//    MouseListener mouseListener = new MouseAdapter() {
//        public void mouseClicked(MouseEvent e) {
//
//            if (e.getClickCount() == 1) { // Kiểm tra xem đã nhấp chuột đúp hay chưa
//                JTable sourceTable = (JTable) e.getSource();
//                int selectedRow = sourceTable.getSelectedRow();
//                ArrayList<KhachHang> selectedKhachHang = new ArrayList<>();
//                GetListDC(selectedKhachHang);
//
//                // Lấy dữ liệu từ hàng được chọn trong bảng tbKhachHang
//                Object maKhachHang = sourceTable.getValueAt(selectedRow, 0); // Lấy giá trị từ cột maKhachHang
//                Object tenKhachHang = sourceTable.getValueAt(selectedRow, 1); // Lấy giá trị từ cột tenKhachHang
//                Object sdt = sourceTable.getValueAt(selectedRow, 2); // Lấy giá trị từ cột sdt
//
//
//                // Thực hiện thao tác để chuyển dữ liệu sang bảng tblDC
//                DefaultTableModel dtm = (DefaultTableModel) tblDC.getModel();
//                dtm.addRow(new Object[]{maKhachHang, tenKhachHang, sdt});
//            }
//        }
//    };
//    public void CBB(ArrayList<String> list) {
//        DefaultComboBoxModel dcbb = (DefaultComboBoxModel) cbbCapBac.getModel();
//        dcbb.removeAllElements();
//        for (String string : list) {
//            dcbb.addElement(string);
//        }
//    }
    public void loadText(int index) {
        txtMa.setText(tbKhachHang.getValueAt(index, 1).toString());
        txtHoTenKH.setText(tbKhachHang.getValueAt(index, 2).toString());
        txtSDT.setText(tbKhachHang.getValueAt(index, 5).toString());
        if (tbKhachHang.getValueAt(index, 3).toString().equalsIgnoreCase("Nam")) {
            radioNam.setSelected(true);
        } else if (tbKhachHang.getValueAt(index, 3).toString().equalsIgnoreCase("Nữ")) {
            RadioNu.setSelected(true);
        }
        txtEmail.setText(tbKhachHang.getValueAt(index, 4).toString());
        txtNgayTao.setText(tbKhachHang.getValueAt(index, 7).toString());
        if (tbKhachHang.getValueAt(index, 6).toString().equalsIgnoreCase("Thường")) {
            radioThuong.setSelected(true);
        } else if (tbKhachHang.getValueAt(index, 6).toString().equalsIgnoreCase("VIP")) {
            radioVip.setSelected(true);
        }
    }

    public void reset() {
        this.txtMa.setText("");
        this.txtHoTenKH.setText("");
        this.txtSDT.setText("");
        this.txtMa.setText("");
        this.radioNam.setSelected(true);
        this.txtEmail.setText("");
        this.txtNgayTao.setText("");
        this.radioThuong.setSelected(true);
        this.txtSearch.setText("");
        this.txtSearchDC.setText("");
        this.HienThi(khachhangrp.getAll());
        this.GetListDC(khachhangrp.getAllDC());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel10 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtHoTenKH = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        btnRS = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        lblCapBac = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        radioNam = new javax.swing.JRadioButton();
        RadioNu = new javax.swing.JRadioButton();
        btnThem1 = new javax.swing.JButton();
        txtNgayTao = new javax.swing.JTextField();
        radioThuong = new javax.swing.JRadioButton();
        radioVip = new javax.swing.JRadioButton();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tbKhachHang = new javax.swing.JTable();
        jLabel42 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch4 = new javax.swing.JButton();
        btnSua2 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        lblCapBac5 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblDC = new javax.swing.JTable();
        btnCRUD = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        txtSearchDC = new javax.swing.JTextField();
        btnSearchDC = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Khách Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel29.setText("Họ Tên");

        jLabel33.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel33.setText("Email");

        jLabel37.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel37.setText("Ngày Tạo");

        txtEmail.setForeground(new java.awt.Color(51, 51, 51));
        txtEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(40, 184, 213)));

        txtHoTenKH.setForeground(new java.awt.Color(51, 51, 51));
        txtHoTenKH.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(40, 184, 213)));

        txtSDT.setForeground(new java.awt.Color(51, 51, 51));
        txtSDT.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(40, 184, 213)));

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel38.setText("Số điện thoại");

        btnRS.setBackground(new java.awt.Color(41, 183, 212));
        btnRS.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnRS.setForeground(new java.awt.Color(255, 255, 255));
        btnRS.setText("Reset");
        btnRS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRSActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(0, 204, 204));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel39.setText("Cấp Bậc");

        lblCapBac.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        jLabel40.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel40.setText("Giới Tính");

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel30.setText("Mã");

        txtMa.setForeground(new java.awt.Color(51, 51, 51));
        txtMa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(40, 184, 213)));

        buttonGroup1.add(radioNam);
        radioNam.setText(" Nam");
        radioNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNamActionPerformed(evt);
            }
        });

        buttonGroup1.add(RadioNu);
        RadioNu.setText(" Nữ");

        btnThem1.setBackground(new java.awt.Color(41, 183, 212));
        btnThem1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnThem1.setForeground(new java.awt.Color(255, 255, 255));
        btnThem1.setText("Thêm");
        btnThem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem1ActionPerformed(evt);
            }
        });

        txtNgayTao.setForeground(new java.awt.Color(51, 51, 51));
        txtNgayTao.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(40, 184, 213)));
        txtNgayTao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayTaoActionPerformed(evt);
            }
        });

        buttonGroup2.add(radioThuong);
        radioThuong.setText(" Thường");

        buttonGroup2.add(radioVip);
        radioVip.setText(" VIP");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37)
                            .addComponent(jLabel39)
                            .addComponent(jLabel33)
                            .addComponent(jLabel40)
                            .addComponent(jLabel38)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNgayTao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(radioThuong)
                                        .addGap(18, 18, 18)
                                        .addComponent(radioVip)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCapBac, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtHoTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(radioNam)
                                .addGap(35, 35, 35)
                                .addComponent(RadioNu))))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(btnRS, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnThem1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134)
                        .addComponent(lblCapBac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(txtHoTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(radioNam)
                            .addComponent(RadioNu))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39)
                            .addComponent(radioThuong)
                            .addComponent(radioVip))))
                .addGap(20, 20, 20)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRS, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tbKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mã", "Tên", "Giới Tính", "Email", "SDT", "Cấp Bậc", "INgày Tạo"
            }
        ));
        tbKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKhachHangMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tbKhachHang);

        jLabel42.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel42.setText("Tìm số điện thoại");

        txtSearch.setForeground(new java.awt.Color(51, 51, 51));
        txtSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(40, 184, 213)));
        txtSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSearchCaretUpdate(evt);
            }
        });
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        btnSearch4.setBackground(new java.awt.Color(41, 183, 212));
        btnSearch4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnSearch4.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch4.setText("Search");
        btnSearch4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnSua2.setBackground(new java.awt.Color(41, 183, 212));
        btnSua2.setText("ĐĂNG XUẤT");
        btnSua2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jScrollPane8)
                        .addContainerGap())
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 609, Short.MAX_VALUE)
                        .addComponent(btnSua2)
                        .addGap(41, 41, 41))))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel42)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearch4))
                    .addComponent(btnSua2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Địa Chỉ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

        lblCapBac5.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        tblDC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID ", "ID Khách Hàng", "Tên Khách Hàng", "SDT", "Địa Chỉ", "Thành Phố", "Ngày Tạo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDCMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblDC);

        btnCRUD.setBackground(new java.awt.Color(0, 204, 204));
        btnCRUD.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnCRUD.setForeground(new java.awt.Color(255, 255, 255));
        btnCRUD.setText("+");
        btnCRUD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCRUDActionPerformed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel43.setText("Tìm địa chỉ");

        txtSearchDC.setForeground(new java.awt.Color(51, 51, 51));
        txtSearchDC.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(40, 184, 213)));
        txtSearchDC.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSearchDCCaretUpdate(evt);
            }
        });
        txtSearchDC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchDCActionPerformed(evt);
            }
        });

        btnSearchDC.setBackground(new java.awt.Color(41, 183, 212));
        btnSearchDC.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnSearchDC.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchDC.setText("Search");
        btnSearchDC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchDCbtnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearchDC, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearchDC)
                        .addGap(117, 117, 117)
                        .addComponent(btnCRUD, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCapBac5))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCRUD)
                            .addComponent(jLabel43)
                            .addComponent(txtSearchDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearchDC))
                        .addGap(6, 6, 6))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(lblCapBac5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem1ActionPerformed
        try {
            if (txtMa.getText().isEmpty() && txtHoTenKH.getText().isEmpty()
                    && txtSDT.getText().isEmpty() && txtNgayTao.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Mời nhập đủ thông tin", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
            try {
                String maKhachHang = txtMa.getText();
                if (khachhangrp.MaKHDaTonTai(maKhachHang)) {
                    JOptionPane.showMessageDialog(this, "Mã đã tồn tại", "Lỗi", JOptionPane.WARNING_MESSAGE);
                    txtMa.requestFocus();
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            String email = txtEmail.getText();
            try {
                if (khachhangrp.EmailDaTonTai(email)) {
                    JOptionPane.showMessageDialog(this, "Email đã tồn tại", "Lỗi", JOptionPane.WARNING_MESSAGE);
                    txtEmail.requestFocus();
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                String emailRegex = "^[A-Za-z0-9+_.-]+@gmail.com+$";
                Pattern pattern = Pattern.compile(emailRegex);
                Matcher matcher = pattern.matcher(email);

                if (!matcher.matches()) {
                    JOptionPane.showMessageDialog(this, "Nhập đúng định dạng email");
                    txtEmail.requestFocus();
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            String sdt = txtSDT.getText();
            try {
                String sdtRegex = "^[0-9]{10}+$";
                Pattern pattern = Pattern.compile(sdtRegex);
                Matcher matcher = pattern.matcher(sdt);

                if (!matcher.matches()) {
                    JOptionPane.showMessageDialog(this, "Nhập đúng định dạng SDT");
                    txtSDT.requestFocus();
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (khachhangrp.sdtDaTonTai(sdt)) {
                    JOptionPane.showMessageDialog(this, "SDT đã tồn tại", "Lỗi", JOptionPane.WARNING_MESSAGE);
                    txtSDT.requestFocus();
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Date NS;
                NS = sdf.parse(txtNgayTao.getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "nhập đúng định dạng yyyy-MM-dd");
                txtNgayTao.requestFocus();
                return;
            }
            KhachHang kh = new KhachHang();
            kh.setMaKhachHang(txtMa.getText());
            kh.setTenKhachHang(txtHoTenKH.getText());
            kh.setSDT(txtSDT.getText());
            String gioiTinh = "Nam";
            if (RadioNu.isSelected()) {
                gioiTinh = "Nữ";
            }
            kh.setGioiTinh(gioiTinh);
            kh.setEmail(txtEmail.getText());
            kh.setNgayTao(sdf.parse(txtNgayTao.getText()));
            kh.setDiemTichLuy(radioThuong.isSelected() == true ? 1 : 2);

            if (khachhangrp.add(kh)) {
                JOptionPane.showMessageDialog(this, "Thêm Thành công");
                HienThi(khachhangrp.getAll());
            }
            reset();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Thêm thất bại", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnThem1ActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // Update KhachHang

        try {
            if (txtHoTenKH.getText().isEmpty()
                    && txtSDT.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Mời nhập đủ thông tin", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String email = txtEmail.getText();
            try {
                String emailRegex = "^[A-Za-z0-9+_.-]+@gmail.com+$";
                Pattern pattern = Pattern.compile(emailRegex);
                Matcher matcher = pattern.matcher(email);

                if (!matcher.matches()) {
                    JOptionPane.showMessageDialog(this, "Nhập đúng định dạng email");
                    txtEmail.requestFocus();
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            String sdt = txtSDT.getText();
            try {
                String sdtRegex = "^[0-9]{10}+$";
                Pattern pattern = Pattern.compile(sdtRegex);
                Matcher matcher = pattern.matcher(sdt);

                if (!matcher.matches()) {
                    JOptionPane.showMessageDialog(this, "Nhập đúng định dạng SDT");
                    txtSDT.requestFocus();
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                Date NS;
                NS = sdf.parse(txtNgayTao.getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "nhập đúng định dạng yyyy-MM-dd");
                txtNgayTao.requestFocus();
                return;
            }

            KhachHang kh = new KhachHang();
            kh.setTenKhachHang(txtHoTenKH.getText());
            kh.setSDT(txtSDT.getText());
            String gioiTinh = "Nam";
            if (RadioNu.isSelected()) {
                gioiTinh = "Nữ";
            }
            kh.setGioiTinh(gioiTinh);
            kh.setEmail(txtEmail.getText());
            kh.setNgayTao(sdf.parse(txtNgayTao.getText()));
            kh.setDiemTichLuy(radioThuong.isSelected() == true ? 1 : 2);
            String idKhachHang = txtMa.getText();

            if (khachhangrp.update(idKhachHang, kh)) {
                JOptionPane.showMessageDialog(this, "Cập nhật thành công");
                HienThi(khachhangrp.getAll());
            }
            reset();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnRSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRSActionPerformed
        reset();
    }//GEN-LAST:event_btnRSActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            String sdt = txtSearch.getText();
            // Kiểm tra nếu trường SDT rỗng
            if (sdt.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Mời nhập số điện thoại", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
            // Gọi phương thức Tim để tìm khách hàng
            ArrayList<KhachHang> resultList = khachhangrp.timKiem(sdt);

            // Hiển thị kết quả tìm kiếm
            if (resultList.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng");
            } else {
                DefaultTableModel dtm = (DefaultTableModel) tbKhachHang.getModel();
                dtm.setRowCount(0);
                for (KhachHang kh : resultList) {
                    dtm.addRow(new Object[]{kh.getId(), kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getGioiTinh(),
                        kh.getEmail(), kh.getSDT(), kh.Diem(), kh.getNgayTao()});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi tìm khách hàng", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSearchCaretUpdate
        // Search
    }//GEN-LAST:event_txtSearchCaretUpdate

    private void tbKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKhachHangMouseClicked
        // Click
        int row = tbKhachHang.getSelectedRow();
        loadText(row);
    }//GEN-LAST:event_tbKhachHangMouseClicked

    private void radioNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioNamActionPerformed

    private void txtNgayTaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayTaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayTaoActionPerformed

    private void btnCRUDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCRUDActionPerformed
        Form form = new Form();
        form.setVisible(true);
    }//GEN-LAST:event_btnCRUDActionPerformed

    private void txtSearchDCCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSearchDCCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchDCCaretUpdate

    private void txtSearchDCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchDCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchDCActionPerformed

    private void btnSearchDCbtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchDCbtnSearchActionPerformed
        try {
            String IdKhachHang = txtSearchDC.getText();
            if (IdKhachHang.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Mời nhập ID khách hàng", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
            ArrayList<KhachHangResponse> List = diachirp.timKiem(IdKhachHang);
            if (List.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy địa chỉ khách hàng");
            } else {
                DefaultTableModel dtt = (DefaultTableModel) tblDC.getModel();
                dtt.setRowCount(0);
                for (KhachHangResponse dc : List) {
                    dtt.addRow(new Object[]{dc.getIdDC(), dc.getId(), dc.getTen(), dc.getSdt(), dc.getDiaChi(), dc.getThanhPho(), dc.getNgayTao()});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSearchDCbtnSearchActionPerformed

    private void tblDCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDCMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDCMouseClicked

    private void btnSua2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua2ActionPerformed
        // TODO add your handling code here:
        new Menu().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnSua2ActionPerformed

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
            java.util.logging.Logger.getLogger(PanelKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelKhachHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RadioNu;
    private javax.swing.JButton btnCRUD;
    private javax.swing.JButton btnRS;
    private javax.swing.JButton btnSearch4;
    private javax.swing.JButton btnSearchDC;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnSua2;
    private javax.swing.JButton btnThem1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel lblCapBac;
    private javax.swing.JLabel lblCapBac5;
    private javax.swing.JRadioButton radioNam;
    private javax.swing.JRadioButton radioThuong;
    private javax.swing.JRadioButton radioVip;
    private javax.swing.JTable tbKhachHang;
    private javax.swing.JTable tblDC;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTenKH;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSearchDC;
    // End of variables declaration//GEN-END:variables

}
