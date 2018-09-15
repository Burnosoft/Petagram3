package diaz.bruno.petagram.fragment;

import java.util.ArrayList;

import diaz.bruno.petagram.adapter.MascotaAdaptador;
import diaz.bruno.petagram.adapter.PerfilAdaptador;
import diaz.bruno.petagram.pojo.Mascota;

public interface IRecyclerViewFragmentView {
    public void generarLinearLayout();
    public MascotaAdaptador crearAdaptadorMascota(ArrayList<Mascota> mascotas);
    public PerfilAdaptador crearAdaptadorMascotaPerfil(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
    public void inicializarAdaptadorPerfilRV(PerfilAdaptador adaptador);
}
