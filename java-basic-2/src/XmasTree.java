

import java.util.Scanner;

public class XmasTree {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("最大の葉の半分の横幅の数,幹の幅,幹の長さ,雪の形を指定してください。");
        System.out.println("また文字を「,」で分割してください。入力例：19,3,7,c");
        System.out.println("以下に入力してください。");

        String str = scan.next();
        String[] word = str.split(",");

        int leaves = Integer.parseInt(word[0]); //最大の葉の半分の横幅の数
        int stemWidth = Integer.parseInt(word[1]); //幹の幅
        int stemHeight = Integer.parseInt(word[2]); //幹の長さ
        String snow = word[3]; //雪の形

        drawXmasTree(leaves, stemWidth, stemHeight, snow);
    }

    //木を描写
    public static void drawXmasTree(int N, int stemWidth, int stemHeight, String snow) {

        // 上部分を描写
        for (int j = 0; j < N; j++) {
            // 左の雪
            for (int i = 0; i < N - j; i++) {
                if ((i + j) % 2 == 0) {
                    System.out.print(snow);
                } else {
                    System.out.print(" ");
                }
            }

            // 葉部分
            for (int i = 0; i <= j * 2; i++) {
                System.out.print("*");
            }

            // 右の雪
            System.out.print(" ");
            for (int i = 0; i < N - j; i++) {
                if (i % 2 == 0) {
                    System.out.print(snow);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }

        // 幹部分
        for (int i = 0; i < stemHeight; i++) {
            for (int j = 0; j < N - stemWidth/2; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < stemWidth; k++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}