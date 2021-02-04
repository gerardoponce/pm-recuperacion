package com.tecsup.pm.gocar.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tecsup.pm.gocar.R;
import com.tecsup.pm.gocar.model.Marca;

import java.util.List;

public class MarcaAdapter extends RecyclerView.Adapter<MarcaAdapter.MarcaViewHolder>{

    private final OnMarcaClickListener marcaClickListener;

    public interface OnMarcaClickListener {
        void onClick(int posicion);
    }

    private final List<Marca> listaMarcas;

    public List<Marca> getlistaMarcas() {
        return listaMarcas;
    }

    static class MarcaViewHolder extends RecyclerView.ViewHolder {

        private final TextView txtId;
        private final TextView txtNombreMarca;

        public MarcaViewHolder(@NonNull View itemView, OnMarcaClickListener marcaClickListener) {
            super(itemView);

            txtId = itemView.findViewById(R.id.txtIdMarca);
            txtNombreMarca = itemView.findViewById(R.id.txtNombreMarca);

            itemView.setOnClickListener(view -> {

                if (marcaClickListener != null) {
                    int posicion = getAdapterPosition();
                    if (posicion != RecyclerView.NO_POSITION) {
                        marcaClickListener.onClick(posicion);
                    }
                }
            });
        }

        public void bindMarca(Marca marca) {
            txtId.setText(String.valueOf(marca.getIdMarca()));
            txtNombreMarca.setText(marca.getNombreMarca());

        }
    }

    public MarcaAdapter(List<Marca> listaMarcas, OnMarcaClickListener marcaClickListener) {
        this.listaMarcas = listaMarcas;
        this.marcaClickListener = marcaClickListener;
    }

    @NonNull
    @Override
    public MarcaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemMarca = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_marca, parent, false);
        return new MarcaViewHolder(itemMarca, marcaClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MarcaViewHolder holder, int position) {
        holder.bindMarca(getlistaMarcas().get(position));
        holder.itemView.setOnClickListener(v -> {

        });
    }

    @Override
    public int getItemCount() {
        return getlistaMarcas().size();
    }

}
