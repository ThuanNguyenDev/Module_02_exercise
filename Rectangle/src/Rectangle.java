import java.util.Scanner;
public class Rectangle {
  public double length, width;
    public void getInformation(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập chiều dài hình chữ nhật: ");
        length = sc.nextDouble();

        System.out.println("Nhập chiều rộng hình chữ nhật: ");
        width = sc.nextDouble();
    }
    public double getArea(){
        return length * width;
    }
    public double getPerimeter(){
        return (length + width) * 2;
    }
    public void display(){
        System.out.println("Diện tích hình chữ nhật là : " + getArea());
        System.out.println("Chu vi hình chữ nhật là : " + getPerimeter());
    }
}
