package com.tecsup.pm.gocar.ui.alumno;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tecsup.pm.gocar.R;
import com.tecsup.pm.gocar.ui.dashboard.DashboardViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AlumnoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AlumnoFragment extends Fragment {

    private AlumnoViewModel alumnoViewModel;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AlumnoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AlumnoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AlumnoFragment newInstance(String param1, String param2) {
        AlumnoFragment fragment = new AlumnoFragment();
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
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        alumnoViewModel =
                new ViewModelProvider(this).get(AlumnoViewModel.class);

        View root = inflater.inflate(R.layout.fragment_alumno, container, false);
        final TextView txtNombres = root.findViewById(R.id.txtNombres);
        final TextView txtApellidos = root.findViewById(R.id.txtApellidos);
        final TextView txtEdad = root.findViewById(R.id.txtEdad);
        final TextView txtDNI = root.findViewById(R.id.txtDNI);
        final TextView txtCelular = root.findViewById(R.id.txtCelular);

        alumnoViewModel.getNombres().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                txtNombres.setText(s);
            }
        });

        alumnoViewModel.getApellidos().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                txtApellidos.setText(s);
            }
        });

        alumnoViewModel.getEdad().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer i) {
                txtEdad.setText(String.valueOf(i));
            }
        });

        alumnoViewModel.getDNI().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                txtDNI.setText(s);
            }
        });

        alumnoViewModel.getCelular().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                txtCelular.setText(s);
            }
        });

        return root;
    }
}