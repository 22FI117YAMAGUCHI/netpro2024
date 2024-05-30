import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ToCapitalLetterUDPClient {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            String message = "abc";
            byte[] sendData = message.getBytes();

            // 送信パケットを作成
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9876);
            // パケットの送信
            socket.send(sendPacket);

            // 受信データのバッファを作成
            byte[] receiveData = new byte[1024];

            // 受信パケットを作成
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            // パケットの受信
            socket.receive(receivePacket);

            // 受信したメッセージを表示
            String modifiedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength()); // 受信データの文字列変換
            System.out.println("返信: " + modifiedMessage);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}