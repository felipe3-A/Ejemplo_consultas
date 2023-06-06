package com.rosa.ejemploconsultas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.net.HttpCookie;
import java.util.ArrayList;

public class Lista extends AppCompatActivity {

    ListView list;
    EditText id_i;
    FirebaseDatabase database;
    DatabaseReference myref;

    ArrayAdapter adapter;

    // String[] preguntass={"Selecciona tu pregunta","Pregunta 1","Pregunta 2","Pregunta 3",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);


        list = findViewById(R.id.datos_i);
        database = FirebaseDatabase.getInstance();//CAPTURAR LA CONEXION
        myref = database.getReference();//OBTENER LA REFERNCIA DE LA CONEXION

        id_i = findViewById(R.id.edtx_id_contenedor_preguntas1);

        Bundle parametros = this.getIntent().getExtras();

        if (parametros != null) {
            String datos = parametros.getString("id1");
            id_i.setText(datos);
            Toast.makeText(this, datos, Toast.LENGTH_SHORT).show();

        ArrayList<Preguntas> almacenadatos = new ArrayList<>();

        myref.child("Preguntas").orderByChild("contenedor").equalTo(datos).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Preguntas preguntas = dataSnapshot.getValue(Preguntas.class);
                    almacenadatos.add(preguntas);
                    adapter = new ArrayAdapter<Preguntas>(Lista.this, android.R.layout.simple_list_item_1, almacenadatos);
                    list.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }


    }
}

//        if(parametros != null) {
//        String datos = parametros.getString("id");
//        edtx_id_contenedor.setText(datos);

//    public void listar() {
//
//        //CREO CONEXION DE BD
//        database = FirebaseDatabase.getInstance(); //conexion
//        myRef = database.getReference(); // referencia
//
//        // CREO MI ARRAYLIST PARA ALMACENAR LOS DATOS DE LA CONSULTA
//
//        ArrayList<Preguntas> listapreguntas = new ArrayList<>();
//
//
//        myRef.child("Preguntas").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//        // creo un ciclo para recorrer los dato almacenados
//                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
//                    Preguntas pregunta = dataSnapshot.getValue(Preguntas.class);
//                    listapreguntas.add(pregunta);
//                    ArrayAdapter adapter =new ArrayAdapter(Lista.this, android.R.layout.simple_list_item_1,listapreguntas);
//                    list.setAdapter(adapter);
//
//                }
//
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//
//
//    }
