package es.uva.inf.kave.myapplication.Auxiliares;


import java.util.ArrayList;
import org.apache.commons.*;
/**
 * Deficion de pracitica de fisica sobre Leh de Ohm.
 */
 public class Operacion {

    final static double alfa = 0.0046;

    /**
     * Calcula la resitencia de un circuito electrico a partir de la Intensidad
     * y la diferencia de potencial
     * @param intensidad
     * @param potencial
     * @return resistencia.....
     */
    public static double resistencia( double intensidad, double potencial){
        return potencial/intensidad;
    }

    public static double resistencia(ArrayList<Datos> datos){
        double sumatorio = 0 ;
        int size = datos.size();
        for(int i = 0; i<size;i++){
            sumatorio = sumatorio + resistencia(datos.get(i).getDoubleR1(), datos.get(i).getDoubleV1());
        }
        return sumatorio/datos.size();
    }

    public static double rcero(double resistencia, double tempAmbiente){
        return resistencia/(1+ (alfa * tempAmbiente));
    }

    public static double rcero(ArrayList<Datos> datos){
        double sumatorio = 0 ;
        int size = datos.size();
        for(int i = 0; i<size;i++){
            sumatorio = sumatorio + rcero(datos.get(i).getDoubleR1(), datos.get(i).getDoubleR2());
        }
        return sumatorio/datos.size();
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
    public static double requivalente(double r1, double r2, double r3, double r4, double r5){
        return Math.pow(1/ (r1 + r2 + r3) + (1/(r4 + r5)),-1);

    }

    /**
     * Calcula el error absoluto de R0. Fijamos el error de medidas directas de las resistencias
     * en +- 0.01 y el de temperatura ambiente en +- 1.
     * @param resistencia
     * @param temperatura
     * @return
     */
    public static double errorRcero (double resistencia, double temperatura){
        double errorR, errorT;
        // TODO Corregir los errores, E resistencia y E termometro
        errorR = 1/(1+(alfa * temperatura)) * 0.001;
        errorT = ((resistencia * alfa) / Math.pow((1+alfa * temperatura),2)) * 1;
        return errorR + errorT;
    }

    public static double errorRcero(ArrayList<Datos> datos){
        double sumatorio = 0 ;
        int size = datos.size();
        for(int i = 0; i<size;i++){
            sumatorio = sumatorio + errorRcero(datos.get(i).getDoubleR1(),datos.get(i).getDoubleR2());
        }
        return sumatorio/datos.size();
    }

    public static double mediaTemp(ArrayList<Datos> datos){
        double sumatorio = 0 ;
        int size = datos.size();
        for(int i = 0; i<size;i++){
            sumatorio = sumatorio + datos.get(i).getDoubleR2();
        }
        return sumatorio/datos.size();
    }

    public static String errorMedida(double num){
        Double d = num;
        String[] splitter = d.toString().split("\\.");
        int decim = splitter[1].length();
        String error = "0.";
        for(int i = 0; i<decim; i++){
            error = error + "0";
        }
        error = error + "1";

        return error;
    }

    public static


}
