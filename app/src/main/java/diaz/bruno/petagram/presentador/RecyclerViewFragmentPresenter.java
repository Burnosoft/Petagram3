package diaz.bruno.petagram.presentador;

import android.content.Context;

import java.util.ArrayList;

import diaz.bruno.petagram.Contacto;
import diaz.bruno.petagram.db.ConstructorMascotas;
import diaz.bruno.petagram.fragment.IRecyclerViewFragmentView;
import diaz.bruno.petagram.pojo.Mascota;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerContactosBaseDatos();
    }

    @Override
    public void obtenerContactosBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptadorMascota(mascotas));
        iRecyclerViewFragmentView.generarLinearLayout();
    }
}
