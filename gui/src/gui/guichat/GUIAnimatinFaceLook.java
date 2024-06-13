package gui.guichat;

import java.awt.Color;
import java.awt.Graphics;

// 顔のオブジェクトを描画するための機能を提供
class GUIAnimatinFaceLook {// 顔のオブジェクト

    int h = 100;
    int w = 100;

    int xStart = 0;
    int yStart = 0;

    public void setXY(int x, int y) {
        this.xStart = x;
        this.yStart = y;
    }

    public void setSize(int h, int w) {
        this.h = h;
        this.w = h;
    }

    // コンストラクタ
    public GUIAnimatinFaceLook() {

    }

    // 顔の基本的な要素（目、鼻、口）を描画 (オーバーロード)
    void makeFace(Graphics g) {
        // makeRim(g);
        makeEyes(g, w / 5, w / 5);
        makeNose(g, h / 5);
        makeMouth(g, w / 2);
    }

    // 感情に応じて顔を描画
    public void makeFace(Graphics g, String emotion) {
        // **ここにemotion毎の顔を用意する。*///
        if (emotion.equals("normal")) {
            makeEyes(g, w / 5, 0);
            makeNose(g, h / 5);
            makeMouth(g, w / 2);
        } else if (emotion.equals("smile")) {
            makeEyes(g, w / 5, -w / 5);
            makeNose(g, h / 5);
            makeMouth(g, w / 2);
        } else if (emotion.equals("angry")) {
            makeEyes(g, w / 5, w / 5);
            makeNose(g, h / 5);
            makeMouth(g, w / 2);
        }

    }

    /*
     * public void makeRim(Graphics g) { g.drawLine(xStart, yStart, xStart + h,
     * yStart); g.drawLine(xStart, yStart, xStart, yStart + w);
     * g.drawLine(xStart, yStart + w, xStart + h, yStart + w); g.drawLine(xStart
     * + h, yStart, xStart + h, yStart + w); }
     */

    void makeEyes(Graphics g, int eyeSize, int blows) {
        // setColor(Color.red);
        // g.fillRect(xStart + (h * 1 / 3) - 20, yStart + (w * 1 / 3) - 10,
        // 10, 10);

        g.setColor(Color.blue);

        // g.fillRoundRect()
        // g.fillOval()
        g.fillArc(xStart + (h * 2 / 7), yStart + (w * 1 / 3), eyeSize, eyeSize,
                0, 300);
        g.setColor(Color.black);

        // 眉毛
        g.drawLine(xStart + (h * 1 / 3) - 20, yStart + (w * 1 / 3) - 10,
                xStart + (h * 1 / 3) + 20, yStart + (w * 1 / 3) - 10 + blows);
        g.drawLine(xStart + (h * 2 / 3) - 20, yStart + (w * 1 / 3) - 10 + blows,
                xStart + (h * 2 / 3) + 20, yStart + (w * 1 / 3) - 10);

        g.drawOval(xStart + (h * 2 / 7), yStart + (w * 1 / 3), eyeSize, eyeSize);
        g.drawOval(xStart + (h * 4 / 7), yStart + (w * 1 / 3), eyeSize, eyeSize);
    }// makeEyes()

    public void makeNose(Graphics g, int noseSize) {
        g.drawLine(xStart + (h * 1 / 2), yStart + (w * 2 / 4), xStart
                + (h * 1 / 2), yStart + (w * 2 / 4) + noseSize);
    }// makeNose() end

    public void makeMouth(Graphics g, int mouseSize) {
        int xMiddle = xStart + h / 2;
        int yMiddle = yStart + 3 * w / 4;
        g.drawLine(xMiddle - mouseSize / 2, yMiddle, xMiddle + mouseSize / 2,
                yMiddle);
    }
}// FaceObj End