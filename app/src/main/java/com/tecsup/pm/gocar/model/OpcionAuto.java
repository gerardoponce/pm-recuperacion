package com.tecsup.pm.gocar.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OpcionAuto {

    @SerializedName("opciones")
    @Expose
    private List<Modelo> opciones = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public OpcionAuto() {
    }

    /**
     *
     * @param opciones
     */
    public OpcionAuto(List<Modelo> opciones) {
        super();
        this.opciones = opciones;
    }

    public List<Modelo> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<Modelo> opciones) {
        this.opciones = opciones;
    }

    public OpcionAuto withOpciones(List<Modelo> opciones) {
        this.opciones = opciones;
        return this;
    }

}
