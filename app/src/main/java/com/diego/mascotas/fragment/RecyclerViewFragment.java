package com.diego.mascotas.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.diego.mascotas.pojo.Mascota;
import com.diego.mascotas.R;
import com.diego.mascotas.adapter.MascotaAdaptador;
import com.diego.mascotas.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView( inflater, container, savedInstanceState );
        View v = inflater.inflate( R.layout.fragment_recyclerview,container, false );

        listaMascotas = (RecyclerView) v.findViewById( R.id.rvMascotas );

        LinearLayoutManager llm =  new LinearLayoutManager( getActivity() );
        llm.setOrientation( LinearLayoutManager.VERTICAL );
        listaMascotas.setLayoutManager( llm );

        inicializarListaMascotas();
        iniciarlizaAdaptador();

        return v;

    }


    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.mipmap.golden,"Yaya"));
        mascotas.add(new Mascota(R.mipmap.pulgoso,"Jamie"));
        mascotas.add(new Mascota(R.mipmap.mancha,"Lara"));
        mascotas.add(new Mascota(R.mipmap.kawaii,"Torque"));
        mascotas.add(new Mascota(R.mipmap.pastor,"Tini"));
    }

    public MascotaAdaptador adaptador;
    private void iniciarlizaAdaptador(){
        adaptador = new MascotaAdaptador( mascotas,getActivity() );
        listaMascotas.setAdapter( adaptador );
    }


}
