import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TaskServerOnce {

    public static void main(String arg[]) {
        try {
            /* 通信の準備をする */
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            scanner.close();
            System.out.println("localhostの" + port + "番ポートで待機します");
            ServerSocket server = new ServerSocket(port); // ポート番号を指定し、クライアントとの接続の準備を行う

            Socket socket = server.accept(); // クライアントからの接続要求を待ち、
            // 要求があればソケットを取得し接続を行う
            System.out.println("接続しました。相手の入力を待っています......");

            // クライアントからのオブジェクトを受け取る
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ITask task = (ITask) ois.readObject();

            // 受信したnumberを表示
            int number = ((TaskObject) task).getExecNumber();
            System.out.println("クライアントから" + number + "を受信しました");

            // 計算を実行する
            System.out.println("計算を実行します");
            task.exec();

            // 計算結果をクライアントに送信
            int result = ((TaskObject) task).getResult();
            System.out.println("計算結果" + result +  "をクライアントに送ります");
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(task);
            oos.flush();

            // close処理
            ois.close();
            oos.close();
            // socketの終了。
            socket.close();
            server.close();

        } // エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (BindException be) {
            be.printStackTrace();
            System.out.println("ポート番号が不正、ポートが使用中です");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}