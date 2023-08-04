package com.snacks.dao;

import com.snacks.database.Conexion;
import com.snacks.interfaces.crudResponsables;
import com.snacks.model.responsable;
import com.snacks.security.Encriptador;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResponsablesDao implements crudResponsables {

    //Estancias necesarias para la logica
    responsable res = new responsable();
    Conexion cn = new Conexion();
    CallableStatement cs;
    Connection con;
    ResultSet rs;
    Integer idResponsable;

    //variables para los procedimientos almacenados
    String getAll = "CALL SeleccionarTodosResponsables()";
    String getById = "CALL SeleccionarResponsablePorID(?)";
    String getIdResponsable = "CALL ObtenerIdResponsablePorUsuario(?)";
    String add = "CALL InsertarResponsable(?,?,?,?,?,?)";
    String update = "CALL ActualizarResponsablePorID(?,?,?,?,?,?,?)";
    String delete = "CALL EliminarResponsablePorID(?)";

    @Override
    public List getAll() {

        ArrayList<responsable> lista = new ArrayList<>();
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(getAll);
            rs = cs.executeQuery();
            while (rs.next()) {
                responsable responsable = new responsable();
                responsable.setIdResponsables(rs.getInt(1));
                responsable.setResIntento(rs.getInt(2));
                responsable.setResNombres(rs.getString(3));
                responsable.setResApellidos(rs.getString(4));
                responsable.setResRole(rs.getString(5));
                responsable.setResUsuario(rs.getString(6));
                responsable.setResClave(rs.getString(7));
                lista.add(responsable);
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar: " + ex.getMessage());
        }
        return lista;
    }

    @Override
    public responsable getById(Integer id) {
               try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(getById);
            cs.setInt(1, id);
            rs = cs.executeQuery();
            while (rs.next()) {
                res.setIdResponsables(rs.getInt(1));
                res.setResIntento(rs.getInt(2));
                res.setResNombres(rs.getString(3));
                res.setResApellidos(rs.getString(4));
                res.setResRole(rs.getString(5));
                res.setResUsuario(rs.getString(6));
                res.setResClave(new Encriptador().desencriptar(rs.getString(7)));
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar: " + ex.getMessage());
        }
        return res;
    }

    @Override
    public String add(responsable responsables) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(add);
            cs.setInt(1, responsables.getResIntento());
            cs.setString(2, responsables.getResNombres());
            cs.setString(3, responsables.getResApellidos());
            cs.setString(4, responsables.getResRole());
            cs.setString(5, responsables.getResUsuario());
            cs.setString(6, new Encriptador().encriptar(responsables.getResClave()));
            cs.execute();
        } catch (SQLException ex) {
            System.out.println("Error al crear: " + ex.getMessage());
            return "no creado";
        }
        return "creado";
    }

    @Override
    public String updateById(responsable responsables) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(update);
            cs.setInt(1, responsables.getIdResponsables());
            cs.setInt(2, responsables.getResIntento());
            cs.setString(3, responsables.getResNombres());
            cs.setString(4, responsables.getResApellidos());
            cs.setString(5, responsables.getResRole());
            cs.setString(6, responsables.getResUsuario());
            cs.setString(7, new Encriptador().encriptar(responsables.getResClave()));
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

    @Override
    public Integer getIdResponsable(String resUsuario) {

        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(getIdResponsable);
            cs.setString(1, resUsuario);
            rs = cs.executeQuery();
            while (rs.next()) {
                idResponsable = rs.getInt(1);
                System.out.println("idResponsable lisr " + idResponsable);
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar: " + ex);
        }
        return idResponsable;
    }

}
