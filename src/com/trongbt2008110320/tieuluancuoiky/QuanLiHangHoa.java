package com.trongbt2008110320.tieuluancuoiky;

import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class QuanLiHangHoa {
    NodeHH head;
    NodeHH tail;
    Scanner nhap = new Scanner(System.in);

    //hàm kiểm tra mã hàng hoá
    int kiemTra(int ma){
        NodeHH current = head;
        while(current != null){
            if(current.maHang == ma)
                return 0;
            current = current.next;
        }
        return 1;
        
    }
    // hàm thêm
    void them(String l, int mh, String thh, double gn, int sl, String nn) {
        NodeHH newSP = new NodeHH(l, mh, thh, gn, sl, nn);
        if (head == null) {
            head = newSP;
            tail = newSP;
        } else {
            tail.next = newSP;
            tail = newSP;
        }
    }

    // Thêm hàng hoá vào đầu danh sách
    void themDau() throws ParseException {
        System.out.println("- Thêm hàng hoá vào đầu danh sách:");
        NodeHH newSP = new NodeHH();
        newSP.nhapThongTin();
        do{
            if(kiemTra(newSP.maHang) == 0){
                System.out.println("- Mã hàng của sản phẩm mới đã trùng với mã hàng của một hàng hoá có trong kho!!!");
                System.out.print("- Mời nhập lại mã mới:");
                newSP.maHang = nhap.nextInt();
                kiemTra(newSP.maHang);
            }
        }while(kiemTra(newSP.maHang) == 0);
        newSP.next = head;
        head = newSP;
        System.out.println("- Thêm thành công.");
    }

    // Thêm hàng hoá vào cuối danh sách
    void themCuoi() throws ParseException {
        System.out.println("- Thêm hàng hoá vào cuối danh sách: ");
        NodeHH newSP = new NodeHH();
        newSP.nhapThongTin();
        do{
            if(kiemTra(newSP.maHang) == 0){
                System.out.println("- Mã hàng của sản phẩm mới đã trùng với mã hàng của một hàng hoá có trong kho!!!");
                System.out.print("- Mời nhập lại mã mới:");
                newSP.maHang = nhap.nextInt();
                kiemTra(newSP.maHang);
            }
        }while(kiemTra(newSP.maHang) == 0);
        tail.next = newSP;
        tail = newSP;
        System.out.println("- Thêm thành công.");
    }

    // Tìm hàng hoá theo mã
    NodeHH tim(int maTim) {
        NodeHH tam = head;
        if (head.maHang == maTim) {
            System.out.println("Thông tin hàng hoá cần tìm:");
            head.inThongTin();
            return head;
        }
        while (tam != null) {
            if (tam.next.maHang == maTim) {
                System.out.println("Thông tin hàng hoá cần tìm:");
                tam.next.inThongTin();
                return tam;
            }
            tam = tam.next;
        }
        return null;
    }

    // Thêm hàng hoá trước 1 hàng hoá đã có
    void themTruoc() throws ParseException {
        System.out.println("--Thêm một hàng hoá vào trước một hàng hoá tìm được--");
        int ma;
        System.out.print("- Nhập mã của hàng hoá cần tìm: ");
        ma = nhap.nextInt();
        NodeHH tam = tim(ma);
        System.out.println("- Thông tin của hàng hoá muốn thêm: ");
        NodeHH newSP = new NodeHH();
        newSP.nhapThongTin();
        do{
            if(kiemTra(newSP.maHang) == 0){
                System.out.println("- Mã hàng của sản phẩm mới đã trùng với mã hàng của một hàng hoá có trong kho!!!");
                System.out.print("- Mời nhập lại mã mới:");
                newSP.maHang = nhap.nextInt();
                kiemTra(newSP.maHang);
            }
        }while(kiemTra(newSP.maHang) == 0);
        if (tam == null) {
            System.out.println("- Không có hàng hoá cần tìm trong kho.");
            return;
        }
        if (head.maHang == ma) {
            themDau();
            System.out.println("- Thêm thành công.");
            return;
        }
        newSP.next = tam.next;
        tam.next = newSP;
        System.out.println("- Thêm thành công.");
    }

    // Xoá thông tin hàng hoá đầu danh sách
    void xoaDau() {
        head = head.next;
        System.out.println("*****Xoá thành công*****");
    }

    // Xoá thông tin hàng hoá cuối danh sách
    void xoaCuoi() {
        NodeHH tam = head;
        while (tam != null) {
            if (tam.next == tail) {
                tail = tam;
                tail.next = null;
                System.out.println("*****Xoá thành công*****");
            }
            tam = tam.next;
        }
    }

    // Hàm xoá ở một vị trí bất kì
    void xoa() {
        System.out.println("- Xoá hàng hoá ở vị trí bất kì: ");
        int ma;
        System.out.print("- Nhập mã của hàng hoá cần tìm: ");
        ma = nhap.nextInt();
        NodeHH tam = tim(ma);
        if (tam == null) {
            System.out.println("- Không có hàng hoá cần tìm trong kho.");
        } else if (head.maHang == ma) {
            xoaDau();
        } else {
            tam.next = tam.next.next;
            System.out.println("*****Xoá thành công*****");
        }

    }

    // hàm đỏi vị trí
    void doiViTri(String tam1, int tam2, double tam3, Date tam4, NodeHH current, NodeHH index) {
        // đồi loại hàng hoá
        tam1 = current.loai;
        current.loai = index.loai;
        index.loai = tam1;
        // đổi chỗ mã hàng
        tam2 = current.maHang;
        current.maHang = index.maHang;
        index.maHang = tam2;
        // đổi chỗ tên hàng hoá
        tam1 = current.tenHH;
        current.tenHH = index.tenHH;
        index.tenHH = tam1;
        // đổi chỗ giá nhập hàng hoá
        tam3 = current.giaNhap;
        current.giaNhap = index.giaNhap;
        index.giaNhap = tam3;
        // đổi chỗ số lượng tồn kho
        tam2 = current.soLuongTonKho;
        current.soLuongTonKho = index.soLuongTonKho;
        index.soLuongTonKho = tam2;
        // đổi chỗ ngày nhập hàng
        tam4 = current.ngayNhapKho;
        current.ngayNhapKho = index.ngayNhapKho;
        index.ngayNhapKho = tam4;

    }

    // Sắp xếp tăng dần theo giá
    void tangDanTheoGia() {
        NodeHH current = head;
        NodeHH index = null;
        String tam1 = null;
        int tam2 = 0;
        double tam3 = 0;
        Date tam4 = null;
        System.out.println("- Hàng hoá tăng dần theo giá: ");
        while (current != null) {
            index = current.next;
            while (index != null) {
                if (current.giaNhap > index.giaNhap) {
                    doiViTri(tam1, tam2, tam3, tam4, current, index);
                }
                index = index.next;
            }
            current = current.next;
        }
        System.out.println("+ Sắp xếp thành công.");
    }

    // sắp xếp giảm dần theo giá
    void giamDanTheoGia() {
        NodeHH current = head;
        NodeHH index = null;
        String tam1 = null;
        int tam2 = 0;
        double tam3 = 0;
        Date tam4 = null;
        System.out.println("- Hàng hoá giảm dần theo giá: ");
        while (current != null) {
            index = current.next;
            while (index != null) {
                if (current.giaNhap < index.giaNhap) {
                    doiViTri(tam1, tam2, tam3, tam4, current, index);
                }
                index = index.next;
            }
            current = current.next;
        }
        System.out.println("+ Sắp xếp thành công.");
    }

    // sắp xếp giảm dần theo ngày
    void giamTheoNgay() {
        NodeHH current = head;
        NodeHH index = null;
        String tam1 = null;
        int tam2 = 0;
        double tam3 = 0;
        Date tam4 = null;
        System.out.println("- Hàng hoá giảm dần theo ngày nhập: ");
        while (current != null) {
            index = current.next;
            while (index != null) {
                if ((current.ngayNhapKho).compareTo(index.ngayNhapKho) < 0) {
                    doiViTri(tam1, tam2, tam3, tam4, current, index);
                }
                index = index.next;
            }
            current = current.next;
        }
        System.out.println("+ Sắp xếp thành công.");
    }

    // sắp xếp tăng dần theo ngày nhập
    void tangTheoNgay() {
        NodeHH current = head;
        NodeHH index = null;
        String tam1 = null;
        int tam2 = 0;
        double tam3 = 0;
        Date tam4 = null;
        System.out.println("- Hàng hoá tăng dần theo ngày nhập: ");
        while (current != null) {
            index = current.next;
            while (index != null) {
                if ((current.ngayNhapKho).compareTo(index.ngayNhapKho) > 0) {
                    doiViTri(tam1, tam2, tam3, tam4, current, index);
                }
                index = index.next;
            }
            current = current.next;
        }
        System.out.println("+ Sắp xếp thành công.");
    }

    // sắp xếp theo loại;
    void xepTheoLoai() {
        NodeHH current = head;
        NodeHH index = null;
        String tam1 = null;
        int tam2 = 0;
        double tam3 = 0;
        Date tam4 = null;
        while (current != null) {
            index = current.next;
            while (index != null) {
                if ((current.loai).compareTo(index.loai) > 0) {
                    doiViTri(tam1, tam2, tam3, tam4, current, index);
                }
                index = index.next;
            }
            current = current.next;
        }
    }

    // Sắp xếp theo loại hàng hoá và tăng dần theo ngày nhập
    void loaiVaNgayTang() {
        xepTheoLoai();
        NodeHH current = head;
        NodeHH index = null;
        String tam1 = null;
        int tam2 = 0;
        double tam3 = 0;
        Date tam4 = null;
        System.out.println("- Sắp xếp hàng hoá theo loại hàng và ngày nhập tăng dần: ");
        while (current != null) {
            index = current.next;
            while (index != null && current.loai == index.loai) {
                if ((current.ngayNhapKho).compareTo(index.ngayNhapKho) > 0) {
                    doiViTri(tam1, tam2, tam3, tam4, current, index);
                }
                index = index.next;
            }
            current = current.next;
        }
        System.out.println("+ Sắp xếp thành công.");
    }

    // sắp xếp theo loại và ngày giảm dần
    void loaiVaNgayGiam() {
        xepTheoLoai();
        NodeHH current = head;
        NodeHH index = null;
        String tam1 = null;
        int tam2 = 0;
        double tam3 = 0;
        Date tam4 = null;
        System.out.println("- Sắp xếp hàng hoá theo loại và ngày nhập giảm dần: ");
        while (current != null) {
            index = current.next;
            while (index != null && current.loai == index.loai) {
                if ((current.ngayNhapKho).compareTo(index.ngayNhapKho) < 0) {
                    doiViTri(tam1, tam2, tam3, tam4, current, index);
                }
                index = index.next;
            }
            current = current.next;
        }
        System.out.println("+ Sắp xếp thành công.");
    }

    // sắp xếp theo loại và giá tăng
    void loaiVaGiaTang() {
        xepTheoLoai();
        NodeHH current = head;
        NodeHH index = null;
        String tam1 = null;
        int tam2 = 0;
        double tam3 = 0;
        Date tam4 = null;
        System.out.println("- Sắp xếp hàng hoá theo loại và giá nhập tăng dần: ");
        while (current != null) {
            index = current.next;
            while (index != null && current.loai == index.loai) {
                if (current.giaNhap > index.giaNhap) {
                    doiViTri(tam1, tam2, tam3, tam4, current, index);
                }
                index = index.next;
            }
            current = current.next;
        }
        System.out.println("+ Sắp xếp thành công.");
    }

    // sắp xếp theo loại và giá giảm
    void loaiVaGiaGiam() {
        xepTheoLoai();
        NodeHH current = head;
        NodeHH index = null;
        String tam1 = null;
        int tam2 = 0;
        double tam3 = 0;
        Date tam4 = null;
        System.out.println("- Sắp xếp hàng hoá theo loại và giá nhập giảm dần: ");
        while (current != null) {
            index = current.next;
            while (index != null && current.loai == index.loai) {
                if (current.giaNhap < index.giaNhap) {
                    doiViTri(tam1, tam2, tam3, tam4, current, index);
                }
                index = index.next;
            }
            current = current.next;
        }
        System.out.println("+ Sắp xếp thành công.");
    }

    // thống kê tổng số lượng hàng hoá
    void tongSL() {
        int tong = 0;
        NodeHH current = head;
        while (current != null) {
            tong = tong + current.soLuongTonKho;
            current = current.next;
        }
        System.out.println("- Tổng số lượng hàng hoá trong kho là: " + tong);
    }

    // thống kê tổng giá trị nhập kho
    void tongGT() {
        double tongGT = 0;
        NodeHH current = head;
        while (current != null) {
            tongGT = tongGT + current.giaNhap*current.soLuongTonKho;
            current = current.next;
        }
        System.out.printf("- Tổng giá trị nhập của kho là: %.1f đồng\n", tongGT);
    }

    // thống kê số lượng từng loại hàng hoá
    void soLuong() {
        xepTheoLoai();
        System.out.println("- Số lượng hàng hoá mỗi loại:");
        NodeHH current = head;
        int soLuong = 0;
        while (current.next != null) {
            while (current.loai == current.next.loai) {
                soLuong = soLuong + current.soLuongTonKho;
                current = current.next;
                if (current.next.next == null) {
                    System.out.printf("+ Tổng số lượng hàng hoá của %s là: %d\n ", current.loai,(soLuong + current.soLuongTonKho + current.next.soLuongTonKho));
                    return;
                }
            }
            System.out.printf("+ Tổng số lượng hàng hoá của %s là: %d \n ", current.loai,(soLuong + current.soLuongTonKho));
            soLuong = 0;
            current = current.next;
        }
    }
    //sửa
    void sua(NodeHH hh) throws ParseException{
        System.out.println("- Sửa thông tin của hàng hoá:");
        System.out.print("+ Giá nhập mới: ");
        hh.giaNhap = nhap.nextDouble();
        System.out.print("+ Số lượng tồn kho mới: ");
        hh.soLuongTonKho = nhap.nextInt();
        nhap.nextLine();
        System.out.print("+ Ngày nhập mới: ");
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        hh.ngayNhapKho = date.parse(nhap.nextLine());
    }

    // sửa thông tin của hàng hoá
    void suaThongTin() throws ParseException {
        System.out.println("*****Tìm hàng hoá cần sửa thông tin*****");
        int ma;
        System.out.print("- Nhập mã của hàng hoá cần tìm: ");
        ma= nhap.nextInt();
        NodeHH hh = tim(ma).next;
        if(head.maHang == ma){
            sua(head);
            System.out.println("- Sửa thành công.");
        }else{
            sua(hh);
            System.out.println("- Sửa thành công.");
        }
    }
    //tìm kiếm theo loại
    void timKiemTheoLoai(){
        System.out.println("- Tìm kiếm hàng hoá theo loại.");
        System.out.print("+ Nhập loại hàng cần tìm: ");
        String l = nhap.nextLine();
        NodeHH current = head;
        while(current != null){
            if(current.loai.equalsIgnoreCase(l)){
                current.inThongTin();
            }
            current = current.next;
        }
    }
    //tìm kiếm theo khoảng giá
    void timKiemTheoGia(){
        System.out.println("- Tìm kiếm hàng hoá theo khoảng giá.");
        System.out.print("+ Nhập khoảng giá min: ");
        double min = nhap.nextDouble();
        System.out.print("+ Nhập khoảng giá max: ");
        double max = nhap.nextDouble();
        NodeHH current = head;
        while(current != null){
            if(current.giaNhap >= min && current.giaNhap <= max){
                current.inThongTin();
            }
            current = current.next;
        }
    }
    //tìm kiếm theo khoảng ngày
    void timKiemtheoNgay() throws ParseException{
        System.out.println("- Tìm kiến hàng hoá theo khoảng ngày.");
        System.out.print("- Nhập khoảng thời gian đầu: ");
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        Date bd = date.parse(nhap.nextLine());
        System.out.print("- Nhập khoảng thờI gian cuối: ");
        Date kt = date.parse(nhap.nextLine());
        NodeHH current = head;
        while(current != null){
            if(current.ngayNhapKho.compareTo(bd) > 0 && current.ngayNhapKho.compareTo(kt) < 0){
                current.inThongTin();
            }
            current = current.next;
        }

        
    }

    // Xuất thông tin kho hàng
    void in() {
        NodeHH current = head;
        while (current != null) {
            current.inThongTin();
            current = current.next;
        }
    }

}
