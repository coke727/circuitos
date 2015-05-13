package es.uva.inf.kave.myapplication;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Medida {

	protected double valor1;
	protected double valor2;
	protected double valorIc;
	protected int apartado;
	
	/**
	 * Creador de una medida realizada para los apartados 2 y 3.
	 * @param valor1 Distancia de medida.
	 * @param valor2 Campo magnético resultante en el punto.
	 */
	public Medida(double valor1, double valor2) {
		super();
		this.valor1 = valor1;
		this.valor2 = valor2;
		this.apartado = 2;
	}
	/**
	 * Constructor de Medida realizada en el apartado 1.
	 * @param valor1 Valor de la intensidad marcado por la pinza amperimétrica reductora (mA).
	 * @param valor2 Campo magnético calculado en el punto (mT).
	 * @param valorIc Valor de la intensidad real que pasa por el circuito (A).
	 */
	public Medida(double valor1, double valor2, double valorIc) {
		super();
		this.valor1 = valor1;
		this.valor2 = valor2;
		this.valorIc = valorIc;
		this.apartado = 1;
	}
	/**
	 * Devuelve el array con la medida.
	 * @return Array de doubles con 2 ó 3 valores, dependiendo del apartado.
	 */
	public double[] get(){
			BigDecimal res ,res2 = new BigDecimal(valor2);
			res2.setScale(4, RoundingMode.HALF_EVEN);
		if(apartado == 2){
			double result[] = new double[2];
			res = new BigDecimal(valor1);
			res = res.multiply(new BigDecimal(100)); //valor en centimetros
			res.setScale(2, RoundingMode.HALF_EVEN);
			result[0] = res.doubleValue();
			result[1] = res2.doubleValue();
			return result;
		}else{
			double result[] = new double[3];
			result[0] = valor1;
			result[1] = res2.doubleValue();
			result[2] = valorIc;
			return result;
		}
	}
	/**
	 * Devolverá el valor de la distancia o la corriente dependiendo del apartado
	 * de la medida
	 * @return Un double con: la distancia del punto de medicion en el apartado1, e intensidad en el apartado 2 ó 3
	 */
	public double getValor1() {
		BigDecimal res = new BigDecimal(valor1);
		if(apartado==2){
			res.setScale(2, RoundingMode.HALF_EVEN);
			res = res.multiply(new BigDecimal(100)); //valor en centimetros
			res.setScale(2, RoundingMode.HALF_EVEN);
			//float aux = res.floatValue();
			return res.floatValue(); //Devuelve el valor en centimetros
		}
		return valor1;
	}
	/**
	 * Devolverá el valor del Campo calculado.
	 * @return Un valor double con el valor del campo correspondiente (mT) 
	 */
	public double getValor2() {
		BigDecimal res2 = new BigDecimal(valor2);
		res2 = res2.setScale(4, RoundingMode.HALF_EVEN);
		return res2.doubleValue();
	}
	
	/**
	 * Apartado al que corresponde la Medida.
	 * @return Apartado de la medida, valor de 1 a 3.
	 */
	public double get_apartado(){
		return apartado;
	}
	/**
	 * Devuelve el valor de la corriente en Amperios
	 * @requiere Si el apartado es 1, devuelve valor, sino devuelve null.
	 */
	public Double getValorIc() {
		if(this.apartado ==1){
			return valorIc;
		}
		return null;
	}

}
