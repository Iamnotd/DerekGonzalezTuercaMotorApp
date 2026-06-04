package org.derekgonzalez.model.dao;

import java.util.ArrayList;
import java.util.List;
import org.derekgonzalez.model.Clientes;
import org.derekgonzalez.model.conexion.Conexion;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientesDAOImpl implements ClientesDAO {

    @Override
    public boolean insertar(Clientes clientes) {
        // Tu procedimiento sp_insertar_clientes recibe 5 parámetros según el orden de la BD
        String consulta = "{call sp_insertar_clientes(?, ?, ?, ?, ?)}";
        int filasAfectadas = 0;
        try (
            Connection conexion = Conexion.conectar();
            CallableStatement call = conexion.prepareCall(consulta)
        ) {
            // CORREGIDO: Quitados los puntos dobles y estructurado limpiamente
            call.setLong(1, clientes.getCui());
            call.setString(2, clientes.getNombre());
            call.setString(3, clientes.getApellido());
            call.setString(4, clientes.getDireccion());
            call.setString(5, clientes.getTelefono());
            
            filasAfectadas = call.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR al registrar cliente: " + e.getMessage());
        }
        return filasAfectadas > 0;
    }

    @Override
    public List<Clientes> listar() {
        List<Clientes> lista = new ArrayList<>();
        String consulta = "{call sp_listar_clientes()}";
        try (
            Connection conexion = Conexion.conectar();
            CallableStatement call = conexion.prepareCall(consulta);
            ResultSet resultado = call.executeQuery()
        ) {
            while (resultado.next()) {
                lista.add(new Clientes(
                    resultado.getLong("cui"),
                    resultado.getString("nombre"),
                    resultado.getString("apellido"),
                    resultado.getString("direccion"),
                    resultado.getString("telefono")
                ));
            }
        } catch (SQLException e) {
            System.out.println("ERROR al listar clientes: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public Clientes buscar(long cui) {
        Clientes cliente = null;
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
            System.out.println("ERROR al buscar cliente por CUI: " + e.getMessage());
        }
        return cliente;
    }

    @Override
    public List<Clientes> buscarPorDireccion(String direccion) {
        List<Clientes> listaClientes = new ArrayList<>();
        String consulta = "select cui, nombre, apellido, direccion, telefono from clientes where direccion like ?";
        try (
            Connection conexion = Conexion.conectar();
            PreparedStatement statement = conexion.prepareStatement(consulta)
        ) {
            statement.setString(1, "%" + direccion + "%");
            try (ResultSet resultado = statement.executeQuery()) {
                while (resultado.next()) {
                    listaClientes.add(new Clientes(
                        resultado.getLong("cui"),
                        resultado.getString("nombre"),
                        resultado.getString("apellido"),
                        resultado.getString("direccion"),
                        resultado.getString("telefono")
                    ));
                }
            }
        } catch (SQLException e) {
            System.out.println("ERROR al buscar cliente por dirección: " + e.getMessage());
        }
        return listaClientes;
    }

    @Override
    public List<Clientes> buscarPorTelefono(String telefono) {
        List<Clientes> listaClientes = new ArrayList<>();
        String consulta = "select cui, nombre, apellido, direccion, telefono from clientes where telefono = ?";
        try (
            Connection conexion = Conexion.conectar();
            PreparedStatement statement = conexion.prepareStatement(consulta)
        ) {
            statement.setString(1, telefono);
            try (ResultSet resultado = statement.executeQuery()) {
                while (resultado.next()) {
                    listaClientes.add(new Clientes(
                        resultado.getLong("cui"),
                        resultado.getString("nombre"),
                        resultado.getString("apellido"),
                        resultado.getString("direccion"),
                        resultado.getString("telefono")
                    ));
                }
            }
        } catch (SQLException e) {
            System.out.println("ERROR al buscar cliente por teléfono: " + e.getMessage());
        }
        return listaClientes;
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