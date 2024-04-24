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
        double notProbabilityGirls15Years = 1.0; // 15年間の女子学生が来ない確率

        for (int i = 0; i < years; i++) {
            // 学生総数の推移
            tduStudent += random.nextInt(20) - 10; // +-10人でランダム性を持って推移
            // 女子学生の割合の推移
            tduGirlsRate += 0.01; // 毎年1%上昇
            // 岩井研の配属人数の推移
            iwaiKenStudent += random.nextInt(6) - 3; // +-3人のランダム性で推移

            hairetu[i][0] = tduStudent; // 年ごとの学生総数
            hairetu[i][1] = (int) (tduGirlsRate * 100); // 年ごとの女子学生の割合（割合をパーセンテージに変換）
            hairetu[i][2] = iwaiKenStudent; // 年ごとの岩井研の配属人数

            double notProbabilityGirlsYear = 1.0; // その年の女子学生が来ない確率

            for (int j = 0; j < hairetu[i][2]; j++) {
                int girls = hairetu[i][0] * hairetu[i][1] / 100; // その年の女子学生の人数
                int mens = hairetu[i][0] - girls; // その年の男子学生の人数

                // 選ばれた人が男子学生である確率
                double maleOnlyProbability = (double) mens / hairetu[i][0];

                notProbabilityGirlsYear *= maleOnlyProbability;

                // その年の男子学生の数を1人減らす。
                mens -= 1;
            }

            // 15年間ずっと男性しか選べない確率を更新
            notProbabilityGirls15Years *= notProbabilityGirlsYear;
        }
        System.out.println("15年間岩井研に女子学生が来ない確率：" + notProbabilityGirls15Years);
    }
}