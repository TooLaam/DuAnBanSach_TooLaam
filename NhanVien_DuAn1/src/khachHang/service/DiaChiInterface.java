/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package khachHang.service;

import java.util.ArrayList;
import khachHang.model.DiaChi;
import khachHang.model.KhachHangResponse;

/**
 *
 * @author ASUS
 */
public interface DiaChiInterface {


    public Boolean add(DiaChi diaChi);

    public Boolean update(String id, DiaChi diachi);

    public ArrayList<KhachHangResponse> timKiem(String IdKhachHang);
        
    public boolean Delete(String id);
    
    public boolean KhachHangChuaTonTai(String id);
    
}
