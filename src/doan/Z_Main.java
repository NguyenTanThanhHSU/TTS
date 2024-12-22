/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package doan;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Z_Main {
    public static void main(String []args) throws IOException
    {
//        File f = new File("Test");
//        FileWriter fw = new FileWriter(f);        
        
        
        QuanlyUser em_command = new QuanlyUser();
        em_command.tutaonhanvien();
        
        System.out.println("Dang Nhap\n");
        while(em_command.check_in==false)
        {
           em_command.dangnhap();
        }
        
        QuanLyMatHang pr_command = new QuanLyMatHang();
        QuanLyHoaDon bi_command = new QuanLyHoaDon();
        pr_command.ds = new ArrayList<HangHoa>();
        bi_command.dshd = new ArrayList<HoaDon>();
        int jack=0;

        Scanner ch = new Scanner(System.in);
        pr_command.DocFile("DanhSachSP_2.txt");

        
        while (jack!=-1)
        {
            System.out.println("Che do Nhan Vien:\n0. Thoat He Thong\n1. Quan Ly Mat Hang\n2. Quan Ly Hoa Don");
            jack = Integer.parseInt(ch.nextLine());
            switch (jack)
            {
                case 0 ->
                {
                    System.out.println("Hoan thanh cong viec!");
                    jack = -1;
                    break;
                }
                case 1 ->
                {
                    pr_command.Menu();
                    if (pr_command.thoatmenu==0)
                    {
                        jack = pr_command.thoatmenu; break;
                    }
                }
                case 2 ->
                {
                    if (pr_command.ds!=null)
                    {
                        System.out.println("Bat dau xuat hoa don");
                        bi_command.Menu_hd(pr_command.ds);
                        if (bi_command.thoatmenu2==0)
                        {
                            jack = bi_command.thoatmenu2; break;
                        }
                    }
                }
            }
        }
    }
}
