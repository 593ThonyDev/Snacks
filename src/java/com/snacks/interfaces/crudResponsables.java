package com.snacks.interfaces;

import com.snacks.model.responsable;
import java.util.*;

public interface crudResponsables {

    List getAll();

    responsable getById(Integer id);

    Integer getIdResponsable(String resUsuario);

    String add(responsable responsables);

    String updateById(responsable responsables);

    String deleteById(Integer id);
}
