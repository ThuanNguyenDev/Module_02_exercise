public class Bophim {
    private String movieName;
    private int producingYear;
    private HangSanXuat producingbrand;
    private double priceTicket;
    private Ngay featuringDay;

    public Bophim(String movieName, int producingYear, HangSanXuat producingbrand, double priceTicket, Ngay featuringDay) {
        this.movieName = movieName;
        this.producingYear = producingYear;
        this.producingbrand = producingbrand;
        this.priceTicket = priceTicket;
        this.featuringDay = featuringDay;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getProducingYear() {
        return producingYear;
    }

    public void setProducingYear(int producingYear) {
        this.producingYear = producingYear;
    }

    public HangSanXuat getProducingbrand() {
        return producingbrand;
    }

    public void setProducingbrand(HangSanXuat producingbrand) {
        this.producingbrand = producingbrand;
    }

    public double getPriceTicket() {
        return priceTicket;
    }

    public void setPriceTicket(double priceTicket) {
        this.priceTicket = priceTicket;
    }

    public Ngay getFeaturingDay() {
        return featuringDay;
    }

    public void setFeaturingDay(Ngay featuringDay) {
        this.featuringDay = featuringDay;
    }
}
