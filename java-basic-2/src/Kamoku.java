
class Kamoku {
	String name;
	int score;
	private int studentID;

	Kamoku(int id, int s) { // これがコンストラクタ。特殊なメソッド。クラス名と同じ。
		studentID = id;
		score = s;
	}

	// setScore というメソッドを定義する。
	// score に値を設定する。
	public void setScore(int num) {
		score = num;
	}

	// getScore というメソッドを定義する。
	// scoreを返す。
	public int getScore() {
		return score;
	}

	// getScore というメソッドを定義する。
	// scoreを返す。
	public int getStudentID() {
		return studentID;
	}
}

// メソッド 関数のこと
// public 返り値(戻り値return value) 関数名() {
// 中に具体的な処理を書く
// }