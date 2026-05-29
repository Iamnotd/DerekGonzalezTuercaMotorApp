package org.derekgonzalez.model;

public class DetallesOrdenes {
    private int idDetalle;
    private int idOrden;
    private long codigoRepuesto; // Conectado al bigint (long) de repuestos
    private int cantidadUsada;
    private double precioMomento;

    public DetallesOrdenes() {
    }

    // Constructor para insertar
    public DetallesOrdenes(int idOrden, long codigoRepuesto, int cantidadUsada, double precioMomento) {
        this.idOrden = idOrden;
        this.codigoRepuesto = codigoRepuesto;
        this.cantidadUsada = cantidadUsada;
        this.precioMomento = precioMomento;
    }

    // Constructor completo para listar
    public DetallesOrdenes(int idDetalle, int idOrden, long codigoRepuesto, int cantidadUsada, double precioMomento) {
        this.idDetalle = idDetalle;
        this.idOrden = idOrden;
        this.codigoRepuesto = codigoRepuesto;
        this.cantidadUsada = cantidadUsada;
        this.precioMomento = precioMomento;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public long getCodigoRepuesto() {
        return codigoRepuesto;
    }

    public void setCodigoRepuesto(long codigoRepuesto) {
        this.codigoRepuesto = codigoRepuesto;
    }

    public int getCantidadUsada() {
        return cantidadUsada;
    }

    public void setCantidadUsada(int cantidadUsada) {
        this.cantidadUsada = cantidadUsada;
    }

    public double getPrecioMomento() {
        return precioMomento;
    }

    public void setPrecioMomento(double precioMomento) {
        this.precioMomento = precioMomento;
    }
}