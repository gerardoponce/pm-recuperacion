package com.tecsup.pm.gocar.rest;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiServiceGenerator {

    // Cliente HTTP interno que se encarga de realizar la conexión mediante este protocolo
    private static OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();

    // Permite construir una instancia de Retrofit a partir de una url base y de un conversor json
    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl(RutasApi.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    // Objeto Retrofit para conexiones a los servicios web
    // es static por que solo se creará una única instancia de este objeto
    private static Retrofit retrofit;

    // Se agrega el constructor vacío
    public ApiServiceGenerator() {
    }

    public static <S> S createService(Class<S> serviceClass) {
        // Se valida si el objeto Retrofit ya ha sido instanciado, caso contrario lo instancia
        if (retrofit == null) {

            // Debido a que es nulo, se instancia el objeto retrofit
            // Para visualizar en logcat los logs (request y response) de las llamadas
            // a los servicios se utilizará un interceptor
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            // Agregar el interceptor al cliente HTTP
            httpClientBuilder.addInterceptor(httpLoggingInterceptor);

            // Instanciamos el cliente http a partir del builder
            OkHttpClient httpClient = httpClientBuilder.build();

            // Instanciamos retrofit a partir del builder
            retrofit = retrofitBuilder.client(httpClient).build();
        }
        return retrofit.create(serviceClass);
    }
}
