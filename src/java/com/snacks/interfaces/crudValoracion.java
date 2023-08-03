package com.snacks.interfaces;
import java.util.*;
import com.snacks.model.valoracion;

public interface crudValoracion {
  
    List getAll();

    valoracion getById(Integer id);

    String add(valoracion valoracion);

    String updateById(valoracion valoracion);

    String deleteById(Integer id);
}
