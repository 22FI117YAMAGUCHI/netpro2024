package gui.guichat;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class MovingBallAWT {
    public static void main(String[] args) {
        FFrame f = new FFrame();
        f.setSize(FFrame.WIDTH, FFrame.HEIGHT);

        // ウィンドウが閉じられる際のイベントを処理
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // コンポーネントのサイズが変更されたときのイベントを処理
        f.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                f.adjustBalls();
            }
        });

        // ウィンドウを表示
        f.setVisible(true);
    }

    static class FFrame extends Frame implements Runnable {
        static final int WIDTH = 500;
        static final int HEIGHT = 500;
        Thread th;
        Ball myBall1;
        Ball myBall2;
        private boolean enable = true;
        private int counter = 0;
        private Random random = new Random();

        FFrame() {
            th = new Thread(this);
            th.start();
        }

        @Override
        public void run() {
            int r1 = random.nextInt(40) + 40; // ball1の半径
            int r2 = random.nextInt(40) + 80; // ball2の半径
            int x1 = random.nextInt(WIDTH - r1) + r1; // ball1のxの初期値
            int x2 = random.nextInt(WIDTH - r2) + r2; // ball2のxの初期値
            int y1 = random.nextInt(HEIGHT - r1) + r1; // ball1のyの初期値
            int y2 = random.nextInt(HEIGHT - r2) + r2; // ball2のyの初期値

            myBall1 = new Ball(x1, y1, r1, Color.RED);
            myBall2 = new Ball(x2, y2, r2, Color.GREEN);

            while (enable) {
                try {
                    Thread.sleep(10);
                    counter++;
                    if (counter >= 2000) {
                        enable = false;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                myBall1.move(getWidth(), getHeight());
                myBall2.move(getWidth(), getHeight());

                repaint();
            }
        }

        @Override
        public void paint(Graphics g) {
            myBall1.draw(g);
            myBall2.draw(g);

            g.setColor(Color.BLACK);
            g.drawString("Count: " + counter, 10, 40);
        }

        public void adjustBalls() {
            if (myBall1 != null && myBall2 != null) {
                myBall1.adjustPosition(getWidth(), getHeight());
                myBall2.adjustPosition(getWidth(), getHeight());
            }
        }

        class Ball {
            int x;
            int y;
            int r; // 半径
            Color c; // カラー
            double xDir = 7; // x加速度
            double yDir = 3; // y加速度
            double reboundFactor = 0.93; // 反発係数
            double gravity = 9.8 / 10; // 重力

            Ball(int x, int y, int r, Color c) {
                this.x = x;
                this.y = y;
                this.r = r;
                this.c = c;

                Random random = new Random();
                this.xDir = random.nextInt(20) + 5; // 2から7（両端含む）のランダムな整数を生成します
                this.yDir = random.nextInt(20) + 5;
            }

            public void draw(Graphics g) {
                g.setColor(c);
                g.fillOval(x - r, y - r, 2 * r, 2 * r); // 直径で描画するために半径を2倍
            }

            public void move(int width, int height) {
                x += xDir;
                yDir += gravity;
                y += yDir;

                if (x + r > width) {
                    xDir = -xDir * reboundFactor;
                    x = width - r;
                } else if (x - r < 0) {
                    xDir = -xDir * reboundFactor;
                    x = 0 + r;
                }

                if (y + r > height) {
                    yDir = -yDir * reboundFactor;
                    y = height - r;
                } else if (y - r < 0) {
                    yDir = -yDir * reboundFactor;
                    y = 0 + r;
                }
            }

            public void adjustPosition(int width, int height) {
                if (x + r > width) {
                    x = width - r;
                }
                if (y + r > height) {
                    y = height - r;
                }
            }
        }
    }
}