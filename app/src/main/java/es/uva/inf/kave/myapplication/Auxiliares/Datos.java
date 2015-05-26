package es.uva.inf.kave.myapplication.Auxiliares;

public class Datos {

	private String v3;
	private String v2;
	private String v1;
	private String r3;
	private String r2;
	private String r1;

	public Datos(String r1, String r2, String r3, String v1, String v2, String v3) {
		this.r1 = r1;
		this.r2 = r2;
		this.r3 = r3;
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
	}

	public String getV3() {
		return v3;
	}

	public String getV2() {
		return v2;
	}

	public String getV1() {
		return v1;
	}

	public String getR3() {
		return r3;
	}

	public String getR2() {
		return r2;
	}

	public String getR1() {
		return r1;
	}
}
