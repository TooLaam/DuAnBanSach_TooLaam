package khachHang.implement;

import java.util.ArrayList;
import khachHang.model.KhachHang;
import khachHang.model.KhachHangResponse;
import khachHang.repository.KhachHangRepository;
import khachHang.service.KhachHangService;

/**
 *
 * @author ASUS
 */
public class KhachHangImplement implements khachHang.service.KhachHangService {

    private KhachHangRepository KHRepo = new KhachHangRepository();

    @Override
    public ArrayList<KhachHang> getAll() {
        return KHRepo.getListKhachHang();
    }

    @Override
    public Boolean add(KhachHang khachHang) {

        return KHRepo.addNew(khachHang);
    }

    @Override
    public Boolean update(String maKhachHang, KhachHang kh) {
        return KHRepo.updateNew(maKhachHang, kh);
    }

    @Override
    public ArrayList<KhachHang> timKiem(String SDT) {
        return KHRepo.Tim(SDT);
    }

    @Override
    public boolean sdtDaTonTai(String SDT) {
        return KHRepo.sdtDaTonTai(SDT);
    }

    @Override
    public boolean MaKHDaTonTai(String maKhachHang) {
        return KHRepo.MaKHDaTonTai(maKhachHang);
    }

    @Override
    public boolean EmailDaTonTai(String Email) {
        return KHRepo.EmailDaTonTai(Email);

    }

    @Override
    public ArrayList<KhachHangResponse> getAllDC() {
        return KHRepo.getListDiaChi();
    }

}
