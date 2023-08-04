package com.snacks.dao;

import com.snacks.database.Conexion;
import com.snacks.interfaces.crudRegistro;
import com.snacks.model.registro;
import com.snacks.model.registro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegistroDao implements crudRegistro{
   
    //Estancias necesarias para la logica
    registro registro = new registro();
    Conexion cn = new Conexion();
    CallableStatement cs;
    Connection con;
    ResultSet rs;

    //variables para los procedimientos almacenados
    String getAll = "CALL SeleccionarTodosRegistros()";
    String getById = "CALL SeleccionarRegistroPorID(?)";
    String add = "CALL InsertarRegistro(?,?,?,?,?,?,?,?,?,?,?)";
    String update = "CALL ActualizarRegistroPorID(?,?,?,?,?,?,?,?,?,?,?,?)";
    String delete = "CALL EliminarRegistroPorID(?)";

    @Override
    public List getAll() {
        ArrayList<registro> lista = new ArrayList<>();
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(getAll);
            rs = cs.executeQuery();
            while (rs.next()) {
                registro cli = new registro();
                cli.setIdRegistro(rs.getInt(1));
                cli.setRegCodigo(rs.getString(2));
                cli.setRegVigencia(rs.getString(3));
                cli.setRegVersion(rs.getString(4));
                cli.setRegFecha(rs.getString(5));
                cli.setRegInicio(rs.getString(6));
                cli.setRegFin(rs.getString(7));
                cli.setRegLinea(rs.getString(8));
                cli.setRegResponsable(rs.getString(9));
                cli.setRegPersonas(rs.getString(10));
                cli.setRegAceite(rs.getString(11));
                lista.add(cli);
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar: " + ex.getMessage());
        }
        return lista;
    }

    @Override
    public registro getById(Integer id) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(getById);
            cs.setInt(1, id);
            rs = cs.executeQuery();
            while (rs.next()) {
                registro.setIdRegistro(rs.getInt(1));
                registro.setRegCodigo(rs.getString(2));
                registro.setRegVigencia(rs.getString(3));
                registro.setRegVersion(rs.getString(4));
                registro.setRegFecha(rs.getString(5));
                registro.setRegInicio(rs.getString(6));
                registro.setRegFin(rs.getString(7));
                registro.setRegLinea(rs.getString(8));
                registro.setRegResponsable(rs.getString(9));
                registro.setRegPersonas(rs.getString(10));
                registro.setRegAceite(rs.getString(11));
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar: " + ex.getMessage());
        }
        return registro;
    }

    @Override
    public String add(registro registro) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(add);
            cs.setString(1, registro.getRegCodigo());
            cs.setString(2, registro.getRegVigencia());
            cs.setString(3, registro.getRegVersion());
            cs.setString(4, registro.getRegFecha());
            cs.setString(5, registro.getRegInicio());
            cs.setString(6, registro.getRegFin());
            cs.setString(7, registro.getRegLinea());
            cs.setString(8, registro.getRegResponsable());
            cs.setString(9, registro.getRegPersonas());
            cs.setString(10, registro.getRegAceite());
            cs.execute();
        } catch (SQLException ex) {
            System.out.println("Error al crear: " + ex.getMessage());
            return "no creado";
        }
        return "creado";
    }

    @Override
    public String updateById(registro registro) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(update);
            cs.setInt(1, registro.getIdRegistro());
            cs.setString(2, registro.getRegCodigo());
            cs.setString(3, registro.getRegVigencia());
            cs.setString(4, registro.getRegVersion());
            cs.setString(5, registro.getRegFecha());
            cs.setString(6, registro.getRegInicio());
            cs.setString(7, registro.getRegFin());
            cs.setString(8, registro.getRegLinea());
            cs.setString(9, registro.getRegResponsable());
            cs.setString(10, registro.getRegPersonas());
            cs.setString(11, registro.getRegAceite());
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
