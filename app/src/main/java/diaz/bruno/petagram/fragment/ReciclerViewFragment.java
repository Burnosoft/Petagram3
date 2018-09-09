package diaz.bruno.petagram.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import diaz.bruno.petagram.CustomItemClickListener;
import diaz.bruno.petagram.R;
import diaz.bruno.petagram.adapter.MascotaAdaptador;
import diaz.bruno.petagram.pojo.Mascota;

public class ReciclerViewFragment extends android.support.v4.app.Fragment implements CustomItemClickListener{

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private CustomItemClickListener listener;
    private MascotaAdaptador adaptador;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_reciclerview, container, false);

        // traigo a objeto recyclerview
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        // defino orientacion de recyclerviw
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        //inicializo lista de mascotas
        inicializarListaMascotas();
        // inicializo adaptador
        inicializarAdaptador();

        return v;
    }


    public void inicializarAdaptador() {
        adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
        adaptador.setClickListener(this);


    }

    public void inicializarListaMascotas() {
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.puppy1, "Oso", 2));
        mascotas.add(new Mascota(R.drawable.puppy2, "Milton", 5));
        mascotas.add(new Mascota(R.drawable.puppy3, "Blacky", 4));
        mascotas.add(new Mascota(R.drawable.puppy2, "Lucky", 1));
        mascotas.add(new Mascota(R.drawable.puppy4, "Tom", 6));
    }

    @Override
    public void likeClicked(View v, int position) {

        // sumo like y actualizo el valor en adaptador
        mascotas.get(position).setLikes( mascotas.get(position).getLikes() + 1);
        adaptador.notifyDataSetChanged();
    }
}