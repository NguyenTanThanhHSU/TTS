package doan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class QuanLyMatHang{
    HangHoa com;
    ArrayList<HangHoa> ds;
    public int thoatmenu;
    private boolean add_success = false;
    
    public void setDS(ArrayList list)
    {
        ds = list;
    }
    
    public void QuanLyMatHang() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void Them(HangHoa hh)
    {
        if (hh!=null)
        {ds.add(hh);
        System.out.println("Da them san pham vao danh sach");
        }
    }
    public void Xoa()
    {
        Scanner xoa = new Scanner(System.in);
        System.out.println("Xoa Mat Hang Bang: \n0. Thoat\n1. Ten\n2. MaSo");
        try{
            int c2 = Integer.parseInt(xoa.nextLine());
            if (c2!=0)
            {
                switch (c2)
                {
                    case 1 -> //ten
                    {
                        System.out.println("Nhap ten san pham can xoa: ");
                        for (HangHoa f: ds)
                        {
                            if (f!=null)
                            {
                                if (f.tenhh.trim().equals(xoa.nextLine()))
                                {
                                    ds.remove(f);
                                    System.out.println("Da xoa san pham khoi danh sach");
                                    return;
                                }else{
                                    System.out.println("Da khong tim thay san pham trong danh sach");
                                }
                            }
                        }
                    }
                    case 2 ->                        
                    {
                        System.out.println("Nhap ma so san pham can xoa: ");
                        for (HangHoa f: ds)
                        {
                            if (f!=null)
                            {
                                if (f.maso==Integer.parseInt(xoa.nextLine()))
                                {
                                    ds.remove(f);
                                    System.out.println("Da xoa san pham khoi danh sach");
                                    return;
                                }
                            }else{
                                System.out.println("Da khong tim thay san pham trong danh sach");
                            }
                        }
                    }
                }
            }
        }catch(NumberFormatException es)
        {
            System.out.println("lam cho dung vao" + es.getMessage());
        }
    }
    //4 tham so: maso, ten, don gia, so luong
    HangHoa Timkiem()
    {
        Scanner te4 = new Scanner(System.in);
        System.out.println("Tim Kiem Mat Hang: \n0. Thoat\n1. Ten\n2. MaSo\n3. Don Gia\n4. So Luong");
        try{
        int cd = Integer.parseInt(te4.nextLine());
        if (cd!=0)
        {
            for (HangHoa x: ds)
            {
                if (x!=null)
                {
                    switch (cd)
                    {
                        case 1 -> //ten
                        {
                            System.out.println("Nhap ten san pham can tim: ");
                            if (x.tenhh.trim().equals(te4.nextLine()))
                            {
                                System.out.println("\nDa tim thay san pham\n");
                                x.OutputHanghoa(); return x;
                            }
                        }
                        case 2 ->                         {
                            System.out.println("Nhap ma so san pham can tim: ");
                            if (x.maso==Integer.parseInt(te4.nextLine()))
                            {
                                System.out.println("\nDa tim thay san pham\n"); x.OutputHanghoa(); return x;
                            }
                        }
                        case 3 ->                         {
                            System.out.println("Nhap don gia san pham can tim: ");                            
                            if (x.dongia==Double.parseDouble(te4.nextLine()))
                            {
                                System.out.println("\nDa tim thay san pham\n"); x.OutputHanghoa(); return x;
                            }
                        }
                        case 4 ->                         {
                            System.out.println("Nhap so luong san pham can tim: ");
                            if (x.soluong==Integer.parseInt(te4.nextLine()))
                            {
                                System.out.println("\nDa tim thay san pham\n"); x.OutputHanghoa(); return x;
                            }
                        }
                    }
                }else{
                    System.out.println("Da khong tim thay San pham can tim");
                }
            }
        }
        }catch(NumberFormatException ex){
            System.out.println("Lam cho dung vao " + ex.getMessage());
        }
        
        return null;
    }    
    public Comparator Sapxep()
    {
        Scanner te8 = new Scanner(System.in);
        System.out.println("Sap Xep Danh Sach (tang dan): \n0. Thoat\n1. Ten\n2. MaSo");
        int cc = Integer.parseInt(te8.nextLine());
        switch (cc)
        {
            case 1 ->{
                Comparator <HangHoa> ten = new Comparator <HangHoa>()
                {
                    @Override
                    public int compare(HangHoa o1, HangHoa o2)
                    {
                        return o1.tenhh.compareTo(o2.tenhh);
                    }
                };
                return ten;
            }
            case 2 ->{
                Comparator <HangHoa> maso = new Comparator <HangHoa>()
                {
                    @Override
                    public int compare(HangHoa o1, HangHoa o2) {
                        if (o1.maso>o2.maso)
                        {
                            return 1;
                        }else if (o1.maso==o2.maso)
                        {
                            return 0;
                        }else
                        {
                            return -1;
                        }
                    }
                };
                return maso;
            }
        }
        return null;
    }
    
    public void DocFile(String tenfile)
    {
        File f = new File(tenfile);
        
        try
        {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            
            String line;
            while ((line = br.readLine()) != null)
                {
                    if (line.trim().equals("")) continue;
                    String d[] = line.split("[,]+");
                    HangHoa h = new HangHoa(Integer.parseInt(d[0].trim()), d[1], Integer.parseInt(d[2].trim()), Double.parseDouble(d[3].trim()));
                    ds.add(h);
                }
            fr.close(); br.close();
            add_success = true;
        }catch (IOException | NumberFormatException e)
        {
            System.out.println("Doc file khong thanh cong\t" + e.getMessage() + "\n\n"); 
        }
    }
    
    public void Menu()
    {
        int ch = 10;
        while(ch>0)
        {
            Scanner rc = new Scanner(System.in);
            System.out.println("Quan Ly Mat Hang\n0. Thoat\n1. Them\n2. Xoa\n3. Tim Kiem\n4. Sap Xep\n5. Xuat Danh Sach San Pham\n");
            try{
                ch = Integer.parseInt(rc.nextLine());
                switch (ch)
                {
                    case 0 -> {thoatmenu = 0; ch=-1; break;}
                    case 1 ->
                    {
                        //Them(dulieusanpham());
                        Scanner nm = new Scanner(System.in);
                        System.out.println("Nhap ten file: ");
                        DocFile(nm.nextLine());
                        if (add_success){
                            System.out.println("\nDa them vao danh sach thanh cong!\n");}
                        else{
                            System.out.println("\nDa khong the them vao danh sach\n");
                        }
                        ch = 10;
                        break;
                    }
                    case 2 ->
                    {
                        Xoa(); ch = 10; break;
                    }
                    case 3 ->
                    {
                        Timkiem(); ch = 10; break;
                    }
                    case 4 ->
                    {
                        Collections.sort(ds, Sapxep());
                        ch = 10;
                        break;
                    }
                    case 5 ->
                    {
                        System.out.println("MaSo\tTen\tDonGia\tSoLuong\tThanhTien");
                        for (HangHoa s: ds)
                        {
                            s.OutputHanghoa();
                        }
                        System.out.println("\nDa in ra danh sach");
                        ch = 10; break;
                    }
                }
            }catch(Exception ex)
            {
                System.out.println("Lam cho dung vao" + ex.getMessage());    
            }
        }
    }
}
