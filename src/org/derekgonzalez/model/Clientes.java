package org.derekgonzalez.model;

public class Clientes {
    
    private long CuiClientes;
    private String nombreClientes;
    
    public Clientes() {
        
    }
    
    public Clientes(int CuiClientes, String nombreClientes) {
        this.CuiClientes = CuiClientes;
        this.nombreClientes = nombreClientes;
    }
    
    public String getNombreClientes() { 
        return nombreClientes;
    }
    
    public void setNombreClientes (String nombreCategoria) { 
        this.nombreClientes = nombreClientes;
    }
    
    public int getCuiClientes() {
        return (int) CuiClientes;
    }
    
    public void setCuiClientes(int CuiCategoria) {
        this.CuiClientes = CuiClientes;
    }
}
