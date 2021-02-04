package com.tecsup.pm.gocar.ui.alumno;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AlumnoViewModel extends ViewModel {

    private MutableLiveData<String> mNombres;
    private MutableLiveData<String> mApellidos;
    private MutableLiveData<Integer> mEdad;
    private MutableLiveData<String> mDNI;
    private MutableLiveData<String> mCelular;

    public AlumnoViewModel() {
        mNombres = new MutableLiveData<>();
        mApellidos = new MutableLiveData<>();
        mEdad = new MutableLiveData<>();
        mDNI  = new MutableLiveData<>();
        mCelular = new MutableLiveData<>();

        mNombres.setValue("Gerardo Gustavo");
        mApellidos.setValue("Ponce Pari");
        mEdad.setValue(21);
        mDNI.setValue("76439844");
        mCelular.setValue("995 875 677");
    }

    public LiveData<String> getNombres() {
        return mNombres;
    }

    public LiveData<String> getApellidos() {
        return mApellidos;
    }

    public LiveData<Integer> getEdad() {
        return mEdad;
    }

    public LiveData<String> getDNI() {
        return mDNI;
    }

    public LiveData<String> getCelular() {
        return mCelular;
    }
}
