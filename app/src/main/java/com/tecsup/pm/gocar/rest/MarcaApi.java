package com.tecsup.pm.gocar.rest;

import com.tecsup.pm.gocar.model.OpcionMarca;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MarcaApi {

    @GET("combos/get/?nombre=marca_busqueda")
    Call<OpcionMarca> obtenerMarcas();
}
