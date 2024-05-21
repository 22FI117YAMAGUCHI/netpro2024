public class DinnerFullCourse {

	private Dish[] list = new Dish[5];// [0]-[4]の計5個

	public static void main(String[] args) {

		DinnerFullCourse fullcourse = new DinnerFullCourse();
		fullcourse.eatAll();
	}

	DinnerFullCourse() {

		list[0] = new Dish();
		list[0].setName("枝豆");
		list[0].setValune(120);

		list[1] = new Dish();
		list[1].setName("マグロの刺身");
		list[1].setValune(650);

		list[2] = new Dish();
		list[2].setName("野菜スティック");
		list[2].setValune(330);

		list[3] = new Dish();
		list[3].setName("サーろうぃんステーキ");
		list[3].setValune(2290);

		list[4] = new Dish();
		list[4].setName("チャーハン");
		list[4].setValune(440);
	}

	void eatAll() {
		int total = 0;
		System.out.print("ご注文の品は");
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i].getName());
			total += list[i].getValune();
			if (i < list.length - 1) {
				System.out.print("、");
			}
		}
		System.out.println("の" + list.length + "点で合計" + total + "円です。");

	}

}