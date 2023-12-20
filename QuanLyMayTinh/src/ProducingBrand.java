public class ProducingBrand {
    private String producingBrandName;
    private Country country;

    public ProducingBrand(String producingBrandName, Country country) {
        this.producingBrandName = producingBrandName;
        this.country = country;
    }

    public String getProducingBrandName() {
        return producingBrandName;
    }

    public void setProducingBrandName(String producingBrandName) {
        this.producingBrandName = producingBrandName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
