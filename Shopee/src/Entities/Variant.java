package Entities;

public class Variant {
    private int idVariant;
    private String color;
    private String sizeVariant;

    public Variant(int idVariant, String color, String sizeVariant) {
        this.idVariant = idVariant;
        this.color = color;
        this.sizeVariant = sizeVariant;
    }

    public int getIdVariant() {
        return idVariant;
    }

    public void setIdVariant(int idVariant) {
        this.idVariant = idVariant;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSizeVariant() {
        return sizeVariant;
    }

    public void setSizeVariant(String sizeVariant) {
        this.sizeVariant = sizeVariant;
    }
}
