package es.uva.inf.kave.myapplication.Auxiliares;

import java.io.Serializable;

public class Datos implements Serializable {

	private String v3, v2, v1;
    private String r5, r4, r3, r2, r1;

	public Datos(String r1, String v1) {
		this.r1 = r1;
		this.v1 = v1;
	}

	public Datos(String r1, String r2, String v1, String v2) {
		this.r1 = r1;
		this.r2 = r2;
		this.v1 = v1;
		this.v2 = v2;
	}

	public Datos(String r1, String r2, String r3, String r4, String r5, String v1, String v2) {
		this.r1 = r1;
		this.r2 = r2;
		this.r3 = r3;
		this.r4 = r4;
		this.r5 = r5;
		this.v1 = v1;
		this.v2 = v2;
	}

	public String getV2() { return v2; }

	public String getV1() { return v1; }

	public String getR2() { return r2; }

	public String getR1() { return r1; }

	public Double getDoubleV1() { return Double.parseDouble(v1); }

	public Double getDoubleR1() { return Double.parseDouble(r1); }

	public Double getDoubleV2() { return Double.parseDouble(v2); }

	public Double getDoubleR2() { return Double.parseDouble(r2); }

	public Double getDoubleR3() { return Double.parseDouble(r3); }

	public Double getDoubleR4() { return Double.parseDouble(r4); }

	public Double getDoubleR5() { return Double.parseDouble(r4); }
}
