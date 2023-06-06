package com.rosa.ejemploconsultas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    EditText edtx_pregtunta, edtx_respuesta1, edtx_respuesta2, edtx_respuesta3, edtx_respuesta4, id;
    Button btn_insertar, btn_listar;
    FirebaseDatabase database;
    DatabaseReference myRef;

    TextView edtx_id_contenedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        referenciar();
    }


    private void referenciar() {
        edtx_id_contenedor = findViewById(R.id.edtx_id_contenedor_preguntas);
        edtx_pregtunta = findViewById(R.id.edtx_pregtunta);
        edtx_respuesta1 = findViewById(R.id.edtx_respuesta1);
        edtx_respuesta2 = findViewById(R.id.edtx_respuesta2);
        edtx_respuesta3 = findViewById(R.id.edtx_respuesta3);
        edtx_respuesta4 = findViewById(R.id.edtx_respuesta4);
        btn_insertar = findViewById(R.id.btn_insertar);
        btn_listar = findViewById(R.id.btn_listar);
        id = findViewById(R.id.edtx_id_contenedor_preguntas);

        Bundle parametros = this.getIntent().getExtras();
        if (parametros != null) {
            String datos = parametros.getString("id");
            id.setText(datos);

            final String id2=datos;

        btn_insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertar();
            }
        });

        btn_listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, Lista.class));
                Intent intent1=new Intent(MainActivity.this,Lista.class);
                intent1.putExtra("id1",id2);
                startActivity(intent1);
                Toast.makeText(MainActivity.this, datos, Toast.LENGTH_SHORT).show();

            }
        });
    }

}

    public void insertar() {
        database = FirebaseDatabase.getInstance(); //conexion
        myRef = database.getReference(); // referencia

        Preguntas preguntas = new Preguntas();
        preguntas.setId(UUID.randomUUID().toString());

        preguntas.setContenedor(edtx_id_contenedor.getText().toString());
        preguntas.setPregunta(edtx_pregtunta.getText().toString());
        preguntas.setRespuesta1(edtx_respuesta1.getText().toString());
        preguntas.setRespuesta2(edtx_respuesta2.getText().toString());
        preguntas.setRespuesta3(edtx_respuesta3.getText().toString());
        preguntas.setRespuesta4(edtx_respuesta4.getText().toString());
        myRef.child("Preguntas").child(preguntas.getPregunta()).setValue(preguntas); //insercion
        Toast.makeText(this, "datos insertados", Toast.LENGTH_SHORT).show();

    }





}