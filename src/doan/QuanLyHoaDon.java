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
public class QuanLyHoaDon{
    HangHoa com;
    ArrayList<HoaDon> dshd;
    public int thoatmenu2;
    int global_array = 0;
    
    //    ArrayList<HangHoa> listsp = new ArrayList<HangHoa>();
    //    HangHoa array[];
    
    
    public QuanLyHoaDon() {}
    
    public void SetListHD(ArrayList list)
    {
        dshd = list;
        //listsp = list;
    }
    
    public void taodshoadon()
    {
        HoaDon d1 = new HoaDon();
        d1.set_date_id(true);
        d1.dssphd = new HangHoa[100];
        d1.dssphd[0] = new HangHoa(14, "Pop", 46, 9);
        d1.dssphd[1] = new HangHoa(23, "Giay", 94, 100);
        
        HoaDon d2 = new HoaDon();
        d2.set_date_id(true);
        d2.dssphd = new HangHoa[100];
        d2.dssphd[0] = new HangHoa(14, "Pop", 10, 9);
        d2.dssphd[1] = new HangHoa(5, "Kinh", 2, 900);
        d2.dssphd[2] = new HangHoa(11, "Mien", 100, 19);
        d2.dssphd[3] = new HangHoa(73, "Nap", 5, 20);
        
        dshd.add(d1);
        dshd.add(d2);
    }
    
    public void XuatDSHD()
    {
        System.out.println("Ma Bill\tThoi gian");
        for (HoaDon z: dshd)
        {
            System.out.println(z.ma_bill + "\t" + z.bill_date);
        }
    }
    
    HoaDon Tim(ArrayList<HangHoa> ps)
    {
        XuatDSHD();
        Scanner te4 = new Scanner(System.in);
        System.out.println("Tim Kiem Bill voi ma so: ");
        try{
        int cdh = Integer.parseInt(te4.nextLine());
        if (cdh!=0)
        {
            for (HoaDon z: dshd)
            {
                if (z.ma_bill == cdh)
                {
                    System.out.println("MaSoHD: " + z.ma_bill);
                    System.out.println("Thoigian: " + z.bill_date);
                    System.out.println("MaSo\tTen\tDonGia\tSoLuong\tThanhTien");
                    for (int i = 0; i < z.dssphd.length; i++)
                    {
                        if (z.dssphd[i]!=null)
                        {int m = z.dssphd[i].maso;
                        String t = z.dssphd[i].tenhh;
                        double dg = z.dssphd[i].dongia;
                        int s = z.dssphd[i].soluong;
                        double to = s*dg;
                        System.out.println(m + "\t" + t + "\t" + dg + "\t" + s + "\t" + to);
                        }
                    }
                }
            }
        }
        }catch(NumberFormatException ex){
            System.out.println("Lam cho dung vao\t" + ex.getMessage());
        }
        
        return null;
    }

    HoaDon NhapSPvaoHD(HoaDon xz, ArrayList<HangHoa> lp, int array)
    {
        int ms = 0, sl = 0;
        double dongia = 0, thanhtien = 0;
        String name = null;
        boolean search=false;
        
        Scanner nsc = new Scanner(System.in);
        System.out.println("Nhap so sp can tim: ");
        ms = Integer.parseInt(nsc.nextLine());
        for (HangHoa s: lp)
        {
            if (s!=null)
            {
                if (s.maso==ms)
                {
                    name = s.tenhh;
                    dongia = s.dongia;
                    search = true; break;
                }
            }
        }
        System.out.println("Nhap so luong sp: ");
        sl = Integer.parseInt(nsc.nextLine());
        thanhtien = dongia*sl;
        
        xz.dssphd[array] = new HangHoa(ms, name, sl, dongia);
        
        return xz;
    }
    
    public void Menu_hd(ArrayList<HangHoa> dshh)
    {
        taodshoadon();
        boolean check_bill_add = false;
        int ch = 7;
        while(ch>0)
        {
            Scanner rc = new Scanner(System.in);
            System.out.println("\nQuan Ly Hoa Don:\n0. Thoat\n1. Tim Kiem\n2. Xuat Hoa Don");
           try{
                ch = Integer.parseInt(rc.nextLine());
                switch (ch)
                {
                    case 0 -> {thoatmenu2 = 0; ch = -1; break;}
                    case 1 -> {Tim(dshh); ch = 7; break;}
                    case 2 ->
                    {
                        HoaDon in = new HoaDon();
                        in.set_date_id(true);
                        in.dssphd = new HangHoa[100];
                        int slot = 0, choice = 0;
                        
                        System.out.println("MaSo\tTen\tDonGia\tSoLuong\tThanhTien");
                        for (HangHoa xs: dshh)
                        {
                            xs.OutputHanghoa();
                        }
                        
                        
                        while (true)
                        {
                            Scanner sd = new Scanner(System.in);
                            System.out.println("0. Thoat\n1. Nhap vao HD");
                            choice = Integer.parseInt(sd.nextLine());
                            
                            if (choice != 0)
                            {
                                NhapSPvaoHD(in, dshh, slot);
                                slot++;
                                check_bill_add = true;
                            }else{
                                break;
                            }
                        }
                        if (check_bill_add)
                        {
                            dshd.add(in);              
                            System.out.println("Da them vao log HD\n");
                            System.out.println("MaSoHD: " + in.ma_bill);
                            System.out.println("Thoigian: " + in.bill_date);
                            System.out.println("MaSo\tTen\tDonGia\tSoLuong\tThanhTien");
                            for (int i = 0; i <= slot; i++)
                            {
                                if (in.dssphd[i]!=null)
                                {int m = in.dssphd[i].maso;
                                String t = in.dssphd[i].tenhh;
                                double dg = in.dssphd[i].dongia;
                                int s = in.dssphd[i].soluong;
                                double to = s*dg;
                                System.out.println(m + "\t" + t + "\t" + dg + "\t" + s + "\t" + to);
                                }
                            }
                        }
                        ch = 7; break;
                    }
                }
            }catch(Exception ex)
            {
                System.out.println("Lam cho dung vao" + ex.getMessage());    
            }
        }
    }
}
