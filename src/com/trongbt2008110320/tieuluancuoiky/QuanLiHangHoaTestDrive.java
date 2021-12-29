package com.trongbt2008110320.tieuluancuoiky;

import java.text.ParseException;
import java.util.Scanner;

public class QuanLiHangHoaTestDrive {
    public static void main(String[] args) throws ParseException {
        QuanLiHangHoa quanLiHangHoa = new QuanLiHangHoa();
        Scanner nhap = new Scanner(System.in);
        int chon;
        quanLiHangHoa.them("Thuc Pham", 1, "Bánh ngọt", 15000, 10000, "08-02-2020");
        quanLiHangHoa.them("Sanh Su", 2, "Tô", 30000, 17000, "2-9-2021");
        quanLiHangHoa.them("Thuc Pham", 3, "Kẹo mút", 1000, 15000, "15-01-2021");
        quanLiHangHoa.them("Thuc Pham", 4, "Bánh tráng", 5000, 20000, "01-06-2020");
        quanLiHangHoa.them("Dien May", 5, "Máy giặt", 7000000, 150, "02-03-2020");
        quanLiHangHoa.them("Sanh Su", 6, "Đĩa", 45000, 1800, "30-8-2020");
        quanLiHangHoa.them("Thuc Pham", 7, "Bánh kem", 20000, 11000, "12-11-2021");
        quanLiHangHoa.them("Dien May", 8, "Quạt", 250000, 700, "01-01-2019");
        quanLiHangHoa.them("Thuc Pham", 9, "Bánh gạo", 25000, 6000, "13-11-2021");
        quanLiHangHoa.them("Thuc Pham", 10, "Hảo hảo", 3000, 30000, "23-04-2020");
        quanLiHangHoa.them("Sanh Su", 11, "Bình cắm hoa", 75000, 5600, "23-04-2021");
        quanLiHangHoa.them("Thuc Pham", 12, "Omachi", 5000, 60000, "28-05-2020");
        quanLiHangHoa.them("Thuc Pham", 13, "Kẹo dẻo", 1500, 4500, "15-06-2021");
        quanLiHangHoa.them("Sanh Su", 14, "Chén", 5000, 12000, "26-07-2021");
        quanLiHangHoa.them("Dien May", 15, "Tủ lạnh", 8020000, 250, "05-05-2020");
        quanLiHangHoa.them("Sanh Su", 16, "Chén nhỏ", 3000, 13000, "21-09-2021");
        quanLiHangHoa.them("Dien May", 17, "Máy lạnh", 4700000, 2600, "25-12-2019");
        quanLiHangHoa.them("Dien May", 18, "Máy lọc nước", 2500000, 170, "27-12-2020");
        quanLiHangHoa.them("Thuc Pham", 19, "xúc xích", 2000, 10000, "01-01-2020");
        quanLiHangHoa.them("Thuc Pham", 20, "Đùi gà", 25000, 6500, "14-11-2021");
        do{
            System.out.println("===================MENU===================");
            System.out.println(">>1: Thêm hàng hoá mới vào đầu danh sách kho.");
            System.out.println(">>2: Thêm hàng hoá mới vào cuối danh sách kho.");
            System.out.println(">>3: Thêm hàng hoá mới vào trước một hàng hoá tìm được.");
            System.out.println(">>4: Xoá hàng hoá ở đầu danh sách.");
            System.out.println(">>5: Xoá hàng hoá ở cuối danh sách.");
            System.out.println(">>6: Xoá hàng hoá ở một vị trí bất kì.");
            System.out.println(">>7: Sửa thông tin của hàng hoá trong kho.");
            System.out.println(">>8: Tìm kiếm hàng hoá theo loại.");
            System.out.println(">>9: Tìm kiếm hàng hoá theo khoảng giá.");
            System.out.println(">>10: Tìm kiếm hàng hoá theo khoang thời gian nhập hàng.");
            System.out.println(">>11: Sắp xếp hàng hoá tăng dần theo giá.");
            System.out.println(">>12: Sắp xếp hàng hoá giảm dần theo giá.");
            System.out.println(">>13: Sắp xếp hàng hoá tăng dần theo ngày.");
            System.out.println(">>14: Sắp xếp hàng hoá giảm dần theo ngày.");
            System.out.println(">>15: Sắp xếp hàng hoá theo loại.");
            System.out.println(">>16: Sắp xếp hàng hoá theo loại và tăng dần theo ngày nhập.");
            System.out.println(">>17: Sắp xếp hàng hoá theo loại và giảm dần theo ngày nhập.");
            System.out.println(">>18: Sắp xếp hàng hoá theo loại và tăng dần theo giá.");
            System.out.println(">>19: Sắp xếp hàng hoá theo loại và giảm dần theo giá.");
            System.out.println(">>20: Thống kê tổng số lượng hàng hoá trong kho.");
            System.out.println(">>21: Thống kê tổng giá trị của hàng hoá trong kho.");
            System.out.println(">>22: Thống kê số lượng hàng hoá của từng loại hàng.");
            System.out.println(">>23: In danh sách hàng hoá trong kho.");
            System.out.println(">>24: Kết thúc.");
            System.out.println("==========================================");
            System.out.print("- Nhập vào sự lựa chọn(1 -> 24): ");
            chon = nhap.nextInt();
            switch(chon){
                case 1:
                    quanLiHangHoa.themDau();
                    break;
                case 2:
                    quanLiHangHoa.themCuoi();
                    break;
                case 3: 
                    quanLiHangHoa.themTruoc();
                    break;
                case 4:
                    quanLiHangHoa.xoaDau();
                    break;
                case 5:
                    quanLiHangHoa.xoaCuoi();
                    break;
                case 6:
                    quanLiHangHoa.xoa();
                    break;
                case 7:
                    quanLiHangHoa.suaThongTin();
                    break;
                case 8:
                    quanLiHangHoa.timKiemTheoLoai();
                    break;
                case 9:
                    quanLiHangHoa.timKiemTheoGia();
                    break;
                case 10:
                    quanLiHangHoa.timKiemtheoNgay();
                    break;
                case 11:
                    quanLiHangHoa.tangDanTheoGia();
                    break;
                case 12:
                    quanLiHangHoa.giamDanTheoGia();
                    break;
                case 13:
                    quanLiHangHoa.tangTheoNgay();
                    break;
                case 14:
                    quanLiHangHoa.giamTheoNgay();
                    break;
                case 15:
                    System.out.println("- Sắp xếp hàng hoá theo loại hàng: ");
                    quanLiHangHoa.xepTheoLoai();
                    System.out.println("+ Sắp xếp thành công.");
                    break;
                case 16:
                    quanLiHangHoa.loaiVaNgayTang();
                    break;
                case 17:
                    quanLiHangHoa.loaiVaNgayGiam();
                    break;
                case 18:
                    quanLiHangHoa.loaiVaGiaTang();
                    break;
                case 19: 
                    quanLiHangHoa.loaiVaGiaGiam();
                    break;
                case 20:
                    quanLiHangHoa.tongSL();
                    break;
                case 21:
                    quanLiHangHoa.tongGT();
                    break;
                case 22:
                    quanLiHangHoa.soLuong();
                    break;
                case 23:
                    quanLiHangHoa.in();
                    break;
                case 24:
                    System.out.println("- KẾT THÚC!!!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ vui lòng nhập lại!");
            }
            System.out.print("- Quay lại MENU chính(1:yes/0:no): ");
            chon = nhap.nextInt(); 
        }while(chon == 1);
        nhap.close();
    }
    
}
