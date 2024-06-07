package Singleton;

public class Singleton2 {
    private static volatile Singleton2 instance;

    private Singleton2() {
        // コンストラクタを private にすることで外部からのインスタンス化を防ぐ
    }

    public static Singleton2 getInstance() {
        if (instance == null) {
            synchronized (Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}
