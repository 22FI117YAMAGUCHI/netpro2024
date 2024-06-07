//FacesAWTMain.java
//FacesAWTMain 目標 インナークラスのFaceObjクラスを作ってみよう。描画処理を移譲してください。
//3x3　の顔を描画してください。色などもぬってオリジナルな楽しい顔にしてください。

package guibasic;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FacesAWTMain {

    public static void main(String[] args) {
        new FacesAWTMain();
    }

    FacesAWTMain() {
        FaceFrame f = new FaceFrame();
        f.setSize(800, 800);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setVisible(true);
    }

    // インナークラスを定義
    class FaceFrame extends Frame {

        private FaceObj fobj1;
        int xStart0 = 50;
        int yStart0 = 50;

        FaceFrame() {
            fobj1 = new FaceObj();
        }

        public void paint(Graphics g) {

            // この中には、g.drawLine というのは入ってこない
            // Graphicsクラス(型のようなもの---今は--)のgという変数はメソッドに渡す
            FaceObj[] fobjs = new FaceObj[9];

            for (int j = 0; j < 3; j++) {
                for (int i = 0; i < 3; i++) {
                    fobjs[i + j * 3] = new FaceObj();
                    fobjs[i + j * 3].setPosition(xStart0 + 250 * i, yStart0 + 250 * j);
                    fobjs[i + 3 * j].setEmotionLevel(i, j);
                    fobjs[i + j * 3].drawFace(g);
                }
            }
        }
    }// FaceFrame end

    // Faceクラスを作ってみよう。
    private class FaceObj {
        private int w = 200;
        private int h = 200;
        private int xStart = 150;
        private int yStart = 150;
        private int i;
        private int j;

        public void drawFace(Graphics g) {
            drawRim(g);
            drawBrow(g, j*8);
            drawEye(g, 35);
            drawNose(g, 40);
            drawMouth(g, 100);
        }

        public void setEmotionLevel(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public void setPosition(int xStart0, int yStart0) {
            this.xStart = xStart0;
            this.yStart = yStart0;
        }

        public void drawRim(Graphics g) { // wが横幅、hが縦幅
            g.drawLine(xStart, yStart, xStart + w, yStart);
            g.drawLine(xStart, yStart, xStart, yStart + h);
            g.drawLine(xStart, yStart + h, xStart + w, yStart + h);
            g.drawLine(xStart + w, yStart, xStart + w, yStart + h);
        }

        public void drawBrow(Graphics g, int updown) { // xは目の幅 呼ばれる方(=定義する方)
            int wx1 = xStart + w * 1 / 8;
            int wx2 = xStart + w * 5 / 8;
            int wy = yStart + h / 5;
            g.drawLine(wx1, wy + updown, wx1 + w * 2 / 8, wy);
            g.drawLine(wx2, wy, wx2 + w * 2 / 8, wy + updown);
        }

        public void drawNose(Graphics g, int nx) { // xは鼻の長さ
            int xMiddle = xStart + w / 2;
            int widthNose = 30;

            // 鼻
            g.drawRect(xMiddle - widthNose / 2, yStart + 110, widthNose, nx);
            // 左穴
            g.drawOval(xMiddle - widthNose / 2, yStart + 140, 10, 10);
            // 右穴
            g.drawOval(xMiddle + 5, yStart + 140, 10, 10);
        }

        public void drawEye(Graphics g, int r) { // rは目の半径
            // 左目

            // 左目：輪郭
            // g.setColor(Color.BLACK);
            g.drawOval(xStart + 35 - 15, yStart + 65, r + 30, r);
            // 左目：目、外円
            // g.setColor(Color.GREEN);
            g.drawOval(xStart + 35, yStart + 65, r, r);
            // 左目：目、内円
            // g.setColor(Color.BLUE);
            g.drawOval(xStart + 35 + 5, yStart + 65 + 5, r - 10, r - 10);

            // 右目

            // 右目：輪郭
            // g.setColor(Color.BLACK);
            g.drawOval(xStart + 35 + 80, yStart + 65, r + 30, r);
            // 右目：目、外円
            // g.setColor(Color.GREEN);
            g.drawOval(xStart + 35 + 95, yStart + 65, r, r);
            // 右目：目、内円
            // g.setColor(Color.BLUE);
            g.drawOval(xStart + 35 + 95 + 5, yStart + 65 + 5, r - 10, r - 10);
        }

        public void drawMouth(Graphics g, int mx) { // xは口の幅
            int xMiddle = xStart + w / 2;
            int yMiddle = yStart + h - 30;
            int mouseWidth = 100;
            int mouseHight = 50;
            // 横口
            if (j == 1) {
                g.drawLine(xMiddle - mx / 2, yMiddle, xMiddle + mx / 2, yMiddle);
            }

            // 上口
            if (j == 0) {
                g.fillArc(xMiddle - mouseWidth / 2, yMiddle - mouseHight * 3 / 5, mouseWidth,
                        mouseHight, 180, 180);
            }

            // 下口
            if (j == 2) {
                g.fillArc(xMiddle - mouseWidth / 2, yMiddle - mouseHight * 1 / 5, mouseWidth,
                        mouseHight, 0, 180);
            }
        }
    }

}// Faces class end