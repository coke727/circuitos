package es.uva.inf.kave.myapplication;

/**
 * Created by coke on 12/05/15.
 */

import es.uva.inf.kave.myapplication.Datos;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Simulador extends Fragment{

    private EditText r1;
    private EditText r2;
    private EditText r3;
    private EditText v1;
    private EditText v2;
    private EditText v3;
    private Button medir;
    private Button deshacer;
    private Button limpiar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.simulador, container, false);

        r1 = (EditText) rootView.findViewById(R.id.r1);
        r2 = (EditText) rootView.findViewById(R.id.r2);
        r3 = (EditText) rootView.findViewById(R.id.r3);
        v1 = (EditText) rootView.findViewById(R.id.v1);
        v2 = (EditText) rootView.findViewById(R.id.v2);
        v3 = (EditText) rootView.findViewById(R.id.v3);
        medir = (Button) rootView.findViewById(R.id.Medir);
        deshacer = (Button) rootView.findViewById(R.id.deshacer);
        limpiar = (Button) rootView.findViewById(R.id.limpiar);

        medir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = r1+","+r2+","+r3+","+v1+","+v2+","+v3;
                Datos.getDatos().add(item);
            }
        });

        deshacer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Datos.getDatos().remove();
            }
        });

        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((EditText) getView().findViewById(R.id.r1)).setText("");
                ((EditText) getView().findViewById(R.id.r2)).setText("");
                ((EditText) getView().findViewById(R.id.r3)).setText("");
                ((EditText) getView().findViewById(R.id.v1)).setText("");
                ((EditText) getView().findViewById(R.id.v2)).setText("");
                ((EditText) getView().findViewById(R.id.v3)).setText("");
            }
        });

        return rootView;

    }
}