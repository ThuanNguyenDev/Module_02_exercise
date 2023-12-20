package Loop;

public class PrimeNumbers20100 {
    public static void main(String[] args) {

        for (int number = 2; number < 100; number++) {
            if (isPrime(number)) {
                System.out.print(number + " ");
            }
        }
    }
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
