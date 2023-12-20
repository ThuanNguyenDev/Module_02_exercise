
public class Main {
    public static void main(String[] args) {
        Ngay ngay1 = new Ngay(12,11,2005);
        Ngay ngay2 = new Ngay(12,11,2005);
        Ngay ngay3 = new Ngay(12,10,2005);

        Lop lop1 = new Lop("DC067","Khoa Đại Cương");
        Lop lop2 = new Lop("DC001","Khoa Anh Ngữ");
        Lop lop3 = new Lop("DC003","Khoa XHNV");

        SinhVien sinhvien1 = new SinhVien("K01","Thuan",8.2,ngay1,lop1);
        SinhVien sinhvien2 = new SinhVien("K03","Tuan",9.2,ngay2,lop2);
        SinhVien sinhvien3 = new SinhVien("K04","Tu",4.2,ngay3,lop3);

        System.out.println("Tên khoa: ");
        System.out.println("SV1: " + sinhvien1.layTenKhoa());
        System.out.println("SV2: " + sinhvien2.layTenKhoa());
        System.out.println("SV3: " + sinhvien3.layTenKhoa());

        System.out.println("Kiểm tra thi đạt: ");
        System.out.println("SV1: " + sinhvien1.kiemTraThiDat());
        System.out.println("SV2: " + sinhvien2.kiemTraThiDat());
        System.out.println("SV3: " + sinhvien3.kiemTraThiDat());

        SinhVienService svService = new SinhVienService();
        System.out.println("Kiểm tra SV cùng ngày sinh: ");
        System.out.println("SV1 vs SV2: " + svService.check(sinhvien1, sinhvien2));
        System.out.println("SV1 vs SV3: " + svService.check(sinhvien1, sinhvien3));
    }
}