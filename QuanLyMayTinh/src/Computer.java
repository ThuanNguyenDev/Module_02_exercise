public class Computer {
    private double price;
    private double warrantyPeriodDate;
    private ProducingBrand producingBrand;
    private Date producingDay;

    public Computer(double price, double warrantyPeriodDate, ProducingBrand producingBrand, Date producingDay) {
        this.price = price;
        this.warrantyPeriodDate = warrantyPeriodDate;
        this.producingBrand = producingBrand;
        this.producingDay = producingDay;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWarrantyPeriodDate() {
        return warrantyPeriodDate;
    }

    public void setWarrantyPeriodDate(double warrantyPeriodDate) {
        this.warrantyPeriodDate = warrantyPeriodDate;
    }

    public ProducingBrand getProducingBrand() {
        return producingBrand;
    }

    public void setProducingBrand(ProducingBrand producingBrand) {
        this.producingBrand = producingBrand;
    }

    public Date getProducingDay() {
        return producingDay;
    }

    public void setProducingDay(Date producingDay) {
        this.producingDay = producingDay;
    }
}
