import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MyMulticastClient {
    public static void main(String[] args) {
        try {
            // マルチキャストグループのIPアドレスとポート番号を指定
            InetAddress group = InetAddress.getByName("239.0.0.1");
            int port = 12345;

            // データ送信用のソケットを作成
            DatagramSocket socket = new DatagramSocket();

            // 送信するコマンドを設定
            String message = "My name is Taisei!";

            while (true) {
                // コマンドをバイト配列に変換して DatagramPacket を作成し、マルチキャストグループに送信
                byte[] buffer = message.getBytes();
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, port);
                socket.send(packet);
                System.out.println("Message sent : " + message);
                Thread.sleep(2000); // 2秒ごとにメッセージを送信
            }

            // ソケットを閉じる (この部分は無限ループの外に配置されるべき)
            // socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}