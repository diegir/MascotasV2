package com.diego.mascotas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.diego.mascotas.adapter.PageAdapter;
import com.diego.mascotas.fragment.PerfilFragment;
import com.diego.mascotas.fragment.RecyclerViewFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        toolbar = (Toolbar) findViewById( R.id.toolbar );
        tabLayout = (TabLayout) findViewById( R.id.tabLayout );
        viewPager = (ViewPager) findViewById( R.id.viewPager );
        setUpViewPager();


        if (toolbar != null){
            setSupportActionBar( toolbar );
        }




    }


    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add( new RecyclerViewFragment() );
        fragments.add( new PerfilFragment() );

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter( new PageAdapter( getSupportFragmentManager(), agregarFragments() ) );
        tabLayout.setupWithViewPager( viewPager );

        tabLayout.getTabAt( 0 ).setIcon( R.drawable.ic_contacts );
        tabLayout.getTabAt( 1 ).setIcon( R.drawable.ic_action_name );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.menu_opciones,menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            /*case R.id.mRefresh:
                //Intent
                Toast.makeText( this,"Refresh", Toast.LENGTH_SHORT ).show();
                break;*/

            case R.id.mFavoritos:
                //Intent
                Intent intfav = new Intent(this, ActivityMascota.class);
                startActivity( intfav );
                break;

            case R.id.mContacto:
                Intent intent = new Intent(this, ActivityContacto.class);
                startActivity( intent );
                break;

            case R.id.mAcerca:
                Intent i = new Intent(this, ActivityAcerca.class);
                startActivity( i );
                break;
        }

        return super.onOptionsItemSelected( item );
    }




}