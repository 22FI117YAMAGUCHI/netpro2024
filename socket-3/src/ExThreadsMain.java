public class ExThreadsMain {

    public static void main(String[] args) {
        // ExThreadsWorkerクラスのインスタンスを作成
        ExThreadsWorker worker = new ExThreadsWorker();

        // workerを実行する新しいスレッドを作成
        Thread workerThread = new Thread(worker);

        // スレッドを開始。ExThreadsWorkerのrunメソッドが呼び出される。
        workerThread.start();

        // メインスレッドでの処理
        // １～１０秒を数える
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Main thread : i = " + i);
                Thread.sleep(1000); // １秒ごとに
            }
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }
}

class ExThreadsWorker implements Runnable {

    @Override
    public void run() {
        int sum = 0;

        // 1から10まで順に数値を加算
        for (int i = 1; i <= 10; i++) {
            sum += i;
            System.out.println("Worker thread : sum = " + sum);

            try {
                Thread.sleep(1000); // 1秒ごと
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
    }
}