package org.derekgonzalez.model.dao;

import java.util.ArrayList;
import java.util.List;
import org.derekgonzalez.model.Repuestos;
import org.derekgonzalez.model.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepuestosDAOImpl implements RepuestosDAO {

    @Override
    public boolean insertar(Repuestos repuesto) {
        String consulta = "insert into repuestos (nombre, precio_unitario, stock) values (?, ?, ?)";
        int filasAfectadas = 0;
        
        try (
            Connection conexion = Conexion.conectar();
            PreparedStatement statement = conexion.prepareStatement(consulta)
        ) {
            statement.setString(1, repuesto.getNombre());
            statement.setDouble(2, repuesto.getPrecioUnitario());
            statement.setInt(3, repuesto.getStock());
            filasAfectadas = statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR al registrar repuesto: " + e.getMessage());
        }
        return filasAfectadas > 0;
    }

    @Override
    public List<Repuestos> listar() {
        List<Repuestos> lista = new ArrayList<>();
        String consulta = "select codigo, nombre, precio_unitario, stock from repuestos";
        
        try (
            Connection conexion = Conexion.conectar();
            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultado = statement.executeQuery()
        ) {
            while (resultado.next()) {
                lista.add(new Repuestos(
                    resultado.getLong("codigo"),
                    resultado.getString("nombre"),
                    resultado.getDouble("precio_unitario"),
                    resultado.getInt("stock")
                ));
            }
        } catch (SQLException e) {
            System.out.println("ERROR al listar repuestos: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public Repuestos buscar(long codigo) {
        Repuestos repuesto = null;
        String consulta = "select codigo, nombre, precio_unitario, stock from repuestos where codigo = ?";
        
        try (
            Connection conexion = Conexion.conectar();
            PreparedStatement statement = conexion.prepareStatement(consulta)
        ) {
            statement.setLong(1, codigo);
            
            try (ResultSet resultado = statement.executeQuery()) {
                if (resultado.next()) {
                    repuesto = new Repuestos(
                        resultado.getLong("codigo"),
                        resultado.getString("nombre"),
                        resultado.getDouble("precio_unitario"),
                        resultado.getInt("stock")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("ERROR al buscar repuesto: " + e.getMessage());
        }
        return repuesto;
    }
}