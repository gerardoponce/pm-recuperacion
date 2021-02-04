package com.tecsup.pm.gocar.ui.catalogo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tecsup.pm.gocar.R;
import com.tecsup.pm.gocar.adapter.MarcaAdapter;
import com.tecsup.pm.gocar.model.Marca;
import com.tecsup.pm.gocar.model.OpcionMarca;
import com.tecsup.pm.gocar.rest.ApiServiceGenerator;
import com.tecsup.pm.gocar.rest.MarcaApi;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CatalogoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CatalogoFragment extends Fragment {

    private FrameLayout frmContenedorFragment;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;

    public CatalogoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CatalogoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CatalogoFragment newInstance(String param1, String param2) {
        CatalogoFragment fragment = new CatalogoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            String mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_catalogo, container, false);

        MarcaApi marcaApi = ApiServiceGenerator.createService(MarcaApi.class);
        Call<OpcionMarca> call = marcaApi.obtenerMarcas();
        call.enqueue(new Callback<OpcionMarca>() {
            @Override
            public void onResponse(@NotNull Call<OpcionMarca> call, @NotNull Response<OpcionMarca> response) {
                OpcionMarca json = response.body();
                assert json != null;
                List<Marca> marcaList = json.getOpcionesMarca();
                obtenerMarcas(marcaList);
            }

            @Override
            public void onFailure(@NotNull Call<OpcionMarca> call, @NotNull Throwable t) {
                Toast.makeText(getActivity(),"El servidor no está respondiendo", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private void obtenerMarcas(List<Marca> marcaList){

        RecyclerView recyclerView = requireView().findViewById(R.id.rcvMarcas);
        
        MarcaAdapter.OnMarcaClickListener marcaClickListener =
                posicion -> {

                    MarcaAdapter heroeAdapter = (MarcaAdapter) recyclerView.getAdapter();
                    Intent intent = new Intent(getContext(), ModeloActivity.class);
                    Marca marca = marcaList.get(posicion);
                    intent.putExtra("idMarca", marca.getIdMarca());
                    startActivity(intent);

                    Toast.makeText(getActivity(), heroeAdapter.getlistaMarcas().get(posicion).toString(), Toast.LENGTH_SHORT).show();
                };

        MarcaAdapter marcaAdapter = new MarcaAdapter(marcaList, marcaClickListener);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(marcaAdapter);
    }
}