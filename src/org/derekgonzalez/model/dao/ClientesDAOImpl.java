package org.derekgonzalez.model.dao;

import java.util.ArrayList;
import java.util.List;
import org.derekgonzalez.model.Clientes;
import org.derekgonzalez.model.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientesDAOImpl implements ClientesDAO {

    @Override
    public boolean insertar(Clientes clientes) {
        String consulta = "{call sp_insertar_clientes(?, ?, ?, ?, ?)}";
        int filasAfectadas = 0;

        try (
            Connection conexion = Conexion.conectar();
            CallableStatement call = conexion.prepareCall(consulta)
        ) {
            call.setLong(1, clientes.getCuiClientes()); 
            call.setString(2, clientes.getNombreClientes());
            call.setString(3, clientes.getApellidoClientes());
            call.setString(4, clientes.getDireccionClientes());
            call.setString(5, clientes.getTelefonoClientes());

            filasAfectadas = call.executeUpdate();

        } catch (SQLException e) {
            System.out.println("ERROR: al registrar cliente: " + e.getMessage());
        }

        return filasAfectadas > 0;
    }

    @Override
    public List<Clientes> listar() {
        List<Clientes> clientes = new ArrayList<>();
        String consulta = "{call sp_listar_clientes()}";

        try (
            Connection conexion = Conexion.conectar();
            CallableStatement call = conexion.prepareCall(consulta);
            ResultSet resultado = call.executeQuery()
        ) {
            while (resultado.next()) {
                // Instanciamos el objeto con todos los campos correspondientes a 'select *'
                clientes.add(new Clientes(
                    resultado.getLong("cui"),
                    resultado.getString("nombre"),
                    resultado.getString("apellido"),
                    resultado.getString("direccion"),
                    resultado.getString("telefono")
                ));
            }
        } catch (SQLException e) {
            System.out.println("ERROR: al listar nombres: " + e.getMessage());
        }

        return clientes;
    }

    @Override
    public Clientes buscar(long cui) {
        Clientes cliente = null;
        // Hacemos una consulta directa ya que el procedimiento almacenado no existe en tu DDL
        String consulta = "select cui, nombre, apellido, direccion, telefono from clientes where cui = ?"; 

        try (
            Connection conexion = Conexion.conectar();
            PreparedStatement statement = conexion.prepareStatement(consulta)
        ) {
            statement.setLong(1, cui);
            
            try (ResultSet resultado = statement.executeQuery()) {
                if (resultado.next()) {
                    cliente = new Clientes(
                        resultado.getLong("cui"),
                        resultado.getString("nombre"),
                        resultado.getString("apellido"),
                        resultado.getString("direccion"),
                        resultado.getString("telefono")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("ERROR: al buscar cliente por CUI: " + e.getMessage());
        }
        return cliente;
    }

    @Override
    public boolean actualizar(Clientes clientes) {
        return false;
    }

    @Override
    public boolean eliminar(long cui) {
        return false;
    }
}