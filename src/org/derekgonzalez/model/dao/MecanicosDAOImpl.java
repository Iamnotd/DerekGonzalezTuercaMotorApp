package org.derekgonzalez.model.dao;

import java.util.ArrayList;
import java.util.List;
import org.derekgonzalez.model.Mecanicos;
import org.derekgonzalez.model.conexion.Conexion;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MecanicosDAOImpl implements MecanicosDAO {

    @Override
    public boolean insertar(Mecanicos mecanico) {
        String consulta = "{call sp_insertar_mecanicos(?, ?, ?)}";
        int filasAfectadas = 0;

        try (
            Connection conexion = Conexion.conectar();
            CallableStatement call = conexion.prepareCall(consulta)
        ) {
            call.setLong(1, mecanico.getNoEmpleado());
            call.setString(2, mecanico.getNombre());
            call.setString(3, mecanico.getApellido());

            filasAfectadas = call.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR al registrar mecánico: " + e.getMessage());
        }
        return filasAfectadas > 0;
    }

    @Override
    public List<Mecanicos> listar() {
        List<Mecanicos> lista = new ArrayList<>();
        String consulta = "{call sp_listar_mecanicos()}";

        try (
            Connection conexion = Conexion.conectar();
            CallableStatement call = conexion.prepareCall(consulta);
            ResultSet resultado = call.executeQuery()
        ) {
            while (resultado.next()) {
                lista.add(new Mecanicos(
                    resultado.getLong("no_empleado"),
                    resultado.getString("nombre"),
                    resultado.getString("apellido")
                ));
            }
        } catch (SQLException e) {
            System.out.println("ERROR al listar mecánicos: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public Mecanicos buscar(long noEmpleado) {
        Mecanicos mecanico = null;
        String consulta = "select no_empleado, nombre, apellido from mecanicos where no_empleado = ?";

        try (
            Connection conexion = Conexion.conectar();
            PreparedStatement statement = conexion.prepareStatement(consulta)
        ) {
            statement.setLong(1, noEmpleado);
            
            try (ResultSet resultado = statement.executeQuery()) {
                if (resultado.next()) {
                    mecanico = new Mecanicos(
                        resultado.getLong("no_empleado"),
                        resultado.getString("nombre"),
                        resultado.getString("apellido")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("ERROR al buscar mecánico: " + e.getMessage());
        }
        return mecanico;
    }
}