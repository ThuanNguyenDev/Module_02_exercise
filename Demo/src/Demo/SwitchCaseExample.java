package Demo;

public class SwitchCaseExample {
    public static void main(String[] args) {
        int dayOfWeek = 3;
        String dayName;

        switch (dayOfWeek) {
            case 1:
                dayName = "Thứ Hai";
                break;
            case 2:
                dayName = "Thứ Ba";
                break;
            case 3:
                dayName = "Thứ Tư";
                break;
            case 4:
                dayName = "Thứ Năm";
                break;
            case 5:
                dayName = "Thứ Sáu";
                break;
            case 6:
                dayName = "Thứ Bảy";
                break;
            case 7:
                dayName = "Chủ Nhật";
                break;
            default:
                dayName = "Không hợp lệ";
                break;
        }

        System.out.println("Ngày " + dayOfWeek + " là " + dayName);
    }
}

