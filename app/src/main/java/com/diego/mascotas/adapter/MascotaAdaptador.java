package com.diego.mascotas.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.diego.mascotas.R;
import com.diego.mascotas.pojo.Mascota;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    ArrayList<Mascota> mascotas;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, FragmentActivity activity){
        this.mascotas = mascotas;
    }



    //Inflar el layout y lo pasara al viewholder para el obtenga los views
    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from( parent.getContext() ).inflate( R.layout.cardview_mascota, parent, false );

        return new MascotaViewHolder( v );
    }

    //asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {
        Mascota mascota = mascotas.get( position );
        mascotaViewHolder.imgFoto.setImageResource( mascota.getFoto() );
        mascotaViewHolder.tvNombreCV.setText( mascota.getNombre() );
    }

    @Override
    public int getItemCount() { //Cantidad de elementos que contiene mi lista
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreCV;

        public MascotaViewHolder(@NonNull View itemView) {
            super( itemView );
            imgFoto      = (ImageView) itemView.findViewById( R.id.imgFoto );
            tvNombreCV   = (TextView) itemView.findViewById( R.id.tvNombreCV );
        }
    }
}
