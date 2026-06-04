package org.derekgonzalez.model;

public class Clientes {
    private long cuiClientes;
    private String nombreClientes;
    private String apellidoClientes;
    private String direccionClientes;
    private String telefonoClientes;

    public Clientes() {
    }

    public Clientes(long cuiClientes, String nombreClientes) {
        this.cuiClientes = cuiClientes;
        this.nombreClientes = nombreClientes;
    }

    public Clientes(long cuiClientes, String nombreClientes, String apellidoClientes, String direccionClientes, String telefonoClientes) {
        this.cuiClientes = cuiClientes;
        this.nombreClientes = nombreClientes;
        this.apellidoClientes = apellidoClientes;
        this.direccionClientes = direccionClientes;
        this.telefonoClientes = telefonoClientes;
    }

    public long getCuiClientes() {
        return cuiClientes;
    }

    public void setCuiClientes(long cuiClientes) {
        this.cuiClientes = cuiClientes;
    }

    public String getNombreClientes() {
        return nombreClientes;
    }

    public void setNombreClientes(String nombreClientes) {
        this.nombreClientes = nombreClientes;
    }

    public String getApellidoClientes() {
        return apellidoClientes;
    }

    public void setApellidoClientes(String apellidoClientes) {
        this.apellidoClientes = apellidoClientes;
    }

    public String getDireccionClientes() {
        return direccionClientes;
    }

    public void setDireccionClientes(String direccionClientes) {
        this.direccionClientes = direccionClientes;
    }

    public String getTelefonoClientes() {
        return telefonoClientes;
    }

    public void setTelefonoClientes(String telefonoClientes) {
        this.telefonoClientes = telefonoClientes;
    }

    public long getCui() {
        return this.cuiClientes;
    }

    public String getNombre() {
        return this.nombreClientes;
    }

    public String getApellido() {
        return this.apellidoClientes;
    }

    public String getTelefono() {
        return this.telefonoClientes;
    }

    public String getDireccion() {
        return this.direccionClientes;
    }
}