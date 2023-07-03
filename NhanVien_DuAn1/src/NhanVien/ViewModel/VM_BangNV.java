/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NhanVien.ViewModel;

/**
 *
 * @author DELL
 */
public class VM_BangNV {
    private String IDNV, tenCV,Ma,Ten,gioiTinh,ngaySinh,Email,SDT,diaChi,matKhau;
    private int trangThaiDiLam,trangTháihipper;

    public VM_BangNV() {
    }

    public VM_BangNV(String IDNV, String tenCV, String Ma, String Ten, String gioiTinh, String ngaySinh, String Email, String SDT, String diaChi, String matKhau, int trangThaiDiLam, int trangTháihipper) {
        this.IDNV = IDNV;
        this.tenCV = tenCV;
        this.Ma = Ma;
        this.Ten = Ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.Email = Email;
        this.SDT = SDT;
        this.diaChi = diaChi;
        this.matKhau = matKhau;
        this.trangThaiDiLam = trangThaiDiLam;
        this.trangTháihipper = trangTháihipper;
    }

    public String getIDNV() {
        return IDNV;
    }

    public void setIDNV(String IDNV) {
        this.IDNV = IDNV;
    }

    public String getTenCV() {
        return tenCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public int getTrangThaiDiLam() {
        return trangThaiDiLam;
    }

    public void setTrangThaiDiLam(int trangThaiDiLam) {
        this.trangThaiDiLam = trangThaiDiLam;
    }

    public int getTrangTháihipper() {
        return trangTháihipper;
    }

    public void setTrangTháihipper(int trangTháihipper) {
        this.trangTháihipper = trangTháihipper;
    }
    
    public String TrangThaiLam() {
        if (trangThaiDiLam ==1) {
            return "Đang làm";
        }
       if (trangThaiDiLam ==2) {
            return "Tạm thời nghỉ";
        }
        else{
            return  "Nghỉ việc";
        }
      
}
    
      public String TrangThaiship() {
        if (trangTháihipper ==1) {
            return "Có thể giao hàng";
        }
       
        else{
            return  "Không thể giao hàng";
        }
      }
}
