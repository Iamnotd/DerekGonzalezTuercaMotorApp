package org.derekgonzalez.model;

public class Vehiculos {
    private String placa;
    private String marca;
    private String color;
    private String modelo;
    private long cuiCliente;

    public Vehiculos() {
    }

    public Vehiculos(String placa, String marca, String color, String modelo, long cuiCliente) {
        this.placa = placa;
        this.marca = marca;
        this.color = color;
        this.modelo = modelo;
        this.cuiCliente = cuiCliente;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public long getCuiCliente() {
        return cuiCliente;
    }

    public void setCuiCliente(long cuiCliente) {
        this.cuiCliente = cuiCliente;
    }
}