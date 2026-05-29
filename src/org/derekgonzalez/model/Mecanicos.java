package org.derekgonzalez.model;

public class Mecanicos {
    private long noEmpleado;
    private String nombre;
    private String apellido;

    public Mecanicos() {
    }

    public Mecanicos(long noEmpleado, String nombre, String apellido) {
        this.noEmpleado = noEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public long getNoEmpleado() {
        return noEmpleado;
    }

    public void setNoEmpleado(long noEmpleado) {
        this.noEmpleado = noEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}