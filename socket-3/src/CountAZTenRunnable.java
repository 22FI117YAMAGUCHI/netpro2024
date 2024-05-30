public class CountAZTenRunnable implements Runnable {
    private char cAtoZ;

    // 文字を設定
    public void setChar(char c) {
        this.cAtoZ = c;
    }

    public static void main(String[] args) {
        // 26個の配列の、CountTenRunnable クラスのインスタンスを作成
        CountAZTenRunnable[] runnables = new CountAZTenRunnable[26];
        // cAtoZ を実行するThread クラスの、スレッドを作成
        Thread[] threads = new Thread[26];

        // a から z を生成し、それぞれの CountAZTenRunnable インスタンスに設定
        for (int i = 0; i < 26; i++) {
            char c = (char) (97 + i); // 英数小文字をa,b,cという風に増やす
            runnables[i] = new CountAZTenRunnable();
            runnables[i].setChar(c);
            threads[i] = new Thread(runnables[i], c + "_chan  thread");
        }

        // すべてのスレッドを開始
        for (Thread thread : threads) {
            thread.start();
        }

        // メインスレッドが0から9までカウントアップ
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("main : i = " + i);
                Thread.sleep(500); // 0.5秒間隔
            }
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }

    // スレッドが実行するコードを定義
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(cAtoZ + "_chan thread : i = " + i);
                Thread.sleep(1000); // １秒間隔
            }
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }
}