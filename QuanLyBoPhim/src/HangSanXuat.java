public class HangSanXuat {
    private String producingProduct;
    private String country;

    public HangSanXuat(String producingProduct, String country) {
        this.producingProduct = producingProduct;
        this.country = country;
    }

    public String getProducingProduct() {
        return producingProduct;
    }

    public void setProducingProduct(String producingProduct) {
        this.producingProduct = producingProduct;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
