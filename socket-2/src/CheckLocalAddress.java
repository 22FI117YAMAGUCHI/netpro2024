import java.net.InetAddress;
import java.net.UnknownHostException;

public class CheckLocalAddress {
    public static void main(String[] args) {
        try {
            // ローカルホストのInetAddressオブジェクトを取得
            InetAddress localHost = InetAddress.getLocalHost();

            // ホスト名を取得して表示
            String hostName = localHost.getHostName();
            System.out.println("Host name is: " + hostName);

            // IPアドレスを取得して表示
            String hostAddress = localHost.getHostAddress();
            System.out.println("IP address is: " + hostAddress);
        } catch (UnknownHostException e) {
            System.out.println("Could not find local host information.");
            e.printStackTrace();
        }
    }
}