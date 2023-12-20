
public class Main {
    public static void main(String[] args) {
        StopWatch watch = new StopWatch();
        watch.start();

        try {
            Thread.sleep(2500); // Giả định thời gian đã trôi qua là 2.5 giây
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        watch.stop();

        watch.reset();
    }
        }

