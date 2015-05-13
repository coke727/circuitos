package es.uva.inf.kave.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Clase que se encarga de generar los compoenentes de la lista con
 * dos valores
 *
 */
public class Adapter_Tabla extends BaseAdapter {
    Activity activity;
    int numApartado;
    ArrayList<Medida> arrayDatos;

    public Adapter_Tabla(Activity activity, ArrayList<Medida> arrayDatos) {
        super();
        this.activity = activity;
        this.arrayDatos = arrayDatos;
    }

    public int getCount() {


        return arrayDatos.size();
    }

    public Object getItem(int position) {
        return arrayDatos.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;
        if (convertView==null){
            LayoutInflater inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.tabla_1, null);

            holder= new ViewHolder();
            holder.tvColumA = (TextView)view.findViewById(R.id.tvColumA_23);
            holder.tvColumB = (TextView)view.findViewById(R.id.tvColumB_23);

            view.setTag(holder);

        }else {
            holder = (ViewHolder)view.getTag();
        }

        Medida item = arrayDatos.get(position);
        holder.tvColumA.setText(item.getValor1()+"");
        holder.tvColumB.setText(item.getValor2()+"");

        return view;
    }

    private class ViewHolder {
        TextView tvColumA;
        TextView tvColumB;
    }
}

