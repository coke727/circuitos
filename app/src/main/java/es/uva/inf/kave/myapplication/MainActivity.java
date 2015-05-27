package es.uva.inf.kave.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

        //Componentes
        final Button teoria = (Button)findViewById(R.id.teoria);
        final Button ejercicio1 = (Button)findViewById(R.id.ejercicio1);
        final Button ejercicio2 = (Button)findViewById(R.id.ejercicio2);
        final Button ejercicio3 = (Button)findViewById(R.id.ejercicio3);
        final Button ejercicio4 = (Button)findViewById(R.id.ejercicio4);

        //Evento onClick de los botones. transición entre vistas
        teoria.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(MainActivity.this, Activity_teoria.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        ejercicio1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                intent = new Intent(MainActivity.this, Activity_Ejercicio1.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });

        ejercicio2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                intent = new Intent(MainActivity.this, Activity_Ejercicio2.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });

        ejercicio3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                intent = new Intent(MainActivity.this, Activity_Ejercicio3.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });

        ejercicio4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                intent = new Intent(MainActivity.this, Activity_Ejercicio4.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });
    }
}
