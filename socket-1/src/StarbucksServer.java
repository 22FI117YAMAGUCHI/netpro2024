import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class StarbucksServer {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            scanner.close();
            System.out.println("localhostの" + port + "番ポートで待機します");
            ServerSocket server = new ServerSocket(port);

            Socket socket = server.accept();
            System.out.println("接続しました。相手の入力を待っています......");

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            while (true) {
                // クライアントへの最初のメッセージを送信
                Order welcomeMessage = new Order();
                welcomeMessage.setDrink("いらっしゃいませ。ご注文はどうなさいますか？");
                oos.writeObject(welcomeMessage);
                oos.flush();

                // クライアントからドリンクとサイズを受け取る
                Order order = (Order) ois.readObject();
                String drink = order.getDrink();
                if (drink.equalsIgnoreCase("quit") || drink.equalsIgnoreCase("exit")) {
                    break;
                }
                String size = order.getSize();
                System.out.println("ドリンクは " + drink);
                System.out.println("サイズは " + size);

                // トッピングを尋ねるメッセージをクライアントに送信
                Order requestForTopping = new Order();
                requestForTopping.setDrink("トッピングは無料ですが、どうなさいますか？");
                oos.writeObject(requestForTopping);
                oos.flush();

                // クライアントからトッピングを受け取る
                order = (Order) ois.readObject();
                String topping = order.getTopping();
                System.out.println("トッピングは " + topping);

                // 料金設定
                int price;
                switch (size) {
                    case "s":
                        price = 500;
                        break;
                    case "m":
                        price = 600;
                        break;
                    case "l":
                        price = 700;
                        break;
                    default:
                        price = -1; // 不正な入力
                }

                // クライアントに料金を送信
                Order priceMessage = new Order();
                priceMessage.setDrink("料金は " + price + " 円です。");
                oos.writeObject(priceMessage);
                oos.flush();

                // 最終確認メッセージをクライアントに送信
                Order finalMessage = new Order();
                finalMessage.setDrink(drink + "のサイズは" + size + "、トッピングは" + topping + "のご注文ありがとうございました!!");
                oos.writeObject(finalMessage);
                oos.flush();
            }

            // リソースのクローズ
            ois.close();
            oos.close();
            socket.close();
            server.close();

        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            e.printStackTrace();
        }
    }
}
