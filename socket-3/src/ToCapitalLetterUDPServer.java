import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ToCapitalLetterUDPServer {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            // DatagramSocketの作成
            socket = new DatagramSocket(9876); // ポート9876を使ってサーバソケットを作成
            // 受信用バッファの準備
            byte[] receiveData = new byte[1024]; // バッファのサイズは1024バイト
            // 送信用バッファの宣言
            byte[] sendData; // ここではまだ初期化しない

            while (true) {
                // 受信パケットを作成
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                // パケットの受信 受信データはreceivePacketに格納
                socket.receive(receivePacket);

                // 受信したバイトデータを文字列に変換
                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("受信: " + message);

                // メッセージを大文字に変換
                String capitalizedMessage = message.toUpperCase();

                // クライアントのアドレスとポートを取得
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                // 返信パケットを作成
                sendData = capitalizedMessage.getBytes();
                // 送信パケットの作成
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                // パケットの送信
                socket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}