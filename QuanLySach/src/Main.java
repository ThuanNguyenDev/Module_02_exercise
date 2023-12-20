
public class Main {
    public static void main(String[] args) {
        Ngay ngay1 = new Ngay(15,5,2012);
        Ngay ngay2 = new Ngay(2,12,2030);
        Ngay ngay3 =  new Ngay(15,11,2020);

        TacGia tacgia1 = new TacGia("Thuan",ngay1);
        TacGia tacgia2 = new TacGia("Tinh",ngay2);
        TacGia tacgia3 = new TacGia("Duy",ngay3);

        Sach sach1 = new Sach("Java",15000,2010,tacgia1);
        Sach sach2 = new Sach("C#",50000, 2020,tacgia2);
        Sach sach3 = new Sach("Code for beginner", 100000,2020,tacgia3);

        sach1.inTenSach();
        sach2.inTenSach();
        sach3.inTenSach();

        System.out.println("So sánh NXB sách 1 và sách 2: "+ sach1.kiemTraCungNamXuatBan(sach3));
        System.out.println("So sánh NXB sách 2 và sách 3: " + sach2.kiemTraCungNamXuatBan(sach3));

        System.out.println("Sách 1 sau khi giảm 10% : " + sach1.giaSauKhiGiam(10));
        System.out.println("Sách 2 sau khi giảm 30% : " + sach2.giaSauKhiGiam(30));
        System.out.println("Sách 3 sau khi giảm giá 50% : " + sach3.giaSauKhiGiam(50));
    }
}