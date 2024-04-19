
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
			System.out.println("何歳ですか?");
			String line = reader.readLine();
			int age = Integer.parseInt(line);
			System.out.println("あなたは" + age + "歳ですね。");
			System.out.println("あなたは10年後、" + (age + 10) + "歳ですね。");

			// 誕生年から元号を表示する
			int birthYear = 2024 - age;
			String era = getEra(birthYear);
			System.out.println("あなたが誕生した年の元号は" + era + "年です。");
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