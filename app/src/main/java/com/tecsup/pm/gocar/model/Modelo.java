package com.tecsup.pm.gocar.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Modelo {

    @SerializedName("IdModelo")
    @Expose
    private Long idModelo;
    @SerializedName("NombreModelo")
    @Expose
    private String nombreModelo;

    /**
     * No args constructor for use in serialization
     *
     */

    public Modelo() {
    }

    /**
     *
     * @param idModelo
     * @param nombreModelo
     */
    public Modelo(Long idModelo, String nombreModelo) {
        this.idModelo = idModelo;
        this.nombreModelo = nombreModelo;
    }

    public Long getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Long idModelo) {
        this.idModelo = idModelo;
    }

    public String getNombreModelo() {
        return nombreModelo;
    }

    public void setNombreModelo(String nombreModelo) {
        this.nombreModelo = nombreModelo;
    }
}
