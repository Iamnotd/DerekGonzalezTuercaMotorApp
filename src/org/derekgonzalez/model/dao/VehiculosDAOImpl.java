package org.derekgonzalez.model.dao;

import java.util.ArrayList;
import java.util.List;
import org.derekgonzalez.model.Vehiculos;
import org.derekgonzalez.model.conexion.Conexion;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VehiculosDAOImpl implements VehiculosDAO {

    @Override
    public boolean insertar(Vehiculos vehiculo) {
        String consulta = "{call sp_insertar_vehiculos(?, ?, ?, ?, ?)}";
        int filasAfectadas = 0;

        try (
            Connection conexion = Conexion.conectar();
            CallableStatement call = conexion.prepareCall(consulta)
        ) {
            call.setString(1, vehiculo.getPlaca());
            call.setString(2, vehiculo.getMarca());
            call.setString(3, vehiculo.getColor());
            call.setString(4, vehiculo.getModelo());
            call.setLong(5, vehiculo.getCuiCliente());

            filasAfectadas = call.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR al registrar vehículo: " + e.getMessage());
        }
        return filasAfectadas > 0;
    }

    @Override
    public List<Vehiculos> listar() {
        List<Vehiculos> lista = new ArrayList<>();
        String consulta = "{call sp_listar_vehiculos()}";

        try (
            Connection conexion = Conexion.conectar();
            CallableStatement call = conexion.prepareCall(consulta);
            ResultSet resultado = call.executeQuery()
        ) {
            while (resultado.next()) {
                lista.add(new Vehiculos(
                    resultado.getString("placa"),
                    resultado.getString("marca"),
                    resultado.getString("color"),
                    resultado.getString("modelo"),
                    resultado.getLong("cui_cliente")
                ));
            }
        } catch (SQLException e) {
            System.out.println("ERROR al listar vehículos: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public Vehiculos buscar(String placa) {
        Vehiculos vehiculo = null;
        String consulta = "select placa, marca, color, modelo, cui_cliente from vehiculos where placa = ?";

        try (
            Connection conexion = Conexion.conectar();
            PreparedStatement statement = conexion.prepareStatement(consulta)
        ) {
            statement.setString(1, placa);
            
            try (ResultSet resultado = statement.executeQuery()) {
                if (resultado.next()) {
                    vehiculo = new Vehiculos(
                        resultado.getString("placa"),
                        resultado.getString("marca"),
                        resultado.getString("color"),
                        resultado.getString("modelo"),
                        resultado.getLong("cui_cliente")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("ERROR al buscar vehículo: " + e.getMessage());
        }
        return vehiculo;
    }
}