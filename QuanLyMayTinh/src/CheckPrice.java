public class CheckPrice {
    boolean checkThePrice(Computer computer11,Computer computer22){
        double check1 = computer11.getPrice();
        double check2 = computer22.getPrice();

        if(check1>check2){
            return true;}
        else{
            return false;}
    }
}
