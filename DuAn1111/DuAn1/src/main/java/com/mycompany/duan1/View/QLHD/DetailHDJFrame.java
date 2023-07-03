/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.duan1.View.QLHD;

import com.mycompany.duan1.Entity.CTSach;
import com.mycompany.duan1.Entity.CapBac;
import com.mycompany.duan1.Entity.CartItem;
import com.mycompany.duan1.Entity.HoaDon;
import com.mycompany.duan1.Entity.HoaDonChiTiet;
import com.mycompany.duan1.Entity.KhachHang;
import com.mycompany.duan1.Entity.LichSuCapNhatTrangThai;
import com.mycompany.duan1.Entity.NhanVien;
import com.mycompany.duan1.Entity.PhieuGiaoHang;
import com.mycompany.duan1.Entity.ThongTinChiTiet;
import com.mycompany.duan1.Service.CTSachService;
import com.mycompany.duan1.Service.ChiTietHoaDonService;
import com.mycompany.duan1.Service.HoaDonService;
import com.mycompany.duan1.Service.Impl.CTSachServiceImpl;
import com.mycompany.duan1.Service.Impl.ChiTietHoaDonServiceImpl;
import com.mycompany.duan1.Service.Impl.HoaDonServiceImpl;
import com.mycompany.duan1.Service.Impl.KhachHangServiceImpl;
import com.mycompany.duan1.Service.Impl.LichSuCapNhatTrangThaiServiceImpl;
import com.mycompany.duan1.Service.Impl.PhieuGiaoHangServiceImpl;
import com.mycompany.duan1.Service.Impl.ThongTinChiTietServiceImpl;
import com.mycompany.duan1.Service.KhachHangService;
import com.mycompany.duan1.Service.LichSuCapNhatTrangThaiService;
import com.mycompany.duan1.Service.PhieuGiaoHangService;
import com.mycompany.duan1.Service.ThongTinChiTietService;
import com.mycompany.duan1.Storage.SessionStorage;
import java.awt.BorderLayout;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.springframework.beans.BeanUtils;

/**
 *
 * @author Admin
 */
public class DetailHDJFrame extends javax.swing.JFrame {

    private final HoaDonService hoadonservice = new HoaDonServiceImpl();

    private final KhachHangService khachhangservice = new KhachHangServiceImpl();

    private final PhieuGiaoHangService phieugiaohangservice = new PhieuGiaoHangServiceImpl();
    private final ThongTinChiTietService thongtinchitietservice = new ThongTinChiTietServiceImpl();
    private ChiTietHoaDonService chitiethoaddon = new ChiTietHoaDonServiceImpl();
    private LichSuCapNhatTrangThaiService lichSuCapNhatTrangThaiService = new LichSuCapNhatTrangThaiServiceImpl();
    private CTSachService ctsService = new CTSachServiceImpl();

    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm dd/MM/yyyy");

    private long idHD;

    public DetailHDJFrame() {

    }

