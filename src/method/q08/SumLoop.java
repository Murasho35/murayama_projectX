package method.q08;

public class SumLoop {
	public static void main(String[] args) {
		sumLoop(1, 100);

	}

	public static int sumLoop(int min, int max) {

		System.out.println("最小値:" + min);
		System.out.println("最大値:" + max);

		int sum = 0;
		for (int i = min; i <= max; i++) {
			sum = sum + i;
		}

		System.out.println("加算結果:" + sum);

		return sum;

	}
}
