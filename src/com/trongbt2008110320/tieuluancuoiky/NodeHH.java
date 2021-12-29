package com.trongbt2008110320.tieuluancuoiky;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class NodeHH {
    String loai;
    int maHang;
    String tenHH;
    double giaNhap;
    int soLuongTonKho;
    Date ngayNhapKho;
    NodeHH next;
    static Scanner nhap = new Scanner(System.in);
    SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");

    //hàm tạo
    NodeHH(){

    }
    NodeHH(String l, int mh, String thh, double gn, int sl, String nn){
        loai = l;
        maHang = mh;
        tenHH = thh;
        giaNhap = gn;
        soLuongTonKho = sl;
        try {
            ngayNhapKho = date.parse(nn);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    //hàm nhập thông tin
    public void inThongTin(){
        System.out.println("__________________________________");
        System.out.println("- Loại: "+loai);
        System.out.println("- Mã hàng: "+maHang);
        System.out.println("- Tên hàng hoá: "+tenHH);
        System.out.printf("- Giá bán: %.1f đồng \n", giaNhap);
        System.out.println("- Số lượng tồn kho: "+soLuongTonKho);
        System.out.println("- Ngày nhập: "+ date.format(ngayNhapKho));
        System.out.println("__________________________________");
    }
    public void nhapThongTin() throws ParseException{
        System.out.println("__________________________________");
        System.out.print("+ Nhập loại hàng hoá: ");
        loai = nhap.nextLine();
        System.out.print("+ Nhập mã hàng hoá: ");
        maHang = nhap.nextInt();
        System.out.print("+ Nhập tên hàng hoá: ");
        nhap.nextLine();
        tenHH = nhap.nextLine();
        System.out.print("+ Nhập giá bán: ");
        giaNhap = nhap.nextDouble();
        System.out.print("+ Nhập số lượng: ");
        soLuongTonKho = nhap.nextInt();
        nhap.nextLine();
        System.out.print("+ Nhập ngày nhập hàng: ");
        ngayNhapKho = date.parse(nhap.nextLine());
    } 
    
}
