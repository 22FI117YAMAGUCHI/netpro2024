import java.util.Scanner;

public class Calc2Scanner {

	public static void main(String[] args) {
		int i=0;
        int first,second;
		while(i<10) {//10回繰り返す
			Scanner scan = new Scanner(System.in);

			String str = scan.next();
			System.out.println("最初のトークンは: " + str);
            first = Integer.parseInt(str);

			str = scan.next();
			System.out.println("次のトークンは  : " + str);
            second = Integer.parseInt(str);
			i++;

            System.out.println("合計は  : " + (first + second));
            System.out.println("----次の数字の入力をお願いします ");
		}
	}
}