package method.q04;

public class SumNumbers {

	public static void main(String[] args) {
		calculateSum(3, 2);

	}

	public static int calculateSum(int num1, int num2) {

		System.out.println("第一引数:" + num1);
		System.out.println("第二引数:" + num2);
		System.out.println("加算結果:" + (num1 + num2));

		return num1 + num2;

	}

}
