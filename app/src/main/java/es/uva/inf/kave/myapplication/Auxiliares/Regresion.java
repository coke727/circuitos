package es.uva.inf.kave.myapplication.Auxiliares;

import java.util.ArrayList;
import es.uva.inf.kave.myapplication.Auxiliares.Datos;

public class Regresion {
    public static final double error = 0.001;
    private ArrayList<Datos> x;
    private int n;          //numero de datos
    public double a, b;    //pendiente y ordenada en el origen

    public Regresion(ArrayList<Datos> x) {
        this.x=x;
        n=x.size(); //numero de datos
    }

    public void lineal(){
        double pxy, sx, sy, sx2, sy2;
        pxy=sx=sy=sx2=sy2=0.0;
        double tmpx,tmpy;
        for(int i=0; i<n; i++){
            tmpx = x.get(i).getDoubleV1();
            tmpy = x.get(i).getDoubleA1();
            sx+=tmpx;
            sy+=tmpy;
            sx2+=tmpx*tmpx;
            sy2+=tmpy*tmpy;
            pxy+=tmpx*tmpy;
        }
        b=(n*pxy-sx*sy)/(n*sx2-sx*sx);
        a=(sy-b*sx)/n;
    }

    public double correlacion(){

//valores medios
        double suma=0.0;
        for(int i=0; i<n; i++){
            suma+=x.get(i).getDoubleV1();;
        }
        double mediaX=suma/n;

        suma=0.0;
        for(int i=0; i<n; i++){
            suma+=x.get(i).getDoubleV1();;
        }
        double mediaY=suma/n;
//coeficiente de correlacion
        double pxy, sx2, sy2;
        pxy=sx2=sy2=0.0;
        for(int i=0; i<n; i++){
            double tmpx = x.get(i).getDoubleV1();
            double tmpy = x.get(i).getDoubleA1();
            pxy+=(tmpx-mediaX)*(tmpy-mediaY);
            sx2+=(tmpx-mediaX)*(tmpx-mediaX);
            sy2+=(tmpy-mediaY)*(tmpy-mediaY);
        }
        return pxy/Math.sqrt(sx2*sy2);
    }

    public double errorPendiente(){
        double num = Math.sqrt(n)*error;
        double denom;
        double sum = 0;
        double sum2 = 0;
        for(int i=0; i<n;i++){
            sum = sum + (x.get(i).getDoubleV1()*x.get(i).getDoubleV1());
            sum2 = sum2 + x.get(i).getDoubleV1();
        }

        sum2 = sum2*sum2;
        sum = n*sum;
        denom = Math.sqrt(sum-sum2);
        return num/denom;
    }

    public double errorOrdenada(){
        return error/Math.sqrt(n);
    }
}

