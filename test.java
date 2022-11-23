public class _test {
    public static void main(String[] args) {
        Runnable runner = () -> {
 
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Ich laufe immer noch");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Interrupted "+Thread.interrupted());
 
        };
 
        Thread t1 = new Thread(runner);
        t1.start();
 
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
 
        t1.interrupt();
    }
}