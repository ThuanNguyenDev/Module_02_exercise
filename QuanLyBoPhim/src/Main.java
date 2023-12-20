public class Main {
    public static void main(String[] args) {
        Ngay day1 = new Ngay(02,03,2007);
        Ngay day2 = new Ngay(03,07,2006);
        Ngay day3 = new Ngay(10,12,2007);

        HangSanXuat producebrand1 = new HangSanXuat("Holly Wood","US");
        HangSanXuat producebrand2 = new HangSanXuat("Ly Hai","Vietnam");
        HangSanXuat producebrand3 = new HangSanXuat("Tran Thanh Town","Chína");

        Bophim latmat1 = new Bophim("LALA",2020,producebrand1,100000,day1);
        Bophim latmat2 = new Bophim("NALA",2018,producebrand1,85000,day2);
        Bophim latmat3 = new Bophim("THE MASK SINGER",2015,producebrand3,75000,day3);

        BoPhimService phimservice = new BoPhimService();
        System.out.println("So sánh giá vé bộ phim 1 và 2 : " + phimservice.kiemTraGiaVeReHon(latmat1,latmat2) );
        System.out.println("So sánh giá vé bộ phim 1 và 3 : " + phimservice.kiemTraGiaVeReHon(latmat1,latmat3) );

        BoPhimService1 phim1 = new BoPhimService1();
        System.out.println("Tên hãng sản xuất của Phim 1 : " + phim1.layTenHangSanXuatPhim(producebrand1));
        System.out.println("Tên hãng sản xuất của Phim 2 : " + phim1.layTenHangSanXuatPhim(producebrand2));
        System.out.println("Tên hãng sản xuất của Phim 3 : " + phim1.layTenHangSanXuatPhim(producebrand3));

        BoPhimService2 phim2 = new BoPhimService2();
        System.out.println("Giá vé sau khi giảm của Phim 1 " + phim2.giaVePhimSauKhiGiam(latmat1,10));
        System.out.println("Giá vé sau khi giảm của Phim 2 " + phim2.giaVePhimSauKhiGiam(latmat2,50));
        System.out.println("Giá vé sau khi giảm của Phim 3 " + phim2.giaVePhimSauKhiGiam(latmat2,30));
    }
}