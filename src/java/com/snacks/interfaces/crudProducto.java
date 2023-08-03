package com.snacks.interfaces;
import java.util.*;
import com.snacks.model.producto;

public interface crudProducto {
    
    List getAll();

    producto getById(Integer id);

    String add(producto producto);

    String updateById(producto producto);

    String deleteById(Integer id);
}
