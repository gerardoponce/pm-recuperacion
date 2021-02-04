package com.tecsup.pm.gocar.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OpcionMarca {

    @SerializedName("opciones")
    @Expose
    private List<Marca> opcionesMarca = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public OpcionMarca() {
    }

    /**
     *
     * @param opcionesMarca
     */
    public OpcionMarca(List<Marca> opcionesMarca) {
        super();
        this.opcionesMarca = opcionesMarca;
    }

    public List<Marca> getOpcionesMarca() {
        return opcionesMarca;
    }

    public void setOpcionesMarca(List<Marca> opcionesMarca) {
        this.opcionesMarca = opcionesMarca;
    }

    public OpcionMarca withOpciones(List<Marca> opciones) {
        this.opcionesMarca = opciones;
        return this;
    }
}
