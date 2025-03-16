package method.q10;

import java.util.Arrays;

public class EvenNumber {
	public static void main(String[] args) {

		int hairetu[] = { 3, 2, 5, 6, 7, 25, 10, 51, 88, 98 };

		int count = getEvenNumbers(hairetu);

		System.out.print(Arrays.toString(hairetu));

		System.out.print("には、偶数が" + count + "個あります。");

	}

	public static int getEvenNumbers(int hairetu[]) {
		// TODO 自動生成されたメソッド・スタブ

		int count = 0;
		for (int i = 0; i < 10; i++) {
			if (hairetu[i] % 2 == 0) {

				count = count + 1;

			}

		}

		return count;

	}
}
