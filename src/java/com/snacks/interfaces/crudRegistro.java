package com.snacks.interfaces;
import com.snacks.model.registro;
import java.util.*;

public interface crudRegistro {

    List getAll();

    registro getById(Integer id);

    String add(registro registro);

    String updateById(registro registro);

    String deleteById(Integer id);
}
