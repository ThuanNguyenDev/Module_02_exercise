public class BoPhimService {
    public boolean kiemTraGiaVeReHon(Bophim phimkhac1, Bophim phimkhac2) {
        double price1 = phimkhac1.getPriceTicket();
        double price2 = phimkhac2.getPriceTicket();
        if (price1 > price2) {
            return true;
        } else {
            return false;
        }

    }
}