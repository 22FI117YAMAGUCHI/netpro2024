package Singleton;

public class Singleton {
    private static Singleton instance;

    private Singleton() {
        // コンストラクタを private にすることで外部からのインスタンス化を防ぐ
    }

    public static Singleton getInstance() {//呼び出されてから初期化する。
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
