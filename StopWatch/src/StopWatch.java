public class StopWatch {
    private long startTime;
    private long endTime;
    private boolean isRunning;

    public StopWatch() {
        startTime = 0;
        endTime = 0;
        isRunning = false;
    }

    public void start() {
        if (isRunning) {
            System.out.println("Stopwatch is already running.");
        } else {
            startTime = System.currentTimeMillis();
            System.out.println("Stopwatch started.");
            isRunning = true;
        }
    }

    public void stop() {
        if (!isRunning) {
            System.out.println("Stopwatch is not running.");
        } else {
            endTime = System.currentTimeMillis();
            System.out.println("Stopwatch stopped. Elapsed time: " + getElapsedTime() + " milliseconds.");
            isRunning = false;
        }
    }

    public void reset() {
        startTime = 0;
        endTime = 0;
        isRunning = false;
        System.out.println("Stopwatch reset.");
    }

    private long getElapsedTime() {
        if (isRunning) {
            return System.currentTimeMillis() - startTime;
        } else {
            return endTime - startTime;
        }
    }
}