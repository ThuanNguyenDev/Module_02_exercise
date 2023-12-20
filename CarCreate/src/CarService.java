public class CarService {
    public Car createCar(String cartype) {
        if(cartype.equals("Audi")) {
            return new Car(new BanhMerce(), new VoMerce(),new DongCoMerce(), new GheMerce());
        } else if ( cartype.equals("Merce")) {
            return new Car(new BanhAudi(),new VoAudi(), new DongCoAudi(), new GheAudi());
        }
        return null;

    }
}
