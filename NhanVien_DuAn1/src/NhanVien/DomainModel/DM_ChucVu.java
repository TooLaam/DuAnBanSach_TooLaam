/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author DELL
 */
public class DM_ChucVu {
    private String IDCV,Ma,Ten;

    public String getIDCV() {
        return IDCV;
    }

    public void setIDCV(String IDCV) {
        this.IDCV = IDCV;
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

    public DM_ChucVu(String IDCV, String Ma, String Ten) {
        this.IDCV = IDCV;
        this.Ma = Ma;
        this.Ten = Ten;
    }

    public DM_ChucVu() {
    }
}
