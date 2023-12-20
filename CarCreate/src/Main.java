
public class Main {
    public static void main(String[] args) {

        //C1
          Banh banhAudi = new BanhAudi();
          Vo voAudi = new VoAudi();
          DongCo dongcoAudi = new DongCoAudi();
          Ghe gheAudi = new GheAudi();

          Car carAudi = new Car(banhAudi,voAudi,dongcoAudi,gheAudi);

          Banh banhMerce = new BanhMerce();
          Vo voMerce = new VoMerce();
          DongCo dongCoMerce = new DongCoMerce();
          Ghe gheMerce = new GheMerce();

          Car carMerce = new Car(banhMerce,voMerce,dongCoMerce,gheMerce);


        //C2
        CarService carService = new CarService();
          carService.createCar("Audi");
          carService.createCar("Merce");

    }
}