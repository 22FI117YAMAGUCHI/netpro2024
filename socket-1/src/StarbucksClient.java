import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class StarbucksClient {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            scanner.nextLine(); // 改行を消費する
            System.out.println("localhostの" + port + "番ポートに接続を要求します");
            Socket socket = new Socket("localhost", port);
            System.out.println("接続されました");

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            while (true) {
                // サーバーからの最初のメッセージを受け取る
                Order welcomeMessage = (Order) ois.readObject();
                System.out.println("サーバからのメッセージ: " + welcomeMessage.getDrink());

                // ドリンクとサイズを入力
                // ドリンク注文でexit or quitを入力するとプログラム終了
                System.out.println("注文いいですか？");
                System.out.println("ドリンクを入力してください (例: coffee) → ");
                System.out.print("※注文をやめる場合はexit or quitを入力してください→");
                String drink = scanner.nextLine();
                if (drink.equalsIgnoreCase("quit") || drink.equalsIgnoreCase("exit")) {
                    break;
                }
                System.out.print("サイズを入力してください (例: s , m, l) → ");
                String size = scanner.nextLine();

                // ドリンクとサイズをサーバーに送信
                Order order = new Order();
                order.setDrink(drink);
                order.setSize(size);
                oos.writeObject(order);
                oos.flush();

                // サーバーからのトッピングのリクエストを受け取る
                Order requestForTopping = (Order) ois.readObject();
                System.out.println("サーバからのメッセージ: " + requestForTopping.getDrink());

                // トッピングを入力
                System.out.print("トッピングを入力してください (例: choco) → ");
                String topping = scanner.nextLine();

                // トッピングをサーバーに送信
                order = new Order();
                order.setTopping(topping);
                oos.writeObject(order);
                oos.flush();

                // サーバーから料金のメッセージを受け取る
                Order priceMessage = (Order) ois.readObject();
                System.out.println("サーバからのメッセージ: " + priceMessage.getDrink());

                // サーバーからの最終確認を受け取る
                Order response = (Order) ois.readObject();
                System.out.println("サーバからのメッセージ: " + response.getDrink());
            }

            // 接続を閉じる
            ois.close();
            oos.close();
            socket.close();
            scanner.close();

        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            e.printStackTrace();
        }
    }
}