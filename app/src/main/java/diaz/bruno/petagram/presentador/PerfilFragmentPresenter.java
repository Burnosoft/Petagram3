package diaz.bruno.petagram.presentador;

import android.content.Context;

import java.util.ArrayList;

import diaz.bruno.petagram.db.ConstructorMascotas;
import diaz.bruno.petagram.fragment.IRecyclerViewFragmentView;
import diaz.bruno.petagram.pojo.Mascota;

public class PerfilFragmentPresenter implements IRecyclerViewFragmentPresenter{

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public PerfilFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerContactosBaseDatos();
    }

    @Override
    public void obtenerContactosBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatosPerfil();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorPerfilRV(iRecyclerViewFragmentView.crearAdaptadorMascotaPerfil(mascotas));
        iRecyclerViewFragmentView.generarLinearLayout();
    }
}

