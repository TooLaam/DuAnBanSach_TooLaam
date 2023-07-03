/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package khachHang.service;

import java.util.ArrayList;
import khachHang.model.KhachHang;
import khachHang.model.KhachHangResponse;

/**
 *
 * @author ASUS
 */
public interface KhachHangService {


    public ArrayList<KhachHang> getAll();

    public Boolean add(KhachHang khachHang);

    public Boolean update(String maKhachHang, KhachHang kh);

    public ArrayList<KhachHang> timKiem(String SDT);
    
    public boolean MaKHDaTonTai(String maKhachHang);
    
    public boolean EmailDaTonTai(String Email);

    public boolean sdtDaTonTai(String sdt);
    
    public ArrayList<KhachHangResponse> getAllDC();





}
