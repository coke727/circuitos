package es.uva.inf.kave.myapplication.Auxiliares;

import java.io.Serializable;

public class Datos implements Serializable {

	private String t1, v1, a1;
    private String r5, r4, r3, r2, r1;

	public Datos(String a1, String v1) {
		this.a1 = a1;
		this.v1 = v1;
	}

	public Datos(String r1, String t1, String a1, String v1) {
		this.r1 = r1;
		this.t1 = t1;
		this.a1 = a1;
		this.v1 = v1;
	}

	public Datos(String r1, String r2, String r3, String r4, String r5, String v1, String a1) {
		this.r1 = r1;
		this.r2 = r2;
		this.r3 = r3;
		this.r4 = r4;
		this.r5 = r5;
		this.v1 = v1;
		this.a1 = a1;
	}

	public String getT1() { return t1; }

	public String getV1() { return v1; }

	public String getA1() { return a1; }

	public String getR1() { return r1; }

	public Double getDoubleV1() { return Double.parseDouble(v1); }

	public Double getDoubleA1() { return Double.parseDouble(a1); }

	public Double getDoubleT1() { return Double.parseDouble(t1); }

	public Double getDoubleR1() { return Double.parseDouble(r1); }

	public Double getDoubleR2() { return Double.parseDouble(r2); }

	public Double getDoubleR3() { return Double.parseDouble(r3); }

	public Double getDoubleR4() { return Double.parseDouble(r4); }

	public Double getDoubleR5() { return Double.parseDouble(r5); }
}
