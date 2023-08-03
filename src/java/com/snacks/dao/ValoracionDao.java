package com.snacks.dao;
import com.snacks.database.Conexion;
import com.snacks.interfaces.crudValoracion;
import com.snacks.model.valoracion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ValoracionDao implements crudValoracion{
    
    //Estancias necesarias para la logica
    valoracion valoracion = new valoracion();
    Conexion cn = new Conexion();
    CallableStatement cs;
    Connection con;
    ResultSet rs;

    //variables para los procedimientos almacenados
    String getAll = "CALL spLeerValoracion()";
    String getById = "CALL spObtenerValoracionPorID(?)";
    String add = "CALL spCrearValoracion?,?,?,?,?)";
    String update = "CALL spActualizarValoracion(?,?,?,?,?,?)";
    String delete = "CALL spEliminarValoracion(?)";

    @Override
    public List getAll() {
        ArrayList<valoracion> lista = new ArrayList<>();
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(getAll);
            rs = cs.executeQuery();
            while (rs.next()) {
                valoracion cli = new valoracion();
                cli.setIdValoracion(rs.getInt(1));
                cli.setValTipo(rs.getString(2));
                cli.setValValor(rs.getString(3));
                lista.add(cli);
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar: " + ex.getMessage());
        }
        return lista;
    }

    @Override
    public valoracion getById(Integer id) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(getById);
            cs.setInt(1, id);
            rs = cs.executeQuery();
            while (rs.next()) {
                valoracion.setIdValoracion(rs.getInt(1));
                valoracion.setValTipo(rs.getString(2));
                valoracion.setValValor(rs.getString(3));
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar: " + ex.getMessage());
        }
        return valoracion;
    }

    @Override
    public String add(valoracion valoracion) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(add);
            cs.setString(1, valoracion.getValTipo());
            cs.setString(2, valoracion.getValValor());
            cs.execute();
        } catch (SQLException ex) {
            System.out.println("Error al crear: " + ex.getMessage());
            return "no creado";
        }
        return "creado";
    }

    @Override
    public String updateById(valoracion valoracion) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(update);
            cs.setInt(1, valoracion.getIdValoracion());
            cs.setString(2, valoracion.getValTipo());
            cs.setString(3, valoracion.getValValor());
            cs.execute();
        } catch (SQLException ex) {
            System.out.println("Error al actualizar: " + ex.getMessage());
            return "no actualizado";
        }
        return "actualizado";
    }

    @Override
    public String deleteById(Integer id) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(delete);
            cs.setInt(1, id);
            cs.execute();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar: " + ex.getMessage());
            return "no eliminado";
        }
        return "eliminado";
    }

    
}
