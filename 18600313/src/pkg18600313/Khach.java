/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg18600313;

/**
 *
 * @author TUAN
 */
public class Khach {
    private int id;
    private String ten;
    private int sodu;
    private int tienno;

    public Khach(int id, String ten, int sodu, int tienno) {
        this.id = id;
        this.ten = ten;
        this.sodu = sodu;
        this.tienno = tienno;
    }
    public Khach(){}
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

    public int getSodu() {
        return sodu;
    }

    public void setSodu(int sodu) {
        this.sodu = sodu;
    }

    public int getTienno() {
        return tienno;
    }

    public void setTienno(int tienno) {
        this.tienno = tienno;
    }
    
    
}
