package es.uva.inf.kave.myapplication.Auxiliares;


/**
 * Deficion de pracitica de fisica sobre Leh de Ohm.
 */
 public class Operacion {

    final double alfa = 0.0046;



    /**
     * Calcula la resitencia de un circuito electrico a partir de la Intensidad
     * y la diferencia de potencial
     * @param intensidad
     * @param potencial
     * @return resistencia.....
     */
    public double resistencia( double intensidad, double potencial){
        return potencial/intensidad;
    }

    public double rcero(double resistencia, double tempAmbiente){
        return resistencia/(1+ (alfa * tempAmbiente));
    }

    /**
     * Calcula la resistencia equivalente de un circuito electrico mixto
     * con 5 resistencias.
     * @param r1
     * @param r2
     * @param r3
     * @param r4
     * @param r5
     * @return resistencia equivalente del circuito mixto.
     */
    public double requivalente(double r1, double r2, double r3, double r4, double r5){
        return Math.pow(1/ (r1 + r2 + r3) + (1/(r4 + r5)),-1);

    }

    /**
     * Calcula el error absoluto de R0. Fijamos el error de medidas directas de las resistencias
     * en +- 0.01 y el de temperatura ambiente en +- 1.
     * @param resistencia
     * @param temperatura
     * @return
     */
    public double errorRcero (double resistencia, double temperatura){
        double errorR, errorT;
        // TODO Corregir los errores, E resistencia y E termometro
        errorR = 1/(1+(alfa * temperatura)) * 0.001;
        errorT = ((resistencia * alfa) / Math.pow((1+alfa * temperatura),2)) * 1;
        return errorR + errorT;
    }


}
