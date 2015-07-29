import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {

    private static final int SENDER_PORT_NUMBER = 40000;
    private static final int RECEIVER_PORT_NUMBER = 50000;
    private static final int BYTE_SIZE = 1000;
    private static final int LOOP_COUNT = 100;
    private static final int LAMBDA = 20;

    public static void main(String[] args) throws Exception {
        //InetAddress inet = InetAddress.getLocalHost();
        InetAddress inet = InetAddress.getByName("127.0.0.1");
        int port = SENDER_PORT_NUMBER;
        byte[] buf = new byte[BYTE_SIZE];
        DatagramPacket packet = new DatagramPacket(buf, buf.length, inet, RECEIVER_PORT_NUMBER);
        DatagramPacket answer = new DatagramPacket(buf, buf.length, inet, RECEIVER_PORT_NUMBER);
        DatagramSocket senderSocket = new DatagramSocket(port);
        senderSocket.setSoTimeout(1);
        double timeSlots = 0;
        int count = 0;
        int delay = 0;

        while (timeSlots < 5000) {
            double sleepTime = generate(LAMBDA);
            timeSlots = timeSlots + sleepTime;
            Thread.sleep((long)sleepTime, (int)((sleepTime-(long)sleepTime)*1000000));
            try {
                senderSocket.send(packet);
                senderSocket.receive(answer);
                int tries = 0;
                while (answer.getLength() == 1) {
                    int backOff = 0;
                    System.out.println(tries);
                    for (int i = 0; i <= tries; i++) {
                        backOff = backOff + (int) (((int) (Math.random() + 0.5)) * Math.pow(2.0, i));
                    }
                    delay = delay + backOff;
                    timeSlots = timeSlots + backOff;
                    Thread.sleep(backOff);
                    senderSocket.send(packet);
                    senderSocket.receive(answer);
                    tries++;
                }
            } catch (Exception e) {
                System.out.println("A");
                count--;
            }
            count++;
        }
        senderSocket.close();
        System.out.println("Packets Sent: "+count+"\nTimeSlots Delay: "+delay);
    }

    static double generate(int L) {
        double u = 0;
        while (u == 0) {
            u = Math.random();
        }
        return L * Math.log(u) * (-1);
    }
}
