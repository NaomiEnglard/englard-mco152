package englard.math;

public class QuadraticEquation {

	private double a;
	private double b;
	private double c;

	public QuadraticEquation(double a, double b, double c) throws InvalidInputException {
		// if a == 0 then it is not a quadratic bx + c = 0, solve for x.
		// bx = 0-c, x = (0-c)/b
		// if b ==0 then use regular formula to solve not quadratic axx + c = 0.
		// axx = 0-c, xx = (0-c)/a, x = Math.sqrt((0-c)/a)
		if (a == 0 || b == 0) {
			throw new InvalidInputException();
		}
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double getPositiveX() {
		return (-b + Math.sqrt(b * b - (4 * a * c))) / (2 * a);
	}

	public double getNegativeX() {
		return (-b - Math.sqrt(b * b - (4 * a * c))) / (2 * a);
	}
}
