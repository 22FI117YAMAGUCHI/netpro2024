import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class HeikinCKadai {
    public static void main(String[] args) {

        int num = 0; // 合計点
        Random random = new Random();

        // Kamokuオブジェクトの配列を作成し、100人の学生の数学の点数をランダムに生成
        Kamoku[] math = new Kamoku[100];

        for (int i = 0; i < math.length; i++) {
            int score = random.nextInt(101); // 0から100までのランダムな整数を生成
            math[i] = new Kamoku(i + 1, score);
        }

        // 点数を配列にコピーし、点数を合計
        int[] scoreHairetsu = new int[math.length];
        for (int i = 0; i < math.length; i++) {
            scoreHairetsu[i] = math[i].getScore();
            num += scoreHairetsu[i];
        }

        // 平均点を計算
        double averageScore = (double) num / math.length;

        // 平均点を出力
        System.out.println("数学の平均点は" + averageScore + "です");

        // 合格者一覧をだしましょう

        int requiredScore = 80; // 合格点

        // 80点以上の学生を抽出
        ArrayList<Kamoku> passingScoreStudent = new ArrayList<>();
        for (Kamoku passingStudent : math) {
            if (passingStudent.getScore() >= requiredScore) {
                passingScoreStudent.add(passingStudent);
            }
        }

        // 80点以上の学生のみからなる配列を作成
        Kamoku[] passingStudentHairetsu = passingScoreStudent.toArray(new Kamoku[0]);

        // 昇順にソート
        Arrays.sort(passingStudentHairetsu, Comparator.comparingInt(Kamoku::getScore));

        // 学籍番号と点数を出力
        System.out.println("点数と学生番号の両方を、「合格者の点数」で昇順でソートして出力:");
        for (Kamoku passingStudent : passingStudentHairetsu) {
            System.out.println("学籍番号：22FI" + String.format("%03d", passingStudent.getStudentID()) + " の点数は"
                    + passingStudent.getScore() + "点です。");
        }
    }
}