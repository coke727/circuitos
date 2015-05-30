package es.uva.inf.kave.myapplication;

/**
 * Created by coke on 12/05/15.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ScrollView;

import java.util.ArrayList;

import es.uva.inf.kave.myapplication.Auxiliares.Datos;
import es.uva.inf.kave.myapplication.Auxiliares.ListAdapter;

public class Simulador4 extends Fragment{

    private String r1, r2, r3, v1, v2, v3;
    private Button medir;
    private Button deshacer;
    private Button limpiar, calcular;
    private ListView listaMedidas;
    private ScrollView scroll;
    Intent intent;

    ArrayList<Datos> tabla;
    ListAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.simulador_ej4, container, false);

        medir = (Button) rootView.findViewById(R.id.Medir);
        deshacer = (Button) rootView.findViewById(R.id.deshacer);
        limpiar = (Button) rootView.findViewById(R.id.limpiar);
        scroll = (ScrollView) rootView.findViewById(R.id.scrollView);
        calcular = (Button) rootView.findViewById(R.id.calcular);

        tabla = new ArrayList<Datos>();
        adapter = new ListAdapter(getActivity(), R.layout.row, tabla);

        medir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r1 = ((EditText) getView().findViewById(R.id.r1)).getText().toString();
                r2 = ((EditText) getView().findViewById(R.id.r2)).getText().toString();
                r3 = ((EditText) getView().findViewById(R.id.r3)).getText().toString();
                v1 = ((EditText) getView().findViewById(R.id.v1)).getText().toString();
                v2 = ((EditText) getView().findViewById(R.id.v2)).getText().toString();
                v3 = ((EditText) getView().findViewById(R.id.v3)).getText().toString();
                Log.i(r1,r2 + r3 + v1 + v2 + v3);
                Datos fila = new Datos(r1,r2,r3,v1,v2,v3);
                tabla.add(fila);
                adapter.notifyDataSetChanged();
                scroll.computeScroll();
            }
        });

        deshacer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tabla.size()>0) {
                    tabla.remove(tabla.get(tabla.size() - 1));
                    adapter.notifyDataSetChanged();
                }
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

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extra = new Bundle();
                extra.putSerializable("array", tabla);
                intent = new Intent(getActivity(),Activity_Resultado.class);
                intent.putExtra("array", extra);
                intent.putExtra("ejercicio", 4);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        listaMedidas = (ListView) rootView.findViewById(R.id.listaMedidas);
        View header = inflater.inflate(R.layout.header, null);

        listaMedidas.addHeaderView(header);
        listaMedidas.setAdapter(adapter);

        return rootView;

    }
}