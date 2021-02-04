package com.tecsup.pm.gocar.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tecsup.pm.gocar.R;
import com.tecsup.pm.gocar.model.Modelo;

import java.util.List;

public class ModeloAdapter extends RecyclerView.Adapter<ModeloAdapter.ModeloViewHolder>{

    private List<Modelo> listaModelos;

    public List<Modelo> getListaModelos() {
        return listaModelos;
    }

    static class ModeloViewHolder extends RecyclerView.ViewHolder {

        private TextView txtId;
        private TextView txtNombreModelo;

        public ModeloViewHolder(@NonNull View itemView) {
            super(itemView);

            txtId = itemView.findViewById(R.id.txtIdModelo);
            txtNombreModelo = itemView.findViewById(R.id.txtNombreModelo);

        }

        public void bindModelo(Modelo modelo) {
            txtId.setText(String.valueOf(modelo.getIdModelo()));
            txtNombreModelo.setText(modelo.getNombreModelo());
        }
    }

    public ModeloAdapter(List<Modelo> listaModelos) {
        this.listaModelos = listaModelos;
    }

    @NonNull
    @Override
    public ModeloViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemModelo = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_modelo, parent, false);
        return new ModeloAdapter.ModeloViewHolder(itemModelo);
    }

    @Override
    public void onBindViewHolder(@NonNull ModeloViewHolder holder, int position) {
        holder.bindModelo(getListaModelos().get(position));
    }

    @Override
    public int getItemCount() {
        return getListaModelos().size();
    }
}
