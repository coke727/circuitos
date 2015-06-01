package es.uva.inf.kave.myapplication.Auxiliares;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import es.uva.inf.kave.myapplication.Auxiliares.Datos;
import es.uva.inf.kave.myapplication.R;

public class ListAdapter extends ArrayAdapter<Datos> {

    Context context;
    int layoutResourceId;
    ArrayList<Datos> datos;

    public ListAdapter(FragmentActivity context, int layoutResourceId, ArrayList<Datos> datos) {
        super(context, layoutResourceId, datos);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.datos = datos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        DatosHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, null);

            holder = new DatosHolder();
            holder.v1 = (TextView) row.findViewById(R.id.tv1);
            holder.a1 = (TextView) row.findViewById(R.id.tv2);
            holder.r1 = (TextView) row.findViewById(R.id.tr1);
            holder.t1 = (TextView) row.findViewById(R.id.tr2);

            row.setTag(holder);
        }
        else
        {
            holder = (DatosHolder)row.getTag();
        }

        Datos fila = datos.get(position);

        holder.v1.setText(fila.getV1());
        holder.a1.setText(fila.getA1());
        holder.r1.setText(fila.getR1());
        holder.t1.setText(fila.getT1());

        return row;
    }

    static class DatosHolder
    {
        TextView v1;
        TextView a1;
        TextView r1;
        TextView t1;
    }
}
