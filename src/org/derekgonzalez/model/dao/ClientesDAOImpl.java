package org.derekgonzalez.model.dao;

import java.util.ArrayList;
import java.util.List;
import org.derekgonzalez.model.Clientes;
import org.derekgonzalez.model.conexion.Conexion;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientesDAOImpl implements ClientesDAO {

    @Override
    public boolean insertar(Clientes clientes) {
        return false;
    }

    @Override
    public List<Clientes> listar() {

        // Vector de objetos
        List<Clientes> clientes = new ArrayList<>();

        String consulta = "{call sp_listar_clientes()}";

        try (
            Connection conexion = Conexion.conectar();
            CallableStatement call = conexion.prepareCall(consulta);
            ResultSet resultado = call.executeQuery()
        ) {

            while (resultado.next()) {

                clientes.add(new Clientes(
                    (int) resultado.getLong("cui"),
                    resultado.getString("nombre")
                ));

            }

        } catch (SQLException e) {
            System.out.println("ERROR: al listar nombres: " + e.getMessage());
        }

        return clientes;
    }

    public Clientes buscar(long cui) {
        return null;
    }

    @Override
    public boolean actualizar(Clientes clientes) {
        return false;
    }

    public boolean eliminar(long cui) {
        return false;
    }

    @Override
    public Clientes buscar(int Cui) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(int Cui) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}