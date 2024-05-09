import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyExceptionHoliday {

	public static void main(String[] args) {
		MyExceptionHoliday myE = new MyExceptionHoliday();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			try {
				System.out.println("以下に日付を入力してください");
				String str = reader.readLine();
				int date = Integer.parseInt(str);
				myE.test(date);
			} catch (NumberFormatException e) {
				System.out.println("数値を入力してください。");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NoHolidayException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	void test(int date) throws NoHolidayException {
		if (notHoliday(date)) {
			throw new NoHolidayException("平日です。");
		}
		System.out.println("休日です。");
	}

	boolean notHoliday(int date) {
		return (date >= 1 && date <= 2) ||
				(date >= 7 && date <= 10) ||
				(date >= 13 && date <= 17) ||
				(date >= 20 && date <= 24) ||
				(date >= 27 && date <= 31);
	}
}

class NoHolidayException extends Exception {
	public NoHolidayException(String message) {
		super(message);
	}
}