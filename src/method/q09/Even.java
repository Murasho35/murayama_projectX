package method.q09;

public class Even {
	public static void main(String[] args) {
		checkEven(10);

	}

	public static String checkEven(int num) {

		String result = null;

		if (num % 2 == 0) {
			System.out.println(num + "は偶数です。");
			result = "true";
		}

		else {
			System.out.println(num + "は奇数です。");
			result = "false";
		}

		return result;

	}
}
