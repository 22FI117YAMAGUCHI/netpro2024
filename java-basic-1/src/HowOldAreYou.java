
// C言語では、#include に相当する
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HowOldAreYou {

	public static void main(String[] args) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader というのは、データ読み込みのクラス(型)
		// クラスの変数を作るには、new を使う。

		// readLine() は、入出力エラーの可能性がある。エラー処理がないとコンパイルできない。
		// Java では、 try{ XXXXXXXX } catch(エラーの型 変数) { XXXXXXXXXXXXXXXXXX} と書く
		try {
			while (true) { // 入力がq,eの場合は終了。それ以外は繰り返し入力を行う。
				System.out.println("何歳ですか?");
				String line = reader.readLine();

				// 入力がq,eの場合は終了
				if (line.equals("q") || line.equals("e")) {
					System.out.println("終了しました。");
					break;
				}

				int age = Integer.parseInt(line);

				// 入力した現在の年齢がマイナスおよび120歳以上の場合は再入力を促す。
				if (age > 120 || age < 1) {
					System.out.println("再入力してください。");
					continue;
				}

				System.out.println("あなたは" + age + "歳です。");
				System.out.println("あなたは10年後、" + (age + 10) + "歳です。");

				// 誕生年から元号を表示する
				int birthYear = 2024 - age;
				String era = getEra(birthYear);
				System.out.println("あなたが誕生した年の元号は" + era + "年です。");
				System.out.println();
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	// 西暦から元号への変換
	public static String getEra(int year) {
		if (year >= 2019) {
			return "令和" + (year - 2018);
		} else if (year >= 1989) {
			return "平成" + (year - 1988);
		} else if (year >= 1926) {
			return "昭和" + (year - 1925);
		} else if (year >= 1912) {
			return "大正" + (year - 1911);
		} else {
			return "明治" + (year - 1867);
		}
	}
}