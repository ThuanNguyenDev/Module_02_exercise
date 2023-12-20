
public class Main {
    public static void main(String[] args) {
        String str = "123";
        int number = Integer.parseInt(str);
        System.out.println(number); // Output: 123


        String str1 = "3.14";
        double number1 = Double.parseDouble(str1);
        System.out.println(number1); // Output: 3.14

        String str2 = "true";
        boolean boolValue = Boolean.parseBoolean(str2);
        System.out.println(boolValue); // Output: true

        String str3 = "a";
        char character = str3.charAt(0);
        System.out.println(character); // Output: a


        //Lưu ý rằng khi ép kiểu từ chuỗi sang kiểu dữ liệu khác, nếu chuỗi không thể được chuyển đổi thành kiểu dữ liệu đó (ví dụ: chuỗi không hợp lệ)
        //một ngoại lệ sẽ được ném (ví dụ: NumberFormatException)

    }
    }
