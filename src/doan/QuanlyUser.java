package doan;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class QuanlyUser {
    ArrayList<QuanlyUser> nv = new ArrayList<>();
    String tentk, pass;
    boolean check_in = false;

    public QuanlyUser(String tentk, String pass) {
        this.tentk = tentk;
        this.pass = pass;
    }
    public void tutaonhanvien()
    {
        nv.add(new QuanlyUser("meocon","2332"));
        nv.add(new QuanlyUser("cuncon","14s5"));
    }
    QuanlyUser() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void dangnhap()
    {
        Scanner dn = new Scanner(System.in);
        System.out.println("Ten tai khoan");
        String ten = dn.nextLine();
        System.out.println("Mat khau");
        String mk = dn.nextLine();
        checktk(ten, mk);
    }
    public boolean checktk(String t, String p)
    {
        for (QuanlyUser n: nv)
        {
            if (t.trim().equals(n.tentk) && p.trim().equals(n.pass))
            {
                System.out.println("Dang nhap thanh cong.");
                this.check_in = true;
                return true;
            }
        }
        System.out.println("Dang nhap that bai. Ten TK hoac Pass bi sai.");
        return false;
    }
}
