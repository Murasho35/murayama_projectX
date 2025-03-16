package method.q09;

public class Even {
	public static void main(String[] args) {

		int num = 5;

		String result = checkEven(num);

		if (result.equals("true")) {
			System.out.println(num + "は偶数です。");
		} else {
			System.out.println(num + "は奇数です。");
		}
	}

	public static String checkEven(int i) {

		String result = null;

		if (i % 2 == 0) {

			result = "true";
		}

		else {

			result = "false";
		}

		return result;

	}
}
