/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package khachHang.implement;

import java.util.ArrayList;
import khachHang.model.DiaChi;
import khachHang.model.KhachHangResponse;
import khachHang.repository.DiaChiRepository;
import khachHang.service.DiaChiInterface;

/**
 *
 * @author ASUS
 */
public class DiaChiImplement implements DiaChiInterface {

    private DiaChiRepository DiaChiRP = new DiaChiRepository();

    @Override
    public Boolean add(DiaChi diaChi) {
        return DiaChiRP.addNew(diaChi);
    }

    @Override
    public Boolean update(String id, DiaChi diachi) {
        return DiaChiRP.updateNew(id, diachi);
    }

    @Override
    public ArrayList<KhachHangResponse> timKiem(String IdKhachHang) {
        return DiaChiRP.Tim(IdKhachHang);
    }

    @Override
    public boolean Delete(String id) {
        return DiaChiRP.DeleteNew(id);
    }

    @Override
    public boolean KhachHangChuaTonTai(String id) {
        return DiaChiRP.KhachHangChuaTonTai(id);
    }

}
