package englard.math;

public class PythagoreanTheorem {
	private double a;
	private double b;
	private double c;

	public PythagoreanTheorem() {
		this.a = 0.0;
		this.b = 0.0;
		this.c = 0.0;
	}

	/**
	 * Sets the value of A and B and computes C
	 */
	public void setAB(double a, double b) {
		this.a = a;
		this.b = b;
		this.c = Math.sqrt((a * a) + (b * b));

	}

	/**
	 * Sets the value of A and C and computes B
	 */
	public void setAC(double a, double c) {
		this.a = a;
		this.c = c;
		this.b = Math.sqrt((c * c) - (a * a));
	}

	/**
	 * Sets the value of B and C and computes A
	 */
	public void setBC(double b, double c) {
		this.b = b;
		this.c = c;
		this.a = Math.sqrt((c * c) - (b * b));
	}

	public double getA() throws InvalidDataException {
		if (a == 0.0) {
			throw new InvalidDataException();
		}
		return a;
	}

	public double getB() throws InvalidDataException {
		if (b == 0.0) {
			throw new InvalidDataException();
		}
		return b;
	}

	public double getC() throws InvalidDataException {
		if (c == 0.0) {
			throw new InvalidDataException();
		}
		return c;
	}
}
