/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duan1.Bean;

/**
 *
 * @author Admin
 */
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QrCodePanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private BufferedImage qrCodeImage;

    public QrCodePanel() {
        String receiverName = "Tran Tuan Linh"; // Tên người nhận
        String receiverAccount = "0011004377344"; // Số tài khoản người nhận
        String receiverBank = "VIETCOMBANK"; // Tên ngân hàng người nhận
        double amount = 1000000; // Số tiền chuyển khoản
        String content = "Chuyen khoan"; // Nội dung chuyển khoản

        String qrCodeText = "ST25:" + receiverAccount + "|Name:" + receiverName + "|Bank:" + receiverBank + "|Amount:" + amount + "|Content:" + content;

        int size = 250; // Kích thước của mã QR
        try {
            // Sử dụng QRCodeWriter để tạo mã QR
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(qrCodeText, BarcodeFormat.QR_CODE, size, size);

            // Chuyển BitMatrix thành BufferedImage
            qrCodeImage = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
            qrCodeImage.createGraphics();
            Graphics graphics = qrCodeImage.getGraphics();
            graphics.setColor(java.awt.Color.WHITE);
            graphics.fillRect(0, 0, size, size);
            graphics.setColor(java.awt.Color.BLACK);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (bitMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }
        } catch (WriterException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(qrCodeImage, 0, 0, null); // Vẽ mã QR lên panel
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new QrCodePanel());
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
