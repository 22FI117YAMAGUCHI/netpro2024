import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket; //ネットワーク関連のパッケージを利用する
import java.util.Scanner;

public class TaskClientOnce {

    public static void main(String arg[]) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            System.out.println("localhostの" + port + "番ポートに接続を要求します");
            Socket socket = new Socket("localhost", port);
            System.out.println("接続されました");

            System.out.println("数字を送ります");
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            // サーバーに送る数字を入力
            System.out.print("計算対象の数字を入力してください(例:100) →");
            int number = scanner.nextInt();
            scanner.close();

            // オブジェクトを作成
            TaskObject task = new TaskObject();
            task.setExecNumber(number);

            // サーバーに送信
            oos.writeObject(task);
            oos.flush();

            // サーバーから計算結果を受け取る
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            task = (TaskObject) ois.readObject();

            // 計算結果を表示
            int result = task.getResult();
            System.out.println(number + "の中で最大の素数は" + result);

            ois.close();
            oos.close();
            socket.close();

        } // エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (BindException be) {
            be.printStackTrace();
            System.err.println("ポート番号が不正か、サーバが起動していません");
            System.err.println("サーバが起動しているか確認してください");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}