package diaz.bruno.petagram.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import diaz.bruno.petagram.CustomItemClickListener;
import diaz.bruno.petagram.R;
import diaz.bruno.petagram.adapter.MascotaAdaptador;
import diaz.bruno.petagram.adapter.MascotaAdaptadorPerfil;
import diaz.bruno.petagram.pojo.Mascota;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private CustomItemClickListener listener;
    private MascotaAdaptadorPerfil adaptadorPerfil;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        // traigo a objeto recyclerview
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas2);
        // defino orientacion de recyclerviw
        //LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        //llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(new GridLayoutManager(getContext(), 3));
        //inicializo lista de mascotas
        inicializarListaMascotas();
        // inicializo adaptador
        inicializarAdaptador();

        return v;
    }


    public void inicializarAdaptador() {
        adaptadorPerfil = new MascotaAdaptadorPerfil(mascotas);
        listaMascotas.setAdapter(adaptadorPerfil);
        //adaptador.setClickListener(this);


    }

    public void inicializarListaMascotas() {
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.puppy1, "Oso", 2));
        mascotas.add(new Mascota(R.drawable.puppy2, "Milton", 5));
        mascotas.add(new Mascota(R.drawable.puppy3, "Blacky", 4));
        mascotas.add(new Mascota(R.drawable.puppy2, "Lucky", 1));
        mascotas.add(new Mascota(R.drawable.puppy4, "Tom", 6));
        mascotas.add(new Mascota(R.drawable.puppy1, "Oso", 2));
        mascotas.add(new Mascota(R.drawable.puppy2, "Milton", 5));
        mascotas.add(new Mascota(R.drawable.puppy3, "Blacky", 4));
        mascotas.add(new Mascota(R.drawable.puppy2, "Lucky", 1));
        mascotas.add(new Mascota(R.drawable.puppy4, "Tom", 6));
    }


}
