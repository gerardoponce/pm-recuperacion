package com.tecsup.pm.gocar.rest;

import com.tecsup.pm.gocar.model.OpcionMarca;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ModeloApi {

    @GET("combos/get/?nombre=marca_busqueda&marca={id}")
    Call<OpcionMarca> obtenerMarcas(@Path("id") Long id);
}
