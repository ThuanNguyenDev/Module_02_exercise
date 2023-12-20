package Loop;

public class PrimeNumbers {

    public static void main(String[] args) {
        int count = 0;

        for(int number = 2; count < 20; ++number) {
            if (isPrime(number)) {
                System.out.print("" + number + " ");
                ++count;
            }
        }
    }
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        } else {
            for(int i = 2; (double)i <= Math.sqrt((double)num); ++i) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
