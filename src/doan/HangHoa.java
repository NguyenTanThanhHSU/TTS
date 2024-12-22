package doan;

import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class HangHoa {
    String tenhh;
    int maso;
    int soluong;
    double dongia;
    double tongtien;

    public HangHoa(int maso, String tenhh, int soluong, double dongia) {
        this.tenhh = tenhh;
        this.maso = maso;
        this.soluong = soluong;
        this.dongia = dongia;
    }

    public HangHoa() {}
    public int getMaso() {
        return maso;
    }
    public void setMaso(int maso) {
        this.maso = maso;
    }
    public String getTenhh() {
        return tenhh;
    }
    public void setTenhh(String tenhh) {
        this.tenhh = tenhh;
    }
    public int getSoluong() {
        return soluong;
    }
    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    public double getDongia() {
        return dongia;
    }
    public void setDongia(double dongia) {
        this.dongia = dongia;
    }
    public double getTongtien() {
        return soluong*dongia;
    }
    
    public void InputHanghoa()
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Nhap ma so san pham: ");
        setMaso(Integer.parseInt(sc.nextLine()));
        
        System.out.println("Nhap ten san pham: ");
        setTenhh(sc.nextLine());
        
        System.out.println("\nNhap so luong san pham: ");
        setSoluong(Integer.parseInt(sc.nextLine()));
        
        System.out.println("\nNhap don gia san pham: ");
        setDongia(Double.parseDouble(sc.nextLine()));
    }
    public void OutputHanghoa()
    {
        System.out.println(maso + "\t" + tenhh + "\t" + dongia + "\t" + soluong + "\t" + getTongtien());
    }
    @Override
    public String toString()
    {
        return maso + "\t" + tenhh + "\t" + dongia + "\t" + soluong;
    }
}
