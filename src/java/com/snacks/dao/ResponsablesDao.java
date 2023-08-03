package com.snacks.dao;

import com.snacks.database.Conexion;
import com.snacks.interfaces.crudResponsables;
import com.snacks.model.responsables;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResponsablesDao implements crudResponsables {

    //Estancias necesarias para la logica
    responsables responsables = new responsables();
    Conexion cn = new Conexion();
    CallableStatement cs;
    Connection con;
    ResultSet rs;

    //variables para los procedimientos almacenados
    String getAll = "CALL spLeerResponsables()";
    String getById = "CALL spObtenerResponsablesPorID(?)";
    String add = "CALL spCrearResponsables(?,?,?,?,?)";
    String update = "CALL spActualizarResponsables(?,?,?,?,?,?)";
    String delete = "CALL spEliminarResponsables(?)";

    @Override
    public List getAll() {

        ArrayList<responsables> lista = new ArrayList<>();
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(getAll);
            rs = cs.executeQuery();
            while (rs.next()) {
                responsables cli = new responsables();
                cli.setIdResponsables(rs.getInt(1));
                cli.setResNombres(rs.getString(2));
                cli.setResApellidos(rs.getString(3));
                cli.setResRole(rs.getString(4));
                cli.setResUsuario(rs.getString(5));
                cli.setResClave(rs.getString(6));
                lista.add(cli);
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar: " + ex.getMessage());
        }
        return lista;
    }

    @Override
    public responsables getById(Integer id) {

        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(getById);
            cs.setInt(1, id);
            rs = cs.executeQuery();
            while (rs.next()) {
                responsables.setIdResponsables(rs.getInt(1));
                responsables.setResNombres(rs.getString(2));
                responsables.setResApellidos(rs.getString(3));
                responsables.setResRole(rs.getString(4));
                responsables.setResUsuario(rs.getString(5));
                responsables.setResClave(rs.getString(6));
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar: " + ex.getMessage());
        }
        return responsables;

    }

    @Override
    public String add(responsables responsables) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(add);
            cs.setString(1, responsables.getResNombres());
            cs.setString(2, responsables.getResApellidos());
            cs.setString(3, responsables.getResRole());
            cs.setString(4, responsables.getResUsuario());
            cs.setString(5, responsables.getResClave());
            cs.execute();
        } catch (SQLException ex) {
            System.out.println("Error al crear: " + ex.getMessage());
            return "no creado";
        }
        return "creado";
    }

    @Override
    public String updateById(responsables responsables) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(update);
            cs.setInt(1, responsables.getIdResponsables());
            cs.setString(2, responsables.getResNombres());
            cs.setString(3, responsables.getResApellidos());
            cs.setString(4, responsables.getResRole());
            cs.setString(5, responsables.getResUsuario());
            cs.setString(6, responsables.getResClave());
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
