/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg18600313;

import java.util.logging.Logger;

/**
 *
 * @author TUAN
 */
public class Sanpham {
    private int id;
    private String sanpham;
    private int quycach;
    private int giamgia;
    private int gia;

    public int getGiamgia() {
        return giamgia;
    }

    public void setGiamgia(int giamgia) {
        this.giamgia = giamgia;
    }

    public Sanpham(int id, String sanpham, int quycach, int giamgia, int gia) {
        this.id = id;
        this.sanpham = sanpham;
        this.quycach = quycach;
        this.giamgia = giamgia;
        this.gia = gia;
    }
    public Sanpham(){}

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSanpham() {
        return sanpham;
    }

    public void setSanpham(String sanpham) {
        this.sanpham = sanpham;
    }

    public int getQuycach() {
        return quycach;
    }

    public void setQuycach(int quycach) {
        this.quycach = quycach;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
}
