package gui.guichat;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

// 顔をアニメーションさせる
class GUIAnimationBall {

    GUIAnimatinFaceLook facelook; // 顔の外観を管理するオブジェクト

    String cstr = ""; // 衝突時のテキストメッセージ
    Random rdn; // ランダムオブジェクト

    String emotion = "normal"; // ボールの感情状態

    int w = 500; // ウィンドウの幅
    int h = 500; // ウィンドウの高さ

    int x;
    int y;
    int radius; // 半径
    Color basicColor = Color.gray; // ボールの基本色
    final Color initColor = Color.gray; // ボールの初期色

    double xDir = -1; // 1:+方向 -1: -方向
    double yDir = 1;
    private int strCounter; // 衝突メッセージの表示カウンター

    private String basicLabelMessage = "(空白:未受信)"; // 基本メッセージ

    // コンストラクタ
    GUIAnimationBall(int w, int h) {

        rdn = new Random();
        xDir = rdn.nextDouble() * 10 - 5;
        yDir = rdn.nextDouble() * 10 - 5;
        this.w = w;
        this.h = h;

        // ボールの位置と半径をランダム
        setPosition(rdn.nextInt(w), rdn.nextInt(h - 5));
        setRadius(rdn.nextInt(30) + 30);// 30-60のサイズの顔の輪郭

        // ボールの基本色をランダムに設定
        this.basicColor = new Color(rdn.nextInt(255), rdn.nextInt(255),
                rdn.nextInt(255));

        // GUIAnimatinFaceLookオブジェクトを初期化
        facelook = new GUIAnimatinFaceLook();
    }

    /* 感情をセット */
    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

    /* メッセージをセット */
    public void setMessage(String message) {
        this.basicLabelMessage = message;
    }

    /* 基本色をセット */
    void setBasicColor(Color bcolor) {
        this.basicColor = bcolor;
    }

    /* 衝突テキストのセット */
    public void setCollisionText(String cstr, int strCounter) {
        this.cstr = cstr;
        this.strCounter = strCounter;
    }

    // ボールの移動
    void move() {

        if ((xDir > 0) && (x + this.radius * 2 >= w)) {
            xDir = -1 * xDir;
            if (emotion.equals("angry")) {
                setCollisionText("右が痛いわぁ!!激おこ", 6);
            } else {
                setCollisionText("右が痛い。。。でも言えない", 3);
            }

        } else if ((xDir < 0) && (x <= 0)) {
            xDir = -1 * xDir;

            if (emotion.equals("angry")) {
                setCollisionText("左が痛いわぁ!!おこ", 6);
            } else {
                setCollisionText("左の頬が少し。。。", 4);
            }

        }

        if ((yDir > 0) && (y + this.radius * 2 >= h)) {
            yDir = -1 * yDir;
            if (emotion.equals("angry")) {
                setCollisionText("顎が痛いよ!!ぷんぷん", 7);
            } else {
                setCollisionText("AGO ITAI...Boku..", 4);
            }
        }
        if ((yDir < 0) && (y <= 0)) {
            yDir = -1 * yDir;
            if (emotion.equals("angry")) {
                setCollisionText("頭をぶつけたよ痛いよ!!まじ痛いよ", 8);
            } else {
                setCollisionText("こつん.", 4);
            }

        }

        x += (int) xDir;
        y += (int) yDir;

    }

    void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void setRadius(int r) {
        this.radius = r;
    }

    void draw(Graphics g) {

        // 円の処理
        g.setColor(basicColor);
        g.fillOval(x, y, 2 * radius, 2 * radius); // rは半径なので2倍にする
        g.drawString(basicLabelMessage, x - 5, y - 10);

        if (strCounter > 0) {
            g.drawString(cstr, x, y);
            strCounter--;
        } else {
            cstr = "";
        }

        facelook.setXY(x, y);
        facelook.setSize(2 * radius, 2 * radius);

        // fobj.makeFace(g);
        facelook.makeFace(g, emotion);

        g.setColor(initColor);

    }

}// ball rim end
