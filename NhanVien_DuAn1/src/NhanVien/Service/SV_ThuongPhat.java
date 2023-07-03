/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NhanVien.Service;

import DomainModel.DM_PhatThuong;
import DomainModel.DM_Thuong;
import DomainModel.DM_Phat;
import NhanVien.Repository.RP_ThuongPhat;
import NhanVien.ViewModel.VM_PhatThuong;
import NhanVien.ViewModel.VM_Thuong;
import NhanVien.ViewModel.VM_Phat;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class SV_ThuongPhat {
     private RP_ThuongPhat repo;
   
   public SV_ThuongPhat(){
       repo = new RP_ThuongPhat();
   }
   
   public List<VM_Thuong> hienThiThuong() throws SQLException{
       List<VM_Thuong> QLCV = new ArrayList<>();
       List<DM_Thuong> CV = repo.hienThiThuong();
       
       for (DM_Thuong CVDM : CV) {
           VM_Thuong CVVM = new VM_Thuong(CVDM.getLyDo(), CVDM.getId(), CVDM.getMuc());
            
           QLCV.add(CVVM);
       }
       return QLCV;
               
   }
   
   public  void insertThuong(VM_Thuong CVVM){
       DM_Thuong CVDM = new DM_Thuong(CVVM.getLyDo(),CVVM.getId(),CVVM.getMuc());
       
       
       
       repo.insertThuong(CVDM);
   }
   
   
   public void suaThuong(String ID, String LyDo, BigDecimal muc) throws SQLException{
       repo.SuaThuong(ID, LyDo, muc);
   }
   
    public List<VM_Phat> hienThiPhat() throws SQLException{
       List<VM_Phat> QLCV = new ArrayList<>();
       List<DM_Phat> CV = repo.hienThiPhat();
       
       for (DM_Phat CVDM : CV) {
           VM_Phat CVVM = new VM_Phat(CVDM.getLyDo(), CVDM.getId(), CVDM.getMuc());
           
           QLCV.add(CVVM);
       }
       return QLCV;
               
   }
   
   public  void insertPhat(VM_Phat CVVM){
       DM_Phat CVDM = new DM_Phat(CVVM.getLyDo(),CVVM.getId(), CVVM.getMuc());
       
       
      
       repo.insertPhat(CVDM);
   }
   
   
   public void suaPhat(String ID, String LyDo, BigDecimal muc) throws SQLException{
       repo.SuaPhat(ID, LyDo, muc);
   }
   
   public  void insertCTPhat(VM_PhatThuong CVVM){
       DM_PhatThuong CVDM = new DM_PhatThuong("", "", "", CVVM.getIdPhat(), CVVM.getIdNV(), CVVM.getNgayTao(), BigDecimal.ZERO, BigDecimal.ONE, 0);
       
       
       
       repo.insertCTPhat(CVDM);
   }
//   
   public  void insertCTThuong(VM_PhatThuong CVVM){
       DM_PhatThuong CVDM = new DM_PhatThuong("", "", CVVM.getIdThuong(), "", CVVM.getIdNV(), CVVM.getNgayTao(), BigDecimal.ZERO, BigDecimal.ONE, 0);
      
       repo.insertCTThuong(CVDM);
   }
//   
    public List<VM_PhatThuong> hienThiCTPhatThuong() throws SQLException{
       List<VM_PhatThuong> QLCV = new ArrayList<>();
       List<DM_PhatThuong> CV = repo.hienThiCTThuongPhat();
       
       for (DM_PhatThuong CVDM : CV) {
           VM_PhatThuong CVVM = new VM_PhatThuong(CVDM.getLyDoThuong(),CVDM.getLyDoPhat(), CVDM.getIdThuong(),"", CVDM.getIdNV(), CVDM.getNgayTao(), CVDM.getMucPhat(),CVDM.getMucThuong() ,CVDM.getTrangThai());
           
           QLCV.add(CVVM);
       }
       return QLCV;
               
   }
//    
//    public List<VM_Thuong> hienThiCTThuong() throws SQLException{
//       List<VM_Thuong> QLCV = new ArrayList<>();
//       List<DM_Thuong> CV = repo.hienThiCTThuong();
//       
//       for (DM_Thuong CVDM : CV) {
//           VM_Thuong CVVM = new VM_Thuong(CVDM.getLyDo(), CVDM.getId(), CVDM.getIdNV(), CVDM.getNgayTao(), CVDM.getMucPhat(), CVDM.getTrangThai());
//           
//           QLCV.add(CVVM);
//       }
//       return QLCV;
//               
//   }
}
