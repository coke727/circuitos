package es.uva.inf.kave.myapplication;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Adapter_Cabecera_Tabla extends BaseAdapter {
    Activity activity;
    int numApartado;
    ArrayList<String> arrayDatos;

    public Adapter_Cabecera_Tabla(Activity activity, ArrayList<String> arrayDatos) {
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
            view = inflater.inflate(R.layout.valores_1, null);

            holder= new ViewHolder();
            holder.tvColumA = (TextView)view.findViewById(R.id.tvColumA_23);
            holder.tvColumB = (TextView)view.findViewById(R.id.tvColumB_23);

            view.setTag(holder);

        }else {
            holder = (ViewHolder)view.getTag();
        }

        String item = arrayDatos.get(position);

        String [] temp = item.split(":");


        holder.tvColumA.setText(temp[0]);
        //holder.tvColumA.setBackgroundResource(R.color.verdeApp);
        //holder.tvColumA.setTextAppearance(activity, R.style.boldText);
        holder.tvColumB.setText(temp[1]);
        //holder.tvColumB.setBackgroundResource(R.color.verdeApp);
        //holder.tvColumB.setTextAppearance(activity, R.style.boldText);

        return view;
    }

    private class ViewHolder {
        TextView tvColumA;
        TextView tvColumB;
    }
}

