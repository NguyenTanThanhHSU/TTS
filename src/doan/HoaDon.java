package doan;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class HoaDon extends QuanLyMatHang{
    String bill_date;
    int ma_bill;
    int hd_mssp, hd_slsp;
    double tien_bill;
    HangHoa dssphd[];
    public HoaDon() {}

//    public HoaDon(String bill_date, int ma_bill, double tien_bill) {
//        this.bill_date = bill_date;
//        this.ma_bill = ma_bill;
//        this.tien_bill = tien_bill;
//    }
    
    public String getBill_date() {
        return bill_date;
    }

    public void setBill_date(String bill_date) {
        this.bill_date = bill_date;
    }

    public int getMa_bill() {
        return ma_bill;
    }

    public void setMa_bill(int ma_bill) {
        this.ma_bill = ma_bill;
    }

    public double getTien_bill() {
        return tien_bill;
    }

    public void setTien_bill(double tien_bill) {
        this.tien_bill = tien_bill;
    }
    
    public void set_date_id(boolean them)
    {
        if (them == true)
        {
            if (bill_date==null)
            {
                setBill_date(LocalDate.now().toString());
            }
            if (ma_bill==0)
            {
                Random rand = new Random();
                setMa_bill(rand.nextInt(1000));
            }
        }
    }

    public void XuatHoaDon(HangHoa pr, int sl)//(ArrayList<HangHoa> ps)
    {
        System.out.println("Ma so Hoa Don: " + ma_bill);
        System.out.println("Han Hoa Don: " + bill_date);
        System.out.println("MaSo\tTen\tDonGia\tSoLuong\tThanhTien");
        System.out.println(pr.maso + "\t" + pr.tenhh + "\t" + pr.dongia + "\t" + hd_slsp + "\t" + tien_bill);
    }
    public void Xuattheobill(int ms, ArrayList<HangHoa> ps)
    {
        if (ma_bill==ms)
        {
            System.out.println("Ma so Hoa Don: " + ma_bill);
            System.out.println("Han Hoa Don: " + bill_date);
            System.out.println("MaSo\tTen\tDonGia\tSoLuong\tThanhTien");

            for (HangHoa pr: ps)
            {
                if (pr.maso==hd_mssp)
                    System.out.println(pr.maso + "\t" + pr.tenhh + "\t" + pr.dongia + "\t" + hd_slsp + "\t" + tien_bill);
            }
        }
    }
}
