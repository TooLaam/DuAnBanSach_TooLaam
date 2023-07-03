package DotKhuyenMai.service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



import java.sql.SQLException;
import java.util.List;
import DotKhuyenMai.model.khuyenMaiModel;
import DotKhuyenMai.repository.Repository;

/**
 *
 * @author DELL
 */
public class Service {
     private final Repository repo;

    public Service() {
        repo = new Repository();
    }
    
    
      public List<khuyenMaiModel> checkMa(String Ma) {
        try {
            return repo.checkMa(Ma);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
      
         public void insert(khuyenMaiModel HD) {
        repo.insert(HD);
    }
         
         
          public List<khuyenMaiModel> hienThi() {
        try {
            return repo.hienThi();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
          
           public List<khuyenMaiModel> hienThiDang() {
        try {
            return repo.hienThiDang();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
           
             public void update(khuyenMaiModel HD) throws SQLException {
        repo.update(HD);
    }
             
               public List<khuyenMaiModel> hienThiDangtheoma(String matim) {
        try {
            return repo.hienThiDangtheoma(matim);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }  public List<khuyenMaiModel> hienThitheoma(String matim) {
        try {
            return repo.hienThitheoma(matim);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
         
}
