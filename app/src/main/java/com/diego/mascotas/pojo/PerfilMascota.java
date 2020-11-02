package com.diego.mascotas.pojo;

public class PerfilMascota {

    private int fotito;
    private int numero;

    public PerfilMascota(int fotito, int numero) {
        this.fotito = fotito;
        this.numero = numero;
    }

    public int getFotito() {
        return fotito;
    }

    public void setFotito(int fotito) {
        this.fotito = fotito;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
