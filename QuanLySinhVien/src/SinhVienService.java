public class SinhVienService {
    public boolean check(SinhVien svkhac1, SinhVien svkhac2){
        Ngay ngaySv1 = svkhac1.getNgaysinh();
        Ngay ngaySv2 = svkhac2.getNgaysinh();
        if (ngaySv1.getNgay() == ngaySv2.getNgay() &&
                ngaySv1.getThang() == ngaySv2.getThang() &&
                ngaySv1.getNam() == ngaySv2.getNam() ){
            return true;
        }
        return false;
    }

}
