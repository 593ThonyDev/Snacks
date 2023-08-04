package com.snacks.dao;
import com.snacks.database.Conexion;
import com.snacks.interfaces.crudProducto;
import com.snacks.model.producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDao implements crudProducto{
    
    //Estancias necesarias para la logica
    producto producto = new producto();
    Conexion cn = new Conexion();
    CallableStatement cs;
    Connection con;
    ResultSet rs;

    //variables para los procedimientos almacenados
    String getAll = "CALL SeleccionarTodosProductos()";
    String getById = "CALL SeleccionarProductoPorID(?)";
    String add = "CALL InsertarProducto(?,?,?)";
    String update = "CALL spActualizarProducto(?,?,?,?)";
    String delete = "CALL EliminarProductoPorID(?)";


    @Override
    public List getAll() {
        ArrayList<producto> lista = new ArrayList<>();
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(getAll);
            rs = cs.executeQuery();
            while (rs.next()) {
                producto cli = new producto();
                cli.setIdProducto(rs.getInt(1));
                cli.setProNombre(rs.getString(2));
                cli.setProLote(rs.getString(3));
                cli.setProDescripcion(rs.getString(4));
                lista.add(cli);
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar: " + ex.getMessage());
        }
        return lista;
    }

    @Override
    public producto getById(Integer id) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(getById);
            cs.setInt(1, id);
            rs = cs.executeQuery();
            while (rs.next()) {
                producto.setIdProducto(rs.getInt(1));
                producto.setProNombre(rs.getString(2));
                producto.setProLote(rs.getString(3));
                producto.setProDescripcion(rs.getString(4));
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar: " + ex.getMessage());
        }
        return producto;
    }

    @Override
    public String add(producto producto) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(add);
            cs.setString(1, producto.getProNombre());
            cs.setString(2, producto.getProLote());
            cs.setString(3, producto.getProDescripcion());
            cs.execute();
        } catch (SQLException ex) {
            System.out.println("Error al crear: " + ex.getMessage());
            return "no creado";
        }
        return "creado";
    }

    @Override
    public String updateById(producto producto) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(update);
            cs.setInt(1, producto.getIdProducto());
            cs.setString(2, producto.getProNombre());
            cs.setString(3, producto.getProLote());
            cs.setString(4, producto.getProDescripcion());
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
