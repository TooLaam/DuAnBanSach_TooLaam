/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duan1.Controller;

import com.mycompany.duan1.Bean.DanhMuc;
import com.mycompany.duan1.View.QLHD.createHDJPanel;
import com.mycompany.duan1.View.QLHD.listHDJPanel;
import com.mycompany.duan1.View.QLHD.searchHDJPanel;
import com.mycompany.duan1.View.QLHDJFrame;
import com.mycompany.duan1.View.QLHDJPanel;
import com.mycompany.duan1.View.QLKMJPanel;
import com.mycompany.duan1.View.QLNS.QLNSJPanel;
import com.mycompany.duan1.View.TrangChuJPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class ChuyenManHinhController {

    private JPanel root;
    private String kindSelected = "";
    private List<DanhMuc> listDanhMuc = null;

    public ChuyenManHinhController() {
    }

    public ChuyenManHinhController(JPanel jpnRoot) {
        this.root = jpnRoot;

    }

    // khi ứng dụng bắt đầu chạy màn hình Trang chủ sẽ được chọn
    public void setViewStart(JPanel jpnItem, JLabel jlbItem) {
//        kindSelected = "QLHD";
//        jpnItem.setBackground(new Color(96, 100, 191));
//        jlbItem.setBackground(new Color(96, 100, 191));
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new QLHDJPanel());
        root.validate();
        root.repaint();
    }

    public void setEvent(List<DanhMuc> listDanhMuc) {
        this.listDanhMuc = listDanhMuc;
        for (DanhMuc danhMuc : listDanhMuc) {
            danhMuc.getJlb().addMouseListener(new LabelEvent(danhMuc.getKindWrap(), danhMuc.getKind(), danhMuc.getJpn(), danhMuc.getJlb()));
        }
    }

    class LabelEvent implements MouseListener {

        private JPanel node;//
        private String kind;
        private String kindWrap;
        private JPanel jpnItem;
        private JLabel jlbItem;

//        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
//            this.kind = kind;
//            this.jpnItem = jpnItem;
//            this.jlbItem = jlbItem;
//        }
        public LabelEvent(String kindWrap, String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.kindWrap = kindWrap;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

//       `
        //Được gọi khi nút chuột đã được nhấp (nhấn và nhả) trên một thành phần.
        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kindWrap) {
                case "Main":
                    switch (kind) {
                        case "TrangChu":
                            node = new TrangChuJPanel();
                            break;
                        case "QLKM":
                            node = new QLKMJPanel();
                            break;
                        case "QLHD":
                            node = new QLHDJPanel();
                            break;
                        case "QLNS":
                            node = new QLNSJPanel();
                            break;
                        default:
                            break;
                    }
                    break;
                case "QuanLiHoaDon":
                    switch (kind) {
                        case "create":
                            node = null;
                            System.out.println("aaaaaa");
                            new QLHDJFrame().setVisible(true);
                            break;
                        case "search":
                            node = new searchHDJPanel();
                            break;
                        case "danhsach":
                            node = new listHDJPanel();
                            break;
                        default:
                            node = null;
                            break;
                    }
                
            }

            if (node != null) {
                root.removeAll();
                root.setLayout(new BorderLayout());
                root.add(node);
                root.validate();
                root.repaint();
                setChangeBackground(kind);
            }
        }

        //Mã màu
        // Color(96, 100, 191) màu xanh nước biển đậm
        // Color(75, 175, 80)) màu xanh lá cây
        // Được gọi khi một nút chuột đã được nhấn trên một thành phần.
        @Override
        public void mousePressed(MouseEvent e) {
//            kindSelected = kind;
//            jpnItem.setBackground(new Color(96, 100, 191));//màu xanh nước biển
//            jlbItem.setBackground(new Color(96, 100, 191));

        }

        // Được gọi khi một nút chuột đã được nhả ra trên một thành phần.
        @Override
        public void mouseReleased(MouseEvent e) {
//            jpnItem.setBackground(new Color(75, 175, 80));
//            jlbItem.setBackground(new Color(75, 175, 80));//xanh lá cây
        }

        // Được gọi khi di chuột vào một thành phần( như là hover)
        @Override
        public void mouseEntered(MouseEvent e) {
//            jpnItem.setBackground(new Color(96, 100, 191));
//            jlbItem.setBackground(new Color(96, 100, 191));
        }

        // Được gọi khi chuột thoát khỏi một thành phần.
        @Override
        public void mouseExited(MouseEvent e) {
//            if (kindSelected.equalsIgnoreCase(kind)) {
//                jpnItem.setBackground(new Color(75, 175, 80));
//                jlbItem.setBackground(new Color(75, 175, 80));
//            }
        }

    }

    private void setChangeBackground(String kind) {
        for (DanhMuc danhMuc : listDanhMuc) {
            if (danhMuc.getKind().equalsIgnoreCase(kind)) {
                danhMuc.getJpn().setBackground(new Color(96, 100, 191));
                danhMuc.getJlb().setBackground(new Color(96, 100, 191));
            } else {
                danhMuc.getJpn().setBackground(new Color(76, 175, 80));
                danhMuc.getJlb().setBackground(new Color(76, 175, 80));
            }
        }
    }
}
