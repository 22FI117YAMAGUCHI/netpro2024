import java.io.Serializable;

public interface ITask extends Serializable {
    // クライアントで最初に計算させる数字を入力しておく関数
    public void setExecNumber(int x);

    // サーバで計算を実行をさせる関数...計算アルゴリズムが記載される。
    public void exec();

    // クライアントで結果を取り出す関数
    public int getResult();
}
