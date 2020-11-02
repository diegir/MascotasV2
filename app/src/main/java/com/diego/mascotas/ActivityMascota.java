package com.diego.mascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.diego.mascotas.adapter.MascotaAdaptadorFavorito;
import com.diego.mascotas.pojo.Mascota;

import java.util.ArrayList;

public class ActivityMascota extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_detalle_mascota );

        listaMascotas = (RecyclerView) findViewById( R.id.rv2Mascotas );
        LinearLayoutManager llm = new LinearLayoutManager( this );
        llm.setOrientation( LinearLayoutManager.VERTICAL );
        listaMascotas.setLayoutManager( llm );
        inicializarListaContactos();
        iniciarlizaAdaptador();

    }

    public void iniciarlizaAdaptador(){
        MascotaAdaptadorFavorito adaptador = new MascotaAdaptadorFavorito( mascotas );
        listaMascotas.setAdapter( adaptador );
    }


    public void inicializarListaContactos(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.mipmap.golden,"Yaya"));
        mascotas.add(new Mascota(R.mipmap.pulgoso,"Jamie"));
        mascotas.add(new Mascota(R.mipmap.mancha,"Lara"));
        mascotas.add(new Mascota(R.mipmap.kawaii,"Torque"));
        mascotas.add(new Mascota(R.mipmap.pastor,"Tini"));
    }
    public void irPrimeraActividad(View v){
        Intent intent = new Intent(ActivityMascota.this,MainActivity.class);
        startActivity( intent );
    }

}