/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import java.math.BigDecimal;

/**
 *
 * @author DELL
 */
public class DM_Phat {
    private String lyDo,id;
    private BigDecimal muc;

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getMuc() {
        return muc;
    }

    public void setMuc(BigDecimal muc) {
        this.muc = muc;
    }

    public DM_Phat(String lyDo, String id, BigDecimal muc) {
        this.lyDo = lyDo;
        this.id = id;
        this.muc = muc;
    }

    public DM_Phat() {
    }
}
