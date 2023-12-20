public class Main {
    public static void main(String[] args) {
     Date day1 = new Date(01,02,2017);
     Date day2 = new Date(12,12,2021);
     Date day3 = new Date(12,01,2022);

     Country country1 = new Country("K01","KOREA");
     Country country2 = new Country("C01","CHINA");
     Country country3 = new Country("V01","VIETNAM");

     ProducingBrand brand1 = new ProducingBrand("ST10",country1);
     ProducingBrand brand2 = new ProducingBrand("ST11",country2);
     ProducingBrand brand3 = new ProducingBrand("ST12",country3);

     Computer computer1 = new Computer(17000000,12,brand1,day1);
     Computer computer2 = new Computer(15000000,36,brand2,day2);
     Computer computer3 = new Computer(20000000,24,brand3,day3);

     CheckPrice checkPrice = new CheckPrice();
     System.out.println("So sánh giá của MÁY TÍNH 1 và 2 : " + checkPrice.checkThePrice(computer1,computer2));
     System.out.println("So sánh giá của MÁY TÍNH 1 và 3 : " + checkPrice.checkThePrice(computer1,computer3));

     GetCountryName getcountry = new GetCountryName();
     System.out.println("Máy tính 1 sản xuất từ quốc gia : " + getcountry.getCountryName(country1));
     System.out.println("Máy tính 2 sản xuất từ quốc gia : " + getcountry.getCountryName(country2));
     System.out.println("Máy tính 3 sản xuất từ quốc gia : " + getcountry.getCountryName(country3));
    }
}