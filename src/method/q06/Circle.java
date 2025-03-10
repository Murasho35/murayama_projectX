package method.q06;

public class Circle {
	public static void main(String[] args) {
		getCircleArea(5.0);

	}

	public static double getCircleArea(double r) {

		double area = r * r * 3.14;

		System.out.println("半径:" + r);
		System.out.println("円の面積:" + area);

		return area;
	}
}
