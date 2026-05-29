package org.derekgonzalez.model.dao;

import java.util.ArrayList;
import java.util.List;
import org.derekgonzalez.model.DetallesOrdenes;
import org.derekgonzalez.model.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DetallesOrdenesDAOImpl implements DetallesOrdenesDAO {

    @Override
    public boolean insertar(DetallesOrdenes detalle) {
        // Inserción directa en la tabla de detalles resguardando la relación de llaves foráneas
        String consulta = "insert into detalles_orden_repuestos (id_orden, codigo_repuesto, cantidad_usada, precio_momento) values (?, ?, ?, ?)";
        int filasAfectadas = 0;
        try (
            Connection conexion = Conexion.conectar();
            PreparedStatement statement = conexion.prepareStatement(consulta)
        ) {
            statement.setInt(1, detalle.getIdOrden());
            statement.setLong(2, detalle.getCodigoRepuesto());
            statement.setInt(3, detalle.getCantidadUsada());
            statement.setDouble(4, detalle.getPrecioMomento());
            filasAfectadas = statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR al registrar detalle de repuesto: " + e.getMessage());
        }
        return filasAfectadas > 0;
    }

    @Override
    public List<DetallesOrdenes> listar() {
        List<DetallesOrdenes> lista = new ArrayList<>();
        // Invocamos el SP exacto visible en tu script de la BD
        String consulta = "{call sp_listar_detalles_repuestos()}";
        try (
            Connection conexion = Conexion.conectar();
            CallableStatement call = conexion.prepareCall(consulta);
            ResultSet resultado = call.executeQuery()
        ) {
            while (resultado.next()) {
                lista.add(new DetallesOrdenes(
                    resultado.getInt(1), // id_detalle
                    resultado.getInt(2), // id_orden
                    resultado.getLong(3), // codigo_repuesto
                    resultado.getInt(4), // cantidad_usada
                    resultado.getDouble(5) // precio_momento
                ));
            }
        } catch (SQLException e) {
            System.out.println("ERROR al listar detalles: " + e.getMessage());
        }
        return lista;
    }
}