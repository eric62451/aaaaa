
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {

    private static final int SENDER_PORT_NUMBER = 50000;
    private static final int RECEIVER_PORT_NUMBER = 50000;

    public static void main(String[] args) throws Exception {
        //InetAddress inet = InetAddress.getLocalHost();
        InetAddress inet = InetAddress.getByName("127.0.0.1");
        int port = RECEIVER_PORT_NUMBER;
        byte[] buf = new byte[1000];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        DatagramPacket collide = new DatagramPacket(buf, buf.length);
        DatagramPacket collision = new DatagramPacket(new byte[1], 1, inet, SENDER_PORT_NUMBER);
        DatagramSocket receiverSocket = new DatagramSocket(port);
        while (true) {
            try {
                receiverSocket.receive(packet);
                receiverSocket.setSoTimeout(1);
                receiverSocket.receive(collide);
                collision.setAddress(packet.getAddress());
                receiverSocket.send(collision);
                collision.setAddress(collide.getAddress());
                receiverSocket.send(collision);
                receiverSocket.setSoTimeout(0);
                System.out.println("collision");
            } catch (Exception e) {
                /*if (Math.random() < 0.3) {
                    collision.setAddress(packet.getAddress());
                    receiverSocket.send(collision);
                } else*/
                    receiverSocket.send(packet);
                    receiverSocket.setSoTimeout(0);
                    System.out.println("send");
            }
        }
    }
}
