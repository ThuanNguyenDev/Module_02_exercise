public class SinhVien {
    public Ngay Ngaysinh;
    private String maSinhVien;
    private String hoTen;
    private double diemTrungBinh;
    private Ngay ngaysinh;
    private Lop lop;

    public SinhVien(String maSinhVien, String hoTen, double diemTrungBinh, Ngay ngaysinh, Lop lop) {
        this.maSinhVien = maSinhVien;
        this.hoTen = hoTen;
        this.diemTrungBinh = diemTrungBinh;
        this.ngaysinh = ngaysinh;
        this.lop = lop;
    }

    public String getMaSinhVien() {
        return this.maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getHoTen() {
        return this.hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public double getDiemTrungBinh() {
        return this.diemTrungBinh;
    }

    public void setDiemTrungBinh(double diemTrungBinh) {
        this.diemTrungBinh = diemTrungBinh;
    }

    public Ngay getNgaysinh() {
        return this.ngaysinh;
    }

    public void setNgaysinh(Ngay ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public Lop getLop() {
        return this.lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }

    public String layTenKhoa() {
        return this.lop.getTenKhoa();
    }

    public boolean kiemTraThiDat() {
        if(this.diemTrungBinh>=5) { return true;}
        else { return false;}

    }
    public boolean kiemTraCungNgaySinh(SinhVien sinhvienkhac){
        if (this.ngaysinh == (sinhvienkhac.ngaysinh)) {
            return true;
        } else {
            return false;}
    }

}
