package method.q06;

public class Circle {
	public static void main(String[] args) {

		double r = 5.0;

		double area = getCircleArea(5.0);

		System.out.println("半径:" + r);
		System.out.println("円の面積:" + area);

	}

	public static double getCircleArea(double r) {

		double area = r * r * 3.14;

		return area;
	}
}
