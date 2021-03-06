package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class Server {
    public static int serverPort =8000;
    public static int clientPort = 8001;
    public static int buffer_size = 512;
    public static DatagramSocket ds;
    public static byte[] buffer = new byte[buffer_size];

    public static void TheServer() throws Exception {
        int length;
        String str;
        while(true) {
            length = System.in.read(buffer);
            str = new String(buffer, 0, buffer.length, StandardCharsets.UTF_8);
            if(length != 1) {
                ds.send(new DatagramPacket(buffer, length, InetAddress.getByName("192.168.43.132"), clientPort));
            }
            if(length == -1){
                break;
            }
            if(str.equals("quit")){
                break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ds = new DatagramSocket();
        TheServer();
    }
}