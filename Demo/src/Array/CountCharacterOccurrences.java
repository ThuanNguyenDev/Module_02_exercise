package Array;

public class CountCharacterOccurrences {
    public static int countOccurrences(String str, char targetChar) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == targetChar) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        String str = "Hello, world!";
        char targetChar = 'l';

        int occurrences = countOccurrences(str, targetChar);
        System.out.println("Số lần xuất hiện của ký tự '" + targetChar + "' trong chuỗi là: " + occurrences);
    }
}
