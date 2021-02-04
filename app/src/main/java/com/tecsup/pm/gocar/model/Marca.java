package com.tecsup.pm.gocar.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Marca {

    @SerializedName("IdMarca")
    @Expose
    private Long idMarca;
    @SerializedName("NombreMarca")
    @Expose
    private String nombreMarca;

    /**
     * No args constructor for use in serialization
     *
     */
    public Marca() {
    }

    public Marca(Long idMarca, String nombreMarca) {
        this.idMarca = idMarca;
        this.nombreMarca = nombreMarca;
    }

    public Long getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Long idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }
}
