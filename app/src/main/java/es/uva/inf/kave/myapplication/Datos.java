package es.uva.inf.kave.myapplication;

public class Datos {

	private double v3;
	private double v2;
	private double v1;
	private double r3;
	private double r2;
	private double r1;

	public Datos(double r1, double r2, double r3, double v1, double v2, double v3) {
		this.r1 = r1;
		this.r2 = r2;
		this.r3 = r3;
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
	}

	public double getV3() {
		return v3;
	}

	public double getV2() {
		return v2;
	}

	public double getV1() {
		return v1;
	}

	public double getR3() {
		return r3;
	}

	public double getR2() {
		return r2;
	}

	public double getR1() {
		return r1;
	}
}
