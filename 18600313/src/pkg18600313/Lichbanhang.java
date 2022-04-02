/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg18600313;
import java.util.Date;
/**
 *
 * @author TUAN
 */
public class Lichbanhang {
    private int id;
    private String ten;
    private Date ngay;
    private int tien;

    public Lichbanhang(int id, String ten, Date ngay, int tien) {
        this.id = id;
        this.ten = ten;
        this.ngay = ngay;
        this.tien = tien;
    }
    public Lichbanhang(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public int getTien() {
        return tien;
    }

    public void setTien(int tien) {
        this.tien = tien;
    }
}
