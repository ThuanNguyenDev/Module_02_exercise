public class BoPhimService1 {
    public String layTenHangSanXuatPhim (HangSanXuat hangsanxuat) {
        String brand = hangsanxuat.getProducingProduct();
        return brand;
    }
}
