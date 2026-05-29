package org.derekgonzalez.model;

import java.sql.Date;

public class OrdenesServicio {
    private int idOrden;
    private Date fechaIngreso;
    private double presupuesto;
    private String placaVehiculo;
    private long noMecanico;
    private String horasDedicadas;

    public OrdenesServicio() {
    }

    // Constructor para insertar (la BD genera el id_orden de forma automática)
    public OrdenesServicio(Date fechaIngreso, double presupuesto, String placaVehiculo, long noMecanico, String horasDedicadas) {
        this.fechaIngreso = fechaIngreso;
        this.presupuesto = presupuesto;
        this.placaVehiculo = placaVehiculo;
        this.noMecanico = noMecanico;
        this.horasDedicadas = horasDedicadas;
    }

    // Constructor completo para listar
    public OrdenesServicio(int idOrden, Date fechaIngreso, double presupuesto, String placaVehiculo, long noMecanico, String horasDedicadas) {
        this.idOrden = idOrden;
        this.fechaIngreso = fechaIngreso;
        this.presupuesto = presupuesto;
        this.placaVehiculo = placaVehiculo;
        this.noMecanico = noMecanico;
        this.horasDedicadas = horasDedicadas;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    public long getNoMecanico() {
        return noMecanico;
    }

    public void setNoMecanico(long noMecanico) {
        this.noMecanico = noMecanico;
    }

    public String getHorasDedicadas() {
        return horasDedicadas;
    }

    public void setHorasDedicadas(String horasDedicadas) {
        this.horasDedicadas = horasDedicadas;
    }
}