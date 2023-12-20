public class Car {
    private Banh banh;
    private Vo vo;
    private DongCo dongco;
    private Ghe ghe;

    public Car() {
    }

    public Car(Banh banh, Vo vo, DongCo dongco, Ghe ghe) {
        this.banh = banh;
        this.vo = vo;
        this.dongco = dongco;
        this.ghe = ghe;
    }

    public Banh getBanh() {
        return banh;
    }

    public void setBanh(Banh banh) {
        this.banh = banh;
    }

    public Vo getVo() {
        return vo;
    }

    public void setVo(Vo vo) {
        this.vo = vo;
    }

    public DongCo getDongco() {
        return dongco;
    }

    public void setDongco(DongCo dongco) {
        this.dongco = dongco;
    }

    public Ghe getGhe() {
        return ghe;
    }

    public void setGhe(Ghe ghe) {
        this.ghe = ghe;
    }
}
