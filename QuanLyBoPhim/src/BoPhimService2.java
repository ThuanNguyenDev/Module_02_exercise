public class BoPhimService2 {
    public double giaVePhimSauKhiGiam(Bophim bophimkhac,double x) {
        double bophim123 = bophimkhac.getPriceTicket();
        return  bophim123-bophim123*x/100;
    }
}