    public DetailHDJFrame(Long idHD) {
        this.idHD = idHD;
        initComponents();
        setLocationRelativeTo(null);

        //Thực hiện truy ván dữ liệu
        Optional<List<PhieuGiaoHang>> l1stPHGopt = phieugiaohangservice.findByHoaDonID(idHD);
        HoaDon hoadon = hoadonservice.findByID(idHD);

        //SET VIEW
        txtIdHD.setText(String.valueOf(hoadon.getId()));
        // Set MÃ hoá đơn
        txtMaHD.setText(hoadon.getMa());

        // THÔNG TIN KH
        Long idKH = hoadon.getKhachhangHD().getId();
        Optional<KhachHang> khachhang = khachhangservice.findByID(idKH);
        CapBac capbac = new CapBac();
        if (khachhang.isPresent()) {
            //set txtKH
            txtKH.setText(khachhang.get().getTen());
            BeanUtils.copyProperties(khachhang.get().getCapbac(), capbac);
            //Set Địa chỉ chi tiết
            List<ThongTinChiTiet> ttct = khachhang.get().getCtkh();
            for (ThongTinChiTiet item : ttct) {
                if (item.getIs_primary() == 1) {
                    txtSDT.setText(item.getSDT());
                    txtDC.setText(item.getDiaChi());
                    txtThanhPhos.setText(item.getThanhPho());
                }
            }

        }
        txtNhanVien.setText(String.valueOf(hoadon.getNhanvienHD().getTen()));

        //setTrang thai
        txtTrangThai.setText(hoadon.getTthd().getTen());

        //set txtKM
        Double phamtramKM = null;
        if (hoadon.getDotkhuyenmai() == null) {
            txtKM.setText("Không");
            phamtramKM = 0.0;
        }
        if (hoadon.getDotkhuyenmai() != null) {
            txtKM.setText(hoadon.getDotkhuyenmai().getTen());
            phamtramKM = hoadon.getDotkhuyenmai().getPhanTramKM();
        }

        //set txtPhanTramGiamGia
        Double tongphantramduocgiamgia = phamtramKM + capbac.getMucGiam();
        txtPhanTramGiamGia.setText(String.valueOf(tongphantramduocgiamgia));

        // set txtSoTienGiamGia
        Double tongtienhd = hoadon.getTongTien().doubleValue();
        Double sotienduocgiam = tongtienhd * 100 / (100 - tongphantramduocgiamgia) - tongtienhd;
        txtSoTienGiamGia.setText(String.valueOf(sotienduocgiam));

        //set txtCapBac
        txtCapBac.setText(capbac.getTen());

        // Set HTTT
        if (hoadon.getHinhthucthanhtoan() == null) {
            txtHinhThucThanhToan.setText("Không");

        }
        if (hoadon.getHinhthucthanhtoan() != null) {
            txtHinhThucThanhToan.setText(hoadon.getHinhthucthanhtoan().getTenHinhThucThanhToan());

        }

        //Set Tổng tiền
        txtTotal.setText(String.valueOf(hoadon.getTongTien()));

        // SET Bảng sản phẩm đã chọn 
        loadToTableSanPhamDaChon(idHD);

        String formattedDate = dateFormat.format(hoadon.getNgayTao());
        txtNgayTao.setText(formattedDate);
//
        //Set bảng Phiếu Giao hàng
        if (l1stPHGopt.isPresent()) {
            loadDataToPGHTable(l1stPHGopt.get());
        }

        //set jpnChucNangHoaDon
        if (hoadon.getTthd().getTen().equals("Khởi tạo")) {
            jpnChuongTrinhHoaDon.removeAll();
            jpnChuongTrinhHoaDon.setLayout(new BorderLayout());
            jpnChuongTrinhHoaDon.add(jpnThanhToan);
            jpnChuongTrinhHoaDon.validate();
            jpnChuongTrinhHoaDon.repaint();
        }
        if (hoadon.getTthd().getTen().equals("Đã thanh toán")) {
            jpnChuongTrinhHoaDon.removeAll();
            jpnChuongTrinhHoaDon.setLayout(new BorderLayout());
            jpnChuongTrinhHoaDon.add(jpnDaThanhToan);
            jpnChuongTrinhHoaDon.validate();
            jpnChuongTrinhHoaDon.repaint();
        }

        //SET Jpanel chức năng PhieuGiaHang
        if (l1stPHGopt.isPresent()) {
            if (!l1stPHGopt.get().isEmpty()) {
                // Thực hiện xử lý chỉ khi danh sách không rỗng
                txtMaPGH.setText(String.valueOf(l1stPHGopt.get().get(l1stPHGopt.get().size() - 1).getId()));
                switch (l1stPHGopt.get().get(l1stPHGopt.get().size() - 1).getTrangthaiPGH().getName()) {
                    case "Khởi tạo":
                        jpnChuongTrinhHoaDon.removeAll();
                        jpnChuongTrinhPGH.removeAll();
                        jpnChuongTrinhPGH.setLayout(new BorderLayout());
                        jpnChuongTrinhPGH.add(jpnDongGoi);
                        jpnChuongTrinhPGH.validate();
                        jpnChuongTrinhPGH.repaint();
                        break;
                    case "Đóng gói":
                        jpnChuongTrinhHoaDon.removeAll();
                        jpnChuongTrinhPGH.removeAll();
                        jpnChuongTrinhPGH.setLayout(new BorderLayout());
                        jpnChuongTrinhPGH.add(jpnXuatKho);
                        jpnChuongTrinhPGH.validate();
                        jpnChuongTrinhPGH.repaint();
                        break;
                    case "Xuất kho":
                        jpnChuongTrinhHoaDon.removeAll();
                        jpnChuongTrinhPGH.removeAll();
                        jpnChuongTrinhPGH.setLayout(new BorderLayout());
                        jpnChuongTrinhPGH.add(jpnHoanThanh);
                        jpnChuongTrinhPGH.validate();
                        jpnChuongTrinhPGH.repaint();
                        break;
                    default:
                        jpnChuongTrinhPGH.removeAll();
                        jpnChuongTrinhPGH.setLayout(new BorderLayout());
                        jpnChuongTrinhPGH.add(jpnKhoiTao);
                        jpnChuongTrinhPGH.validate();
                        jpnChuongTrinhPGH.repaint();
                        break;
                }
            } else {
                jpnChuongTrinhPGH.removeAll();
                jpnChuongTrinhPGH.setLayout(new BorderLayout());
                jpnChuongTrinhPGH.add(jpnKhoiTao);
                jpnChuongTrinhPGH.validate();
                jpnChuongTrinhPGH.repaint();

            }

        }

        if (hoadon.getTthd().getTen().equals("Hoàn thành") || hoadon.getTthd().getTen().equals("Huỷ")) {
            jpnChuongTrinhPGH.removeAll();
            jpnChuongTrinhHoaDon.removeAll();

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

        jpnKhoiTao = new javax.swing.JPanel();
        btnTaoPGH = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        jpnDongGoi = new javax.swing.JPanel();
        btnDongGoi = new javax.swing.JButton();
        btnHuyPGH = new javax.swing.JButton();
        jpnXuatKho = new javax.swing.JPanel();
        btnXuatKho = new javax.swing.JButton();
        btnHuyDongGoi = new javax.swing.JButton();
        txtMaPGH = new javax.swing.JTextField();
        txtIdHD = new javax.swing.JTextField();
        jpnHoanThanh = new javax.swing.JPanel();
        btnHoanThanh = new javax.swing.JButton();
        jpnDaThanhToan = new javax.swing.JPanel();
        btnHoanThanhDTT = new javax.swing.JButton();
        jpnThanhToan = new javax.swing.JPanel();
        btnThanhToan = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        txtDC = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtThanhPhos = new javax.swing.JTextField();
        txtKH = new javax.swing.JTextField();
        txtMaHD = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTrangThai = new javax.swing.JTextField();
        txtNhanVien = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSSP = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtHinhThucThanhToan = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPGH = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtNgayTao = new javax.swing.JTextField();
        txtKM = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCapBac = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtPhanTramGiamGia = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtSoTienGiamGia = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jpnChuongTrinhPGH = new javax.swing.JPanel();
        jpnChuongTrinhHoaDon = new javax.swing.JPanel();

        btnTaoPGH.setText("Tạo PGH");
        btnTaoPGH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoPGHActionPerformed(evt);
            }
        });

        btnHuy.setText("Huỷ hoá đơn");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnKhoiTaoLayout = new javax.swing.GroupLayout(jpnKhoiTao);
        jpnKhoiTao.setLayout(jpnKhoiTaoLayout);
        jpnKhoiTaoLayout.setHorizontalGroup(
            jpnKhoiTaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnKhoiTaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTaoPGH)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(btnHuy)
                .addContainerGap())
        );
        jpnKhoiTaoLayout.setVerticalGroup(
            jpnKhoiTaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnKhoiTaoLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jpnKhoiTaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTaoPGH)
                    .addComponent(btnHuy))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        btnDongGoi.setText("Đóng gói");
        btnDongGoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongGoiActionPerformed(evt);
            }
        });

        btnHuyPGH.setText("Huỷ PGH");
        btnHuyPGH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyPGHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnDongGoiLayout = new javax.swing.GroupLayout(jpnDongGoi);
        jpnDongGoi.setLayout(jpnDongGoiLayout);
        jpnDongGoiLayout.setHorizontalGroup(
            jpnDongGoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDongGoiLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(btnDongGoi)
                .addGap(18, 18, 18)
                .addComponent(btnHuyPGH)
                .addGap(12, 12, 12))
        );
        jpnDongGoiLayout.setVerticalGroup(
            jpnDongGoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDongGoiLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jpnDongGoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDongGoi)
                    .addComponent(btnHuyPGH))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        btnXuatKho.setText("Xuất Kho");
        btnXuatKho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatKhoActionPerformed(evt);
            }
        });

        btnHuyDongGoi.setText("Huỷ đóng gói");
        btnHuyDongGoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyDongGoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnXuatKhoLayout = new javax.swing.GroupLayout(jpnXuatKho);
        jpnXuatKho.setLayout(jpnXuatKhoLayout);
        jpnXuatKhoLayout.setHorizontalGroup(
            jpnXuatKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnXuatKhoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnXuatKho, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHuyDongGoi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnXuatKhoLayout.setVerticalGroup(
            jpnXuatKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnXuatKhoLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jpnXuatKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXuatKho)
                    .addComponent(btnHuyDongGoi))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        txtMaPGH.setText("jTextField1");

        btnHoanThanh.setText("Hoàn thành");
        btnHoanThanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoanThanhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnHoanThanhLayout = new javax.swing.GroupLayout(jpnHoanThanh);
        jpnHoanThanh.setLayout(jpnHoanThanhLayout);
        jpnHoanThanhLayout.setHorizontalGroup(
            jpnHoanThanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnHoanThanhLayout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(btnHoanThanh)
                .addGap(52, 52, 52))
        );
        jpnHoanThanhLayout.setVerticalGroup(
            jpnHoanThanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHoanThanhLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnHoanThanh)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        btnHoanThanhDTT.setText("Hoàn Thành");
        btnHoanThanhDTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoanThanhDTTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnDaThanhToanLayout = new javax.swing.GroupLayout(jpnDaThanhToan);
        jpnDaThanhToan.setLayout(jpnDaThanhToanLayout);
        jpnDaThanhToanLayout.setHorizontalGroup(
            jpnDaThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDaThanhToanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHoanThanhDTT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnDaThanhToanLayout.setVerticalGroup(
            jpnDaThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDaThanhToanLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(btnHoanThanhDTT)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnThanhToanLayout = new javax.swing.GroupLayout(jpnThanhToan);
        jpnThanhToan.setLayout(jpnThanhToanLayout);
        jpnThanhToanLayout.setHorizontalGroup(
            jpnThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnThanhToanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnThanhToanLayout.setVerticalGroup(
            jpnThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnThanhToanLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnThanhToan)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 64)); // NOI18N
        jLabel1.setText("Hoá Đơn");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Mã hoá đơn:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Khách hàng:");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 255, 255)));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("SĐT:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Địa chỉ:");

        txtSDT.setEditable(false);
        txtSDT.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txtDC.setEditable(false);
        txtDC.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel17.setText("Thành phố :");

        txtThanhPhos.setEditable(false);
        txtThanhPhos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThanhPhosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtDC, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtThanhPhos, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(txtThanhPhos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        txtKH.setEditable(false);
        txtKH.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtKH.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtMaHD.setEditable(false);
        txtMaHD.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtMaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaHDActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel8.setText("Trạng thái:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel9.setText("Nhân viên:");

        txtTrangThai.setEditable(false);
        txtTrangThai.setBackground(new java.awt.Color(255, 255, 255));
        txtTrangThai.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtTrangThai.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtNhanVien.setEditable(false);
        txtNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        txtNhanVien.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtNhanVien.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNhanVienActionPerformed(evt);
            }
        });

        tblDSSP.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tblDSSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Sản phẩm", "Giá tiền", "Số lượng", "Thành Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDSSP);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Chương trình KM :");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("Hình thức thanh toán:");

        txtHinhThucThanhToan.setEditable(false);
        txtHinhThucThanhToan.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Tổng :");

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(255, 255, 255));
        txtTotal.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotal.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        tblPGH.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tblPGH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "PGH", "Ngày tạo", "Tiền cước", "Trạng thái", "Ghi chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPGH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPGHMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblPGH);
        if (tblPGH.getColumnModel().getColumnCount() > 0) {
            tblPGH.getColumnModel().getColumn(0).setPreferredWidth(25);
            tblPGH.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel12.setText("Thông tin phiếu giao hàng:");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setText("Ngày tạo:");

        txtNgayTao.setEditable(false);
        txtNgayTao.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Cấp bậc :");

        txtCapBac.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtCapBac.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCapBac.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel14.setText("Tổng % được giảm giá :");

        txtPhanTramGiamGia.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtPhanTramGiamGia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPhanTramGiamGia.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtPhanTramGiamGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhanTramGiamGiaActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel15.setText("Số tiền được giảm :");

        txtSoTienGiamGia.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtSoTienGiamGia.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("%");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtKH))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 203, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                    .addComponent(txtTrangThai)))
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCapBac, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14)
                                .addGap(204, 204, 204)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtPhanTramGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtKM, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel13))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                            .addComponent(txtHinhThucThanhToan))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                    .addComponent(txtSoTienGiamGia))))
                        .addGap(39, 39, 39))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtCapBac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtPhanTramGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtHinhThucThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtSoTienGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)))
                .addGap(20, 20, 20)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jpnChuongTrinhPGH.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jpnChuongTrinhPGHLayout = new javax.swing.GroupLayout(jpnChuongTrinhPGH);
        jpnChuongTrinhPGH.setLayout(jpnChuongTrinhPGHLayout);
        jpnChuongTrinhPGHLayout.setHorizontalGroup(
            jpnChuongTrinhPGHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jpnChuongTrinhPGHLayout.setVerticalGroup(
            jpnChuongTrinhPGHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 74, Short.MAX_VALUE)
        );

        jpnChuongTrinhHoaDon.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jpnChuongTrinhHoaDonLayout = new javax.swing.GroupLayout(jpnChuongTrinhHoaDon);
        jpnChuongTrinhHoaDon.setLayout(jpnChuongTrinhHoaDonLayout);
        jpnChuongTrinhHoaDonLayout.setHorizontalGroup(
            jpnChuongTrinhHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        jpnChuongTrinhHoaDonLayout.setVerticalGroup(
            jpnChuongTrinhHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 74, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpnChuongTrinhHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnChuongTrinhPGH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jpnChuongTrinhPGH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jpnChuongTrinhHoaDon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNhanVienActionPerformed

    private void btnTaoPGHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoPGHActionPerformed
        PGH pgh = new PGH(this);
        pgh.txtIdHD.setText(txtIdHD.getText());
        pgh.txtMHD.setText(txtMaHD.getText());
        pgh.txtKH.setText(txtKH.getText());
        pgh.txtSDT.setText(txtSDT.getText());
        pgh.txtDC.setText(txtDC.getText());
        pgh.txtThanhPho.setText(txtThanhPhos.getText());

        pgh.setVisible(true);
    }//GEN-LAST:event_btnTaoPGHActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void btnDongGoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongGoiActionPerformed
        Long idHD = Long.valueOf(txtIdHD.getText());
        Optional<PhieuGiaoHang> pgh = phieugiaohangservice.findPGHByHDAndNewest(idHD);
        phieugiaohangservice.setTrangThai(Long.valueOf("3"), pgh.get().getId());
        NhanVien nv = SessionStorage.getLoggedInNhanVien();
        try {
            Date ngayCapNhat = new Date();
            Timestamp ngayCapNhatTimeStamp = new Timestamp(ngayCapNhat.getTime());
            LichSuCapNhatTrangThai lscntt = new LichSuCapNhatTrangThai(0, ngayCapNhatTimeStamp, "Đóng gói", pgh.get(), nv);
            lichSuCapNhatTrangThaiService.save(lscntt);
        } catch (Exception e) {
        }

        new DetailHDJFrame(idHD).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDongGoiActionPerformed

    private void btnHuyPGHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyPGHActionPerformed
        Long idPHGcurrent = Long.valueOf(txtMaPGH.getText());

        phieugiaohangservice.setTrangThai(Long.valueOf("1"), idPHGcurrent);
        NhanVien nv = SessionStorage.getLoggedInNhanVien();
        Long idHD = Long.valueOf(txtIdHD.getText());
        try {

            Optional<PhieuGiaoHang> pgh = phieugiaohangservice.findPGHByHDAndNewest(idHD);
            Date ngayCapNhat = new Date();
            Timestamp ngayCapNhatTimeStamp = new Timestamp(ngayCapNhat.getTime());
            LichSuCapNhatTrangThai lscntt = new LichSuCapNhatTrangThai(0, ngayCapNhatTimeStamp, "Huỷ Phiếu giao hàng", pgh.get(), nv);
            lichSuCapNhatTrangThaiService.save(lscntt);
        } catch (Exception e) {
        }
        System.out.println("mãPhieuGIoahang" + idPHGcurrent);
        Optional<List<PhieuGiaoHang>> l1stPHGopt = phieugiaohangservice.findByHoaDonID(idHD);
        loadDataToPGHTable(l1stPHGopt.get());

        HoaDon hd = hoadonservice.findByID(idHD);

        if (hd.getHinhthucthanhtoan() == null) {
            jpnChuongTrinhHoaDon.removeAll();
            jpnChuongTrinhHoaDon.setLayout(new BorderLayout());
            jpnChuongTrinhHoaDon.add(jpnThanhToan);
            jpnChuongTrinhHoaDon.revalidate();
            jpnChuongTrinhHoaDon.repaint();
        }
        if (hd.getHinhthucthanhtoan() != null) {
            jpnChuongTrinhHoaDon.removeAll();
            jpnChuongTrinhHoaDon.setLayout(new BorderLayout());
            jpnChuongTrinhHoaDon.add(jpnDaThanhToan);
            jpnChuongTrinhHoaDon.revalidate();
            jpnChuongTrinhHoaDon.repaint();
        }

        jpnChuongTrinhPGH.removeAll();
        jpnChuongTrinhPGH.setLayout(new BorderLayout());
        jpnChuongTrinhPGH.add(jpnKhoiTao);
        jpnChuongTrinhPGH.validate();
        jpnChuongTrinhPGH.repaint();


    }//GEN-LAST:event_btnHuyPGHActionPerformed

    private void tblPGHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPGHMouseClicked
        int index = tblPGH.getSelectedRow();
        long idPGH = (long) tblPGH.getValueAt(index, 0);
        new PGHChiTietJrame(idPGH).setVisible(true);
    }//GEN-LAST:event_tblPGHMouseClicked

    private void txtMaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaHDActionPerformed

    private void btnXuatKhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatKhoActionPerformed
        Long idHD = Long.valueOf(txtIdHD.getText());
        Optional<PhieuGiaoHang> pgh = phieugiaohangservice.findPGHByHDAndNewest(idHD);
        phieugiaohangservice.setTrangThai(Long.valueOf("4"), pgh.get().getId());
        NhanVien nv = SessionStorage.getLoggedInNhanVien();
        try {
            Date ngayCapNhat = new Date();
            Timestamp ngayCapNhatTimeStamp = new Timestamp(ngayCapNhat.getTime());
            LichSuCapNhatTrangThai lscntt = new LichSuCapNhatTrangThai(0, ngayCapNhatTimeStamp, "Xuất Kho", pgh.get(), nv);
            lichSuCapNhatTrangThaiService.save(lscntt);
        } catch (Exception e) {
        }
        System.out.println(pgh.get().getId());
        new DetailHDJFrame(idHD).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnXuatKhoActionPerformed

    private void btnHuyDongGoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyDongGoiActionPerformed
        Long idHD = Long.valueOf(txtIdHD.getText());
        Optional<PhieuGiaoHang> pgh = phieugiaohangservice.findPGHByHDAndNewest(idHD);
        phieugiaohangservice.setTrangThai(Long.valueOf("2"), pgh.get().getId());
        NhanVien nv = SessionStorage.getLoggedInNhanVien();
        try {
            Date ngayCapNhat = new Date();
            Timestamp ngayCapNhatTimeStamp = new Timestamp(ngayCapNhat.getTime());
            LichSuCapNhatTrangThai lscntt = new LichSuCapNhatTrangThai(0, ngayCapNhatTimeStamp, "Huỷ đóng gói", pgh.get(), nv);
            lichSuCapNhatTrangThaiService.save(lscntt);
        } catch (Exception e) {
        }

        System.out.println(pgh.get().getId());
        new DetailHDJFrame(idHD).setVisible(true);
        this.dispose();


    }//GEN-LAST:event_btnHuyDongGoiActionPerformed

    private void btnHoanThanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoanThanhActionPerformed
        Long idHD = Long.valueOf(txtIdHD.getText());
        Optional<PhieuGiaoHang> pgh = phieugiaohangservice.findPGHByHDAndNewest(idHD);
        phieugiaohangservice.setTrangThai(Long.valueOf("5"), pgh.get().getId());
        hoadonservice.updateTrangThaiHD(idHD, Long.valueOf("4"));
        NhanVien nv = SessionStorage.getLoggedInNhanVien();
        try {
            Date ngayCapNhat = new Date();
            Timestamp ngayCapNhatTimeStamp = new Timestamp(ngayCapNhat.getTime());
            LichSuCapNhatTrangThai lscntt = new LichSuCapNhatTrangThai(0, ngayCapNhatTimeStamp, "Hoàn thành", pgh.get(), nv);
            lichSuCapNhatTrangThaiService.save(lscntt);
        } catch (Exception e) {
        }
        System.out.println(pgh.get().getId());
        new DetailHDJFrame(idHD).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHoanThanhActionPerformed

    private void txtPhanTramGiamGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhanTramGiamGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhanTramGiamGiaActionPerformed

    private void txtThanhPhosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThanhPhosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtThanhPhosActionPerformed

    private void btnHoanThanhDTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoanThanhDTTActionPerformed
        idHD = Long.parseLong(txtIdHD.getText());
        hoadonservice.updateTrangThaiHD(idHD, Long.valueOf("4"));
        new DetailHDJFrame(idHD).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHoanThanhDTTActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        idHD = Long.parseLong(txtIdHD.getText());
        System.out.println("Mã HĐ là:" + idHD);
        hoadonservice.updateTrangThaiHD(idHD, Long.valueOf("1"));

        Optional<List<HoaDonChiTiet>> OTP = chitiethoaddon.findByIDHD(idHD);
        CTSach cts;
        List<HoaDonChiTiet> listHoaDonChiTiet = new ArrayList<>();
        if (OTP.isPresent()) {
            listHoaDonChiTiet = OTP.get();
        }
        for (HoaDonChiTiet item : listHoaDonChiTiet) {
            Long idCTS = item.getCtsach().getIdCTSach();
            cts = ctsService.findById(idCTS);
            int soLuongSachHienCoTrongDB = cts.getSoLuong();
            int soLuongSachSauKhiHuyHoaDOn = soLuongSachHienCoTrongDB + item.getSoLuong();
            ctsService.updateSoLuongCTSach(idCTS, soLuongSachSauKhiHuyHoaDOn);
        }
        new DetailHDJFrame(idHD).setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        new ChonHinhThucThanhToanJFrame(this).setVisible(true);
    }//GEN-LAST:event_btnThanhToanActionPerformed

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
            java.util.logging.Logger.getLogger(DetailHDJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetailHDJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetailHDJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetailHDJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetailHDJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDongGoi;
    private javax.swing.JButton btnHoanThanh;
    private javax.swing.JButton btnHoanThanhDTT;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnHuyDongGoi;
    private javax.swing.JButton btnHuyPGH;
    private javax.swing.JButton btnTaoPGH;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnXuatKho;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JPanel jpnChuongTrinhHoaDon;
    private javax.swing.JPanel jpnChuongTrinhPGH;
    public javax.swing.JPanel jpnDaThanhToan;
    private javax.swing.JPanel jpnDongGoi;
    private javax.swing.JPanel jpnHoanThanh;
    private javax.swing.JPanel jpnKhoiTao;
    private javax.swing.JPanel jpnThanhToan;
    private javax.swing.JPanel jpnXuatKho;
    private javax.swing.JTable tblDSSP;
    private javax.swing.JTable tblPGH;
    private javax.swing.JTextField txtCapBac;
    private javax.swing.JTextField txtDC;
    private javax.swing.JTextField txtHinhThucThanhToan;
    public javax.swing.JTextField txtIdHD;
    private javax.swing.JTextField txtKH;
    public javax.swing.JTextField txtKM;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaPGH;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtNhanVien;
    private javax.swing.JTextField txtPhanTramGiamGia;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSoTienGiamGia;
    private javax.swing.JTextField txtThanhPhos;
    public javax.swing.JTextField txtTotal;
    public javax.swing.JTextField txtTrangThai;
    // End of variables declaration//GEN-END:variables

    public void loadDataToPGHTable(List<PhieuGiaoHang> listPGH) {
        DefaultTableModel dtm = (DefaultTableModel) tblPGH.getModel();
        dtm.setRowCount(0);
        for (PhieuGiaoHang PGH : listPGH) {
            dateFormat = new SimpleDateFormat("HH:mm dd/MM/yyyy");
            String formattedCreatedDate = dateFormat.format(PGH.getNgayTaoPhieu());
            dtm.addRow(new Object[]{PGH.getId(), formattedCreatedDate, PGH.getTienCuoc(), PGH.getTrangthaiPGH().getName(), PGH.getGhiChu()});
        }
    }

    private void loadToTableSanPhamDaChon(Long idHD) {
        DefaultTableModel dtm = (DefaultTableModel) tblDSSP.getModel();
        dtm.setRowCount(0);
        Optional<List<HoaDonChiTiet>> OTP = chitiethoaddon.findByIDHD(idHD);
        List<CartItem> listCartItem = new ArrayList<>();
        for (HoaDonChiTiet item : OTP.get()) {
            String tenSach = item.getCtsach().getSach().getTen();
            Long idCTSach = item.getCtsach().getIdCTSach();
            CartItem cartitem = new CartItem(idCTSach, tenSach, item.getSoLuong(), item.getCtsach().getGiaBan());
            listCartItem.add(cartitem);
        }
        for (CartItem item : listCartItem) {
            BigDecimal thanhtien = item.getDonGia().multiply(new BigDecimal(item.getSoLuong()));
            dtm.addRow(new Object[]{item.getId(), item.getName(), item.getDonGia(), item.getSoLuong(), thanhtien});
        }
    }
}
