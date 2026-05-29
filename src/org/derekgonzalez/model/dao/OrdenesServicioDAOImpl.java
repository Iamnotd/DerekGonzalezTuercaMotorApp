package org.derekgonzalez.model.dao;

import java.util.ArrayList;
import java.util.List;
import org.derekgonzalez.model.OrdenesServicio;
import org.derekgonzalez.model.conexion.Conexion;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdenesServicioDAOImpl implements OrdenesServicioDAO {

    @Override
    public boolean insertar(OrdenesServicio orden) {
        String consulta = "{call sp_insertar_orden_servicio(?, ?, ?, ?, ?)}";
        int filasAfectadas = 0;

        try (
            Connection conexion = Conexion.conectar();
            CallableStatement call = conexion.prepareCall(consulta)
        ) {
            call.setDate(1, orden.getFechaIngreso());
            call.setDouble(2, orden.getPresupuesto());
            call.setString(3, orden.getPlacaVehiculo());
            call.setLong(4, orden.getNoMecanico());
            call.setString(5, orden.getHorasDedicadas()); // MySQL lo castea automáticamente a TIME

            filasAfectadas = call.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR al registrar la orden de servicio: " + e.getMessage());
        }
        return filasAfectadas > 0;
    }

    @Override
    public List<OrdenesServicio> listar() {
        List<OrdenesServicio> lista = new ArrayList<>();
        String consulta = "{call sp_listar_orden_servicio()}";

        try (
            Connection conexion = Conexion.conectar();
            CallableStatement call = conexion.prepareCall(consulta);
            ResultSet resultado = call.executeQuery()
        ) {
            while (resultado.next()) {
                lista.add(new OrdenesServicio(
                    resultado.getInt("id_orden"),
                    resultado.getDate("fecha_ingreso"),
                    resultado.getDouble("presupuesto"),
                    resultado.getString("placa_vehiculo"),
                    resultado.getLong("no_mecanico"),
                    resultado.getString("horas_dedicadas")
                ));
            }
        } catch (SQLException e) {
            System.out.println("ERROR al listar ordenes de servicio: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public OrdenesServicio buscar(int idOrden) {
        OrdenesServicio orden = null;
        String consulta = "select id_orden, fecha_ingreso, presupuesto, placa_vehiculo, no_mecanico, horas_dedicadas from ordenes_servicio where id_orden = ?";

        try (
            Connection conexion = Conexion.conectar();
            PreparedStatement statement = conexion.prepareStatement(consulta)
        ) {
            statement.setInt(1, idOrden);
            
            try (ResultSet resultado = statement.executeQuery()) {
                if (resultado.next()) {
                    orden = new OrdenesServicio(
                        resultado.getInt("id_orden"),
                        resultado.getDate("fecha_ingreso"),
                        resultado.getDouble("presupuesto"),
                        resultado.getString("placa_vehiculo"),
                        resultado.getLong("no_mecanico"),
                        resultado.getString("horas_dedicadas")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("ERROR al buscar orden de servicio: " + e.getMessage());
        }
        return orden;
    }
}