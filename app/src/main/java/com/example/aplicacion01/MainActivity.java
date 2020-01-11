package com.example.aplicacion01;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.aplicacion01.adapters.ContactoAdaptador;
import com.example.aplicacion01.helpers.QueueUtils;
import com.example.aplicacion01.models.Contacto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView contactosList;
    ContactoAdaptador contactoAdaptador;

    QueueUtils.QueueObject queue = null;

    ArrayList<Contacto> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnTipo = findViewById(R.id.btnTipo);

        Button btnTipo2 = findViewById(R.id.btnTipo2);

        btnTipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Refrescar platos", Toast.LENGTH_SHORT).show();
                items.clear();
                Contacto.injectContactsFromCloud(queue, items, MainActivity.this, "limeno");
            }
        });

        btnTipo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Platos huancayo", Toast.LENGTH_SHORT).show();
                items.clear();
                Contacto.injectContactsFromCloud(queue, items, MainActivity.this, "huancaino");
            }
        });

        contactosList = findViewById(R.id.contactosList);

        queue = QueueUtils.getInstance(this.getApplicationContext());

        items = new ArrayList<>();
        Contacto.injectContactsFromCloud(queue, items, this, "huancayo");

        //contactoAdaptador = new ContactoAdaptador(this, Contacto.getCollection(), queue.getImageLoader());  Datos estaticos
        contactoAdaptador = new ContactoAdaptador(this, items, queue.getImageLoader());
        contactosList.setAdapter(contactoAdaptador);

        Contacto.sendRequestPOST(queue,this);

    }
    public void refreshList(){
        if ( contactoAdaptador!= null ) {
            contactoAdaptador.notifyDataSetChanged();
        }
    }
}
