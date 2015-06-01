package es.uva.inf.kave.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

import java.util.ArrayList;

import es.uva.inf.kave.myapplication.Auxiliares.Datos;
import es.uva.inf.kave.myapplication.Auxiliares.Operacion;
import es.uva.inf.kave.myapplication.Auxiliares.Regresion;

/**
 * Created by Lucas on 27/05/15.
 */
public class Activity_Resultado extends Activity{

    private TextView pendiente, errorPendiente, ordenada, errorOrdenada, correlacion,rx1,rx2;
    private TextView encabezado1, encabezado2, rteo1, rteo2, asig1, asig2, ohm1, ohm2, mas2;
    private TextView campo1, campo2, campo3, campo4, campo5;
    private ArrayList<Datos> datos;
    private int ejercicio;
    private Regresion regresion;
    private double tmp;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado);

        datos = (ArrayList<Datos>) getIntent().getSerializableExtra("array");
        ejercicio = getIntent().getIntExtra("ejercicio",1);
        pendiente = (TextView) findViewById(R.id.pendiente);
        errorPendiente = (TextView) findViewById(R.id.errorPendiente);
        ordenada = (TextView) findViewById(R.id.ordenada);
        errorOrdenada = (TextView) findViewById(R.id.errorOrdenada);
        correlacion = (TextView) findViewById(R.id.correlacion);
        rx1 = (TextView) findViewById(R.id.rx1);
        rx2 = (TextView) findViewById(R.id.rx2);
        rteo1 = (TextView) findViewById(R.id.rteo1);
        rteo2 = (TextView) findViewById(R.id.rteo2);
        asig1 = (TextView) findViewById(R.id.asig1);
        asig2 = (TextView) findViewById(R.id.asig2);
        mas2 = (TextView) findViewById(R.id.mas2);
        ohm1 = (TextView) findViewById(R.id.ohm1);
        ohm2 = (TextView) findViewById(R.id.ohm2);
        encabezado1 = (TextView) findViewById(R.id.encabezado1);
        encabezado2 = (TextView) findViewById(R.id.encabezado2);
        campo1 = (TextView) findViewById(R.id.campo1);
        campo2 = (TextView) findViewById(R.id.campo2);
        campo3 = (TextView) findViewById(R.id.campo3);
        campo4 = (TextView) findViewById(R.id.campo4);
        campo5 = (TextView) findViewById(R.id.campo5);

        switch (ejercicio){
            case 1:
                rteo1.setText("");
                rteo2.setText("");
                encabezado2.setText("");
                ohm2.setText("");
                mas2.setText("");
                asig2.setText("");
                regresion = new Regresion(datos);
                regresion.lineal();
                pendiente.setText(""+regresion.a);
                ordenada.setText(""+regresion.b);
                correlacion.setText(""+regresion.correlacion());
                rx1.setText(""+regresion.a);
                tmp = regresion.errorPendiente();
                rx2.setText(""+tmp);
                errorPendiente.setText(""+tmp);
                errorOrdenada.setText(""+regresion.errorOrdenada());
                break;
            case 2:
                regresion = new Regresion(datos);
                regresion.lineal();
                pendiente.setText(""+regresion.a);
                ordenada.setText(""+regresion.b);
                correlacion.setText(""+regresion.correlacion());
                rx1.setText(""+regresion.a);
                tmp = regresion.errorPendiente();
                rx2.setText(""+tmp);
                errorPendiente.setText(""+tmp);
                errorOrdenada.setText(""+regresion.errorOrdenada());
                rteo1.setText(""+Operacion.requivalente(datos.get(0).getDoubleR1(), datos.get(0).getDoubleR2(), datos.get(0).getDoubleR3(), datos.get(0).getDoubleR4(), datos.get(0).getDoubleR5()));
                rteo2.setText(""+Regresion.error);
                break;
            case 3:
                regresion = new Regresion(datos);
                regresion.lineal();
                encabezado2.setText("Resistencia de la Bombilla a T_Ambiente:");
                asig2.setText("R_bombilla = ");
                campo1.setText("R0 = ");
                campo2.setText("Error de R0 = ");
                campo3.setText("Error de R = ");
                campo4.setText("Error de T = ");
                asig1.setText("T_ambiente =");
                ohm1.setText("ºC");
                campo5.setText("");
                encabezado1.setText("Tempertura Ambiente:");
                correlacion.setText("");
                //Meter valo R0 en campo pendiente // Error R0 en error pendiente // error R en ordenada // error T en error ordenada
                pendiente.setText(""+ Operacion.rcero(datos));
                errorPendiente.setText(""+Operacion.errorRcero(datos));
                double mediaTmp = Operacion.mediaTemp(datos);
                rx1.setText(""+mediaTmp);
                rx2.setText(Operacion.errorMedida(mediaTmp));
                rteo1.setText(""+regresion.a);
                rteo2.setText(""+regresion.errorPendiente());
                ordenada.setText(""+regresion.errorPendiente());
                errorOrdenada.setText(Operacion.errorMedida(mediaTmp));
                break;
        }
    }
}