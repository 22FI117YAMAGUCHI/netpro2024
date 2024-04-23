import java.util.Random;

public class NetproLabMember {
    public static final int years = 15; // [15年分]
    public static final int columns = 3; // [学生総数、女子学生の割合、岩井研の配属人数]

    public static void main(String[] args) {
        int tduStudent = 110; // TDUの学生総数
        int iwaiKenStudent = 10; // 岩井研の配属人数
        double tduGirlsRate = 0.2; // 女子学生の割合20%

        Random random = new Random();

        // 2次元配列の作成
        int[][] hairetu = new int[years][columns];

        for (int i = 0; i < years; i++) {
            // 学生総数の推移
            tduStudent += random.nextInt(20) - 10; // +-10人でランダム性を持って推移
            // 女子学生の割合の推移
            tduGirlsRate += 0.01; // 毎年1%上昇
            // 岩井研の配属人数の推移
            iwaiKenStudent += random.nextInt(6) - 3; // +-3人のランダム性で推移

            hairetu[i][0] = tduStudent; // 年ごとの学生総数
            hairetu[i][1] = (int) tduGirlsRate; // 年ごとの女子学生の割合
            hairetu[i][2] = iwaiKenStudent; // 年ごとの岩井研の配属人数

            // 岩井研に来る学生が女子学生である確率を計算
            double girlsRate = tduGirlsRate;
            double notProbabilityGirls = 1.0;
            for (int j = 0; j < iwaiKenStudent; j++) {
                notProbabilityGirls *= (1 - girlsRate);
            }
            System.out.println((i + 1) + "年目は" + notProbabilityGirls + " の確率で岩井研に女子学生が来ない");
        }
    }
}
