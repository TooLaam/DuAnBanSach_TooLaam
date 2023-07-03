/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NhanVien.Service;

import java.awt.Button;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;

/**
 *
 * @author concu
 */
public class ClockService extends Thread {

    private JButton button;

    public ClockService(JButton button) {
        this.button = button;
    }

    @Override
    public void run() {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss aa");
        
        
        
        while (true) {
            Date now = new Date();

            String st = sdf.format(now);
            button.setText(st);

            try {
                Thread.sleep(1000);
            } catch (Exception ex) {
                break;
            }

        }

    }

}
